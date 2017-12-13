package application;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import Entity.Res;
import Entity.ResMC;
import Entity.ResSale;
import Entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import soyUtils.Const;
import soyUtils.IntUtil;
import soyUtils.SoyGet;
import soyUtils.SoyPost;
import action.BuySale;
import action.GetBag;
import action.GetSale;
import action.Login;
import action.MCGet;
import action.Test;
import action.UseBag;

/** 
* @author Soy 
* @date 2017年11月20日 上午11:18:55 
* @version 1.0 
*/
public class MyController implements Initializable {
	static Logger log = Logger.getLogger(MyController.class);
	static String charset = Const.GB2321;
	static IntUtil util;
	static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3); 

   @FXML
   private Pane rightPane1;
   @FXML
   private Pane rightPane2;
   @FXML
   private Pane rightPane3;
   @FXML
   private Pane rightPane4;
   @FXML
   private Pane rightPane5;
   @FXML
   private Pane rightPane6;
   @FXML
   private Pane rightPane7;
   @FXML
   private Pane rightPane8;
   
   @FXML
   private Button btMain1;
   @FXML
   private Button btMain2;
   @FXML
   private Button btMain3;
   @FXML
   private Button btMain4;
   @FXML
   private Button btMain5;
   @FXML
   private Button btMain6;
   @FXML
   private Button btMain7;
   @FXML
   private Button btMain8;
   @FXML
   private Button bagUse;
   @FXML
   private Button buttonSort;
   
   @FXML
   private TextArea showText;
   @FXML
   private TextField bagUseNum;
   @FXML
   private TextField textBuyNum;
   @FXML
   private TextField textJB;
   @FXML
   private TextField textSJ;
   @FXML
   private TextField textYB;
   @FXML
   private TextField textName;
   
   @FXML
   private TableView bagTable;
   @FXML
   private TableColumn bagId;
   @FXML
   private TableColumn bagName;
   @FXML
   private TableColumn bagSort;
   @FXML
   private TableColumn bagNum;
   
   @FXML
   private TableView tableSale;
   @FXML
   private TableColumn saleName;
   @FXML
   private TableColumn saleNum;
   @FXML
   private TableColumn salePrice;
   @FXML
   private TableColumn saleId;
   @FXML
   private ComboBox comboBoxUser;
   
   @FXML
   private TableView tableMC;
   @FXML
   private TableColumn MCName;
   @FXML
   private TableColumn MCGenre;
   @FXML
   private TableColumn MCLevel;
   @FXML
   private TableColumn MCId;
   
   @FXML
   private Button testButton;
   
   Test ts;
   //初始化数据
   @Override
   public void initialize(URL location, ResourceBundle resources) {
	   showText.setEditable(false);//右侧显示栏不可编辑
	   setUser();//设置已保存的用户
	   setToolTips();//提示条
	   initTable();//初始化Table
   }
   
   //登陆
   public void Login(ActionEvent event) throws Exception{
	   String urlMain="http://s2.vvqz.com:8089/";
	   util = new IntUtil(urlMain,charset,showText);
	   Login login = new Login(util,"wxdwxd","5291314");
	   login.setMoney(textJB, textSJ, textYB, textName);
	   Thread th = new Thread(login);
	   th.start();  
   }
   //刷新背包
   public void refreshBag(ActionEvent event) throws Exception{
	   GetBag getBag = new GetBag(util,bagTable);
	   Thread th = new Thread(getBag);
	   th.start();
   }
   
   //整理背包
   public void sortBag(ActionEvent event){
	   GetBag getBag = new GetBag(util,bagTable);
	   getBag.setSort(true);
	   Thread th = new Thread(getBag);
	   th.start();
   }

   //使用
   public void bagUse(ActionEvent event){
	   Res res = (Res)bagTable.getSelectionModel().getSelectedItem();
	   String num = bagUseNum.getText();
	   num.replace(" ", "");
	   if(res == null){
		   util.showText("请先选择物品！");
	   }else{
		   if(num == null ||num.equals("")){
			   num = res.getNum();
		   }
		   for (int i =0;i<Integer.valueOf(num);i++) {
			   fixedThreadPool.execute(new UseBag(res,util));
		   }
	   }
   }
   
   //刷新拍卖
   public void refreshSale (ActionEvent event) {
	   GetSale get = new GetSale(util,tableSale);
	   Thread th = new Thread(get);
	   th.start();
   }
   
   public void buySale(ActionEvent event) {
	   ResSale res = (ResSale)tableSale.getSelectionModel().getSelectedItem();
	   String num = textBuyNum.getText();
	   num.replace(" ", "");
	   if(res == null){
		   util.showText("请先选择物品！");
	   }else{
		   BuySale get = new BuySale(util,res,num);
		   Thread th = new Thread(get);
		   th.start();
	   }
   }
   
   public void refreshMC(ActionEvent event) {
	   MCGet get = new MCGet(util,tableMC,"1");
	   Thread th = new Thread(get);
	   th.start();
	   
   }
   
   public void testButton (ActionEvent event) {
	   if (testButton.getText().equals("开始")) {
		   ts = new Test();
		   Thread th = new Thread(ts);
		   th.start();
		   testButton.setText("停止");
	   }else{
		   testButton.setText("开始");
		   ts.exit = true;
	   }
   }
   
   public boolean changeButton (Button bt) {
	   return true;
   }
   
   // 功能界面切换
   public void actionChange1(ActionEvent event) {
	   log.info("click btMain1");
	   setVisibleTrue(rightPane1,btMain1);
   }
   public void actionChange2(ActionEvent event) {
	   log.info("click btMain2");
	   setVisibleTrue(rightPane2,btMain2);
   }
   public void actionChange3(ActionEvent event) {
	   log.info("click btMain3");
	   setVisibleTrue(rightPane3,btMain3);
   }
   public void actionChange4(ActionEvent event) {
	   log.info("click btMain4");
	   setVisibleTrue(rightPane4,btMain4);
   }
   public void actionChange5(ActionEvent event) {
	   log.info("click btMain5");
	   setVisibleTrue(rightPane5,btMain5);
   }
   public void actionChange6(ActionEvent event) {
	   log.info("click btMain6");
	   setVisibleTrue(rightPane6,btMain6);
   }
   public void actionChange7(ActionEvent event) {
	   log.info("click btMain7");
	   setVisibleTrue(rightPane7,btMain7);
   }
   public void actionChange8(ActionEvent event) {
	   log.info("click btMain8");
	   setVisibleTrue(rightPane8,btMain8);
   }

   public void setVisibleTrue (Pane pane,Button button){
	   rightPane1.setVisible(false);
	   rightPane2.setVisible(false);
	   rightPane3.setVisible(false);
	   rightPane4.setVisible(false);
	   rightPane5.setVisible(false);
	   rightPane6.setVisible(false);
	   rightPane7.setVisible(false);
	   rightPane8.setVisible(false);
	   pane.setVisible(true);
	   
	   btMain1.setStyle("-fx-text-fill: #006464;");
	   btMain2.setStyle("-fx-text-fill: #006464;");
	   btMain3.setStyle("-fx-text-fill: #006464;");
	   btMain4.setStyle("-fx-text-fill: #006464;");
	   btMain5.setStyle("-fx-text-fill: #006464;");
	   btMain6.setStyle("-fx-text-fill: #006464;");
	   btMain7.setStyle("-fx-text-fill: #006464;");
	   btMain8.setStyle("-fx-text-fill: #006464;");
	   button.setStyle("-fx-text-fill:red;");
   }
   
   public void map2ListParam (Map<String,String> map,List param){
		  for (Map.Entry<String, String> entry : map.entrySet()) {
			  param.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
		  }
	  }
   
   private void setUser(){
	 //已有登陆账号
	    Map userMap = new HashMap();
	    User user1 = new User("aaaa","bbbb","Liar1","网页二区");
	    User user2 = new User("aaaa","bbbb","Liar2","网页二区");
	    User user3 = new User("aaaa","bbbb","Liar3","网页二区");
	    User user4 = new User("aaaa","bbbb","Liar4","网页二区");
	    userMap.put(user1.getName(), user1);
	    userMap.put(user2.getName(), user1);
	    userMap.put(user3.getName(), user1);
	    userMap.put(user4.getName(), user1);
	    Set set = new HashSet();
	    set = userMap.keySet();
		List list = new ArrayList();
		list.addAll(set);
		comboBoxUser.setItems(FXCollections.observableArrayList(list));
		comboBoxUser.setVisibleRowCount(3);
   }
   
   //提示条
   public void setToolTips(){
	   //背包使用
	   Tooltip tsBagUse = new Tooltip();
	   tsBagUse.setText("不填数量默认全部使用哟~");
	   bagUse.setTooltip(tsBagUse);
	   //整理
	   Tooltip tsButtonSort = new Tooltip();
	   tsButtonSort.setText("可以点击列名排序~");
	   buttonSort.setTooltip(tsButtonSort);
	   
   }
   //table初始化
   public void initTable (){
	   //背包
	   bagId.setCellValueFactory(new PropertyValueFactory<>("id"));
	   bagName.setCellValueFactory(new PropertyValueFactory<>("name"));
	   bagNum.setCellValueFactory(new PropertyValueFactory<>("num"));
	   bagSort.setCellValueFactory(new PropertyValueFactory<>("bagSort"));
	   List<Res> res = new ArrayList<Res>();
	   res.add(new Res(" "," "," "," "));
	   bagTable.setItems(FXCollections.observableArrayList(res));
	   //交易所
	   saleId.setCellValueFactory(new PropertyValueFactory<>("id"));
	   saleName.setCellValueFactory(new PropertyValueFactory<>("name"));
	   saleNum.setCellValueFactory(new PropertyValueFactory<>("num"));
	   salePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
	   List<ResSale> resSale = new ArrayList<ResSale>();
	   resSale.add(new ResSale(" "," "," "," "));
	   tableSale.setItems(FXCollections.observableArrayList(resSale));
	   //牧场
	   MCId.setCellValueFactory(new PropertyValueFactory<>("id"));
	   MCName.setCellValueFactory(new PropertyValueFactory<>("name"));
	   MCLevel.setCellValueFactory(new PropertyValueFactory<>("level"));
	   MCGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
	   List<ResMC> resMC = new ArrayList<ResMC>();
	   resMC.add(new ResMC("","","",""));
	   tableMC.setItems(FXCollections.observableArrayList(resMC));
   }
}
