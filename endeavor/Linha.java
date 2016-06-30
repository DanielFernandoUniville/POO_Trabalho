package src2;

import java.io.IOException;
import java.util.ArrayList;

public class Linha {
	private String textos;
	
	public Linha(String localDoArquivo) throws IOException{
		this.buscarTexto(localDoArquivo);
	}
	private void buscarTexto(String localDoArquivo) throws IOException {
		textos = Serializacao.ler(localDoArquivo);
		
	}
	public Linha(){
	}


	public void gravarTexto(String localDoArquivo) throws Exception{
		Serializacao.gravar(localDoArquivo, textos);
	}
	public String getTextos() {
		return textos;
	}
	public void setTextos(String textos) {
		this.textos = textos;
	}
}
