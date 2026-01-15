package banco;

public final class SavingsAccount extends Account {

    private Double interestRate;

    public SavingsAccount() {


    }

    public SavingsAccount(String holder, Double balance, Double interestRate) {

        super(holder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {

        return interestRate;
    }

    public void setInterestRate(Double interestRate) {

        this.interestRate = interestRate;
    }
    
}
