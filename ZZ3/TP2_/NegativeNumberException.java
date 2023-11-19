public class NegativeNumberException extends Exception {
    
    public NegativeNumberException(String message) {
        super(message);
    }

    public static void exampleMethod(int number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException("This number cannot be negative (" + number + ")");
        }
    }
}