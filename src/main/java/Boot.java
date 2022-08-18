import comparators.StudentComparator;
import comparators.UniversityComparator;
import enums.SComparatorList;
import enums.UComparatorList;
import io.XlsReader;
import io.XlsWriter;
import io.XmlWriter;
import model.FullInfo;
import model.Statistics;
import model.Student;
import model.University;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AnalyserUtil;
import utils.JsonUtil;
import utils.MyComparatorUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Boot {

    static final String endExcelFile = "src/main/resources/StatisticsInfo.xlsx";

    private static final Logger logger = LoggerFactory.getLogger(Boot.class.getName());


    //В методе main реализовать получение компаратора по типу (вызов метода утилитного класса).
    // Сохранить полученные значения (то есть экземпляры компараторов) в переменные с типом интерфейса компаратора
    // (аналогично тому, как в коллекциях делается List<T> someList = new ArrayList()).

    public static void main(String[] args) throws IOException {

        logger.info("App  started");

        //comparator list creation
        List<UniversityComparator> universityComparators = new ArrayList<>();

        extracted(universityComparators);
        //write in param
        List<University> universities =
                XlsReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");

        //read from param
        //universities.stream().sorted(universityComparators.get(2).reversed()).forEach(System.out::println);


        ////comparator list creation
        List<StudentComparator> studentComparators = new ArrayList<>();
        studentComparators.add(MyComparatorUtil.getMyComparator(SComparatorList.FULLNAME));
        studentComparators.add(MyComparatorUtil.getMyComparator(SComparatorList.AVGEXAMSCORE));
        studentComparators.add(MyComparatorUtil.getMyComparator(SComparatorList.CURRENTCOURSENUMBER));
        studentComparators.add(MyComparatorUtil.getMyComparator(SComparatorList.UNIVERSITYID));

        //write in param
        List<Student> students =
                XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");


        //read from param
       //students.stream().sorted(studentComparators.get(2).reversed()).forEach(System.out::println);


        //serialization and then read json
        String studentsJson = JsonUtil.CollectionToJson(students);
        String universitiesJson = JsonUtil.CollectionToJson(universities);
        //System.out.println(studentsJson);
        //System.out.println(universitiesJson);
        logger.debug("students Json looks like: {}", studentsJson);
        logger.debug("universities Json looks like: {}", universitiesJson);

        //deserialization and test result
        List<University> newUniversities = JsonUtil.CollectionFromJson(universitiesJson, universities);
        List<Student> newStudents = JsonUtil.CollectionFromJson(studentsJson, students);
        //System.out.println("результат размера коллекций студентов: " + (newStudents.stream().count() == students.stream().count()));
        logger.debug("результат размера коллекций студентов: " + (newStudents.stream().count() == students.stream().count()));
        //System.out.println("результат размера коллекций университетов: " + (newUniversities.stream().count() == universities.stream().count()));
        logger.debug("результат размера коллекций университетов: " + (newUniversities.stream().count() == universities.stream().count()));

        //executing 7-10 tasks
        students = students.stream().map((p) -> JsonUtil.SingleToJson(p)).
                map((p) -> JsonUtil.SingleFromJson(p, new Student())).
                collect(Collectors.toList());

        universities = universities.stream().map((p) -> JsonUtil.SingleToJson(p)).
                map((p) -> JsonUtil.SingleFromJson(p, new University())).
                collect(Collectors.toList());

        List<Statistics> statistics = AnalyserUtil.getherStatistic(students, universities);

        XlsWriter.writeXlsStatistic(statistics, endExcelFile);

        FullInfo fullInfo = new FullInfo()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statistics)
                .setProcessDate(new Date());

        XmlWriter.generateXmlReq(fullInfo);

        logger.info("app finished without mess");

    }

    private static void extracted(List<UniversityComparator> universityComparators) {
        universityComparators.add(MyComparatorUtil.getMyComparator(UComparatorList.FULLNAME));
        universityComparators.add(MyComparatorUtil.getMyComparator(UComparatorList.SHORTNAME));
        universityComparators.add(MyComparatorUtil.getMyComparator(UComparatorList.ID));
        universityComparators.add(MyComparatorUtil.getMyComparator(UComparatorList.STUDYPROFILE));
        universityComparators.add(MyComparatorUtil.getMyComparator(UComparatorList.YEAROFFOUNDATION));
    }
}