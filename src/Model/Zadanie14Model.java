package Model;

public class Zadanie14Model {

    public StringBuilder decToBin(Integer number) {
        StringBuilder input = new StringBuilder();
        if(number == 0) input.insert(0,0);
        while (number > 0) {
            input.insert(0, number % 2 );
            number >>= 1 ;
        }
        return input;
    }

    public StringBuilder decToOct(Integer number) {
        StringBuilder input = new StringBuilder();
        if(number == 0) input.insert(0,0);
        while (number > 0) {
            input.insert(0, number % 8);
            number >>= 3;
        }
        return input;
    }

    public StringBuilder decToHex(Integer number) {
        StringBuilder input = new StringBuilder();
        if(number == 0) input.insert(0,0);
        while (number > 0) {
            if(number % 16 < 10)
                input.insert(0,number % 16);
            else
                input.insert(0, (char)(number % 16+55));
            number >>= 4;
        }
        return input;
    }
}
