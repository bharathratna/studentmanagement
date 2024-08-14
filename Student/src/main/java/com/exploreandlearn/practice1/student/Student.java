package com.exploreandlearn.practice1.student;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String studentName;
    private String classTeacher;
    private Integer standard;
    private String section;

    //    public Student(){
//
//    }

//    public Student(Integer sid, String name, String classTeacher, Integer standard, String section){
//
//    }

}
