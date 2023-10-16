// 1. Créez un fichier Main.java qui contient une classe et un point d’entrée pour le programme (main). La méthode
// Main devra afficher un message d’accueil type Coucou

import java.util.Scanner;

public class Bonus
{
    public static void main(String[] argv)
    {
        System.out.println("Coucou !");

        System.out.println("Que souhaitez-vous faire ?");
        System.out.println("1. Affichez les arguments");
        System.out.println("2. Affichez les arguments en ordre inverse");
        System.out.println("3. Affichez uniqement les arguments en majuscules");
        System.out.println("4. Affichez les arguments avec leurs tailles");
        
        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();

        switch (userChoice)
        {
            case 1:
                DisplayArguments(argv);
                break;

            case 2:
                DisplayArgumentsInReverse(argv);
                break;

            case 3:
                DetectUpperCaseArguments(argv);
                break;

            case 4:
                DisplayArgumentsWithTheirLength(argv);
                break;

            default:
                System.out.println("Vous avez fait un choix inexistant !!");
                break;
        }
    }

    // 3. Modifiez la méthode Main pour qu’elle affiche les arguments passés via le terminal

    public static void DisplayArguments(String[] arguments)
    {
        System.out.println("----- argv content :");
        
        for (int i=0; i<arguments.length; i++)
        {
            System.out.println(arguments[i]);
        }
    }

    // 4. Affichez les arguments passés via le terminal en ordre inverse

    public static void DisplayArgumentsInReverse(String[] arguments)
    {
        System.out.println("----- argv content reversed :");

        for (int i=arguments.length-1; i>=0; i--)
        {
            System.out.println(arguments[i]);
        }
    }

    // 5. Affichez les arguments passés en majuscules

    public static void DetectUpperCaseArguments(String[] arguments)
    {
        System.out.println("----- These are the uppercase arguments detected :");

        for (int i=0; i<arguments.length; i++)
        {
            if (arguments[i].equals(arguments[i].toUpperCase()))
            {
                System.out.println(arguments[i]);
            }
        }
    }

    // 6. Calculez le nombre de caractères des différents arguments

    public static void DisplayArgumentsWithTheirLength(String[] arguments)
    {
        System.out.println("----- Arguments with their length :");
        
        for (int i=0; i<arguments.length; i++)
        {
            System.out.println(arguments[i] + " : " + arguments[i].length());
        }
    }
}