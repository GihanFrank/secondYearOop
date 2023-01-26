
class MyInteger {
    private int number;

    public MyInteger() {
        this.number = 0;
    }

    public MyInteger(int number) {
        this.number = number;
    }

    public String toString() {
        return new String("Number = " + this.number);
    }

    public boolean isEven() {
        if (this.number % 2 == 0)
            return true;
        else
            return false;

    }

    public boolean isOdd() {
        if (this.number % 2 != 0)
            return true;
        else
            return false;

    }

    public boolean isPrime() {
        int count = 0;
        for (int i = 1; i <= this.number; i++) {
            if (this.number % i == 0)
                count++;
        }
        if (count > 2)
            return false;
        else
            return true;
    }

    public boolean isPerfect() {
        int sumP = 0;
        for (int i = 1; i < this.number; i++) {
            if (this.number % i == 0)
                sumP = sumP + i;
        }
        if (sumP == this.number)
            return true;
        else
            return false;

    }

    public boolean isPerfectSqure() {
        int a = 0;
        for (int i = 1; i <= this.number; i++) {
            if (i * i == this.number) {
                a = this.number;
            }

        }
        
        if (a == this.number)
            return true;
        else
            return false;
    }

    public void primeFactors() {
        int remainder;
        int devider = 2;
        int garbage = this.number;

        while (1 < garbage) {
            remainder = garbage % devider;

            if (remainder == 0) {
                System.out.print(devider + ", ");
                garbage = garbage / devider;
            } else {
                devider++;
            }

        }
    }
}



public class Lab22 {
    public static void main(String[] args) {
        MyInteger i1 = new MyInteger(6);
        System.out.println(i1.toString());
        System.out.println("Even= " + i1.isEven());
        System.out.println("Odd= " + i1.isOdd());
        System.out.println("Prime Number= " + i1.isPrime());
        System.out.println("Perfect Number= " + i1.isPerfect());
        System.out.println("Perfect Square Number= " + i1.isPerfectSqure());
        System.out.println("Prime Factors are=");
        i1.primeFactors();
    }

}

