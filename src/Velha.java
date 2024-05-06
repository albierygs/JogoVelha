import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Velha {

    private final Representation[][] tabuleiro;
    private GameState gameState;
    private Player winnerPlayer;

    public Velha() {
        tabuleiro = new Representation[3][3];
        gameState = GameState.CONTINUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = Representation.EMPTY;
            }
        }
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    public void getTabuleiro() {
        int position = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ++position;
                if (tabuleiro[i][j] == Representation.EMPTY) {
                    System.out.print("[ " + position + " ]");
                } else {
                    System.out.print("[" + tabuleiro[i][j].getRepresentation() + "]");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean setTabuleiroPosition(int positionToSet, Representation representation) {
        if (positionToSet < 1 || positionToSet > 9) {
            System.out.println("Digite um número entre 1 e 9");
        }else {
            int position = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    ++position;
                    if (position == positionToSet) {
                        if (tabuleiro[i][j] == Representation.EMPTY) {
                            tabuleiro[i][j] = representation;
                            return true;
                        } else {
                            System.out.println("Posição já preenchida");
                        }
                    }
                }
            }
        }
        return false;
    }

    public void gameVerification(Player player) {
        int position = 0;
        List<Integer> list = new ArrayList<>();

        List<List<Integer>> winnersPositions = Arrays.asList(
            Arrays.asList(1,4,7),
            Arrays.asList(2,5,8),
            Arrays.asList(3,6,9),
            Arrays.asList(1,2,3),
            Arrays.asList(4,5,6),
            Arrays.asList(7,8,9),
            Arrays.asList(1,5,9),
            Arrays.asList(3,5,7)
        );

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ++position;
                if (tabuleiro[i][j] == player.representation()) {
                    list.add(position);
                }
            }
        }

        for (List<Integer> winner : winnersPositions) {
            if (new HashSet<>(list).containsAll(winner)) {
                gameState = GameState.END;
                winnerPlayer = player;
                return;
            }
        }
    }
}
