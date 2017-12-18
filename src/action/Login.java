package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.log4j.Logger;

import Entity.Res;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import soyUtils.Const;
import soyUtils.IntUtil;
import soyUtils.SoyUtils;

/** 
* @author Soy 
* @date 2017��11��27�� ����11:05:18 
* @version 1.0 
*/
public class Login extends Task{
	static Logger log = Logger.getLogger(Login.class);
	private String username;
	private String password;
	private String daqu;
	private CloseableHttpClient client;
	private String charset = Const.GB2321;
	private IntUtil util;
	private TextArea showText;
	private TextField textJB;
	private TextField textSJ;
	private TextField textYB;
	private TextField textName;
	private TextField textPetName;
	private ComboBox comboBoxMainSkill;
	
	public Login (IntUtil util,String username,String password){
		this.util = util;
		this.username = username;
		this.password = password;
	}
	
	public void setCharset(String charset) {
		this.charset = charset;
	}

	public void setMoney(TextField textJB,TextField textSJ,TextField textYB,TextField textName,TextField textPetName,ComboBox comboBoxMainSkill){
		this.textJB = textJB;
		this.textSJ = textSJ;
		this.textYB = textYB;
		this.textName = textName;
		this.textPetName = textPetName;
		this.comboBoxMainSkill = comboBoxMainSkill;
	}


	@Override
	protected Object call() throws Exception {
		   Map loginMap = new HashMap();
		   loginMap.put("username", username);
		   loginMap.put("password", password);
		   loginMap.put("commit", "%B5%C7%C2%BC");
		   try {
				Map loginRetMap;
				util.showText("��ʼ��½...");
				loginRetMap = util.post("passport/deal.php", loginMap);
				int StatusCode = (int) loginRetMap.get("code");
		 		if (StatusCode != 200) {
		 				util.showText("������վʧ�ܣ�");
		 		}else {
		 			if(!(((String)loginRetMap.get("body")).indexOf("login/login.php") != -1)){
		 				util.showText("�˺Ż��������");
		 			}else{
		 				Map ret = util.get("login/login.php");
			 			if((int)ret.get("code")!= 200){
			 				util.showText("��½ʧ�ܣ�");
			 			}else{
				 			Map indexMap = util.get("index.php");
				 			if ((int)indexMap.get("code") != 200) {
				 				util.showText("��½ʧ��!");
				 			}else{
					 			util.showText("��½�ɹ�!");
					 			GetPerson get = new GetPerson(util);
					 			get.setInfo(textJB, textSJ, textYB, textName, textPetName,comboBoxMainSkill);
					 			Thread th2 = new Thread(get);
					 			th2.start();
				 			}
			 			}
		 			}
		 		}
			} catch (Exception e) {
				log.error(e.getMessage());
				log.info(e.getStackTrace());
			}
		   
		   
		return null;
	}
	

}
