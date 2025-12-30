package banco;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static ArrayList<Account> accounts = new ArrayList<>();
    static String name;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        menu();
    }

    public static void menu() {

        int option;

        System.out.println("ESCOLHA UMA OPÇÃO: (DIGITE O NÚMERO):");
        System.out.println("1 - Cadastrar conta");
        System.out.println("2 - Consultar saldo");
        System.out.println("3 - Depósito");
        System.out.println("4 - Saque");
        System.out.println("5 - Transferência");
        System.out.println("6 - Sair");

        System.out.print("DIGITE: ");
        option = sc.nextInt();


        switch (option) {

            case 1:
                registerAccount();
                menu();
                break;

            case 2:
                login();
                checkBalance();
                menu();
                break;

            case 3:
                login();
                deposit();
                menu();
                break;

            case 4:
                login();
                withdraw();
                menu();
                break;

            case 5:
                login();
                transfer();
                menu();
                break;

            case 6:
                System.out.println("Encerrando o programa...");
                System.exit(0);
                break;

            default:
                System.out.println("Valor inválido!");
                menu();

        }
    }

    public static void login() {

        System.out.print("Digite o nome da conta: ");
        name = sc.next();

        for(Account item : accounts) {

            if(item.getHolder().equals(name)) {

                name = item.getHolder();
                break;
            }

            else {

                System.out.println("CONTA NÃO ENCONTRADA!");
            }
        }
    }

    public static void registerAccount() {

        try {

            Double balance;
            Integer optionAccount;
            Integer optionDeposit;
            
            System.out.println("Qual tipo de conta você deseja cadastrar?(Digite 1 para CORRENTE ou 2 para COMERCIAL)\n");
            optionAccount = sc.nextInt();

            System.out.print("Digite o nome da conta: ");
            name = sc.next();

            System.out.println("Deseja realizar depósito na nova conta?(Digite 1 para SIM e 2 para NÃO)");
            optionDeposit = sc.nextInt();

            if (optionDeposit == 1) {

                balance = 0.00;
            }

            else {

                System.out.println("Qual o valor do depósito?");
                balance = sc.nextDouble();
            }

            if (optionAccount == 1) {

                Account account = new Account(name, balance);
                accounts.add(account);
            }

            else {

                if (balance > 0.00) {

                    BusinessAccount account = new BusinessAccount(name, balance, balance*10);
                    accounts.add(account);
                }

                else {

                    BusinessAccount account = new BusinessAccount(name, balance, 0.00);
                    accounts.add(account);
                }
            }

            System.out.println("Conta registrada com sucesso!");
        }

        catch(Exception e) {

            System.out.println("Você digitou algo inválido!");
            System.out.println("Você terá de iniciar o cadastro novamente!");
            registerAccount();
        }
    }

    public static void checkBalance() {

        for(Account item : accounts) {

            if(item.getHolder().equals(name)) {

                System.out.printf("Saldo atual da conta %s: R$%.2f \n", item.getHolder(), item.getBalance());
                break;
            }
        }
    }

    public static void deposit() {

        try {

            System.out.print("Digite o valor do depósito: ");
            double amount = sc.nextDouble();

            for(Account item : accounts) {

                if (item.getHolder().equals(name)) {

                    item.deposit(amount);
                    System.out.println("Depósito realizado com sucesso!");
                    break;
                }
            }
        }

        catch(Exception e) {

            System.out.println("Você digitou algo inválido!");
            deposit();
        }
    }

    public static void withdraw() {

        try {

            System.out.print("Digite o valor do saque: ");
            double amount = sc.nextDouble();

            for(Account item : accounts) {

                if (item.getHolder().equals(name)) {

                    item.withdraw(amount);
                    System.out.println("Saque realizado com sucesso!");
                    break;
                }
            }
        }

        catch(Exception e) {

            System.out.println("Você digitou algo inválido!");
            withdraw();
        }
    }

    public static void transfer() {

        try {

            System.out.print("Digite o valor da transferência: ");
            double amount = sc.nextDouble();

            System.out.println("Digite o nome da pessoa para quem irá transferir: ");
            String person = sc.next();

            for(Account item : accounts) {

                if (item.getHolder().equals(person)) {

                  item.setBalance(item.getBalance() + amount);

                  for (Account item2 : accounts) {

                      if (item2.getHolder().equals(name)) {

                          item2.setBalance(item2.getBalance() - amount);
                          break;
                      }
                  }
                  break;
                }

                else {

                    System.out.println("Conta não encontrada!");
                }
            }
        }

        catch(Exception e) {

            System.out.println("Você digitou algo inválido!");
            transfer();
        }
    }
}

