public class ActiveState implements AccountState {
    @Override
    public void deposit(Account account, Double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposit successful!");
        System.out.println(account);
    }

    @Override
    public void withdraw(Account account, Double amount) {
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient funds!");
        }
        System.out.println(account);
    }

    @Override
    public void suspend(Account account) {
        account.setAccountState(new SuspendedState());
        System.out.println("Account is suspended!");
    }

    @Override
    public void activate(Account account) {
        System.out.println("Account is already activated!");
    }

    @Override
    public void close(Account account) {
        account.setAccountState(new ClosedState());
        System.out.println("Account is closed!");
    }
}
