package com.example.springstudents.Controller;

import com.example.springstudents.Service.StudentService;
import com.example.springstudents.Domain.StudentsInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class StudentsController {

    public StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudents(Model model) {
        List<StudentsInfo> students = studentService.getAll();
        model.addAttribute("students", students);
        return "all-students";
    }

    @GetMapping("/new")
    public String newStudent(@ModelAttribute("student") StudentsInfo student) {
        return "new-student";
    }

    @PostMapping()
    public String createStudent(@ModelAttribute("student") StudentsInfo student) {
        studentService.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getUser(Model model, @PathVariable Integer id) {
        StudentsInfo student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "delete-page";
    }

    @PostMapping("/{id}")
    public RedirectView deleteStudent(RedirectAttributes redirectAttributes, @PathVariable Integer id,
                                      @ModelAttribute StudentsInfo student) {
        studentService.deleteStudent(id);
        String message = "Deleted student " + student.getFirstName();
        redirectAttributes.addFlashAttribute("studentMessage", message);  /** передает null*/
        return new RedirectView("/");
    }
}
