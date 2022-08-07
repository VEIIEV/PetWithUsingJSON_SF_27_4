package io;

import model.Statistics;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;


//класс для записи в файл
public class XlsWriter {


    private static int indexOfRow = 1;
    private XlsWriter() {

    }


    //метод для записи в файл статистики
    //на вход принимает коллекцию Statistic и расположение файла в строковом виде
    public static void writeXlsStatistic(List<Statistics> statistics, String filePath) {
        //создаём объект excel'я

        XSSFWorkbook workbook = new XSSFWorkbook();
        //создаём объект страницы
        XSSFSheet sheet = workbook.createSheet("Statistics");
        //создаём объект стиля
        XSSFCellStyle headerStyle = workbook.createCellStyle();
        //создаём объект шрифта
        XSSFFont font = (workbook).createFont();

        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);

        //создаём объект ряда
        XSSFRow header = sheet.createRow(0);

        //настраиваем стиль
        headerStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 7);
        font.setBold(true);
        headerStyle.setFont(font);
        //заполняем оглавление
        XSSFCell headerCell = header.createCell(0);
        headerCell.setCellValue("studyProfile");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("evgExmScore");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(2);
        headerCell.setCellValue("nStudentsByProfile");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(3);
        headerCell.setCellValue("nUniversitiesByProfile");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(4);
        headerCell.setCellValue("universitiesName");
        headerCell.setCellStyle(headerStyle);

        //записываем данные

        addData(statistics, sheet,headerStyle);

        //записываем информации в файл
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            workbook.write(fileOutputStream);
            workbook.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void addData(List<Statistics> statistics, XSSFSheet sheet, XSSFCellStyle headerStyle) {

        for (Statistics statistic :
                statistics) {
            XSSFRow data = sheet.createRow(indexOfRow++);

            XSSFCell dataCell = data.createCell(0);
            dataCell.setCellValue(statistic.getStudyProfile().toString());
            dataCell.setCellStyle(headerStyle);

            dataCell = data.createCell(1);
            dataCell.setCellValue(statistic.getEvgExmScore());
            dataCell.setCellStyle(headerStyle);

            dataCell = data.createCell(2);
            dataCell.setCellValue(statistic.getnStudentsByProfile());
            dataCell.setCellStyle(headerStyle);

            dataCell = data.createCell(3);
            dataCell.setCellValue(statistic.getnUniversitiesByProfile());
            dataCell.setCellStyle(headerStyle);

            dataCell = data.createCell(4);
            dataCell.setCellValue(statistic.getUniversitiesName());
            dataCell.setCellStyle(headerStyle);

        }

    }

}
