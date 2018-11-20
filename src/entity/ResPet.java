package entity;

import javafx.beans.property.SimpleStringProperty;

public class ResPet {
	private final SimpleStringProperty id;
	private final SimpleStringProperty name;
	private final SimpleStringProperty genre;
	private final SimpleStringProperty level;
	
	public ResPet(String id,String name,String genre,String level ){
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.genre = new SimpleStringProperty(genre);
		this.level = new SimpleStringProperty(level);
	}
	
	public String getId(){
		return id.get();
	}
	public String getName(){
		return name.get();
	}
	public String getGenre(){
		return genre.get();
	}
	public String getLevel(){
		return level.get();
	}
	
	public void setGenre (String genre){
		this.genre.set(genre);
	}
	public void setId (String id){
		this.id.set(id);
	}
	public void setName (String name){
		this.name.set(name);
	}
	public void setLevel (String level){
		this.level.set(level);
	}

	@Override
	public String toString() {
		return "ResSale [id:" + id.get() + ", name:" + name.get() + ", genre:" + genre.get() + ", level:" + level.get() + "]";
	}
}
