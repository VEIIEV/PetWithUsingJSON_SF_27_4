package model.comparators;

import org.apache.commons.lang3.StringUtils;

public class ComparatorUYearofFoundation implements UniversityComparator {
    @Override
    public int compare(Object o1, Object o2) {
        return Integer.compare((Integer) o1, (Integer) o2);
    }
}

