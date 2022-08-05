package comparators;

public class ComparatorSAvgExamScore implements StudentComparator{
    @Override
    public int compare(Object o1, Object o2) {
        return Float.compare((Float) o2, (Float) o1);
    }
}

