import enums.SComparatorList;
import model.Student;
import enums.StudyProfile;
import model.University;
import utils.MyComparator;

public class Main {
//В методе main реализовать получение компаратора по типу (вызов метода утилитного класса).
// Сохранить полученные значения (то есть экземпляры компараторов) в переменные с типом интерфейса компаратора
// (аналогично тому, как в коллекциях делается List<T> someList = new ArrayList()).
    public static void main(String[] args) {
        University university = new University("0", "full", "short", 1999, StudyProfile.MEDICINE);
        Student student = new Student("full", "0", 1, 5);
        Student student2 = new Student("fullname", "0", 1, 5);
        System.out.println(university+ "\n"
        + student);
        System.out.println("there is a comparison of student and student2");
        System.out.println(MyComparator.getMyComparator(SComparatorList.FULLNAME).compare(student,student2));
        System.out.println(MyComparator.getMyComparator(SComparatorList.FULLNAME));
    }
}
