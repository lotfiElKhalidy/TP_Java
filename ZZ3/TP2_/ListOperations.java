import java.util.ArrayList;

public class ListOperations {

    public static ArrayList<Integer> filterEvenNumbers(ArrayList<Integer> listOfNumbers) {
        
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        
        for (Integer number : listOfNumbers)
        {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        
        return evenNumbers;
    }
}