package action;

import java.util.Map;

import javafx.concurrent.Task;
import javafx.scene.control.TableView;
import soyUtils.IntUtil;

public class ShowTips extends Task{
	private IntUtil util;
	private String id ;
	
	public ShowTips (IntUtil util,String id ){
		this.util = util;
		this.id = id;
	}

	@Override
	protected Object call() throws Exception {
		String toUrl = "getPropsInfo.php?id="+id;
		Map retMap = util.get(toUrl);
		if((int)retMap.get("code") != 200){
			return null;
		}else{
			
		}
		return null;
	}

}
