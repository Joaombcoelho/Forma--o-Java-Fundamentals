package br.com.dio.javafundamentals;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite sua idade: ");
        int idade = scanner.nextInt();
        
        
        if (idade < 18) {
            System.out.println("Menor de idade");
        } else if (idade >= 18 && idade < 65) {
            System.out.println("Maior de idade");
        } else {
            System.out.println("Idoso");
        }

        scanner.close();
    }
}