package action;

import java.util.Map;

import javafx.concurrent.Task;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import soyUtils.Const;
import soyUtils.IntUtil;
import soyUtils.SoyUtils;

public class ShowTips extends Task{
	private IntUtil util;
	private String id ;
	private TextArea rushBuyTips;
	
	public ShowTips (IntUtil util,String id,TextArea rushBuyTips ){
		this.util = util;
		this.id = id;
		this.rushBuyTips = rushBuyTips;
	}

	@Override
	protected Object call() throws Exception {
		String toUrl = "function/getPropsInfo.php?equip=1&id="+id;
		Map retMap = util.get(toUrl);
		if((int)retMap.get("code") != 200){
			return null;
		}else{
			String bagHtml = (String) retMap.get("body");
			SoyUtils ut = new SoyUtils();
			String name = ut.getTag(Const.ITEM_INFO_TIPS_NAME_LF, Const.ITEM_INFO_TIPS_NAME_RT, bagHtml);
			String sale = ut.getTag(Const.ITEM_INFO_TIPS_SALE_LF, Const.ITEM_INFO_TIPS_SALE_RT, bagHtml);
			String text = ut.getTag(Const.ITEM_INFO_TIPS_TEXT_LF, Const.ITEM_INFO_TIPS_TEXT_RT, bagHtml);
			util.setRushBuyTips(rushBuyTips);
			util.showTips(name,true);
			util.showTips(sale,false);
			util.showTips(text,false);
		}
		return null;
	}

}
