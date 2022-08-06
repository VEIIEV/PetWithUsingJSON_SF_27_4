package io;

import model.Statistic;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;


//класс для записи в файл
public class XlsWriter {


        //метод для записи в в файл статистики
    //на вход принимает коллекцию Statistic и расположение файла в строковом виде
    public void writeXlsStatistic(List<Statistic> statistics, String filePath){
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
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 14);
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
        addData(statistics, sheet, headerStyle);

        //записываем информации в файл
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)){
            workbook.write(fileOutputStream);
            workbook.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void addData(List<Statistic> statistics, XSSFSheet sheet, XSSFCellStyle headerStyle) {
        Statistic statistic;
        int i =1;
        ListIterator iterator = new ArrayListIterator(statistics);
        while(iterator.hasNext()){
            statistic= (Statistic) iterator.next();
            XSSFRow data = sheet.createRow(i);

            XSSFCell dataCell = data.createCell(0);
            dataCell.setCellValue(statistic.getStudyProfile().toString());
            dataCell.setCellStyle(headerStyle);

            dataCell = data.createCell(1);
            dataCell.setCellValue(statistic.getEvgExmScore());
            dataCell.setCellStyle(headerStyle);

            dataCell = data.createCell(2);
            dataCell.setCellValue(statistic.getnStudentsByProfile().toString());
            dataCell.setCellStyle(headerStyle);

            dataCell = data.createCell(3);
            dataCell.setCellValue(statistic.getnUniversitiesByProfile().toString());
            dataCell.setCellStyle(headerStyle);

            dataCell = data.createCell(4);
            dataCell.setCellValue(statistic.getUniversitiesName().toString());
            dataCell.setCellStyle(headerStyle);

            i++;
        }
    }

}
