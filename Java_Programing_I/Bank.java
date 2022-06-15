package Java_Programing_I;

public class Bank {
    private double balance;
    private double rate;

    public Bank() {
        this.balance = balance;
        this.rate = rate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double calculateInterest(){
       double interest =  balance * (rate / 1200);
        return interest;
    }

    public static void main(String[] args) {
        Bank newbank = new Bank();
        newbank.setBalance(1000);
        newbank.setRate(10);
        System.out.println(newbank.calculateInterest());
    }
}
