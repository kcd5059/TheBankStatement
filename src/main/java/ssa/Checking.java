package ssa;

public class Checking extends Account {
	
	private int lastCheckNumber = 100;
	
	public Checking() {}
	
	public Checking(double initialBalance) {
		super(initialBalance);
	}
	
	public Checking(int id, double initialBalance) {
		super(id, initialBalance);
	}
	
	public double withdraw(double withdrawalAmount) {
		lastCheckNumber++;
		return super.withdraw(withdrawalAmount);
	}

	public int getLastCheckNumber() {
		return lastCheckNumber;
	}

	public void setLastCheckNumber(int lastCheckNumber) {
		this.lastCheckNumber = lastCheckNumber;
	}
	
	public String print() {
		return "C" + " " + super.print() + " " + this.getLastCheckNumber();
	}
	
	

}
