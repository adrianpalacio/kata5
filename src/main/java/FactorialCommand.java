package software.ulpgc.kata5;

import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class FactorialCommand implements Command{
    @Override
    public Output execute(Input input) {
        try {
            return outputOf(factorial(input.get("number")));
        }
        catch (Exception e) {
            return outputException();
        }
    }

    private Output outputException() {
        return new Output() {
            @Override
            public String result() {
                return null;
            }

            @Override
            public int response() {
                return 403;
            }
        };
    }

    private Output outputOf(String result) {
        return new Output() {
            @Override
            public String result() {
                return result;
            }

            @Override
            public int response() {
                return 200;
            }
        };
    }

    private static String factorial(String number) {
        return valueOf(factorial(parseInt(number)));
    }

    private static int factorial(int number) {
        return IntStream.range(2,number+1).reduce(1,(a, i)->a*i);
    }

}
