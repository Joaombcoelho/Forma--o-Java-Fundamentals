import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        // primeiros termos
        int a = 0, b = 1;

        if (n >= 1) System.out.print(a);
        if (n >= 2) System.out.print(" " + b);

        // gera os próximos termos a partir do 3º
        for (int i = 2; i < n; i++) {
            int next = a + b;
            System.out.print(" " + next);
            a = b;
            b = next;
        }

        System.out.println(); // quebra de linha final
        scanner.close();
    }
}