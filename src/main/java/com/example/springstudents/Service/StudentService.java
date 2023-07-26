package com.example.springstudents.EmployeeDAO;

import com.example.springstudents.domain.FormOfEducation;
import com.example.springstudents.domain.StudentsInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDAO {
    private static int STUDENTS_COUNT;
    private List<StudentsInfo> students;

    {
        StudentsInfo firstStudent = new StudentsInfo(++STUDENTS_COUNT, "Lesha", "Kutuznikov",
                "Lawyer", FormOfEducation.DISTANCE);

        StudentsInfo secondStudent = new StudentsInfo(++STUDENTS_COUNT, "Petya", "Vivalis",
                "Engineer", FormOfEducation.FULL_TIME);

        StudentsInfo thirdStudent = new StudentsInfo(++STUDENTS_COUNT, "Margo", "Rebretra",
                "Economist", FormOfEducation.PART_TIME);

        StudentsInfo fourthStudent = new StudentsInfo(++STUDENTS_COUNT, "Demis", "Karabis",
                "Programmer", FormOfEducation.FULL_TIME);

        students = new ArrayList<>();
        students.add(firstStudent);
        students.add(secondStudent);
        students.add(thirdStudent);
        students.add(fourthStudent);

    }
    public List<StudentsInfo> getAll() {
        return students;
    }

    public void addStudent(StudentsInfo student) {
        student.setId(++STUDENTS_COUNT);
        students.add(student);
    }
}
