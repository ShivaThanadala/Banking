package com.jsp.BankManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.BankManagementSystem.Entity.BankManagementSystem;

public interface BankRepository extends JpaRepository<BankManagementSystem, Integer> {
	public BankManagementSystem findByUseraccountnoAndUserpassword(String Useraccountno, String Userpassword);

	public BankManagementSystem findByIfscodeAndUserpassword(String ifscode, String userpassword);

	public BankManagementSystem searchByUsermobilenumberAndUserpasswordAndUseraccountno(String Usermobilenumber,
			String Userpasswor, String Useraccountno);

	public BankManagementSystem searchByUsermobilenumber(String usermobilenumber);
	public BankManagementSystem findByUseraccountno(String useraccountno);
}