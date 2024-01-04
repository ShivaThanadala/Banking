package com.jsp.BankManagementSystem;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.BankManagementSystem.Config.BankConfig;
import com.jsp.BankManagementSystem.DAO.BankManagementSystemDAO;
import com.jsp.BankManagementSystem.DAO.BankManagementSystemDAOImpl;
import com.jsp.BankManagementSystem.Entity.BankManagementSystem;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BankConfig.class);
		BankManagementSystemDAO implDAO = context.getBean(BankManagementSystemDAOImpl.class);
		BankManagementSystem bank = new BankManagementSystem();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 For Your Registration : ");
		System.out.println("Enter 2 For Find By ID Of Your Details : ");
		System.out.println("Enter 3 For All Your Details : ");
		System.out.println("Enter 4 For Find Details By using IFSC Code And Passsword : ");
		System.out.println("Enter 5 For Get Details By using Mobile umber And Address And Password : ");
		System.out.println("Enter 6 For Debit Amount : ");
		System.out.println("Enter 7 for Search User By Mobile Number : ");
		System.out.println("Enter 8 for Mobile To Mobile Transaction : ");
		System.out.println("Enter 9 To Update New PAssword : ");
		System.out.println("Enter 10 For Delete Account : ");
		try {
		int i = sc.nextInt();
		switch (i) {
		case 1:
			System.out.println("***--- Welcome To TECA 89 BANK ---***");
			try {
				Thread.sleep(500);
				System.out.print("Enter Your Name :- ");
				bank.setUsername(sc.next());
				System.out.print("Enter Your Phone Number :- ");
				boolean status=true;
				while(status) {
				String mb = sc.next();
				if (mb.length() == 10) {
					status=false;
					bank.setUsermobilenumber(mb);
				} else {
					System.err.println("Re-Enter 10 Digit Mobile Number");
					status=true;
				}
				}
				
				System.out.print("Enter Amount :- ");
				bank.setUseramount(sc.nextDouble());
				System.out.print("Enter Your E-mail Id :- ");
				bank.setUseremail(sc.next());
				System.out.print("Enter Your Account Number :- ");
				bank.setUseraccountno(sc.next());
				System.out.print("Enter Your Address :- ");
				bank.setUseraddress(sc.next());
				System.out.println("Enter Your Password :- ");
				bank.setUserpassword(sc.next());
				
				bank.setIfscode("SBI-12347");
				bank.setUserbranchname("KPHB-Branch");
				implDAO.userRegistration(bank);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 2:
			System.out.print("Enter Your Id :- ");
			implDAO.SingleUserById(sc.nextInt());
			break;
		case 3:
			implDAO.selectAllUsers();
			break;
		case 4:
			System.out.println("Enter Your IFSC Code");
			String ifc=sc.next();
			System.out.println("Enter Your Password ");
			String ifPass= sc.next();
			
			implDAO.selectByUsingIFSCodeAndPass(ifc,ifPass);
			break;
		case 5:
			System.out.println("Enter Mobile Number : ");
			String mb=sc.next();
			System.out.println("Enter Your Account Number : ");
			String add=sc.next();
			System.out.println("Enter Your Password : ");
			String pass=sc.next();
			implDAO.selectByMobileAndAccountAndPassword(mb, pass, add);
			break;
		case 6:
			System.out.println("Enter Account Number :- ");
			String acc=sc.next();
			System.out.println("Enter Password :- ");
			String password = sc.next();
			implDAO.debitAmount(acc, password);
			break;
		case 7:
			System.out.print("Enter Mobile Number :- ");
			implDAO.findUserDetailsByMobileNo(sc.next());
			break;
		case 8:
			implDAO.mobileToMobileTansaaction("9291516227");
			break;
		case 9:
			System.out.println("Enter Account Number :");
			String accountNo = sc.next();
			System.out.println("Enter  Old Password  :");
			String oldPassword = sc.next();
			implDAO.changingPassword(accountNo, oldPassword);
			break;
		case 10:
			System.out.println("Enter Account Number : ");
			implDAO.deleteAccount(sc.next());
			break;
		default:
			break;
		}
		}catch (Exception e) {
			System.out.println("Select Valid Option...!");
		}

	}
}
