package src2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Serializacao {
	public static void gravar(String localDoArquivo, String texto)
			throws Exception {
		try {
			File arquivo = new File(localDoArquivo);

			if (arquivo.exists() == false) {
				arquivo.createNewFile();
			}

			PrintWriter escritor = new PrintWriter(new FileWriter(localDoArquivo, true));
			texto = texto + "\n";
			escritor.append(texto);
			escritor.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String ler(String localDoArquivo) throws IOException {
		BufferedReader leitor = new BufferedReader(new FileReader(
				localDoArquivo));
		String texto = "";
		try {
			StringBuilder separador = new StringBuilder();
			String linhas = leitor.readLine();

			while (linhas != null) {
				separador.append(linhas);
				separador.append(System.lineSeparator());
				linhas = leitor.readLine();
			}
			texto = separador.toString();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return texto;
	}

}
