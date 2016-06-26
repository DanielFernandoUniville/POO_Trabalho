package endeavor.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Anotacao {
	private int id;
	private String titulo;
	private Calendar dataCriacao;
	private ArrayList<Alteracoes> alteracoes;
	private Login autor;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public ArrayList<Alteracoes> getAlteracoes() {
		return alteracoes;
	}

	public void setAlteracoes(ArrayList<Alteracoes> alteracoes) {
		this.alteracoes = alteracoes;
	}

	public Login getAutor() {
		return autor;
	}

	public void setAutor(Login autor) {
		this.autor = autor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
