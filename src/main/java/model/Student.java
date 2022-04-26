package model;

public class Student {
    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private float avgExamScore;

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public Student() {
        this.fullName = "";
        this.universityId = "";
        this.currentCourseNumber = 0;
        this.avgExamScore = 0;
    }

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public static class StudentBuilder {
        private Student newStudent;

        public StudentBuilder() {
            newStudent = new Student();
        }

        public StudentBuilder withFullName(String fullName){
            newStudent.fullName = fullName;
            return this;
        }

        public StudentBuilder withUniversityId(String universityId){
            newStudent.universityId = universityId;
            return this;
        }

        public StudentBuilder withCurrentCourseNumber(int currentCourseNumber){
            newStudent.currentCourseNumber = currentCourseNumber;
            return this;
        }

        public StudentBuilder withAvgExamScore(float avgExamScore){
            newStudent.avgExamScore = avgExamScore;
            return this;
        }



        public Student build(){
            return newStudent;
        }

    }


}
