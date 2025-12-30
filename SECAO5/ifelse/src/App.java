import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        price();
    }

    public static void ifElse() {

        Scanner reading = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int number = reading.nextInt();

        if (number == 1) {

            System.out.print("O dia digitado é Domingo");
        }

        else if (number == 2) {

            System.out.print("O dia digitado é Segunda");
        }

        else if (number == 3) {

            System.out.print("O dia digitado é Terça");
        }

        else if (number == 4) {

            System.out.print("O dia digitado é Quarta");
        }

        else if (number == 5) {

            System.out.print("O dia digitado é Quinta");
        }

        else if (number == 6) {

            System.out.print("O dia digitado é Sexta");
        }

        else if (number == 7) {

            System.out.print("O dia digitado é Sábado");
        }

        else {

            System.out.print("Valor inválido!");
        }

        reading.close();
    }

    public static void choices() {

        Scanner reading = new Scanner(System.in);
        String day;

        System.out.print("Digite o numero do dia: ");
        int number = reading.nextInt();

        switch(number) {

            case 1:

                day = "Domingo";
                break;
            
            case 2:

                day = "Segunda";
                break;
            
            case 3:

                day = "Terça";
                break;

            case 4: 

                day = "Quarta";
                break;

            case 5:

                day = "Quinta";
                break;

            case 6:

                day = "Sexta";
                break;

            case 7:

                day = "Sábado";
                break;

            default:

                day = "Valor inválido!";
                break;
        }

        System.out.printf("Dia da semana = %s", day);
        reading.close();
    }

    public static void price() {

        Scanner reading = new Scanner(System.in);

        System.out.print("Digite o preço: ");
        double price = reading.nextDouble();

        double reduce = (price < 300) ? price * 0.1 : price * 0.15;

        System.out.printf("desconto = %f", reduce);
        reading.close();
    }
}
