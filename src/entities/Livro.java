package entities;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import interfaces.Emprestavel;

public abstract class Livro implements Emprestavel{
	protected String titulo;
	protected String genero;
	protected String autor;
	protected BigDecimal preco;
	protected Integer paginas;
	
	public Livro(String titulo, String genero, String autor, BigDecimal preco, Integer paginas) {
		this.titulo = titulo;
		this.genero = genero;
		this.autor = autor;
		this.preco = preco;
		this.paginas = paginas;
	}

	String getTitulo() {
		return titulo;
	}

	String getGenero() {
		return genero;
	}

	String getAutor() {
		return autor;
	}

	BigDecimal getPreco() {
		return preco;
	}

	Integer getPaginas() {
		return paginas;
	}

	void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	void setGenero(String genero) {
		this.genero = genero;
	}

	void setAutor(String autor) {
		this.autor = autor;
	}

	void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}
	
	@Override
	public String emprestar(Integer dias) {
		Double precoDouble = Double.parseDouble(preco.toString());
		Double calculoPreco = (precoDouble*0.25) + (dias * (precoDouble*0.05));
		BigDecimal precoEmprestimo = new BigDecimal(""+calculoPreco);
		
		Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, dias);
        Date devolutionDate = c.getTime();
        
		return String.format("O livro %s foi emprestado por %d dias, o preço do empréstimo é de R$ %1.2f \n"
				+ "e sua data de devolução é %s", titulo,dias,precoEmprestimo,devolutionDate);
	}
	
	@Override
	public String toString() {
		return String.format(Locale.US,"titulo: %s, genero: %s, autor: %s, preco: R$ %1.2f, paginas: %d", titulo,genero,autor,preco,paginas);
	}
	
	@Override
	public String identifier() {
		return toString();
	}
}
