package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Entity.Res;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.scene.control.TableView;
import soyUtils.Const;
import soyUtils.IntUtil;
import soyUtils.SoyUtils;

/** 
* @author Soy 
* @date 2017年11月27日 下午6:36:06 
* @version 1.0 
*/
public class GetBag extends Task{
	private IntUtil util;
	private TableView bagTable;
	private boolean isSort = false;
	
	public GetBag (IntUtil util ,TableView bagTable){
		this.util = util;
		this.bagTable = bagTable;
	}
	
	public void setSort(boolean isSort){
		this.isSort = isSort;
	}

	@Override
	protected Object call() throws Exception {
		util.showText("刷新背包中...");
		String toUrl = "function/getBag.php?style=1";
		if(isSort){
			toUrl = "function/getBag.php?clean=1&style=1";
		}
		Map retMap = util.get(toUrl);
		if((int)retMap.get("code") != 200){
			util.showText("刷新背包失败！");
		}else{
			String bagHtml = (String) retMap.get("body");
			List<Res> listBag = new ArrayList<Res>();
			SoyUtils ut = new SoyUtils();
			List<String> list = ut.getTagList(Const.BAG_LEFT, Const.BAG_RIGHT, bagHtml);
			for(String t : list){
				String id = ut.getTag(Const.ID_LEFT, Const.ID_RIGHT, t);
				String name = ut.getTag(Const.NAME_LEFT, Const.NAME_RIGHT, t) ;
				String num = ut.getTag(Const.NUM_LEFT, Const.NUM_RIGHT, t);
				String bagSort = ut.getTag(Const.SORT_LEFT, Const.SORT_RIGHT, t);
				listBag.add(new Res(id,name,num,bagSort));
			}
			bagTable.setItems(FXCollections.observableArrayList(listBag));
		}
		util.showText("刷新完成！");
		return null;
	}

}
