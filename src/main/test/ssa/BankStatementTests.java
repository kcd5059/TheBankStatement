package ssa;

import static org.junit.Assert.*;

import org.junit.Test;

public class BankStatementTests {

	Checking account = new Checking(111, 100);
	Checking account2 = new Checking(100);
	Checking checking = new Checking(500);
	Savings savings = new Savings(222, 1000);

	@Test
	public void tests() {

		// Checking tests
		// Test checkNumber initialization
		assertEquals(100, account.getLastCheckNumber());
		// Check initialBalance
		assertEquals(500, checking.getBalance(), 0);
		// check withdraw method and subsequent lastCheckNumber incrementing
		assertEquals(250, checking.withdraw(250), 0);
		assertEquals(101, checking.getLastCheckNumber());
		// Test Checking setters
		account.setLastCheckNumber(200);
		assertEquals(200, account.getLastCheckNumber());

		// Account tests
		// Check setDescription method
		account.setDescription("My account");
		assertTrue(account.getDescription().equals("My account"));
		// Test setBalance (constructor I used calls this private method)
		assertEquals(100, account.getBalance(), 0);
		// Test setId method (constructor I used calls this private method)
		assertEquals(111, account.getId());
		// Test withdraw method
		assertEquals(50, account.withdraw(50), 0);
		// Test deposit method
		assertEquals(100, account.deposit(50), 0);
		// Test transferFrom method
		account.transferFrom(account2, 100);
		assertEquals(200, account.getBalance(), 0);
		assertEquals(0, account2.getBalance(), 0);
		// Test withdrawal of negative numbers countermeasure
		assertEquals(200, account.withdraw(-100), 0);
		// Test depositing of negative numbers countermeasure
		assertEquals(200, account.deposit(-100), 0);
		// Test print method
		assertEquals("C 111 My account                   200.00 202", account.print());

		// Savings tests
		// Test calcDepositInterest
		assertEquals(5, savings.calcDepositInterest(4), 0);
		assertEquals(1005, savings.getBalance(), 0);
		// Test setInterestRate
		savings.setInterestRate(30);
		assertEquals(.3, savings.getInterestRate(), 0);
		// Test setting negative interest rate
		savings.setInterestRate(-.015);
		assertEquals(.3, savings.getInterestRate(), 0);
		// Test calcDepositInterest with new interest rate
		assertEquals(150.75, savings.calcDepositInterest(6), 0);
		assertEquals(1155.75, savings.getBalance(), 0);
		// Test minimum balance restriction
		savings.setMinimumBalance(1155.76);
		assertEquals(0, savings.calcDepositInterest(2), 0);
		// Test totalInterestPaid tracking
		assertEquals(155.75, savings.getTotalInterestPaid(), 0);
		// Test print method
		savings.setInterestRate(.015);
		savings.setDescription("My Savings");
		savings.withdraw(655.75);
		assertEquals("S 222 My Savings                   500.00      1.50", savings.print());

	}
}
