package br.com.dio.javafundamentals;

import java.util.Scanner;

public class Boletim {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double nota = scanner.nextDouble();
        if (nota >= 7) {
            System.out.println("Aprovado");
        } else if (nota >= 5 && nota <= 6.9) {
            System.out.println("Recuperacao");
        } else {
            System.out.println("Reprovado");
        }
               

        scanner.close();
    }
}
