package comparators;

import org.apache.commons.lang3.StringUtils;

public class ComparatorSFullName implements StudentComparator{
    @Override
    public int compare(Object o1, Object o2) {
        return StringUtils.compare(o1.toString(), o2.toString());
    }

    @Override
    public String toString() {
        return "ComparatorSFullName{}";
    }
}
