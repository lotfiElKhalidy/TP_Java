import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static final void main(String[] args)
    {
        // --------- Example of the filterEvenNumbers method ---------

        ArrayList<Integer> listOfNumbers = new ArrayList<>();

        for (int i=0; i<50; i++)
        {
            listOfNumbers.add(i);
        } 

        ArrayList<Integer> evenNumbers = ListOperations.filterEvenNumbers(listOfNumbers);
        
        System.out.print("The even numbers of the given list are : ");

        for (Integer number : evenNumbers) {
            System.out.print(number + " ");
        }

        System.out.print("\n");


        // --------- Example of the countWords method ---------

        String sentence = "Ceci est un exemple. Un exemple de comptage de mots dans une chaine de caracteres.";

        HashMap<String, Integer> wordCount = WordCounter.countWords(sentence);

        System.out.println("Here is your sentence : " + sentence);
        
        for (HashMap.Entry<String, Integer> entry : wordCount.entrySet())
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // --------- Example of the NegativeNumberException ---------

        try {
            NegativeNumberException.exampleMethod(-21);
        }
        catch(NegativeNumberException e) {
            System.out.println("Error : " + e.getMessage());
        }

        // --------- Example of the divide method ---------

        // Nominal case
        try {
            double result = Calculator.divide(10, 2);
            System.out.println("The result of the division is : " + result);
        }
        catch (ArithmeticException e) {
            System.err.println("Error : " + e.getMessage());
        }
        catch (NegativeNumberException e) {
            System.err.println("Error : " + e.getMessage());
        }

        // In case we're trying to divide by zero
        try {
            double result2 = Calculator.divide(5, 0);
        }
        catch (ArithmeticException e) {
            System.err.println("Error : " + e.getMessage());
        }
        catch (NegativeNumberException e) {
            System.err.println("Error : " + e.getMessage());
        }

        // In case one of the givzn  numbers is negative
        try {
            double result3 = Calculator.divide(-8, 4);
        }
        catch (ArithmeticException e) {
            System.err.println("Error : " + e.getMessage());
        }
        catch (NegativeNumberException e) {
            System.err.println("Error : " + e.getMessage());
        }
    } 
}