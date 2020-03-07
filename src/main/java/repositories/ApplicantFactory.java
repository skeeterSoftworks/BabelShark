package repositories;

import java.util.ArrayList;
import java.util.List;

import models.BankData;

public class ApplicantFactory {

	 public static List<BankData> create() {
	       
	       List<BankData> banks = new ArrayList<>();
	 
	       BankData b1 = new BankData();
	       b1.setCountry("Guatemala");
	       b1.setAccountNumberRIB("11");
	       b1.setAccountNumberIBAN("12");
	       b1.setNameOfTheBank("Tristesa");
	       banks.add(b1);
	 
	       BankData b2 = new BankData();
	       b2.setCountry("Frop");
	       b2.setAccountNumberRIB("1122");
	       b2.setAccountNumberIBAN("123333");
	       b2.setNameOfTheBank("Zwitte");
	       banks.add(b2);
	      
	      return banks;

	   }
	}