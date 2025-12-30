package entities;

public class CurrencyConverter {

    public static double converter(double reais) {

        double dolarValue = reais / 5.56;
        double tax = reais / 100 * 3.5;
        double finalValue = dolarValue + tax;

        return finalValue;
    }

}