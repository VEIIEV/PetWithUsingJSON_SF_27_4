package enums;

public enum StudyProfile {

    MEDICINE("Медицина"),
    ECONOMICS("Экономика"),
    LAW("Законодательство"),
    INFORMATIONSYSTEMS("информационные системы"),
    BUSINESS("бизнес"),
    PHYSICS("физика"),
    LINGUISTICS("лингвистика"),
    MATHEMATICS("математика"),
    ART("искусство");


    String profile;

    StudyProfile(String profile) {
        this.profile = profile;
    }



    @Override
    public String toString() {
        return profile ;
    }
}