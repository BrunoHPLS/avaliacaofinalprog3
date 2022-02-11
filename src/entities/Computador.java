package entities;

import interfaces.Alugavel;

public class Computador implements Alugavel{
	private String especificacoes;
	
	public Computador(String especificacoes) {
		this.especificacoes = especificacoes;
	}

	@Override
	public String alugar(Integer horas) {
		Double precoAluguel = horas * 4D;
		return String.format("O computador %s foi alugado por R$ %1.2f no período de %d hora(s)",
				especificacoes,precoAluguel,horas);
	}
	
	@Override
	public String toString() {
		return "Computador "+especificacoes;
	}
	
	@Override
	public String identifier() {
		return toString();
	}
}
