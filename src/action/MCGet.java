package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import Entity.ResMC;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.scene.control.TableView;
import soyUtils.Const;
import soyUtils.IntUtil;
import soyUtils.SoyUtils;

public class MCGet extends Task{
	static Logger log = Logger.getLogger(MCGet.class);
	private IntUtil util;
	private TableView table;
	private String password;
	
	public MCGet (IntUtil util,TableView table,String password) {
		this.util = util;
		this.table = table;
		this.password = password;
	}

	@Override
	protected Object call() throws Exception {
		util.showText("Ë¢ÐÂÄÁ³¡...");
		String url = "function/Muchang_Mod.php";
		String urlLogin = "function/ext_Muchang.php";
		Map retMap = null;
		if(password != null && password.length()>0) {
			Map paraMap = new HashMap();
			paraMap.put("pwd", password);
			paraMap.put("action", "login");
			Map ret = util.post(urlLogin, paraMap);
			
			if((int)ret.get("code") != 200){
				util.showText("Ë¢ÐÂÊ§°Ü£¡");
				return null;
			}else {
				String retLogin = (String) ret.get("body");
				if (retLogin.equals(Const.MC_PSW_ERR)) {
					util.showText("ÃÜÂë´íÎó£¡");
					return null;
				}else if (retLogin.equals(Const.MC_SUCCESS)) {
					util.setCharset("GBK");
					retMap = util.get(url);
					util.setCharset("gb2312");
					if((int)retMap.get("code") != 200){
						util.showText("Ë¢ÐÂÊ§°Ü£¡");
						return null;
					}
				}else {
					util.showText("Ë¢ÐÂ³ö´í£¡");
					return null;
				}
			}
		}else {
			util.setCharset("GBK");
			retMap = util.get(url);
			util.setCharset("gb2312");
			if((int)retMap.get("code") != 200){
				util.showText("Ë¢ÐÂÊ§°Ü£¡");
				return null;
			}
			
			String mcRet = (String)retMap.get("body");
			if(mcRet.lastIndexOf("ÃÜÂë") != -1) {
				util.showText("ÇëÊäÈëÄÁ³¡ÃÜÂë£¡");
				return null;
			}
		}
		
		SoyUtils ut = new SoyUtils();
		List <ResMC> resMC = new ArrayList<ResMC>();
		String mcBody = (String) retMap.get("body");
		String mc = ut.getTag(Const.MCLIST_LEFT, Const.MCLIST_RIGHT, mcBody);
		List<String> mcList = ut.getTagList(Const.MC_LEFT, Const.MC_RIGHT, mc);
		for (String m : mcList) {
			String id = ut.getTag(Const.MC_ID_LF, Const.MC_ID_RT, m);
			String level = ut.getTag(Const.MC_LEVEL_LF, Const.MC_LEVEL_RT, m);
			String name = ut.getTag(Const.MC_NAME_LF, Const.MC_NAME_RT, m);
			String genre = ut.getTag(Const.MC_GENRE_LF, Const.MC_GENRE_RT, m);
			resMC.add(new ResMC(id,name,genre,level));
		}
		
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
				table.setItems(FXCollections.observableArrayList(resMC));
		    }
		});
		util.showText("Ë¢ÐÂÍê³É£¡");
		return null;
	}
}
