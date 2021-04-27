import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrincipalLabirinto {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		Labirinto lab = new Labirinto();
		
		System.out.println("Digite o nome do arquivo com a extensão: ");
		String nomeDoArquivo = sc.next();
		lab.carregaLabirinto(nomeDoArquivo);
		
		System.out.print(lab.toString());
		
		try {
			File f = new File ("saidaLabirinto.txt");
			FileWriter fr = new FileWriter(f);
			PrintWriter out = new PrintWriter(fr);
			
			if(lab.labirinto()) {
				out.println("Existe um caminho para o labirinto");
				out.close();
			}else {
				out.println("Não existe um caminho para o labirinto");
				out.close();
			}
		
		}catch (IOException e) {
			System.out.println("Erro ao escrever arquivo.");
		}
		
		sc.close();
	}

}
