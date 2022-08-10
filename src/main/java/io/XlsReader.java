package io;

import enums.StudyProfile;
import model.Student;
import model.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XlsReader {


    private static final Logger logger = LoggerFactory.getLogger(XlsReader.class.getName());

    private XlsReader() {
    }

    public static List<University> readXlsUniversities(String filePath) throws IOException {


        logger.info("method readXlsUniversities was started");

        List<University> universities = new ArrayList<>();

        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Университеты");

            if (sheet != null) {
                Iterator<Row> rows = sheet.iterator();
                rows.next();

                while (rows.hasNext()) {
                    Row currentRow = rows.next();
                    University university = new University();
                    universities.add(university);
                    university.setId(currentRow.getCell(0).getStringCellValue());
                    university.setFullName(currentRow.getCell(1).getStringCellValue());
                    university.setShortName(currentRow.getCell(2).getStringCellValue());
                    university.setYearOfFoundation((int) currentRow.getCell(3).getNumericCellValue());
                    university.setMainProfile(StudyProfile.valueOf(
                            StudyProfile.class, currentRow.getCell(4).getStringCellValue()));
                }
            }
        }
        catch (IOException e) {
            logger.error("reading from excel was failed: {}", e );
            return universities;

        }

        logger.info("reading from excel was success");
        return universities;
    }

    public static List<Student> readXlsStudents(String filePath) throws IOException {

        List<Student> students = new ArrayList<>();

        logger.info("method readXlsStudents was started");

        try {

            FileInputStream inputStream = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Студенты");

            if (sheet != null) {
                Iterator<Row> rows = sheet.iterator();
                rows.next();

                while (rows.hasNext()) {
                    Row currentRow = rows.next();
                    Student student = new Student();
                    students.add(student);
                    student.setUniversityId(currentRow.getCell(0).getStringCellValue());
                    student.setFullName(currentRow.getCell(1).getStringCellValue());
                    student.setCurrentCourseNumber((int) currentRow.getCell(2).getNumericCellValue());
                    student.setAvgExamScore((float) currentRow.getCell(3).getNumericCellValue());
                }
            }

        }
        catch (IOException e){
            logger.error("reading from excel was failed: {}", e );
            return students;

        }

        logger.info("reading from excel was success");
        return students;
    }
}