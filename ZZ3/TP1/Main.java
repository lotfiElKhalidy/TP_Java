// ----------- Programmation avancée — Java
// ----------- TP1 Main et ligne de commande


// 1 Introduction

// Le but de ce TP est de vous familiariser avec la ligne de commande et le point d’entrée d’un programme Java : le main.
// Vous n’avez le droit de n’utiliser qu’un éditeur texte basique (type Emacs, Vi, Sublime, VsCode ...) et un terminal.
// Seule la documentation officielle Java sur le site d’Oracle est autorisée. Merci de ne pas utiliser des autres sites où
// vous pourriez trouver le code à copier/coller pour réaliser votre TP. Vous le ferez plus vite, mais vous n’apprendriez
// rien... Demandez-moi de l’aide à la place !

// 2 Travail à effectuer

public class Main
{
    public static void main(String[] argv)
    {

        // 1. Créez un fichier Main.java qui contient une classe et un point d’entrée pour le programme (main). La méthode
        // Main devra afficher un message d’accueil type Coucou

        System.out.println("Coucou !");

        // 2. Compilez le programme et exécutez-le

        // Compilation : javac Main.java
        // Exécution : java Main
        
        // 3. Modifiez la méthode Main pour qu’elle affiche les arguments passés via le terminal

        // Les arguments sont mentionnés lors de l'exécution
        
        System.out.println("----- argv content :");

        for (int i=0; i<argv.length; i++)
        {
            System.out.println(argv[i]);
        }

        // 4. Affichez les arguments passés via le terminal en ordre inverse

        System.out.println("----- argv content reversed :");

        for (int i=argv.length-1; i>=0; i--)
        {
            System.out.println(argv[i]);
        }

        // 5. Affichez les arguments passés en majuscules

        System.out.println("----- These are the uppercase arguments detected :");

        for (int i=0; i<argv.length; i++)
        {
            if (argv[i].equals(argv[i].toUpperCase()))
            {
                System.out.println(argv[i]);
            }
        }

        // 6. Calculez le nombre de caractères des différents arguments

        // len String => .length()
        // len String[] => .length

        System.out.println("----- Arguments with their length :");
        
        for (int i=0; i<argv.length; i++)
        {
            System.out.println(argv[i] + " : " + argv[i].length());
        }
    }
}