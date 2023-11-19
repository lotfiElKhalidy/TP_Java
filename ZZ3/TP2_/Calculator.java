public class Calculator {
    
    public static double divide(double dividend, double divisor) throws ArithmeticException, NegativeNumberException {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        
        if (dividend < 0 || divisor < 0) {
            throw new NegativeNumberException("One of the given numbers is negative");
        }
        
        return dividend / divisor;
    }
}
