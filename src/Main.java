import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Player player1;
        Player player2;

        System.out.print("Nome jogador 1: ");
        String nome1 = scanner.nextLine();
        System.out.print("Escolha o seu símbolo(X ou O): ");
        char simbolo1 = scanner.nextLine().charAt(0);
        System.out.print("Nome jogador 2: ");
        String nome2 = scanner.nextLine();

        if (simbolo1 == 'X' || simbolo1 == 'x') {
            player1 = new Player(nome1, Representation.X);
            player2 = new Player(nome2, Representation.O);
        } else {
            player1 = new Player(nome1, Representation.O);
            player2 = new Player(nome2, Representation.X);
        }

        System.out.println("\n\n");

        Velha velha = new Velha();

        boolean alternar = true;

        do {
            velha.getTabuleiro();

            if (alternar) {
                playerMove(player1, velha);
                velha.gameVerification(player1);
            } else {
                playerMove(player2, velha);
                velha.gameVerification(player2);
            }

            alternar = !alternar;
        } while (velha.getGameState() != GameState.END);

        velha.getTabuleiro();

        System.out.println("VENCEDOR(A): " + velha.getWinnerPlayer().nome().toUpperCase());
    }

    private static void playerMove(Player player, Velha velha) {
        int position;
        do {
            System.out.print(player.nome().toUpperCase() + ", digite a posição que quer jogar: ");
            position = scanner.nextInt();
            System.out.println("\n");
        } while (!velha.setTabuleiroPosition(position, player.representation()));
    }
}