package com.exploreandlearn.practice1.staff;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Staff {

    @Id
    @GeneratedValue
    private Integer staffId;
    private String staffName;
    private String section;
    private Boolean isClassTeacher;
    private  String subject;
}
