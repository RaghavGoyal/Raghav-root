package com.capg.banking.beans;

public class Account {
		
		private String accountNo;
		private String accountType;
		private String customerName;
		private double accountBalance;

		public Account(String accountType, String customerName, double accountBalance) {
			this.accountType = accountType;
			this.customerName = customerName;
			this.accountBalance = accountBalance;
		}
		
		public String getAccountNo() {
			return accountNo;
		}
		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public double getAccountBalance() {
			return accountBalance;
		}
		public void setAccountBalance(double accountBalance) {
			this.accountBalance = accountBalance;
		}


}
