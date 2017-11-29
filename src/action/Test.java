package action;

import javafx.concurrent.Task;
import javafx.scene.control.Button;

/** 
* @author Soy 
* @date 2017年11月29日 下午5:08:49 
* @version 1.0 
*/
public class Test extends Task{
	public volatile boolean exit = false;  
	private int i = 1;

	@Override
	protected Object call() throws Exception {
		while(!exit){
			System.out.println(i++);
		}
		return null;
	}

}
