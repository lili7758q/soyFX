package action;

import java.util.List;
import java.util.Map;

import javafx.concurrent.Task;
import javafx.scene.control.TextArea;
import soyUtils.IntUtil;

/**
 * @version: 1.0
 * @Description: 
 * @author: Soy
 * @date: 2018年11月13日
 */
public class RushBuyPre extends Task{
	private IntUtil util;
	private String item;
	
	public RushBuyPre(IntUtil util,String item){
		this.util = util;
		this.item = item;
	}

	@Override
	protected Object call() throws Exception {
		String[] itemList = item.split(",");
		if(itemList.length != 3){
			util.showText("参数不规范："+item);
		}else{
			Map retMap;
			String id = itemList[0];
			int perNum = Integer.parseInt(itemList[1]);
			int total = Integer.parseInt(itemList[2]);
			int time = total%perNum==0 ? total/perNum : total/perNum+1;
			String url = "function/smbuyGate.php?bid="+id+"&n="+perNum;
			int buyNum = 0;
			for(;;){
				System.out.println("**************" +id + "******************");
				retMap = util.get(url);
				if ((int)retMap.get("code") != 200){
					util.showText("购买失败！code:"+retMap.get("code"));
					continue;
				}else{
					String ret = (String)retMap.get("body");
					if(ret.equals("0")){
						util.addBuyRecord("买入"+id+","+perNum+"个！");
						buyNum++;
						if(buyNum == time){
							break;
						}else if(buyNum == time-1){
							if(total%perNum!=0){
								url = "function/smbuyGate.php?bid="+id+"&n="+total%perNum;
								perNum = total%perNum;	
							}
						}
					}else if(ret.indexOf("购买时间")>0){
						util.showText("操作太快，购买时间间隔太短！");
					}else if(ret.indexOf("未开启")>0){
						util.addBuyRecord("活动未开启！");
						break;
					}else if(ret.equals("10")){
						util.addBuyRecord("元宝不够！");
						break;
					}else if(ret.equals("4")){
						util.addBuyRecord("包裹空间不足！");
						break;
					}else if (ret.indexOf("login") != -1){
						util.showText("网络中断...垃圾服务器");
					}else{
						util.addBuyRecord(ret);
						break;
					}
				}
				Thread.sleep(1000);
			}
		}
		util.addBuyRecord(itemList[0]+"购买结束！");
		return null;
	}

}
