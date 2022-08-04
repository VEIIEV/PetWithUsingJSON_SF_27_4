package model.comparators;

import model.StudyProfile;

public class ComparatorUStudyProfile implements UniversityComparator {
    @Override
    public int compare(Object o1, Object o2) {
        return (((StudyProfile) o1).compareTo( (StudyProfile) o2));
    }
}
