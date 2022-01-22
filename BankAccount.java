public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    // public static void main(String[] args) {
    //     BankAccount accountOne = new BankAccount(100000);
    //     BankAccount accountTwo = new BankAccount(100000);
    //     System.out.printf("Account 1 old balance: $%.2f, Account 2 old balance: $%.2f%n", accountOne.getBalance(), accountTwo.getBalance());

    //     BankAccount.transfer(accountOne, accountTwo, 50000);
    //     System.out.printf("Account 1 new balance: $%.2f, Account 2 new balance: $%.2f%n", accountOne.getBalance(), accountTwo.getBalance());
    // }
}