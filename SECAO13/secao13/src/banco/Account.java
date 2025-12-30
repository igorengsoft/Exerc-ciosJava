package banco;

public class Account  {
    
    protected String holder;
    protected double balance;

    public Account() {

        
    }

    public Account(String holder, double balance) {

        this.holder = holder;
        this.balance = balance;
    }

    public double getBalance() {

        return balance;
    }

    public void setBalance(double balance) {

        this.balance = balance;
    }

    public String getHolder() {

        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public void withdraw(double amount) {

        balance -= amount;
    }

    public void deposit(double amount) {

        balance += amount;
    }
}
