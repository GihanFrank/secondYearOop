abstract class Account {
    protected double amount;

    public Account() {
        this.amount = 0.00;
    }

    void deposit(double m) {
        if (m > 0)
            this.amount += m;
        else
            System.out.println("Deposit error");
    }

    void withdraw(double m) {
        if (this.amount >= m)
            this.amount -= m;
        else
            System.out.println("Insufficient Balance");
    }

    abstract public void show();

    abstract public double dailyInterest();

}

class Checking extends Account {

    public double dailyInterest() {
        double temp = 0;
        if (this.amount >= 1000) {
            temp = (this.amount * 0.003);
            this.amount += temp;
        } else
            System.out.println("Balance is not sufficient");
        return temp;

    }

    public void show() {
        System.out.println("Checking account= " + this.amount);
    }
}

class Saving extends Account {

    public double dailyInterest() {
        double temp = (this.amount * 0.006);
        this.amount += temp;

        return temp;

    }

    public void show() {
        System.out.println("Savings account= " + this.amount);
    }
}

class Lab42 {
    public static void main(String[] args) {
        Account[] a1 = new Account[2];
        Account c1 = new Checking();
        Account s1 = new Saving();

        c1.deposit(3600);
        c1.withdraw(126);
        c1.dailyInterest();
        s1.deposit(5600);
        s1.withdraw(590);

        s1.dailyInterest();
        a1[0] = c1;
        a1[1] = s1;
        for (int i = 0; i < a1.length; i++) {
            a1[i].show();
        }
    }
}