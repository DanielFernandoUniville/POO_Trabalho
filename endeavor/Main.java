package src2;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		boolean terminado = false;
		int flag;
		Linha texto;
		Scanner scan = new Scanner(System.in);
		System.out.println("informe o local do arquivo que deseja ler: ");
		String localDoArquivo = scan.nextLine();
		System.out.println("\n");
		do{
			System.out.println("Digite o que você quer fazer\n");
			System.out.println("para ler um texto, digite 1\n");
			System.out.println("para escrever uma linha, digite 2\n");
			System.out.println("para usar um arquivo diferente, digite 3\n");
			System.out.println("para sair, digite 4\n");
			scan = new Scanner(System.in);
			flag = scan.nextInt(); 
		
			switch(flag){
			
			case 1:
				texto = new Linha(localDoArquivo);
				System.out.println(texto.getTextos());
				break;
				
			case 2:
				texto = new Linha();
				texto.setTextos(JOptionPane.showInputDialog("digite o texto"));
				texto.gravarTexto(localDoArquivo);
				break;
			case 3:
				System.out.println("digite o novo diretório: \n");
				localDoArquivo = scan.nextLine();
				break;
			case 4:
				terminado = true;
				break;
			default: System.out.println("valor incorreto");
			}
		}while(terminado==false);
	}
}
