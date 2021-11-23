package entities;

public class Poupanca extends Conta {
	
	private double interestRate;
	
	public Poupanca() {
		super();
	}

	public Poupanca(int conta, String nome, double deposit, double interestRate) {
		super(conta, nome, deposit);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void updateBalance() {
		saldo += saldo * interestRate;
	}
	
	@Override
	public void retirada(double amount) {
		saldo -= amount;
	}
	

}
