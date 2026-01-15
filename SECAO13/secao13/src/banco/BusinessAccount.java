package banco;

public class BusinessAccount extends Account {

    private Double loanLimit;
    
    public BusinessAccount() {


    }

    public BusinessAccount(String holder, double balance, Double loanLimit) {

        super(holder, balance);
        this.loanLimit = loanLimit;

    }

    public Double getLoanLimit() {

        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {

        this.loanLimit = loanLimit;
    }

    @Override 
    public void withdraw(double amount) {

        super.withdraw(balance);
        balance -= 2.0;
    }
}
