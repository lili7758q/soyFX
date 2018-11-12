package action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Entity.ResRush;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.scene.control.TableView;
import soyUtils.Const;
import soyUtils.IntUtil;
import soyUtils.SoyUtils;

/** 
* @author Soy 
* @date 2018��11��11�� ����23:41:25 
* @version 1.0 
*/
public class GetRushBuy extends Task{
	private IntUtil util;
	private TableView rushBuyTable;
	
	public GetRushBuy (IntUtil util ,TableView rushBuyTable){
		this.util = util;
		this.rushBuyTable = rushBuyTable;
	}
	
	@Override
	protected Object call() throws Exception {
		util.showText("ˢ�������̳���...");
		String toUrl = "function/Shopsm_Mod.php?op=cmp&sjstyle=4";
		Map retMap = util.get(toUrl);
		if((int)retMap.get("code") != 200){
			util.showText("ˢ���̳�ʧ�ܣ�");
		}else{
			String bagHtml = (String) retMap.get("body");
//			if(bagHtml.indexOf("��ʱû����ʱ��������Ʒ")!= -1){
//				util.showText("�������δ��������");
//				return null;
//			}
			try{
				File file = new File("C:\\Users\\Strong\\Desktop\\�����̳�.txt");
				FileReader reader = new FileReader(file);
				BufferedReader bf = new BufferedReader(reader);
				StringBuffer sb=new StringBuffer();
				String rt = "";
				while((rt=bf.readLine())!=null){
					sb.append(rt);
				}
				bagHtml = sb.toString();
			}catch (Exception e){
				e.printStackTrace();
			}
			
			List<ResRush> listRush = new ArrayList<ResRush>();
			SoyUtils ut = new SoyUtils();
			
			String tableStr = ut.getTag(Const.RUSH_BUY_LF, Const.RUSH_BUY_RT, bagHtml);
			List<String> strList = ut.getTagList(Const.RUSH_BUY_LIST_LF, Const.RUSH_BUY_LIST_RT, tableStr);
			for(String t : strList){
				String id = ut.getTag(Const.RUSH_BUY_LIST_ID_LF, Const.RUSH_BUY_LIST_ID_RT, t);
				String name = ut.getTag(Const.RUSH_BUY_LIST_NAME_LF, Const.RUSH_BUY_LIST_NAME_RT, t);
				String num = ut.getTag(Const.RUSH_BUY_LIST_NUM_LF, Const.RUSH_BUY_LIST_NUM_RT, t);
				String price = ut.getTag(Const.RUSH_BUY_LIST_PRICE_LF, Const.RUSH_BUY_LIST_PRICE_RT, t);
				listRush.add(new ResRush(name, price, num, id));
			}
			Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
			    	rushBuyTable.setItems(FXCollections.observableArrayList(listRush));
			    }
			});
			
		}
		util.showText("ˢ����ɣ�");
		return null;
	}

}
