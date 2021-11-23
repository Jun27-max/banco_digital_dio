package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.ContaCorrente;
import entities.Conta;
import entities.Poupanca;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		//Conta acc = new Conta(1001, "Alex", 0.0);
		ContaCorrente bacc = new ContaCorrente(1002, "Maria", 0.0, 500.0);
		List<Conta> list = new ArrayList<>();
		
		
		//UPCASTING
		Conta acc1 = bacc;
		Conta acc2 = new ContaCorrente(1003, "Bob", 500.0, 200.0);
		Conta acc3 = new Poupanca(1004, "Anna", 100.0, 0.001);
		
		//DOWNCASTING
		ContaCorrente acc4 = (ContaCorrente)acc2;
		acc4.loan(100.00);
		
		//BusinessAccount acc5 = (BusinessAccount)acc3;
		if(acc3 instanceof ContaCorrente) {
			ContaCorrente acc5 = (ContaCorrente)acc3;
			acc5.loan(200.0);
			System.out.println("Emprestado");
		}
		
		if(acc3 instanceof Poupanca) {
			Poupanca acc5 = (Poupanca)acc3;
			acc5.updateBalance();
			System.out.println("Atualizado !");
		}
		
		//Conta acc6 = new Conta(1001, "Alex", 1000.0);
		//acc6.retirada(200.0);
		//System.out.println(acc6.getSaldo());
		
		Conta acc7 = new Poupanca(1002, "Franco", 1000.0, 0.01);
		acc7.retirada(200.0);
		System.out.println(acc7.getSaldo());
		
		Conta acc8 = new ContaCorrente(1003, "José", 1000.0, 0.10);
		acc8.retirada(200.0);
		System.out.println(acc8.getSaldo());
		
		list.add(new Poupanca(1001, "Alex", 500.0, 0.01));
		list.add(new ContaCorrente(1009, "Maria", 1000.0, 400.0));
		list.add(acc2);
		list.add(acc3);
		
		double sum = 0.0;
		for(Conta acc : list) {
			sum += acc.getSaldo();
		}
		
		System.out.printf("Saldo total das contas %.2f%n", sum);
		
		System.out.println("Incluíndo Dez reais para cada conta");
		for(Conta acc : list) {
			acc.deposito(10.00);
		}
		
		System.out.println("Extrato");
		for(Conta acc : list) {
			System.out.printf("Atualização no valor de cada conta %d: %.2f %n", acc.getConta(),acc.getSaldo());
		}

		
		System.out.println("Saldo inicial");
		System.out.printf("Saldo Conta: %d: %.2f %n" , acc8.getConta() , acc8.getSaldo());
		System.out.printf("Saldo Conta: %d: %.2f %n" , acc7.getConta() , acc7.getSaldo());
		
		System.out.println("Após Tranferência");
		acc8.transferir(500, acc7);
		System.out.printf("Saldo Conta: %d: %.2f %n" , acc8.getConta() , acc8.getSaldo());
		System.out.printf("Saldo Conta: %d: %.2f %n" , acc7.getConta() , acc7.getSaldo());
		
	}

}
