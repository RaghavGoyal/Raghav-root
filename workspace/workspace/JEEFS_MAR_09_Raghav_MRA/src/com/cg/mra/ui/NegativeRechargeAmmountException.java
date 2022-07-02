package com.cg.mra.ui;

public class NegativeRechargeAmmountException extends Exception {
	
	public String toString(){
	     return ("ERROR: Cannot Recharge Account as Give Amount is in Negative") ;
	  }

}
