package utils;

import enums.StudyProfile;
import model.Statistics;
import model.Student;
import model.University;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class AnalyserUtil {


    public List<Statistics> getherStatistic(List<Student> students, List<University> universities) {


        //мне нужны данные
        //каждый стадипрофайл
        //список университетов этого профиля
        //кол-во уневерситетов этого профиля
        //кол-во студентов этого профиля
        //найти всех студентов этого профиля, найти их ср оценки

        List<Statistics> statisticsList = new ArrayList<>();

        //получаем список профилей у которых есть хотя бы 1 университет
        //используем сет что бы получить по 1 образцу каждого профиля
        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        //ебать жуть
        //проводим ряд операций для каждог оприсета
        profiles.forEach(profile -> {
            //создаём обект статистики
            Statistics statistics = new Statistics();
            //добавляем этот объект в ранее объявленную коллекцию
            statisticsList.add(statistics);
            //начинаем заполнять, с уже известного профиля(очевидно)
            statistics.setStudyProfile(profile);
            //фильтруем институты на подходящие к этому профилю и  получаем список их id
            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            //заполняем  кол-во вузов
            statistics.setnUniversitiesByProfile(profileUniversityIds.size());
            //заполняем название вузов пустой строкой  код нижен равен   statistics.setUniversitiesName("");
            statistics.setUniversitiesName(StringUtils.EMPTY);
            //фильтруем вузы на те что содержат id из списка   profileUniversityIds
            universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    //получаем их имена
                    .map(University::getFullName)
                    //каждое имя приклиеваем к текущей строке + ; до конца списка
                    .forEach(fullNameUniversity -> statistics.setUniversitiesName(
                            statistics.getUniversitiesName() + fullNameUniversity + ";"));
            //создаём список студентов которые состоят в вузах из списка profileUniversityIds
            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            //заносим их количество в статистикс
            statistics.setnStudentsByProfile(profileStudents.size());
            //создаём обёртку для средних значений и заполняем её значениями
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            //отправляем в стистикс значение 0
            statistics.setEvgExmScore(0);
            //если обёртка !=null то записываем её значение в статистикс
            avgExamScore.ifPresent(value -> statistics.setEvgExmScore(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });
        //сформированный объёкт используем как возвращаемое значение
        return statisticsList;

    }
}
