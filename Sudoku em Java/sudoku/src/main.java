import java.util.Scanner;
import model.Board;
import model.Difficulty;
import service.SudokuGenerator;
import service.SudokuValidator;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board;
        SudokuValidator validator = new SudokuValidator();
        int erros;
        long startTime;
        Difficulty difficulty;

        System.out.println("=== Sudoku Console ===");
        System.out.println("Escolha a dificuldade: 1 - Fácil, 2 - Médio, 3 - Difícil");
        int escolhaDiff = scanner.nextInt();
        scanner.nextLine(); // limpar buffer
        difficulty = Difficulty.MEDIUM;
        if (escolhaDiff == 1) difficulty = Difficulty.EASY;
        if (escolhaDiff == 2) difficulty = Difficulty.MEDIUM;
        if (escolhaDiff == 3) difficulty = Difficulty.HARD;

        SudokuGenerator generator = new SudokuGenerator();
        board = generator.generate(difficulty);
        erros = 0;
        startTime = System.currentTimeMillis();

        while (true) {
            clearConsole();
            System.out.println("=== Sudoku ===");
            board.printBoard();
            System.out.println("Erros: " + erros + "/5");
            System.out.println("Células preenchidas: " + countFilledCells(board) + "/81");
            System.out.println("Digite -1 para sair do jogo.");

            System.out.print("Digite linha(1-9), coluna(1-9) e valor(1-9), separados por espaço ou vírgula: ");
            String input = scanner.nextLine().trim();

            if (input.equals("-1")) {
                System.out.println("👋 Saindo do jogo. Até a próxima!");
                break;
            }

            String[] parts = input.split("[, ]+");
            if (parts.length != 3) {
                System.out.println("⚠️ Entrada inválida! Use três números (linha, coluna, valor).");
                pause();
                continue;
            }

            int row = Integer.parseInt(parts[0]) - 1;
            int col = Integer.parseInt(parts[1]) - 1;
            int value = Integer.parseInt(parts[2]);

            if (row < 0 || row > 8 || col < 0 || col > 8 || value < 1 || value > 9) {
                System.out.println("⚠️ Valores fora do intervalo (1-9).");
                pause();
                continue;
            }

            if (validator.isValidMove(board, row, col, value)) {
                board.setValue(row, col, value, false);
            } else {
                System.out.println("❌ Jogada inválida!");
                erros++;
                pause();
                if (erros >= 5) {
                    long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
                    board.printBoard();
                    System.out.println("💀 Você perdeu! Ultrapassou o limite de erros.");
                    System.out.println("⏱️ Tempo total: " + elapsedTime + " segundos");
                    break;
                }
            }

            if (isBoardFull(board)) {
                long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
                int score = calcularPontuacao(elapsedTime, erros);
                board.printBoard();
                System.out.println("🎉 Parabéns! Sudoku completado!");
                System.out.println("⏱️ Tempo total: " + elapsedTime + " segundos");
                System.out.println("🏆 Pontuação final: " + score);
                break;
            }
        }

        scanner.close();
    }

    private static boolean isBoardFull(Board board) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board.getValue(i, j) == 0) return false;
        return true;
    }

    private static int calcularPontuacao(long tempoSegundos, int erros) {
        int base = 10000;
        int score = base - (int)(tempoSegundos * 10) - (erros * 500);
        return Math.max(score, 0);
    }

    private static int countFilledCells(Board board) {
        int count = 0;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board.getValue(i, j) != 0) count++;
        return count;
    }

    private static void pause() {
        try {
            Thread.sleep(1000); // 1 segundo
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception ignored) { }
    }
}