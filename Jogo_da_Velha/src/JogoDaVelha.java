
public class JogoDaVelha {

	private char[][] tabuleiro;
	int jogadorUm = 0;
	int jogadorDois = 0;
	
	public JogoDaVelha(int n) {
		tabuleiro = new char[n][n];
		for (int i = 0; i < tabuleiro.length; i++)
			for (int j = 0; j < tabuleiro[i].length; j++)
				tabuleiro[i][j] = '.';
	}

	public boolean realizaJogada(int linha, int coluna, char simbolo) {
		if (tabuleiro[linha][coluna] != '.')
			return false;
		else {
			tabuleiro[linha][coluna] = simbolo;
			return true;
		}
	}

	public boolean verificaGanhador(Jogador jogadorX,Jogador jogadorO) {
		
		jogadorUm = 0;
		jogadorDois = 0;
		
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				// verifica diagonal principal para X
				if (i == j && tabuleiro[i][j] == 'X') {
					jogadorUm++;
					if (jogadorUm == tabuleiro.length) {
						System.out.println("Jogador Um venceu na diagonal principal!\n");
						jogadorX.setPontos(jogadorX.getPontos()+1);
						return true;
					}
				}
				// verifica diagonal principal para O
				if (i == j && tabuleiro[i][j] == 'O') {
					jogadorDois++;
					if (jogadorDois == tabuleiro.length) {
						System.out.println("Jogador Dois venceu na diagonal principal!\n");
						jogadorO.setPontos(jogadorO.getPontos()+1);
						return true;
					}
				}
			}
		}
		
		jogadorUm = 0;
		jogadorDois = 0;

		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {

				// verifica diagonal secundária para X
				if (j == tabuleiro.length - 1 - i && tabuleiro[i][j] == 'X') {
					jogadorUm++;
					if (jogadorUm == tabuleiro.length) {
						System.out.println("Jogador Um venceu na diagonal secundária!\n");
						jogadorX.setPontos(jogadorX.getPontos()+1);
						return true;
					}
				}

				// verifica diagonal secundária para O
				if (j == tabuleiro.length - 1 - i && tabuleiro[i][j] == 'O') {
					jogadorDois++;
					if (jogadorDois == tabuleiro.length) {
						System.out.println("Jogador Dois venceu na diagonal secundária!\n");
						jogadorO.setPontos(jogadorO.getPontos()+1);
						return true;
					}
				}
			}
		}


		// verifica linhas para X
		for (int i = 0; i < tabuleiro.length; i++) {
			jogadorUm = 0;
			jogadorDois = 0;
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if (tabuleiro[i][j] == 'X') {
					jogadorUm++;
					if (j == tabuleiro.length - 1) {
						if (jogadorUm == tabuleiro.length) {
							System.out.println("Jogador Um venceu na linha!\n");
							jogadorX.setPontos(jogadorX.getPontos()+1);
							return true;
						}
					}
				}
			}
		}


		// verifica linhas para O
		for (int i = 0; i < tabuleiro.length; i++) {
			jogadorUm = 0;
			jogadorDois = 0;
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if (tabuleiro[i][j] == 'O') {
					jogadorDois++;
					if (j == tabuleiro.length - 1) {
						if (jogadorDois == tabuleiro.length) {
							System.out.println("Jogador Dois venceu na linha!\n");
							jogadorO.setPontos(jogadorO.getPontos()+1);
							return true;
						}
					}
				}
			}
		}



		// verifica colunas para X
		for (int i = 0; i < tabuleiro.length; i++) {
			jogadorUm = 0;
			jogadorDois = 0;
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if (tabuleiro[j][i] == 'X') {
					jogadorUm++;
					//j = tabuleiro[i].length;
					if (jogadorUm == tabuleiro.length) {
						System.out.println("Jogador Um venceu na coluna!\n");
						jogadorX.setPontos(jogadorX.getPontos()+1);
						return true;
					}

				}
			}
		}



		// verifica colunas para O
		for (int i = 0; i < tabuleiro.length; i++) {
			jogadorUm = 0;
			jogadorDois = 0;
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if (tabuleiro[j][i] == 'O') {
					jogadorDois++;
					//j = tabuleiro[i].length;
					if (jogadorDois == tabuleiro.length) {
						System.out.println("Jogador Dois venceu na coluna!\n");
						jogadorO.setPontos(jogadorO.getPontos()+1);
						return true;
					}

				}
			}
		}


		return false;
	}

	// toString para retornar o estado atual do tabuleiro
	public String toString() {
		String tabuleiro_atual = "";
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				tabuleiro_atual += (tabuleiro[i][j] + " ");
			}
			tabuleiro_atual += '\n';
		}
		return tabuleiro_atual;
	}

}
