package com.jsp.BankManagementSystem.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;

@Entity
@Table(name = "Bank_Management_System")
public class BankManagementSystem implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_Id")
	private Integer userid;

	@Column(name = "Account_Holder_Name", nullable = false, length = 45)
	private String username;

	@Column(name = "Account_Holder_AccountNo", nullable = false, length = 25, unique = true)
	private String useraccountno;

	@Column(name = "Account_Holder_Password", nullable = false, length = 25, unique = true)
	private String userpassword;

	@Column(name = "Account_Holder_Amount", nullable = true)
	private double useramount;

	@Column(name = "Account_Holder_Mobile_Number", nullable = false, length = 10, unique = true)
	private String usermobilenumber;

	@Column(name = "Account_Holder_Email", nullable = false, length = 35, unique = true)
	private String useremail;

	@Column(name = "Account_Holder_Address", nullable = false, length = 45)
	private String useraddress;

	@Column(name = "IFCCode", nullable = false, length = 25)
	private String ifscode;

	@Column(name = "BranchName", nullable = false, length = 25)
	private String Userbranchname;

	public BankManagementSystem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankManagementSystem(Integer userid, String username, String useraccountno, String userpassword,
			double useramount, String usermobilenumber, String useremail, String useraddress, String ifscode,
			String userbranchname) {
		super();
		this.userid = userid;
		this.username = username;
		this.useraccountno = useraccountno;
		this.userpassword = userpassword;
		this.useramount = useramount;
		this.usermobilenumber = usermobilenumber;
		this.useremail = useremail;
		this.useraddress = useraddress;
		this.ifscode = ifscode;
		Userbranchname = userbranchname;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseraccountno() {
		return useraccountno;
	}

	public void setUseraccountno(String useraccountno) {
		this.useraccountno = useraccountno;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public double getUseramount() {
		return useramount;
	}

	public void setUseramount(double useramount) {
		this.useramount = useramount;
	}

	public String getUsermobilenumber() {
		return usermobilenumber;
	}

	public void setUsermobilenumber(String usermobilenumber) {
		this.usermobilenumber = usermobilenumber;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public String getIfscode() {
		return ifscode;
	}

	public void setIfscode(String ifscode) {
		this.ifscode = ifscode;
	}

	public String getUserbranchname() {
		return Userbranchname;
	}

	public void setUserbranchname(String userbranchname) {
		Userbranchname = userbranchname;
	}

	@Override
	public String toString() {
		return "BankManagementSystem [userid=" + userid + ", username=" + username + ", useraccountno=" + useraccountno
				+ ", userpassword=" + userpassword + ", useramount=" + useramount + ", usermobilenumber="
				+ usermobilenumber + ", useremail=" + useremail + ", useraddress=" + useraddress + ", ifscode="
				+ ifscode + ", Userbranchname=" + Userbranchname + "]";
	}

}
