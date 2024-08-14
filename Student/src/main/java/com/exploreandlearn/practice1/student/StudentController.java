package com.exploreandlearn.practice1.student;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {


    private final StudentService studentService;
    private  int s;



    @Autowired  // 1 is Optional
    public StudentController(StudentService service){
        this.studentService = service;
    }


    @GetMapping("/get")
    public Collection<Student> getAll(){
        return studentService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        try {
            return ResponseEntity.ok().body(studentService.createStudent(student));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getBy")
    public Student getBy(@RequestParam("studentId") Integer studentId){
        return studentService.getStudent(studentId);
    }
}
