package action;

import java.util.List;
import java.util.Map;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import soyUtils.Const;
import soyUtils.IntUtil;
import soyUtils.SoyUtils;

/** 
* @author Soy 
* @date 2017年12月18日 下午5:31:00 
* @version 1.0 
*/
public class GetPerson extends Task{
	private IntUtil util;
	private TextField textJB;
	private TextField textSJ;
	private TextField textYB;
	private TextField textName;
	private TextField textPetName;
	private ComboBox comboBoxMainSkill;

	public GetPerson (IntUtil util) {
		this.util = util;
	}
	
	public void setInfo (TextField textJB,TextField textSJ,TextField textYB,TextField textName,TextField textPetName,ComboBox comboBoxMainSkill) {
		this.textJB = textJB;
		this.textName = textName;
		this.textPetName = textPetName;
		this.textSJ = textSJ;
		this.textYB = textYB;
		this.comboBoxMainSkill = comboBoxMainSkill;
	}
	@Override
	protected Object call() throws Exception {
		SoyUtils ut = new SoyUtils();
		util.showText("获取玩家信息...");
		//个人信息
		Map ret2 = util.get("function/User_Mod.php");
		String body = (String)ret2.get("body");
		String name = ut.getTag(Const.PUB_NAME_LF, Const.PUB_NAME_RT, body);
		String JB = ut.getTag(Const.PUB_JB_LF, Const.PUB_JB_RT, body);
		String SJ = ut.getTag(Const.PUB_SJ_LF, Const.PUB_SJ_RT, body);
		String YB = ut.getTag(Const.PUB_YB_LF, Const.PUB_YB_RT, body);
		//宠物信息
		Map ret3 = util.get("function/Pets_Mod.php");
		String body3 = (String)ret3.get("body");
		String petName = ut.getTag(Const.PET_MAIN_LF, Const.PET_MAIN_RT, body3);
		//主宠技能
		String skillList = ut.getTag(Const.PET_MAIN_SKILLLIST_LF, Const.PET_MAIN_SKILLLIST_RT, body3);
		List skill = ut.getTagList(Const.PET_MAIN_SKILL_LF, Const.PET_MAIN_SKILL_RT, skillList);
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	textJB.setText(JB);
	 			textName.setText(name);
	 			textSJ.setText(SJ);
	 			textYB.setText(YB);
	 			textPetName.setText(petName);
	 			comboBoxMainSkill.setItems(FXCollections.observableArrayList(skill));
	 			comboBoxMainSkill.getSelectionModel().select(0);
		    }
		});
			util.showText("获取玩家信息完毕！");
			util.showText("你好，"+name);
		return null;
	}
	
}
