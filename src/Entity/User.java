package Entity;
/** 
* @author Soy 
* @date 2017年11月22日 上午10:43:39 
* @version 1.0 
*/
public class User {
	private String userName;
	private String passWord;
	private String name;
	private String daqu;
	
	public User(String userName,String passWord,String name,String daqu){
		this.userName = userName;
		this.passWord = passWord;
		this.name = name;
		this.daqu = daqu;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDaqu() {
		return daqu;
	}
	public void setDaqu(String daqu) {
		this.daqu = daqu;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", passWord=" + passWord + ", name=" + name + ", daqu=" + daqu + "]";
	}
}
