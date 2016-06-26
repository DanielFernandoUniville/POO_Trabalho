package endeavor.controller;

import java.util.*;

import endeavor.dao.Bd;
import endeavor.model.Alteracoes;
import endeavor.model.Anotacao;

public class AnotacaoController {

	public void showText(Anotacao anotacao) {
		System.out.println("nota: " + anotacao.getTitulo());
		for (int i = 0; i < anotacao.getAlteracoes().size(); i++) {
			anotacao.getAlteracoes().get(i).getTexto();
		}
	}

	public void salvarAlteracao(Anotacao anotacao) {

		Calendar data = Calendar.getInstance();
		anotacao.getAlteracoes().add(new Alteracoes(data));
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		anotacao.getAlteracoes().get(anotacao.getAlteracoes().lastIndexOf(anotacao.getAlteracoes()) - 1)
				.setTexto(scan.nextLine());
		;
		Bd conexao = new Bd();
		conexao.insertRecord(insertTextQuery(anotacao));

	}

	public void salvarAlteracao(Alteracoes alteracao) {
		alteracao.setAlteracao(Calendar.getInstance());
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		alteracao.setTexto(scan.nextLine());
		;
		Bd conexao = new Bd();
		conexao.insertRecord(insertTextQuery(alteracao));

	}

	public void apagarAnotacao(Anotacao anotacao) {
		// deleta a anotacao. busca-se a anotacao por id no bd. deve-se deletar
		// todas as alteracoes no bd juntamente com a anotacao. muitas queries
		// serao utilizadas

	}

	public void apagarAnotacao(int id) {
		// deleta a anotacao. busca-se a anotacao por id no bd. deve-se deletar
		// todas as alteracoes no bd juntamente com a anotacao. muitas queries
		// serao utilizadas

	}

	public void criarNovo(Anotacao anotacao) {
		// cria nova anotacao e salva no banco de dados

	}

	public Anotacao buscarAnotacao(int id) {
		// busca a anotacao por id. retorna a anotacao inteira e a mostra na
		// tela.
		return null;
	}

	public boolean anotacaoContem(String busca, Anotacao anotacao) {
		// verifica se a anotacao repassada na assinatura contém tal frase. se
		// conter, retorna true. senão, retorna false;
		return true;
	}

	public Anotacao anotacaoContem(String busca) {
		// verifica se a a notacao tem o texto escrito acima e retorna a
		// anotacao em si. método de busca
		return null;
	}
	
	private void deleteNoteQuery(int  id){
		//criar query para deletar anotacao;
	}
	private void deleteNoteQuery(Anotacao anotacao){
		//criar query para deletar anotacao;
	}
	private String insertNewNoteQuery(Anotacao anotacao) {
		return "insert into anotacao (id,titulo, dataCriacao, id_Login) values (null," + anotacao.getTitulo() + ", "
				+ anotacao.getDataCriacao() + ", " + anotacao.getAutor().getId() + ");";
	}

	private String insertTextQuery(Anotacao anotacao) {
		return "insert into alteracoes (idAlteracao, dataAlteracao, texto) values (null,"
				+ anotacao.getAlteracoes().get(anotacao.getAlteracoes().lastIndexOf(anotacao.getAlteracoes()) - 1)
						.getDataAlteracao()
				+ "," + anotacao.getAlteracoes().get(anotacao.getAlteracoes().lastIndexOf(anotacao.getAlteracoes()) - 1)
						.getTexto()
				+ ");";
	}

	private String insertTextQuery(Alteracoes alteracao) {
		return "insert into alteracoes (idAlteracao, dataAlteracao, texto) values (null," + alteracao.getDataAlteracao()
				+ "," + alteracao.getTexto() + ");";
	}

}
