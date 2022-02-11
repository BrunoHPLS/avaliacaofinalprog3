package application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import entities.Computador;
import entities.LivroDigital;
import entities.LivroFisico;
import interfaces.Alugavel;
import interfaces.Compravel;
import interfaces.Emprestavel;
import interfaces.LivrariaItem;

public class Main {

	public static void main(String[] args) {
		List<LivrariaItem> itens = new ArrayList<>();
		itens.add(new LivroFisico(50,"Clean Code", "Informática", "Robert C. Martin", new BigDecimal("65.00"), 425, 24D, 17D, 2.2D));
		itens.add(new LivroFisico(100,"Harry Potter e a pedra filosofal", "Fantasia", "J.K. Rowling", new BigDecimal("25.00"), 208, 23D, 16D, 1.8D));
		itens.add(new LivroFisico(25,"Livro 3", "Romance", "Armando", new BigDecimal("105.00"), 300, 20D, 17D, 2.5D));
		itens.add(new LivroFisico(20,"Livro 4", "Ficção Científica", "Roberto", new BigDecimal("80.00"), 1000, 24D, 17D, 2.2D));
		itens.add(new LivroDigital("Clean Code", "Informática", "Robert C. Martin", new BigDecimal("95.00"),1207));
		itens.add(new LivroDigital("Design Patterns", "Informática", "Gang of Four", new BigDecimal("180.00"),500));
		itens.add(new LivroDigital("Harry Potter e a pedra filosofal", "Fantasia", "J.K. Rowling", new BigDecimal("35.00"),305));
		itens.add(new LivroDigital("Livro 4", "Ficção Científica", "Roberto", new BigDecimal("100.00"), 2500));
		itens.add(new Computador("Intel i7-10700, 12 RAM, 512GB"));
		itens.add(new Computador("Intel i5-12400, 8 RAM, 256GB"));
		itens.add(new Computador("Ryzen 5-5600G, 8 RAM, 526GB"));
		
		System.out.println("Todos:");
		itens.forEach((element) -> System.out.println(itens.indexOf(element)+" "+element));
		
		System.out.println("Compráveis");
		itens.forEach((element) -> {if(element instanceof Compravel){System.out.println(itens.indexOf(element)+" "+element);}});
		System.out.println("Alugáveis");
		itens.forEach((element) -> {if(element instanceof Alugavel){System.out.println(itens.indexOf(element)+" "+element);}});
		System.out.println("Emprestáveis");
		itens.forEach((element) -> {if(element instanceof Emprestavel){System.out.println(itens.indexOf(element)+" "+element);}});
		
		System.out.println("Exemplos:");
		
		System.out.println("Itens Compráveis:");
		Compravel compravel1 = (Compravel) itens.get(0);
		Compravel compravel2 = (Compravel) itens.get(5);
		System.out.println(compravel1.comprar(10));
		System.out.println(compravel2.comprar(10));
		try {
			Compravel compravel3 = (Compravel) itens.get(9);
			System.out.println(compravel3.comprar(10));
		}catch(Exception ex) {
			System.out.println("Computadores não são compráveis");
		}
		
		System.out.println("Itens Emprestáveis:");
		Emprestavel emprestavel1 = (Emprestavel) itens.get(0);
		Emprestavel emprestavel2 = (Emprestavel) itens.get(5);
		System.out.println(emprestavel1.emprestar(5));
		System.out.println(emprestavel2.emprestar(10));
		try {
			Emprestavel emprestavel3 = (Emprestavel) itens.get(9);
			System.out.println(emprestavel3.emprestar(10));
		}catch(Exception ex) {
			System.out.println("Computadores não são emprestáveis");
		}
		
		System.out.println("Itens Alugáveis:");
		Alugavel alugavel1 = (Alugavel) itens.get(0);
		Alugavel alugavel2 = (Alugavel) itens.get(9);
		System.out.println(alugavel1.alugar(2));
		System.out.println(alugavel2.alugar(5));
		try {
			Alugavel alugavel3 = (Alugavel) itens.get(5);
			System.out.println(alugavel3.alugar(2));
		}catch(Exception ex) {
			System.out.println("Livros Digitais não são alugáveis");
		}
	}

}
