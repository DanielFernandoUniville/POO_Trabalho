package endeavor.model;

import java.util.Calendar;

public class Alteracoes {
	private int idAlteracao;
	private Calendar dataAlteracao;
	private String texto;
	
	public Alteracoes(Calendar data) {
		this. dataAlteracao = data;
	}
	
	public int getIdAlteracao() {
		return idAlteracao;
	}
	public void setIdAlteracao(int idAlteracao) {
		this.idAlteracao = idAlteracao;
	}
	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}
	public void setAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
}
