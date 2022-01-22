public class Bank {
    private BankAccount[] accounts;
    
    public Bank(int nAccounts, double startAmount) {
        this.accounts = new BankAccount[nAccounts];
        for (int account = 0; account < this.size(); account++) {
            this.accounts[account] = new BankAccount(startAmount);
        }
    }

    public BankAccount get(int index) {
        return this.accounts[index];
    }

    public void transfer(int fromIndex, int toIndex, double amount) {
        if (fromIndex != toIndex && amount < this.accounts[fromIndex].getBalance()) {
            BankAccount from = this.accounts[fromIndex];
            BankAccount to = this.accounts[toIndex];

            double fromOldBalance = from.getBalance();
            double toOldBalance = to.getBalance();

            from.withdraw(amount);
            to.deposit(amount);

            System.out.printf("%s ----- $%.2f transferred from Account %d (old balance: $%.2f, new balance: $%.2f)%n" +
                    " to Account %d (old balance: $%.2f, new balance: $%.2f)%n%n", Thread.currentThread(), amount,
                    fromIndex,
                    fromOldBalance, from.getBalance(), toIndex, toOldBalance, to.getBalance());
        }
        else {
            System.out.printf("%s ----- Insufficient funds in Account %d", Thread.currentThread(), fromIndex);
        }
    }

    public int size() {
        return this.accounts.length;
    }
}
