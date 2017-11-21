package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/** 
* @author Soy 
* @date 2017年11月20日 上午11:18:55 
* @version 1.0 
*/
public class MyController implements Initializable {
	static Logger log = Logger.getLogger(MyController.class);

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
	private ChoiceBox box;
   
   @Override
   public void initialize(URL location, ResourceBundle resources) {

       // TODO (don't really need to do anything here).
		List list = new ArrayList();
		list.add("one111111111111111");
		list.add("two");
		list.add("three");
		list.add("one111111111111112");
		list.add("one111111111111113");
		list.add("one111111111111114");
		list.add("one111111111111115");
		list.add("one111111111111116");
		box.setItems(FXCollections.observableArrayList(list));
   }

   // 功能界面切换
   public void actionChange1(ActionEvent event) {
	   log.error("click btMain1");
	   setVisibleTrue(rightPane1,btMain1);
   }
   public void actionChange2(ActionEvent event) {
	   log.error("click btMain2");
	   setVisibleTrue(rightPane2,btMain2);
   }
   public void actionChange3(ActionEvent event) {
	   log.error("click btMain3");
	   setVisibleTrue(rightPane3,btMain3);
   }
   public void actionChange4(ActionEvent event) {
	   log.error("click btMain4");
	   setVisibleTrue(rightPane4,btMain4);
   }
   public void actionChange5(ActionEvent event) {
	   log.error("click btMain5");
	   setVisibleTrue(rightPane5,btMain5);
   }
   public void actionChange6(ActionEvent event) {
	   log.error("click btMain6");
	   setVisibleTrue(rightPane6,btMain6);
   }
   public void actionChange7(ActionEvent event) {
	   log.error("click btMain7");
	   setVisibleTrue(rightPane7,btMain7);
   }
   public void actionChange8(ActionEvent event) {
	   log.error("click btMain8");
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
