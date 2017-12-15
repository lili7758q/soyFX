package Entity;
/** 
* @author Soy 
* @date 2017年12月15日 上午11:26:14 
* @version 1.0 
*/
public class MapValue {
	private String id;
	private String name;
	
	public MapValue (String id,String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
