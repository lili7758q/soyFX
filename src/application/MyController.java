package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.log4j.Logger;

import Entity.User;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import soyUtils.Const;
import soyUtils.IntUtil;

/** 
* @author Soy 
* @date 2017年11月20日 上午11:18:55 
* @version 1.0 
*/
public class MyController implements Initializable {
	static Logger log = Logger.getLogger(MyController.class);
	static String urlMain = "";
	static String charset = Const.GB2321;
	IntUtil util = null;

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
   private ComboBox comboBoxUser;
   
   @Override
   public void initialize(URL location, ResourceBundle resources) {
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
		
		//
   }
   //登陆
   public void Login(ActionEvent event){
	   
	   System.out.println("111");
	   urlMain="http://s2.vvqz.com:8089/";
	   util = new IntUtil(urlMain,charset);
	 //登陆
	 		Map loginMap = new HashMap();
	 		loginMap.put("username", "hq1234");
	 		loginMap.put("password", "qazaq");
	 		loginMap.put("commit", "%B5%C7%C2%BC");
			try {
				Map loginRetMap;
				loginRetMap = util.post("passport/deal.php", loginMap);
				System.out.println("loginRetMap-" +loginRetMap.get("body"));
				int StatusCode = (int) loginRetMap.get("code");
		 		if (StatusCode != 200) {
		 			if(StatusCode == 404){
		 				log.error("连接网站失败！");
		 			}else if (StatusCode == 302){
		 				log.error("账号或者密码不正确！");
		 			}
		 		}else {
		 			Map ret = util.get("login/login.php");
		 			System.out.println("ret-" + ret.get("body"));
		 			if((int)ret.get("code")!= 200){
		 				log.error("登陆失败！");
		 			}
		 			Map indexMap = util.get("index.php");
		 			System.out.println("indexMap-" +indexMap.get("body"));
		 			log.error("登陆成功");
		 		}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				log.error(e.getMessage());
				log.info(e.getStackTrace());
			}
	 		
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
}
