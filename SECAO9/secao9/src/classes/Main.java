package classes;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner reading = new Scanner(System.in);

        System.out.println("BEM VINDO AO PROGRAMA MÉDIA DO ALUNO");

        System.out.print("Digite seu nome: ");
        String name = reading.nextLine();

        System.out.print("Digite sua nota 1: ");
        double nota1 = reading.nextDouble();

        System.out.print("Digite sua nota 2: ");
        double nota2 =  reading.nextDouble();

        System.out.print("Digite sua nota 3: ");
        double nota3 = reading.nextDouble();

        System.out.print("Digite sua nota 4: ");
        double nota4 = reading.nextDouble();

        Aluno student = new Aluno(name, nota1, nota2, nota3, nota4);

        double media = student.getMedia();

        System.out.printf("NOME = %s \n MEDIA = %.2f", student.getNome(), media);
        reading.close();

    }
}
