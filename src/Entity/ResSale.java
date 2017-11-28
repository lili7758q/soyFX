package Entity;

import javafx.beans.property.SimpleStringProperty;

/** 
* @author Soy 
* @date 2017年11月28日 上午11:00:47 
* @version 1.0 
*/
public class ResSale {
	private final SimpleStringProperty id;
	private final SimpleStringProperty name;
	private final SimpleStringProperty num;
	private final SimpleStringProperty price;
	
	public ResSale(String id,String name,String num,String price ){
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.num = new SimpleStringProperty(num);
		this.price = new SimpleStringProperty(price);
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
	public String getPrice(){
		return price.get();
	}
	
	public void setPrice (String price){
		this.price.set(price);
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
		return "ResSale [id:" + id.get() + ", name:" + name.get() + ", num:" + num.get() + ", price:" + price.get() + "]";
	}
}
