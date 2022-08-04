package model.comparators;

public class ComparatorSCurrentCourseNumber implements StudentComparator{
    @Override
    public int compare(Object o1, Object o2) {
        return Integer.compare((Integer) o1, (Integer) o2);
    }
}

