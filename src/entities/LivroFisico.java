package entities;

import java.math.BigDecimal;
import java.util.Locale;

import interfaces.Alugavel;
import interfaces.Compravel;

public class LivroFisico extends Livro implements Alugavel, Compravel {
	
	private Double altura;
	private Double largura;
	private Double comprimento;
	private Integer quantidade;
	
	public LivroFisico(Integer quantidade,String titulo, String genero, String autor, BigDecimal preco,
			Integer paginas, Double altura,Double largura,Double comprimento) {
		super(titulo, genero, autor, preco, paginas);
		this.quantidade=quantidade;
		this.altura=altura;
		this.largura=largura;
		this.comprimento=comprimento;
	}
	
	Double getAltura() {
		return altura;
	}

	Double getLargura() {
		return largura;
	}

	Double getComprimento() {
		return comprimento;
	}

	Integer getQuantidade() {
		return quantidade;
	}

	void setAltura(Double altura) {
		this.altura = altura;
	}

	void setLargura(Double largura) {
		this.largura = largura;
	}

	void setComprimento(Double comprimento) {
		this.comprimento = comprimento;
	}

	void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String alugar(Integer horas) {
		Double precoAluguel = horas * 5D;
		return String.format("O livro %s foi alugador por R$ %1.2f e será devolvido em %d hora(s)", 
				titulo,precoAluguel,horas);
	}

	@Override
	public String comprar(Integer quantidade) {
		Double newPreco = Double.parseDouble(""+preco);
		Double precoCompra = quantidade * newPreco;
		this.quantidade -= quantidade;
		return String.format("Comprado %d x %s no valor de R$ %1.2f", quantidade,titulo,precoCompra);
	}
	
	@Override
	public String toString() {
		return String.format(Locale.US,"Livro Físico %s quantidade: %d, altura: %1.2f, largura: %1.2f, comprimento: %1.2f",
				super.toString(),quantidade,altura,largura,comprimento);
	}

}
