package model;

public enum StudyProfile {

    MEDICINE("Медицина"),
    ECONOMICS("Экономика"),
    LAW("Законодательство"),
    INFORMATIONSYSTEMS("информационные системы"),
    BUSINESS("бизнес"),
    ART("искусство");


    String profile;

    StudyProfile(String profile) {
        this.profile = profile;
    }



    @Override
    public String toString() {
        return "StudyProfile{" +
                "StudyProfile='" + profile + '\'' +
                '}';
    }
}