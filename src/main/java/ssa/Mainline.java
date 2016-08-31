package ssa;

import java.util.ArrayList;

public class Mainline {

	public static void main(String[] args) {
		
		Savings savings1 = new Savings(110, 0);
		savings1.setDescription("Savings A");
		savings1.deposit(500.00);
		savings1.setInterestRate(0.025);

		Checking checking2 = new Checking(120, 0);
		checking2.setDescription("Checking B");
		checking2.setLastCheckNumber(100);
		checking2.deposit(400.00);

		Savings savings3 = new Savings(130, 0);
		savings3.setDescription("Savings C");
		savings3.deposit(800.00);
		savings3.setInterestRate(0.015);

		Checking checking4 = new Checking(140, 0);
		checking4.setDescription("Checking D");
		checking4.setLastCheckNumber(230);
		checking4.deposit(200.00);

		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts.add(savings1);
		accounts.add(checking2);
		accounts.add(savings3);
		accounts.add(checking4);

		System.out.println("T Act Description                  Bal    Chk  Rate");
		System.out.println("= === ============================ ====== ===  ====");
		for(Account account : accounts) {
		    System.out.println(account.print());
		}


	}

}
