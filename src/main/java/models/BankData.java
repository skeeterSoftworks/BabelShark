package models;

public class BankData {
	
	private String country;
	private String nameOfTheBank;
	private String accountNumberRIB;
	private String accountNumberIBAN;
	
	
	public BankData(){
		super();
	}
	
	
	public BankData(String country, String nameOfTheBank, String accountNumberRIB, String accountNumberIBAN) {
		super();
		this.country = country;
		this.nameOfTheBank = nameOfTheBank;
		this.accountNumberRIB = accountNumberRIB;
		this.accountNumberIBAN = accountNumberIBAN;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getNameOfTheBank() {
		return nameOfTheBank;
	}
	public void setNameOfTheBank(String nameOfTheBank) {
		this.nameOfTheBank = nameOfTheBank;
	}
	public String getAccountNumberRIB() {
		return accountNumberRIB;
	}
	public void setAccountNumberRIB(String accountNumberRIB) {
		this.accountNumberRIB = accountNumberRIB;
	}
	public String getAccountNumberIBAN() {
		return accountNumberIBAN;
	}
	public void setAccountNumberIBAN(String accountNumberIBAN) {
		this.accountNumberIBAN = accountNumberIBAN;
	}
	
	

}
