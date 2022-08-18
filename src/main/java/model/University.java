package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;

import jakarta.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
public class University {

    //аннотация для json сериализации
    @SerializedName("идентификатор")
    //аннотация для xml представления файла
    @XmlElement(name = "universityId")
    private String id;
    @SerializedName("Полное название")
    @XmlElement(name = "universityName")
    private String fullName;
    @SerializedName("сокращённое название")
    @XmlTransient
    private String shortName;
    @SerializedName("год основания")
    @XmlTransient
    private int yearOfFoundation;
    @SerializedName("направленность")
    @XmlElement(name = "mainProfile")
    private StudyProfile mainProfile;

    public static class UniversityBuilder {
        private University newUniversity;

        public UniversityBuilder() {
            newUniversity = new University();
        }

        public UniversityBuilder withFullName(String fullName){
            newUniversity.fullName = fullName;
            return this;
        }

        public UniversityBuilder withShortName(String shortName){
            newUniversity.shortName = shortName;
            return this;
        }

        public UniversityBuilder withId(String id){
            newUniversity.id = id;
            return this;
        }

        public UniversityBuilder withYearOfFoundation(int yearOfFoundation){
            newUniversity.yearOfFoundation = yearOfFoundation;
            return this;
        }

        public UniversityBuilder withMainProfile(StudyProfile mainProfile){
            newUniversity.mainProfile = mainProfile;
            return this;
        }



        public University build(){
            return newUniversity;
        }

    }

    public University( ) {
        this.id = "";
        this.fullName = "";
        this.shortName = "";
        this.yearOfFoundation = 0;
        this.mainProfile = null;
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }
}
