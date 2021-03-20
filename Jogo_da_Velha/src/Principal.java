import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// criando jogadores
		System.out.println("O jogo vai começar!\n ");
		System.out.println("Digite o nome do primeiro jogador, que vai jogar como 'X': ");
		String nomeUm = sc.nextLine();
		Jogador jogador_x = new Jogador(nomeUm);

		System.out.println("Digite o nome do segundo jogador, que vai jogar como 'O': ");
		String nomeDois = sc.nextLine();
		Jogador jogador_o = new Jogador(nomeDois);

		// iniciando o jogo
		int controle = 1;
		int again = 1;
		while (again == 1) {
			controle = 1;
			// criando o tabuleiro
			System.out.println("Agora, digite o tamanho do tabuleiro que " + jogador_x.getNome() + " e "
					+ jogador_o.getNome() + " vão usar para jogar: ");
			int tam = sc.nextInt();
			JogoDaVelha tabuleiro = new JogoDaVelha(tam);

			boolean alguemGanhou = false;

			//realizando as jogadas de X
			while (controle <= tam*tam) {
				boolean jogadaCorreta = false;
				while (!jogadaCorreta) {
					System.out.print("\n");
					System.out.println("É a vez de " + jogador_x.getNome() + " jogar. Digite a linha de sua jogada: ");
					int linha = sc.nextInt() - 1;
					System.out.println("Digite a coluna de sua jogada: ");
					int coluna = sc.nextInt() - 1;
					try {
						if (tabuleiro.realizaJogada(linha, coluna, 'X')) {
							controle++;
							jogadaCorreta = true;
						} else {
							System.out.println("Esta posição já está ocupada. Escolha outra posição.");
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println(
								"Você não pode realizar esta jogada porque ela ultrapassa os limites do tabuleiro. Escolha outra posição.");
					}
				}

				System.out.print(tabuleiro.toString());

				if (controle > 2) {
					if (tabuleiro.verificaGanhador(jogador_x, jogador_o)) {
						alguemGanhou = true;
						break;
					}
				}

				//realizando as jogadas de O
				if (controle <= tam*tam) {
					boolean jogadaCorreta2 = false;
					while (!jogadaCorreta2) {
						System.out.print("\n");
						System.out.println(
								"É a vez de " + jogador_o.getNome() + " jogar. Digite a linha de sua jogada: ");
						int linha = sc.nextInt() - 1;
						System.out.println("Digite a coluna de sua jogada: ");
						int coluna = sc.nextInt() - 1;
						try {
							if (tabuleiro.realizaJogada(linha, coluna, 'O')) {
								controle++;
								jogadaCorreta2 = true;
							} else {
								System.out.println("Esta posição já está ocupada. Escolha outra posição.");
							}
						} catch (ArrayIndexOutOfBoundsException e) {
							System.out.println(
									"Você não pode realizar esta jogada porque ela ultrapassa os limites do tabuleiro. Escolha outra posição.");
						}
					}

					System.out.print(tabuleiro.toString());
				}

				if (controle > 2) {
					if (tabuleiro.verificaGanhador(jogador_x, jogador_o)) {
						alguemGanhou = true;
						break;
					}
				}
			}

			if (!alguemGanhou)
				System.out.println("\nNinguém venceu...");

			//verificando se os jogadores vão iniciar nova partida
			System.out.println(jogador_x.toString());
			System.out.println(jogador_o.toString());
			System.out.println("Querem jogar novamente?");
			System.out.println("Digite 1 para SIM ou 0 para NÃO");

			boolean valorValido = false;
			while (!valorValido) {
				again = sc.nextInt();

				if (again != 1 && again != 0) {
					System.out.println("Valor inválido.\n");
					System.out.println("Querem jogar novamente?");
					System.out.println("Digite 1 para SIM ou 0 para NÃO");
				} else {
					valorValido = true;
				}
			}
		}

		//resultado final
		if (jogador_x.getPontos() > jogador_o.getPontos()) {
			System.out.println("O jogo acabou! " + jogador_x.getNome() + " venceu =) ");

		} else if (jogador_o.getPontos() > jogador_x.getPontos()) {
			System.out.println("O jogo acabou! " + jogador_o.getNome() + " venceu =) ");

		} else
			System.out.println("O jogo acabou em empate!");

		sc.close();

	}
}
