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
import javafx.scene.control.TextArea;
import soyUtils.Const;
import soyUtils.IntUtil;
import soyUtils.SoyUtils;

/** 
* @author Soy 
* @date 2017Äê11ÔÂ27ÈÕ ÉÏÎç11:05:18 
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
	
	public Login (IntUtil util,String username,String password){
		this.util = util;
		this.username = username;
		this.password = password;
	}
	
	public void setCharset(String charset) {
		this.charset = charset;
	}



	@Override
	protected Object call() throws Exception {
		   Map loginMap = new HashMap();
		   loginMap.put("username", username);
		   loginMap.put("password", password);
		   loginMap.put("commit", "%B5%C7%C2%BC");
		   try {
				Map loginRetMap;
				util.showText("¿ªÊ¼µÇÂ½...");
				loginRetMap = util.post("passport/deal.php", loginMap);
				int StatusCode = (int) loginRetMap.get("code");
		 		if (StatusCode != 200) {
		 				util.showText("Á¬½ÓÍøÕ¾Ê§°Ü£¡");
		 		}else {
		 			if(!(((String)loginRetMap.get("body")).indexOf("login/login.php") != -1)){
		 				util.showText("ÕËºÅ»òÃÜÂë´íÎó£¡");
		 			}else{
		 				Map ret = util.get("login/login.php");
			 			if((int)ret.get("code")!= 200){
			 				util.showText("µÇÂ½Ê§°Ü£¡");
			 			}else{
				 			Map indexMap = util.get("index.php");
				 			if ((int)indexMap.get("code") != 200) {
				 				util.showText("µÇÂ½Ê§°Ü!");
				 			}else{
					 			util.showText("µÇÂ½³É¹¦!");
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
