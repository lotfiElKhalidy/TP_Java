// Déclaration de variables
public class Variables
{
    public static void main(String[] argv)
    {
        // Types primitifs
        int     i = 0;
        char    c = 'A';
        // double est plus précis que float; Il prend plus de chiffres après la virgule
        double  d = 10.0;
        float   e = 1.3f;
        boolean f = true;

        // Déclaration d'une constante
        final double pi = 3.14;

        i = i + 1;

        System.out.println(i);      // 1
        System.out.println(++i);    // 2 ; ++i : On incrémente puis on affiche
        System.out.println(i);      // 2
        System.out.println(i++);    // 2 ; i++ : On affiche puis on affiche
        System.out.println(i);      // 3

        i = (int) 10.2;      // On peut faire un cast comme en C
        int a = 5, b = 2;
        float c = (float) a/b;       // Sans le cast, on aurait eu 2 mais grace au cast le résultat est 2,5
    }
}