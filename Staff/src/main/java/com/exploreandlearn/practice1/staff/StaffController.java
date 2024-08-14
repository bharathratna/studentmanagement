package com.exploreandlearn.practice1.staff;

import com.exploreandlearn.practice1.feign.model.StaffResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/staff")
@RequiredArgsConstructor
@Slf4j
public class StaffController {

    private final StaffService staffService;

    @GetMapping("/get")
    public Collection<Staff> getStaff(){
        return staffService.getAll();
    }

    @PostMapping("/create")
    public Integer createStudent(@RequestBody StaffRequest staff){
        log.info("checking the value of staff is class teacher {}", staff.getIsClassTeacher());
        return staffService.createStaff(staff);
    }

    @GetMapping("/getBy")
    public Staff getByStaff(@RequestParam("staffId") Integer staffId){
        return staffService.getStaffById(staffId);
    }

    @GetMapping("/getBySection")
    public StaffResponse getBySection(@RequestParam("section") String section){
        System.out.println("section called from the inter communication "+ section);
       return  staffService.getBySection(section);
    }
}
