package entities;

import java.math.BigDecimal;

import interfaces.Compravel;

public class LivroDigital extends Livro implements Compravel	{

	public LivroDigital(String titulo, String genero, String autor, BigDecimal preco, Integer paginas) {
		super(titulo, genero, autor, preco, paginas);
	}


	@Override
	public String comprar(Integer quantidade) {
		
		return String.format("O livro %s foi comprado por R$ %1.2f", titulo,preco);
	}
	
	@Override
	public String toString() {
		return "Livro Digital "+super.toString();
	}
	
	
}
