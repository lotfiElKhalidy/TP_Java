public class War {
    public static void main(String[] argv) {
        Trooper trooper1 = new Trooper();
        Trooper trooper2 = new Trooper("Cody");
        Trooper trooper3 = new Trooper();

        trooper1.displayTrooper();
        trooper2.displayTrooper();
        
        trooper3.clone();
        trooper3.setName("Dead");
        trooper3.setStamina(49);
        trooper3.displayTrooper();
    }
}