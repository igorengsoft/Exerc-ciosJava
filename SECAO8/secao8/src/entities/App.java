package entities;

import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) {

        Locale.setDefault(Locale.forLanguageTag("pt-BR"));

        callConverter();
    }

    public static void callTriangle() {

        Scanner reading = new Scanner(System.in);
        Triangle triangle = new Triangle();

        System.out.print("Digite o valor da base: ");
        triangle.base = reading.nextDouble();

        System.out.print("Digite o valor da altura: ");
        triangle.height = reading.nextDouble();

        double area = triangle.area();

        System.out.printf("ÁREA = %.2f", area);
        reading.close();
    } 

    public static void callConverter() {

        Scanner reading = new Scanner(System.in);
        System.out.print("Digite o valor em reais: ");
        double number = reading.nextDouble();

        double newValue = CurrencyConverter.converter(number);

        System.out.printf("VALOR EM DÓLAR = %.2f", newValue);
        reading.close();
    }
}
