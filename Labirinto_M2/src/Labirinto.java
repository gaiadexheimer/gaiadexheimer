import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.lang.Thread;


public class Labirinto {

	Scanner sc = new Scanner(System.in);
	char[][] array = new char[0][0];
	

	// criando o array
	public char[][] carregaLabirinto(String fileName) {

		String linhas = "";
		String colunas = "";

		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader in = new BufferedReader(fr);
			linhas = in.readLine();
			colunas = in.readLine();

			array = new char[Integer.parseInt(linhas)][Integer.parseInt(colunas)];

			String line = in.readLine();
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					array[i][j] = (line.charAt(j));
				}
				line = in.readLine();
			}

			in.close();

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \"" + fileName + "\" não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura de " + fileName + ".");
		}

		return array;
	}

	public String toString() {
		String labirinto_atual = "";
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				labirinto_atual += (array[i][j]);
			}
			labirinto_atual += '\n';
		}
		return labirinto_atual;
	}

	public boolean labirinto() throws IllegalArgumentException {

		System.out.println("Digite o nome do arquivo com o labirinto que vai ser percorrido: ");
		String nomeArq = sc.next();

		char[][] maze = carregaLabirinto(nomeArq);

		if (maze == null)
			throw new IllegalArgumentException();

		sc.close();
		return labirinto(maze, 0, 0);
	}

	// salvar posicoes visitadas
	Pilha pilhaLinha = new Pilha();
	Pilha pilhaColuna = new Pilha();
	//

	private boolean labirinto(char[][] maze, int i, int j) {

		while (i >= 0 && j >= 0) {

			// chegou no fim
			if (maze[i][j] == 'D') {
				System.out.println("Existe caminho até D! :) Arquivo criado com sucesso.");
				return true;
			}

			// preenche caminho por onde passou
			if (maze[i][j] == ' ' || maze[i][j] == '.') {
				maze[i][j] = '.';

				
				try {
					Thread.sleep(450);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(toString());
				
				
				// move para a direita
				if ((j + 1 <= maze[i].length - 1) && // verifica se não estoura o array na direita
						(maze[i][j + 1] == ' ' || maze[i][j + 1] == 'D')) { // verifica se o passo a direita é ' '
					pilhaLinha.push(i);
					pilhaColuna.push(j);
					return labirinto(maze, i, j + 1);
				}

				// move para baixo
				else if ((i + 1 <= maze.length - 1) && // verifica se não estoura o array na parte de baixo
						(maze[i + 1][j] == ' ' || maze[i + 1][j] == 'D')) { // verifica se o passo de baixo é ' '
					pilhaLinha.push(i);
					pilhaColuna.push(j);
					return labirinto(maze, i + 1, j);
				}

				// move para a esquerda
				else if ((j - 1 >= 0) && // verifica se não estoura o array na esquerda
						(maze[i][j - 1] == ' ' || maze[i][j - 1] == 'D')) { // verifica se o passo a esquerda é ' '
					pilhaLinha.push(i);
					pilhaColuna.push(j);
					return labirinto(maze, i, j - 1);
				}

				// move para cima
				else if ((i - 1 >= 0) && // verifica se não estoura o array na parte de cima
						(maze[i - 1][j] == ' ' || maze[i - 1][j] == 'D')) { // verifica se o passo de cima é ' '
					pilhaLinha.push(i);
					pilhaColuna.push(j);
					return labirinto(maze, i - 1, j);
				}

				else if (!(pilhaLinha.isEmpty()) && !(pilhaColuna.isEmpty())) {
					maze[i][j] = 'o';
					return labirinto(maze, pilhaLinha.pop(), pilhaColuna.pop());
				}
				else break;
			}
			
		}

		System.out.println("Não existe caminho até D :( Arquivo criado com sucesso.");
		return false;
	}

}
