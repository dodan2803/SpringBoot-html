package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService<Student> studentService;

    @GetMapping("")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>("Thêm thành công", HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        studentService.save(student);
        return new ResponseEntity<>("Sưa thành công", HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        studentService.delete(id);
        return new ResponseEntity<>("Xóa  thành công", HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> getByName(@RequestParam String q) {
        List<Student> cityBoyList = studentService.findByNameContaining(q);
        return new ResponseEntity<>(cityBoyList, HttpStatus.OK);
    }
}
