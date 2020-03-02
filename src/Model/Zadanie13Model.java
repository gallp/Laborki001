package Model;

public class Zadanie13Model {

    int sum;

    public Zadanie13Model() {

    }

    public int getSum(int n) {
        this.sum = 0;

        if (n % 2 == 0) {
            n -= 1;
        }

        for(int i = n; i > 0;  i-=2) {
        this.sum += i;
        }
        return this.sum;
    }
}

