package entities;


public abstract class Conta {

	private int conta;
	private String nome;
	protected double saldo;
	
	
	public Conta() {
		
	}

	public Conta(int conta, String nome) {
		this.conta = conta;
		this.nome = nome;
	}

	public Conta(int conta, String nome, double deposit) {
		this.conta = conta;
		this.nome = nome;
		deposito(deposit);
	}

	public int getConta() {
		return conta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void deposito(double amount) {
		saldo += amount;

	}

	public void retirada(double amount) {
		saldo -= amount + 5.0;
	}
	
	public void transferir(double amount, Conta destino) {
		this.retirada(amount);
		destino.deposito(amount);
	}

	@Override
	public String toString() {
		return "Account = " + conta + ", Holder = " + nome + ", Balance $ = " + String.format("%.2f", saldo);
	}

}
