package isima;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();

        while (true) {
            System.out.println("1. Parse and sort the CSV file by ID");
            System.out.println("2. Parse and sort the CSV file by Arrondissement then by Station name");
            System.out.println("3. Exit");
            System.out.print("Make your choice :");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    String path = "/home/local.isima.fr/loelkhalid/shared/ZZ3/Java/isima-poa-2023-TP3-ELKHALIDY/ratp_arret.csv";
                    // Parse file
                    List<MetroStop> sortedListMetroStopByID = parser.parse(path);
                    // Sort file
                    sortedListMetroStopByID = parser.sortMetroStopListByID(sortedListMetroStopByID);
                    // Display the result
                    displayData(sortedListMetroStopByID);
                    break;

                case 2:
                    String filePath = "/home/local.isima.fr/loelkhalid/shared/ZZ3/Java/isima-poa-2023-TP3-ELKHALIDY/ratp_arret.csv";
                    // Parse file
                    List<MetroStop> sortedListMetroStop = parser.parse(filePath);
                    // Sort file
                    sortedListMetroStop = parser.sortMetroStopListByArrondissementThenByStationName(sortedListMetroStop);
                    // Display the result
                    displayData(sortedListMetroStop);
                    break;

                case 3:
                    System.out.println("See you soon!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Choose another option.");
            }
        }
    }

    private static void displayData(List<MetroStop> listMetroStop) {
        for (MetroStop m : listMetroStop) {
            System.out.println(m);
        }
    }
}
