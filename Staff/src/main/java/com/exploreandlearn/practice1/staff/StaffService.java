package com.exploreandlearn.practice1.staff;

import com.exploreandlearn.practice1.feign.model.StaffResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class StaffService {
    private final  StaffRepository staffRepository;

    public Collection<Staff> getAll(){
        return staffRepository.findAll();
    }

    public Integer createStaff(StaffRequest staffReq){
        Staff staff = Staff.builder().staffName(staffReq.getStaffName())
                .section(staffReq.getSection())
                .isClassTeacher(staffReq.getIsClassTeacher())
                .subject(staffReq.getSubject())
                .build();
        staffRepository.saveAndFlush(staff);
        return staff.getStaffId();
    }

    public Staff getStaffById(Integer staffId){
        return  staffRepository.findById(staffId).orElseGet(Staff::new);
    }


    public StaffResponse getBySection(String section){
        Optional<Staff> bySection = staffRepository.findBySection(section);
        System.out.println(bySection);
        if(bySection.isPresent()){
            StaffResponse response = new StaffResponse();
            response.setStaffName(bySection.get().getStaffName());
            response.setSection(bySection.get().getSection());
            response.setClassTeacher(bySection.get().getIsClassTeacher());
            response.setSubject(bySection.get().getSubject());
            return response;
        }
        return new StaffResponse();

    }
}
