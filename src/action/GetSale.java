package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import Entity.ResSale;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.scene.control.TableView;
import soyUtils.Const;
import soyUtils.IntUtil;
import soyUtils.SoyUtils;

/** 
* @author Soy 
* @date 2017年11月28日 上午11:08:30 
* @version 1.0 
*/
public class GetSale extends Task{
	static Logger log = Logger.getLogger(GetSale.class);
	private IntUtil util;
	private TableView table;
	private int sort = 0;
	
	public GetSale(IntUtil util,TableView table){
		this.util = util;
		this.table = table;
	}
	
	public void setSort (int sort){
		this.sort = sort;
	}

	@Override
	protected Object call() throws Exception {
		util.showText("刷新交易所...");
		String url = "function/Pai_Mod.php";
		Map retMap = util.get(url);
		if((int)retMap.get("code") != 200){
			util.showText("刷新失败！");
		}else{
			String body = (String) retMap.get("body");
			SoyUtils ut = new SoyUtils();
			List<ResSale> resSale = new ArrayList<ResSale>();
			String shop = ut.getTag(Const.SALELIST_LEFT, Const.SALELIST_RIGHT, body);
			List<String> shopList = ut.getTagList(Const.SALE_LEFT, Const.SALE_RIGHT, shop);
			for(String m :shopList){
				String id = ut.getTag(Const.SALEID_LEFT, Const.SALEID_RIGHT, m);
				String name = ut.getTag(Const.SALENAME_LEFT, Const.SALENAME_RIGHT, m);
				String price = ut.getTag(Const.SALEPRICE_LEFT, Const.SALEPRICE_RIGHT, m);
				String num = ut.getTag(Const.SALENUM_LEFT, Const.SALENUM_RIGHT, m);
				resSale.add(new ResSale(id,name,num,price));
			}
			Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
					table.setItems(FXCollections.observableArrayList(resSale));
			    }
			});
			util.showText("刷新完成！");
		}
		return null;
	}

}
