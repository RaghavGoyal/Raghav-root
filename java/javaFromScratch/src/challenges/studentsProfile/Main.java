package challenges.studentsProfile;

public class Main {
    public static void main(String[] args) {
        String[] s1Major = new String[]{"Computers", "ML", "AI", "Soft Computing"};
        String[] s2Major = new String[]{"Computers", "Java", "Radar", "Communication"};
        StudentProfile student1 = new StudentProfile("Raghav", "Goyal", 10.0, 2019, s1Major);
        StudentProfile student2 = new StudentProfile("Rahul", "Sharma", 8.5, 2019, s2Major);

        System.out.println("Student "+student2.getfName()+" to pass in: "+student2.expectedYearToGraduate);
        student2.increasePassingYear();
        System.out.println(student2.getFullName() + " got year back and hence will pass in: "+student2.expectedYearToGraduate);
        System.out.println("Raghav will pass in "+student1.expectedYearToGraduate);
    }
}
