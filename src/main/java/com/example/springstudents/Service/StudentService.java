package com.example.springstudents.Service;

import com.example.springstudents.Domain.StudentsInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {
    private Integer studentsCount = 0;
    private List<StudentsInfo> students;

    public StudentService(List<StudentsInfo> students) {
        this.students = students;
    }

    public List<StudentsInfo> getAll() {
        return students;
    }

    public StudentsInfo getStudent(Integer id) {
        return students.get(id - 1);
    }

    public void addStudent(StudentsInfo student) {
        student.setId(++studentsCount);
        students.add(student);
    }

    public void deleteStudent(Integer id) {
        students.remove(id - 1);        /** без (- 1) вылазит за границы List */
    }
}
