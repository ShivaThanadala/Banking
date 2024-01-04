package com.jsp.BankManagementSystem.DAO;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.BankManagementSystem.Entity.BankManagementSystem;
import com.jsp.BankManagementSystem.Repository.BankRepository;

@Component
public class BankManagementSystemDAOImpl implements BankManagementSystemDAO {
	@Autowired
	BankRepository repository;

	public void userRegistration(BankManagementSystem bank) {
		BankManagementSystem save = repository.save(bank);
		if (save != null) {
			System.out.println("Data Inserted Successfully ...!");
		} else {
			System.err.println("Data not inserted into the data base...!");
		}

	}

	@Override
	public void debitAmount(String accountNo, String Password) {
		BankManagementSystem bank = repository.findByUseraccountnoAndUserpassword(accountNo, Password);
//		System.out.println(bank);
		Scanner scanner = new Scanner(System.in);

		if (bank != null) {

			System.out.println("Enter Your Amount");
			boolean status = true;
			while (status) {
				double useramount = scanner.nextDouble();
				if (useramount >= 0) {
					status = false;
					double databaseamount2 = bank.getUseramount();
					if (databaseamount2 >= 0) {
						double sub = databaseamount2 - useramount;
						bank.setUseramount(sub);
						BankManagementSystem save = repository.save(bank);
						if (save != null) {
							System.out.println("Debited Succesufully...!");
						} else {
							System.err.println("Server Error ");
						}
					} else {
						System.err.println("Insufficent Amount ");
					}

				} else {
					status = true;
					System.out.println("Invalid Amount");
					System.out.println("Enter Valid Amount");

				}
			}

		} else {
			System.out.println("No data Found");
		}
	}

	@Override
	public void creditAmount(String mobileNo, String password, String accountNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changingPassword(String accountNo, String password) {
		BankManagementSystem find = repository.findByUseraccountnoAndUserpassword(accountNo, password);
		Scanner sc = new Scanner(System.in);
		if (find != null) {
			System.out.println("Enter New Password : ");
			find.setUserpassword(sc.next());
			repository.save(find);
			System.out.println("New Password Updated ...!");
		} else {
			System.err.println("No Data Found");
		}

	}

	@Override
	public void deleteAccount(String accountNo) {
		BankManagementSystem account = repository.findByUseraccountno(accountNo);
		if (account != null) {
			repository.delete(account);
			System.out.println("Account is Deleted Succesfully...");
		} else {
			System.err.println("No Account Is Found ...!");
		}

	}

	@Override
	public void mobileToMobileTansaaction(String mobileNo) {
		BankManagementSystem search = repository.searchByUsermobilenumber(mobileNo);
		Scanner sc = new Scanner(System.in);
		if (search != null) {
//			System.out.println(search);
			System.out.println("Enter Recivers Mobile Number : ");
			boolean status = true;
			while (status) {
				String rmb = sc.next();
				String mb1 = "";
				for (int i = 0; i <= rmb.length() - 1; i++) {
					char ch = rmb.charAt(i);
					if (Character.isDigit(ch)) {
						mb1 += ch;
					}
				}
				if (mb1.length() == 10) {
					status = false;
//				System.out.println("Valid Number");
					BankManagementSystem search2 = repository.searchByUsermobilenumber(mb1);
					if (search.getUsermobilenumber().equalsIgnoreCase(mb1)) {
						System.err.println("It Is not For The Self transaction ");
					} else {
//						System.out.println(search2);
						double sAmount = search.getUseramount();
						System.out.println("Enter The Amount : ");
						boolean amountStatus = true;
						while (amountStatus) {
							double runamount = sc.nextDouble();
							if (runamount >= 0) {
								amountStatus = false;
								if (runamount <= sAmount) {
									amountStatus = false;
									double dataBaseAmount = search2.getUseramount();
									double add = dataBaseAmount + runamount;
									search2.setUseramount(add);
									repository.save(search2);
									double SubAmount = sAmount - runamount;
									search.setUseramount(SubAmount);
									repository.save(search);
									if (search2 != null) {
										System.out.println("Transaction Successfully Completed...!");
									} else {
										System.err.println("Transaction Failed...!");
									}
								} else {
									System.out.println("Insufficent Amount...!");
									System.err.println("Re-Enter Valid Amount");
									amountStatus = true;
								}

							} else {
								amountStatus = true;
								System.out.println("Re-Enter Valid Amount ....");
							}
						}
					}

				} else {
					status = true;
					System.err.println("Re-Enter Recivers Mobile Number : ");
				}
			}
		} else {
			System.err.println("No Data Found...!");
		}

	}

	@Override
	public void selectAllUsers() {
		List<BankManagementSystem> list = repository.findAll();
		for (BankManagementSystem ele : list) {
			System.out.println("User Name is " + ele.getUsername());
			System.out.println("User Phone Number is " + ele.getUsermobilenumber());
			System.out.println();
		}
	}

	@Override
	public void SingleUserById(int id) {
		BankManagementSystem managementSystem = repository.findById(id).orElse(new BankManagementSystem());
		if (managementSystem.getUserid() != null) {
//		System.out.println(managementSystem);

			System.out.println("User Name Is :-" + managementSystem.getUsername());

			System.out.println("User Phone Number Is :- " + managementSystem.getUsermobilenumber());

			System.out.println("User E-mail Id Is :- " + managementSystem.getUseremail());

			System.out.println("User Account Number Is :- " + managementSystem.getUseraccountno());

			System.out.println("User IFSC Code Is :- " + managementSystem.getIfscode());

			System.out.println("User Branch Name Is :- " + managementSystem.getUserbranchname());

			System.out.println("User Address Is :- " + managementSystem.getUseraddress());

			System.out.println("User Amount Is :- " + managementSystem.getUseramount());

			System.out.println("User Password Is :- " + managementSystem.getUserpassword());

		} else {
			System.err.println("No data Found...!");
		}

	}

	@Override
	public void selectByUsingIFSCodeAndPass(String ifsc, String pass) {
		BankManagementSystem IFSCAndPass = repository.findByIfscodeAndUserpassword(ifsc, pass);
		if (IFSCAndPass != null) {
			System.out.println(IFSCAndPass);
		} else {
			System.err.println("No Data Found...!");
		}

	}

	@Override
	public void selectByMobileAndAccountAndPassword(String mb, String pass, String add) {
		BankManagementSystem system = repository.searchByUsermobilenumberAndUserpasswordAndUseraccountno(mb, pass, add);
//		System.out.println(system);
		if (system != null) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter The Amount : ");
			double amount = sc.nextDouble();
			if (amount >= 0) {
				double databaseamount = system.getUseramount();
				double addingamount = amount + databaseamount;
				system.setUseramount(addingamount);
				BankManagementSystem save = repository.save(system);
				if (save != null) {
					System.out.println("Amount Created Successfully ...!");
				} else {
					System.err.println("Amount Not Creared ...!");
				}
			} else {
				System.err.println("Enter Valid Amount ");
			}
		} else {
			System.out.println("No Data Found ...!");
		}

	}

	@Override
	public void findUserDetailsByMobileNo(String mb) {
		BankManagementSystem searchByUsermobilenumber = repository.searchByUsermobilenumber(mb);
		if (searchByUsermobilenumber != null) {
			System.out.println(searchByUsermobilenumber);
		} else {
			System.err.println("No Data Found...!");
		}

	}

}
