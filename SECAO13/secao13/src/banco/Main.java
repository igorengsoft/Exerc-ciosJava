package banco;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static ArrayList<Account> accounts = new ArrayList<>();
    static String name = "";
    static Scanner sc = new Scanner(System.in);
    static String error = "Você digitou algo inválido!";

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
                System.out.println(error);
                menu();

        }
    }

    public static void login() {

        Boolean findPerson = false;

        System.out.print("Digite o nome da conta: ");
        name = sc.next();

        for(Account item : accounts) {

            if(item.getHolder().equals(name)) {

                name = item.getHolder();
                findPerson = true;
                break;
            }
        }

        if (!findPerson) {

            name = "";
            System.out.println("CONTA NÃO ENCONTRADA!");
            login();
        }
    }

    public static void registerAccount() {

        try {

            Double balance;
            Integer optionAccount;
            Integer optionDeposit;
            
            System.out.println("Qual tipo de conta você deseja cadastrar?(Digite 1 para CORRENTE, 2 para COMERCIAL ou 3 para POUPANÇA)\n");
            optionAccount = sc.nextInt();

            System.out.print("Digite o nome da conta: ");
            name = sc.next();

            System.out.println("Deseja realizar depósito na nova conta?(Digite 1 para SIM e 2 para NÃO)");
            optionDeposit = sc.nextInt();

            if (optionDeposit == 2) {

                balance = 0.00;
            }

            else if (optionDeposit == 1){

                System.out.println("Qual o valor do depósito?");
                balance = sc.nextDouble();
            }

            else {

                registerError();
                return;

            }

            if (optionAccount == 1) {

                Account account = new Account(name, balance);
                accounts.add(account);
            }

            else if (optionAccount == 2) {

                if (balance > 0.00) {

                    BusinessAccount account = new BusinessAccount(name, balance, balance*10);
                    accounts.add(account);
                }

                else {

                    BusinessAccount account = new BusinessAccount(name, balance, 0.00);
                    accounts.add(account);
                }
            }

            else if (optionAccount == 3) {

                SavingsAccount account = new SavingsAccount(name, balance, 0.5);
                accounts.add(account);
            }

            else {

                sc.nextLine();
                System.out.println(error);
                registerAccount();
                return;
            }

            System.out.println("Conta registrada com sucesso!");
        }

        catch(Exception e) {

            registerError();
        }
    }

    public static void registerError() {

        sc.nextLine();
        System.out.println(error);
        System.out.println("Você terá de iniciar o cadastro novamente!");
        registerAccount();
    }

    public static void checkBalance() {

        for(Account item : accounts) {

            if(item.getHolder().equals(name)) {

                Double balance = item.getBalance();

                System.out.printf("Saldo atual da conta %s: R$%.2f \n", name, balance);
                break;
            }
        }
    }

    public static void deposit() {

        try {

            System.out.print("Digite o valor do depósito: ");
            double amount = sc.nextDouble();

            if(amount <= 0) {

                System.out.println("Digite uma quantidade válida para o depósito");
                deposit();
                return;
            }

            for(Account item : accounts) {

                if (item.getHolder().equals(name)) {

                    item.deposit(amount);
                    System.out.println("Depósito realizado com sucesso!");

                    if (item instanceof SavingsAccount) {

                        updateSavings((SavingsAccount) item);
                    }

                    break;
                }
            }
        }

        catch(Exception e) {

            sc.nextLine();
            System.out.println(error);
            deposit();
        }
    }

    public static void withdraw() {

        try {

            System.out.print("Digite o valor do saque: ");
            double amount = sc.nextDouble();

            if(amount <= 0) {

                System.out.println("Digite uma quantidade válida para o saque");
                withdraw();
                return;
            }

            for(Account item : accounts) {

                if (item.getHolder().equals(name)) {

                    item.withdraw(amount);
                    System.out.println("Saque realizado com sucesso!");

                    if (item instanceof SavingsAccount) {

                        updateSavings((SavingsAccount) item);
                    }

                    break;
                }
            }
        }

        catch(Exception e) {

            sc.nextLine();
            System.out.println(error);
            withdraw();
        }
    }

    public static void transfer() {

        if (accounts.size() < 2) {

            System.out.println("É necessário haver ao menos duas contas cadastradas");
            return;
        }

        try {

            String person;
            boolean find1 = false;
            boolean find2 = false;
            String message = "Conta não encontrada!";

            System.out.print("Digite o valor da transferência: ");
            double amount = sc.nextDouble();

            System.out.println("Digite o nome da pessoa para quem irá transferir: ");
            person = sc.next();

            for(Account item : accounts) {

                if (item.getHolder().equals(person)) {

                  item.setBalance(item.getBalance() + amount);
                  find1 = true;

                  if (item instanceof SavingsAccount) {

                        updateSavings((SavingsAccount) item);
                  }

                  break;
                }
            }

            if (find1 == false) {

                    System.out.println(message);
                    return;
                }

            for (Account item2 : accounts) {

                if (item2.getHolder().equals(name)) {

                    item2.setBalance(item2.getBalance() - amount);
                    find2 = true;

                    if (item2 instanceof SavingsAccount) {

                        updateSavings((SavingsAccount) item2);
                    }

                    break;
                }
            }

            if (find2 == false) {

                System.out.println(message);
            }
        }

        catch(Exception e) {

            sc.nextLine();
            System.out.println(error);
            transfer();
        }
    }

    public static void updateSavings(SavingsAccount account) {

        account.setBalance(account.getBalance() * account.getInterestRate());
    }
}

