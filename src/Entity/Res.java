package Entity;

import javafx.beans.property.SimpleStringProperty;

/** 
* @author Soy 
* @date 2017年11月27日 下午5:25:52 
* @version 1.0 
*/
public class Res {
	private final SimpleStringProperty id;
	private final SimpleStringProperty name;
	private final SimpleStringProperty num;
	private final SimpleStringProperty bagSort;
	
	public Res(String id,String name,String num,String bagSort ){
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.num = new SimpleStringProperty(num);
		this.bagSort = new SimpleStringProperty(bagSort);
	}
	
	public String getId(){
		return id.get();
	}
	public String getName(){
		return name.get();
	}
	public String getNum(){
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
	public void setNum (String num){
		this.num.set(num);
	}

	@Override
	public String toString() {
		return "Res [id=" + id + ", name=" + name + ", num=" + num + "]";
	}
	

}
