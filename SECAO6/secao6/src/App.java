import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        structureDoWhile();
    }

    public static void structureWhile() {

        Scanner reading = new Scanner(System.in);
        int multiplicate = 1;

        System.out.print("Digite um numero para tabuada: ");
        int number = reading.nextInt();

        while(multiplicate < 11) {

            int result = number * multiplicate;
            System.out.printf("%d X %d = %d \n", number, multiplicate, result);
            multiplicate += 1;
        }

        reading.close();
    }

    public static void structureFor() {

        Scanner reading = new Scanner(System.in);

        System.out.print("Digite um número para tabuada: ");
        int number = reading.nextInt();

        for(int multiplicate = 1; multiplicate<= 10; multiplicate++) {

            int result = number * multiplicate;
            System.out.printf("%d X %d = %d\n", number, multiplicate, result);
        }

        reading.close();
    }

    public static void structureDoWhile() {

        Scanner reading = new Scanner(System.in);
        int multiplicate = 1;
        int result;

        System.out.print("Digite um número para a tabuada: ");
        int number = reading.nextInt();

        result = number * multiplicate;
        System.out.printf("%d X %d = %d \n", number, multiplicate, result);

        do {

            multiplicate +=1;
            result = number * multiplicate;
            System.out.printf("%d X %d = %d \n", number, multiplicate, result);
            
        }

        while(multiplicate < 10);

        reading.close();
    }
}


