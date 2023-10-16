// 1. Créez un fichier Main.java qui contient une classe et un point d’entrée pour le programme (main). La méthode
// Main devra afficher un message d’accueil type Coucou

public class UpgradedMain
{
    public static void main(String[] argv)
    {
        System.out.println("Coucou !");

        DisplayArguments(argv);
        DisplayArgumentsInReverse(argv);
        DetectUpperCaseArguments(argv);
        DisplayArgumentsWithTheirLength(argv);
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