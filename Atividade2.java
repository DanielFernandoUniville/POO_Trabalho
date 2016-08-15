package sopThreads2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import sopthreads.Atividade1;

public class Atividade2 {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out
				.println("digite o  número de linhas e colunas para a matriz");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[][] = new int[n][n];
		int b[][] = new int[n][n];
		int c[][] = new int[n][n];
		int d[][] = new int[n][n];
		int f[][] = new int[n][n];
		int e[][] = new int[n][n];
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				a[i][j] = (int) (Math.random() * 100);
				b[i][j] = (int) (Math.random() * 100);
			}
		}
		System.out.println("Matriz A");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j != n - 1) {
					System.out.print("[" + a[i][j] + "]\t");
				} else {
					System.out.print("[" + a[i][j] + "]\n");
				}
			}
		}
		System.out.println("Matriz B");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j != n - 1) {
					System.out.print("[" + b[i][j] + "]\t");
				} else {
					System.out.print("[" + b[i][j] + "]\n");
				}
			}
		}

		System.out.println("Resultado da Multiplicação:");
		chamarThread(a, b, n);
		// -------------------------------------------------------------------------------------------------------------------------------------//
		System.out.println("Dividindo a matriz");

		System.out
				.println("digite a qtde de threads que quer usar: (deve ser menor que o número de linhas e colunas!!!)");
		int nroThreads = scan.nextInt();
		boolean flag = true;
		do {
			if (nroThreads > n) {
				System.out
						.println("Numero de threads maior que o número de linhas e colunas! digite um número menor ou igual a "
								+ n);
				nroThreads = scan.nextInt();
			} else {
				int cont = 0;
				while (cont < nroThreads) {
					e = new int[(int) a.length / 2][(int) a.length / 2];
					f = new int[(int) a.length / 2][(int) a.length / 2];
					flag = false;
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							if (i < n / 2) {
								if (j < n / 2) {
									c[i][j] = a[i][j];
									d[i][j] = b[i][j];
								} else {
									e[i][j - e.length] = a[i][j];
									f[i][j - f.length] = b[i][j];
								}
							} else {
								if (j > n / 2) {
									e[i - e.length][j - e.length] = a[i][j];
									f[i - f.length][j - f.length] = b[i][j];
								}
							}

						}

						chamarThread(c, d, c.length);
						chamarThread(e, f, e.length);
						System.out.println("Matrizes divididas");

						a = c;
						b = d;
						cont++;
					}
				}

			}

		} while (flag);
		// --------------------------------------------------------------------------------------------------------------------------------
		/*
		 * try {
		 * System.out.println("Insira o local do arquivo contendo os valores");
		 * String fileLocation = scan.next(); BufferedReader fileReader = new
		 * BufferedReader(new FileReader( fileLocation)); String linha;
		 * 
		 * for (int i = 0; i < n; i++) { linha = fileReader.readLine(); String
		 * valores[] = Atividade2.ajeitarDados(linha); for (int j = 0; j < n;
		 * j++) { a[i][j] = Integer.parseInt(valores[0]); b[i][j] =
		 * Integer.parseInt(valores[1]); }
		 * 
		 * } } catch (Exception e) { // TODO: handle exception }
		 */
	}

	public static void chamarThread(int a[][], int b[][], int n) {
		Atividade1 multiplicador = new Atividade1(a, b, n);
		Thread thread = new Thread(multiplicador);
		thread.start();
	}
	/*
	 * public static String[] ajeitarDados(String linha) { String[] linhaArray =
	 * linha.split("."); linha = linhaArray[1]; linhaArray =
	 * linhaArray[0].split(":"); linhaArray[0] = linhaArray[1]; linhaArray[1] =
	 * linha; return linhaArray; }
	 */

}
