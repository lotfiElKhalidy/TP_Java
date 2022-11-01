public class Course {

    private int numberOfStudents;
    private boolean exciting;
    
    public void setNumberOfStudents(int n) {
        numberOfStudents = n;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setExcitingVar(boolean p) {
        exciting = p;
    }

    public boolean isExciting() {
        return exciting;
    }

    public Course() {
        this(0, true);
    }

    public Course(int n, boolean b) {
        setNumberOfStudents(n);
        setExcitingVar(b);
    }

    public static void main(String[] argv) {
        Course c1 = new Course(26, false);

        Course c2 = new Course(12, true);

        System.out.println("Class c2 #" + c2.getNumberOfStudents());

        if (!c1.isExciting())
            System.out.println("bof");
    }
}
