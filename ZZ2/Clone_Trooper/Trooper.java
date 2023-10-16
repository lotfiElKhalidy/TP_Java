class Trooper implements Cloneable {
    private int ID;
    private String name;
    private int stamina;

    static public int count = 0;

    /*
    enum Grade {
        TROOPER {
            public String getGrade() { return "WHITE"; } 
        },
        SERGENT {
            public String getGrade() { return "GREEN"; } 
        },
        LIEUTENANT {
            public String getGrade() { return "BLUE"; } 
        },
        CAPTAIN {
            public String getGrade() { return "RED"; } 
        },
        COMMANDER {
            public String getGrade() { return "YELLOW"; } 
        };

        abstract public String getGrade();
    }
    */

    public Trooper() {
        System.out.println("----------------------------------");
        System.out.println("Trooper's constructor");
        count += 1;
        setID(count);
        setName("Clone de Jango Fett #" + getID());

        // generate a random integer number between 50 and 100
        int randomStamina = (int) Math.random()*101;
        if (randomStamina < 50) {
            randomStamina += 50;
        }
        setStamina(randomStamina);
    }

    public Trooper(String nameVar) {
        System.out.println("----------------------------------");
        System.out.println("Trooper's constructor 2");
        count += 1;
        setID(count);
        setName(nameVar + " #" + getID());

        // generate a random integer number between 50 and 100
        int randomStamina = (int) Math.random()*101;
        if (randomStamina < 50) {
            randomStamina += 50;
        }
        setStamina(randomStamina);
    }

    public int getID() {
        return ID;
    }

    public void setID(int IDvar) {
        ID = IDvar;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameVar) {
        name = nameVar;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int staminaVar) {
        stamina = staminaVar;
    }

    public Object clone() {
        Trooper object = null;
        try {
            object = (Trooper) super.clone();
        } catch(CloneNotSupportedException cnse) {
            cnse.printStackTrace(System.err);
        }
        // s'occuper des attributs "compliqués" 
        // si object est non null
        // MAIS PAS TOUT DE SUITE
        // uniquement quand on vous le demande

        return object;
    }

    public void displayTrooper() {
        System.out.println("This is a Trooper's object");
        System.out.println("ID : " + getID());
        System.out.println("Name : " + getName());
        System.out.println("Stamina : " + getStamina());
    }
}