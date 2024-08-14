package com.exploreandlearn.practice1.staff;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;


@Data
public class StaffRequest {
    private String staffName;
    private String section;
    private Boolean isClassTeacher;
    private String subject;

}
