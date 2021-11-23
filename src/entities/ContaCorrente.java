package entities;

public class ContaCorrente extends Conta {
	
	private Double limiteEmprestimo;
	
	public ContaCorrente() {	
		super();
	}

	public ContaCorrente(int conta, String nome, double deposito, Double limiteEmprestimo) {
		super(conta, nome, deposito);
		this.limiteEmprestimo = limiteEmprestimo;
	}

	public Double getLimiteEmprestimo() {
		return limiteEmprestimo;
	}

	public void setLimiteEmprestimo(Double limiteEmprestimo) {
		this.limiteEmprestimo = limiteEmprestimo;
	}
	
	public void loan(Double montante) {
		if(montante <= limiteEmprestimo)
		saldo += montante - 10.0;
	}
	
	@Override
	public void retirada(double amount) {
		super.retirada(amount);
		saldo -= 2.0;
	}
	

}
