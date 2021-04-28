package challenges.studentsProfile;

import java.util.Arrays;

public class StudentProfile {
    String fName;
    String lName;
    double gpa;
    int expectedYearToGraduate;
    String [] declaredMajor;

    public StudentProfile(String fName, String lName, double gpa, int expectedYearToGraduate, String[] declaredMajor){
        this.fName = fName;
        this.lName = lName;
        this.gpa = gpa;
        this.expectedYearToGraduate = expectedYearToGraduate;
        this.declaredMajor = declaredMajor;
    }

    public void increasePassingYear(){
        expectedYearToGraduate = expectedYearToGraduate + 1;
    }

    public String getFullName(){
        return fName+" "+lName;
    }

    @Override
    public String toString() {
        return "StudentProfile{" +
                "firstName='" + fName + '\'' +
                ", lastName='" + lName + '\'' +
                ", GPA=" + gpa +
                ", expectedYearToGraduate='" + expectedYearToGraduate + '\'' +
                ", declaredMajor=" + Arrays.toString(declaredMajor) +
                '}';
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setExpectedYearToGraduate(int expectedYearToGraduate) {
        this.expectedYearToGraduate = expectedYearToGraduate;
    }

    public void setDeclaredMajor(String[] declaredMajor) {
        this.declaredMajor = declaredMajor;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public double getGpa() {
        return gpa;
    }

    public int getExpectedYearToGraduate() {
        return expectedYearToGraduate;
    }

    public String[] getDeclaredMajor() {
        return declaredMajor;
    }
}
