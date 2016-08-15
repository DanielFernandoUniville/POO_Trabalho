/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopthreads;

import java.util.Scanner;

/**
 * @author UDESC
 */
public class Atividade1 implements Runnable {
	private int a[][];
	private int b[][];
	private int c[][];
	private int n;

	public Atividade1(int a[][], int b[][], int c[][], int n) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.n = n;
	}

	public Atividade1(int a[][], int b[][], int n) {
		this.a = a;
		this.b = b;
		this.n = n;
	}

	public Atividade1() {

	}

	public void principal(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite o número de linhas e colunas da matriz: ");
		int n = teclado.nextInt();
		this.a = new int[n][n];
		this.b = new int[n][n];
		this.c = new int[n][n];

		System.out.println("\n\nDigite os valores da primeira matriz:");
		recebeMatriz(a, n, teclado);

		System.out.println("Digite os valores da primeira matriz:");
		recebeMatriz(b, n, teclado);

		System.out.println("Calculando a matriz Resultante: ");
		// ///////////////////////////////////////////////////////////////
		long inicio = System.currentTimeMillis();
		multiplicacao(a, b, c, n);
		long tempo = System.currentTimeMillis() - inicio;
		// ///////////////////////////////////////////////////////////////
		System.out.println("A multiplicacao demorou: " + tempo
				+ " milisegundos");
		mostraMatriz(c, n);
	}

	public static void recebeMatriz(int matriz[][], int n, Scanner teclado) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matriz[i][j] = teclado.nextInt();
			}
		}
	}

	public static void multiplicacao(int a[][], int b[][], int c[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				c[i][j] = 0;
				for (int k = 0; k < n; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
	}

	public static void mostraMatriz(int matriz[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public void run() {
		c = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				c[i][j] = a[i][j]* b[i][j];	
				if (j != n-1){
					System.out.print("["+ c[i][j]+"]\t");
				}else{
					System.out.print("["+ c[i][j]+"]\n");
				}
			}
		}
	}
}
