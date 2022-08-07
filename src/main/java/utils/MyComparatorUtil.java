package utils;

import comparators.*;
import enums.SComparatorList;
import enums.UComparatorList;

public class MyComparatorUtil {
    //Создать утилитный класс (то есть класс, не позволяющий создать свой экземпляр, работающий
    // исключительно по статическим методам), в котором реализовать два метода, принимающих
    // на вход enum с типом компаратора, определяющих и возвращающих необходимый из реализованных компараторов.
    //Пояснение: на вход метода подаётся параметр, представляющий собой enum. Например, вот так:
    // public static IMyComparator getMyComparator(MyEnum myEnum).
    // Внутри метода по этому значению определяем, какую реализацию компаратора надо взять.
    // На выходе метода, как видно из его описания, мы получаем тот или иной объект,
    // реализующий наш интерфейс компаратора.
    public static StudentComparator getMyComparator(SComparatorList comList) {
        switch (comList) {
            case FULLNAME:
                return new ComparatorSFullName();
            case AVGEXAMSCORE:
                return new ComparatorSAvgExamScore();
            case UNIVERSITYID:
                return new ComparatorSUniversityId();
            case CURRENTCOURSENUMBER:
                return new ComparatorSCurrentCourseNumber();
            default:
                return null;

        }
    }

    public static UniversityComparator getMyComparator(UComparatorList comList) {
        switch (comList) {
            case FULLNAME:
                return new ComparatorUFullName();
            case SHORTNAME:
                return new ComparatorUShortName();
            case ID:
                return new ComparatorUId();
            case STUDYPROFILE:
                return new ComparatorUStudyProfile();
            case YEAROFFOUNDATION:
                return new ComparatorUYearofFoundation();
            default:
                return null;
        }
    }
}
