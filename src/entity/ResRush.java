package entity;

import javafx.beans.property.SimpleStringProperty;

public class ResRush {
	private final SimpleStringProperty rushBuyName;
	private final SimpleStringProperty rushBuyPrice;
	private final SimpleStringProperty rushBuyNum;
	private final SimpleStringProperty rushBuyId;

	public ResRush(String rushBuyName,String rushBuyPrice,String rushBuyNum,String rushBuyId){
		this.rushBuyName = new SimpleStringProperty(rushBuyName);
		this.rushBuyPrice = new SimpleStringProperty(rushBuyPrice);
		this.rushBuyNum = new SimpleStringProperty(rushBuyNum);
		this.rushBuyId = new SimpleStringProperty(rushBuyId);
	}

	public String getRushBuyName() {
		return rushBuyName.get();
	}

	public String getRushBuyPrice() {
		return rushBuyPrice.get();
	}

	public String getRushBuyNum() {
		return rushBuyNum.get();
	}

	public String getRushBuyId() {
		return rushBuyId.get();
	}
	
	public void setRushBuyPrice(String rushBuyPrice) {
		this.rushBuyPrice.set(rushBuyPrice);
	}
	
	public void setRushBuyNum(String rushBuyNum) {
		this.rushBuyNum.set(rushBuyNum);
	}
	
	public void setRushBuyId(String rushBuyId) {
		this.rushBuyId.set(rushBuyId);
	}
	
	public void setRushBuyName(String rushBuyName) {
		this.rushBuyName.set(rushBuyName);
	}
}
