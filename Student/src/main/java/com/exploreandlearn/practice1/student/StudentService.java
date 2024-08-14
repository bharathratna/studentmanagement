package com.exploreandlearn.practice1.student;

import com.exploreandlearn.practice1.feign.client.StaffClient;
import com.exploreandlearn.practice1.feign.model.StaffResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final  StudentRepository studentRepository;
    private final RestTemplate template;
    private final StaffClient staffClient;

    public Collection<Student> getAll(){
        return studentRepository.findAll();
    }


    public Integer createStudent(Student student) throws Exception{
        String section = createSection();
        student.setSection(section);
        System.out.println(section);

//        UriComponentsBuilder builder= UriComponentsBuilder.fromHttpUrl("http://STAFFAPPLICATION/api/v1/staff/getBySection")
//                .queryParam("section",section);
//        Staff resp = template.getForObject(builder.toUriString(),Staff.class);
        StaffResponse staffResponse = staffClient.getBySection(section);
        System.out.println(staffResponse);
        if (staffResponse == null){
            throw new Exception("some thing went wrong!!!");
        }

        student.setClassTeacher(staffResponse.getStaffName());
        studentRepository.saveAndFlush(student);
        return student.getStudentId();
    }

    private String createSection(){
        Random random = new Random();
        int value  = random.nextInt(1,4);
        return value == 1? "A" : value == 2 ? "B" : "C";
    }

    public Student getStudent(Integer id){
        return
                studentRepository.findById(id).orElse(new Student());
    }
}
