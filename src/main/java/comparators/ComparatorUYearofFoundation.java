package comparators;

public class ComparatorUYearofFoundation implements UniversityComparator {
    @Override
    public int compare(Object o1, Object o2) {
        return Integer.compare((Integer) o1, (Integer) o2);
    }
}

