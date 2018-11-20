package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.ResRush;
import entity.Store;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.scene.control.TableView;
import soyUtils.Const;
import soyUtils.IntUtil;
import soyUtils.SoyUtils;

public class RefreshStore extends Task{
	private IntUtil util;
	private String password;
	private TableView storeTable;
	
	public RefreshStore(IntUtil util,String password,TableView storeTable){
		this.util = util;
		this.password = password;
		this.storeTable = storeTable;
	}

	private Map getStore() throws Exception{
		String charset = util.getCharset();
		util.setCharset("gbk");
		Map retMap = util.get(Const.URL_STORE);
		util.setCharset(charset);
		return retMap;
	}
	@Override
	protected Object call() throws Exception {
		try{
			Map retMap = getStore();
			if ((int)retMap.get("code") != 200){
				util.showText("Ë¢ÐÂÊ§°Ü£¡ "+(int)retMap.get("code"));
			}else {
				String storeHtml = (String) retMap.get("body");
				if(storeHtml.indexOf(Const.STORE_PASSWORD_FLAG) > 0){
					//µÇÂ½
					Map loginMap = new HashMap();
					loginMap.put("pwd", password);
					loginMap.put("action", "login");
					Map loginRetMap = util.post(Const.URL_STORE_EXT_PASSWORD, loginMap);
					if ((int)loginRetMap.get("code") != 200){
						util.showText("Ë¢ÐÂÊ§°Ü£¡ "+(int)loginRetMap.get("code"));
					}else{
						String retCode = (String) loginRetMap.get("body");
						if(retCode.equals("10")){
							retMap = getStore();
							if ((int)retMap.get("code") != 200){
								util.showText("Ë¢ÐÂÊ§°Ü£¡ "+(int)loginRetMap.get("code"));
							}else{
								storeHtml = (String) retMap.get("body");
							}
						}else if(retCode.equals("0")){
							util.showText("ÇëÏÈÌîÐ´ÃÜÂë£¡");
						}else{
							util.showText("ÃÜÂë´íÎó£¡");
						}
					}
				}
				
				List<Store> listStore = new ArrayList<Store>();
				SoyUtils ut = new SoyUtils();
				storeHtml = ut.getTag(Const.STORE_TABLE_LF, Const.STORE_TABLE_RT, storeHtml);
				List<String> strList = ut.getTagList(Const.STORE_TABLE_LIST_LF, Const.STORE_TABLE_LIST_RT, storeHtml);
				for(String t : strList){
					String id = ut.getTag(Const.STORE_TABLE_ID_LF, Const.STORE_TABLE_ID_RT, t);
					String name = ut.getTag(Const.STORE_TABLE_NAME_LF, Const.STORE_TABLE_NAME_RT, t);
					String num = ut.getTag(Const.STORE_TABLE_NUM_LF+id+"\" >", Const.STORE_TABLE_NUM_RT, t);
					Store store = new Store(name, Integer.parseInt(num), id);
					listStore.add(store);
				}
				Platform.runLater(new Runnable() {
				    @Override
				    public void run() {
				    	storeTable.setItems(FXCollections.observableArrayList(listStore));
				    }
				});
			}
			util.showText("Ë¢ÐÂÍê³É£¡");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

}
