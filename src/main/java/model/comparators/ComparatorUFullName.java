package model.comparators;

import org.apache.commons.lang3.StringUtils;

public class ComparatorUFullName implements UniversityComparator{
    @Override
    public int compare(Object o1, Object o2) {
        return StringUtils.compare(o1.toString(), o2.toString());
    }
}

