package action;

import java.util.List;

import javafx.concurrent.Task;
import soyUtils.IntUtil;

/**
 * @version: 1.0
 * @Description: 
 * @author: Soy
 * @date: 2018��11��13��
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
			util.showText("�������淶��"+item);
		}else{
			
			
		}
		Thread.sleep(1000);
		return null;
	}

}
