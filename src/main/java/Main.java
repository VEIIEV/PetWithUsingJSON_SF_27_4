import model.Student;
import model.StudyProfile;
import model.University;
import model.comparators.ComparatorUStudyProfile;

public class Main {

    public static void main(String[] args) {
        University university = new University("0", "full", "short", 1999, StudyProfile.MEDICINE);
        Student student = new Student("full", "0", 1, 5);
        System.out.println(university+ "\n"
        + student);
    }
}
