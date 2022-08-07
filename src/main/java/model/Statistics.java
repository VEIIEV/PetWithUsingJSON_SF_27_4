package model;

import enums.StudyProfile;

public class Statistics {
    //минимум, следующие поля: профиль обучения, средний балл за экзамен, количество студентов по профилю, количество университетов по профилю, названия университетов.
    private StudyProfile studyProfile;
    private float evgExmScore;
    private int nStudentsByProfile;
    private int nUniversitiesByProfile;
    private String universitiesName;

    public Statistics(StudyProfile studyProfile, float evgExmScore, int nStudentsByProfile, int nUniversitiesByProfile, String universitiesName) {
        this.studyProfile = studyProfile;
        this.evgExmScore = evgExmScore;
        this.nStudentsByProfile = nStudentsByProfile;
        this.nUniversitiesByProfile = nUniversitiesByProfile;
        this.universitiesName = universitiesName;
    }

    public Statistics() {
        this.studyProfile = null;
        this.evgExmScore = 0;
        this.nStudentsByProfile = 0;
        this.nUniversitiesByProfile = 0;
        this.universitiesName = "";
    }


    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public float getEvgExmScore() {
        return evgExmScore;
    }

    public void setEvgExmScore(float evgExmScore) {
        this.evgExmScore = evgExmScore;
    }

    public int getnStudentsByProfile() {
        return nStudentsByProfile;
    }

    public void setnStudentsByProfile(int nStudentsByProfile) {
        this.nStudentsByProfile = nStudentsByProfile;
    }

    public int getnUniversitiesByProfile() {
        return nUniversitiesByProfile;
    }

    public void setnUniversitiesByProfile(int nUniversitiesByProfile) {
        this.nUniversitiesByProfile = nUniversitiesByProfile;
    }

    public String getUniversitiesName() {
        return universitiesName;
    }

    public void setUniversitiesName(String universitiesName) {
        this.universitiesName = universitiesName;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                " studyProfile=" + studyProfile +
                ", evgExmScore=" + evgExmScore +
                ", nStudentsByProfile=" + nStudentsByProfile +
                ", nUniversitiesByProfile=" + nUniversitiesByProfile +
                ", universitiesName='" + universitiesName + '\'' +
                '}'+'\n';
    }
}
