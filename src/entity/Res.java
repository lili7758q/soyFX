package entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/** 
* @author Soy 
* @date 2017年11月27日 下午5:25:52 
* @version 1.0 
*/
public class Res {
	private final SimpleStringProperty id;
	private final SimpleStringProperty name;
	private final SimpleIntegerProperty num;
	private final SimpleStringProperty bagSort;
	
	public Res(String id,String name,int num,String bagSort ){
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.num = new SimpleIntegerProperty(num);
		this.bagSort = new SimpleStringProperty(bagSort);
	}
	
	public String getId(){
		return id.get();
	}
	public String getName(){
		return name.get();
	}
	public int getNum(){
		return num.get();
	}
	public String getBagSort(){
		return bagSort.get();
	}
	
	public void setBagSort (String bagSort){
		this.bagSort.set(bagSort);
	}
	public void setId (String id){
		this.id.set(id);
	}
	public void setName (String name){
		this.name.set(name);
	}
	public void setNum (int num){
		this.num.set(num);
	}

	@Override
	public String toString() {
		return "Res [id:" + id.get() + ", name:" + name.get() + ", num:" + num.get() + ", bagSort:" + bagSort.get() + "]";
	}

	
	

}
