import java.util.Scanner;

public class app {
public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int soma = 0;
        
        while (true) {
            int numero = scanner.nextInt();
            
            if (numero < 0) {
                break;
            }
           
            soma += numero;
        }
        
       
        System.out.println(soma);
        scanner.close();
    }
}
