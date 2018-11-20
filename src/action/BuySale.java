package action;

import java.util.Map;

import entity.ResSale;
import javafx.concurrent.Task;
import soyUtils.IntUtil;

/** 
* @author Soy 
* @date 2017��11��29�� ����3:22:52 
* @version 1.0 
* @Description buyType: 1��������  2���۸��� 
*/
public class BuySale extends Task{
	private IntUtil util;
	private ResSale res;
	private String total;
	private String num;
	private String price;
	private int buyType;
	
	public BuySale (IntUtil util,ResSale res,String num) {
		this.util = util;
		this.res = res;
		this.num = num;
	}
	
	public void setPrice (String price){
		this.price = price;
	}

	@Override
	protected Object call() throws Exception {
		if(buyType == 1){
			buy(res.getId(),this.num);
		}else if (buyType == 2){
			
		}
		
		return null;
	}
	
	private void buy(String id,String num) throws Exception{
		String url = "function/paibuyGate.php?bid="+id+"&n="+num;
		util.showText("������Ʒ...");
		Map retMap = util.get(url);
		if ((int)retMap.get("code") != 200){
			util.showText("����ʧ�ܣ�");
		}else{
			String ret = (String)retMap.get("body");
			if(ret.equals("0")){
				util.showText("����ɹ���");
			}else{
				if(!ret.equals("5")) util.showText("����ʧ�ܣ�");
			}
		}
	}

}
