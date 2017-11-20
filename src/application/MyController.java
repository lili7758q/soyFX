package application;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/** 
* @author Soy 
* @date 2017年11月20日 上午11:18:55 
* @version 1.0 
*/
public class MyController implements Initializable {

   @FXML
   private Button bt1;
   @FXML
   private Button bt2;

   @FXML
   private TextField myTextField;
 
   @FXML
   private AnchorPane rightPane;

   @Override
   public void initialize(URL location, ResourceBundle resources) {

       // TODO (don't really need to do anything here).

   }

   // When user click on myButton
   // this method will be called.
   public void action1(ActionEvent event) {
	   System.out.println("action1");
   }
   
   public void action2(ActionEvent event) {
	   System.out.println("action2");
       rightPane.setBorder(null);
   }

}
