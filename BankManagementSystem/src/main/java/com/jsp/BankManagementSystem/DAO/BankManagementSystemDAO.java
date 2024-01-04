package com.jsp.BankManagementSystem.DAO;

import com.jsp.BankManagementSystem.Entity.BankManagementSystem;

public interface BankManagementSystemDAO {
	
	void SingleUserById(int id);

	void userRegistration(BankManagementSystem bank);

	void debitAmount(String accountNo, String Password);

	void creditAmount(String mobileNo, String password, String accountNo);

	void changingPassword(String accountNo, String password);

	void deleteAccount(String accountNo);

	void mobileToMobileTansaaction(String mobileNo);

	void selectAllUsers();
	
	void selectByUsingIFSCodeAndPass(String ifsc,String pass);
	void selectByMobileAndAccountAndPassword(String mb,String  pass,String add);
	
	void findUserDetailsByMobileNo(String mb);
}
