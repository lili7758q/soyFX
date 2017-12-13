package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.log4j.Logger;

import Entity.Res;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import soyUtils.Const;
import soyUtils.IntUtil;
import soyUtils.SoyUtils;

/** 
* @author Soy 
* @date 2017年11月27日 上午11:05:18 
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
	
	public Login (IntUtil util,String username,String password){
		this.util = util;
		this.username = username;
		this.password = password;
	}
	
	public void setCharset(String charset) {
		this.charset = charset;
	}

	public void setMoney(TextField textJB,TextField textSJ,TextField textYB,TextField textName){
		this.textJB = textJB;
		this.textSJ = textSJ;
		this.textYB = textYB;
		this.textName = textName;
	}


	@Override
	protected Object call() throws Exception {
		   Map loginMap = new HashMap();
		   loginMap.put("username", username);
		   loginMap.put("password", password);
		   loginMap.put("commit", "%B5%C7%C2%BC");
		   try {
				Map loginRetMap;
				util.showText("开始登陆...");
				loginRetMap = util.post("passport/deal.php", loginMap);
				int StatusCode = (int) loginRetMap.get("code");
		 		if (StatusCode != 200) {
		 				util.showText("连接网站失败！");
		 		}else {
		 			if(!(((String)loginRetMap.get("body")).indexOf("login/login.php") != -1)){
		 				util.showText("账号或密码错误！");
		 			}else{
		 				Map ret = util.get("login/login.php");
			 			if((int)ret.get("code")!= 200){
			 				util.showText("登陆失败！");
			 			}else{
				 			Map indexMap = util.get("index.php");
				 			if ((int)indexMap.get("code") != 200) {
				 				util.showText("登陆失败!");
				 			}else{
					 			util.showText("登陆成功!");
					 			util.showText("获取玩家信息...");
					 			SoyUtils ut = new SoyUtils();
					 			Map ret2 = util.get("function/User_Mod.php");
					 			String body = (String)ret2.get("body");
					 			String name = ut.getTag(Const.PUB_NAME_LF, Const.PUB_NAME_RT, body);
					 			String JB = ut.getTag(Const.PUB_JB_LF, Const.PUB_JB_RT, body);
					 			String SJ = ut.getTag(Const.PUB_SJ_LF, Const.PUB_SJ_RT, body);
					 			String YB = ut.getTag(Const.PUB_YB_LF, Const.PUB_YB_RT, body);
					 			textJB.setText(JB);
					 			textName.setText(name);
					 			textSJ.setText(SJ);
					 			textYB.setText(YB);
					 			util.showText("获取玩家信息完毕！");
					 			util.showText("你好，"+name);
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
