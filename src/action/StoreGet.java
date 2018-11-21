package action;

import java.util.List;
import java.util.Map;

import entity.Store;
import javafx.concurrent.Task;
import javafx.scene.control.TableView;
import soyUtils.IntUtil;

public class StoreGet extends Task{
	
	private IntUtil util;
	private List<Store> storeList;
	private boolean isList = false;
	private Store store;
	private int num;
	private String password;
	private TableView storeTable;
	
	public StoreGet(IntUtil util ){
		this.util = util;
	}
	
	public void setListGet(List<Store> list,boolean isList){
		this.isList = isList;
		this.storeList = list;
	}
	
	public void setSingleGet(Store store,int num){
		this.store = store;
		this.num = num;
	}
	
	public void setTable(String password,TableView storeTable){
		this.password = password;
		this.storeTable = storeTable;
	}

	@Override
	protected Object call() throws Exception {
		try{
			if(isList){
				boolean flag = true;
				for(int i=0; i<storeList.size(); i++){
					if(flag){
						flag = getStore (storeList.get(i),0);
						Thread.sleep(5100);
					}else{
						break;
					}
				}
				refresh();
			}else{
				getStore (store,num);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	private boolean getStore (Store store,int num) throws Exception {
		String id = store.getStoreId();
		int getNum;
		if(num == 0){
			getNum = store.getStoreNum();
		}else{
			getNum = num;
		}
		String toUrl = "function/baseGate.php?bid="+id+"&n="+getNum+"&op=g"; 
		Map retMap = util.get(toUrl);
		if((int)retMap.get("code") != 200){
			util.showText("取出失败！");
		}else{
			String bagHtml = (String) retMap.get("body");
			if(bagHtml.equals("0")){
				util.showText("成功取出 "+store.getStoreName() + " "+getNum+"个");
				if(!isList){
					refresh();
				}
				return true;
			}else if(bagHtml.equals("5")){
				util.showText("背包空间不足！");
				return false;
			}else if(bagHtml.equals("10")){
				util.showText("仓库中没有足够的物品可以取出！");
				return false;
			}else{
				util.showText("取出"+store.getStoreName() + "失败！");
				System.out.println(bagHtml);
				return false;
			}
		}
		
		return true;
	}
	
	private void refresh(){
		RefreshStore get = new RefreshStore(util, password,storeTable);
		Thread th = new Thread(get);
		th.start();
	}

}
