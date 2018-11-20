package entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Store {

	private final SimpleStringProperty storeName;
	private final SimpleIntegerProperty storeNum;
	private final SimpleStringProperty storeId;
	
	public Store(String storeName,int storeNum,String storeId){
		this.storeName = new SimpleStringProperty(storeName);
		this.storeNum = new SimpleIntegerProperty(storeNum);
		this.storeId = new SimpleStringProperty(storeId);
	}
	
	public String getStoreName() {
		return storeName.get();
	}

	public int getStoreNum() {
		return storeNum.get();
	}

	public String getStoreId() {
		return storeId.get();
	}
	
	public void setStoreNum(int StoreNum) {
		this.storeNum.set(StoreNum);
	}
	
	public void setStoreId(String StoreId) {
		this.storeId.set(StoreId);
	}
	
	public void setStoreName(String StoreName) {
		this.storeName.set(StoreName);
	}
}
