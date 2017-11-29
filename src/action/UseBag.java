package action;

import java.util.Map;

import Entity.Res;
import javafx.concurrent.Task;
import soyUtils.IntUtil;

public class UseBag extends Task{
	private Res res;
	private IntUtil util;
	public UseBag (Res res,IntUtil util){
		this.res = res;
		this.util = util;
	}

	@Override
	protected Object call() throws Exception {
		String url = "function/usedProps.php?id=";
		String id = res.getId();
		String name = res.getName();
		url = url + id;
		Map retMap = util.get(url);
		if ((int)retMap.get("code") != 200){
			util.showText(" π”√ ß∞‹£°");
		}else {
			String text = (String) retMap.get("body");
			if(text.indexOf("login") != -1){
				util.showText("Õ¯¬Á÷–∂œ...");
			}else{
				util.showText(text);
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

}
