package com.example.dto.Controller;

import com.example.dto.Model.Address;
import com.example.dto.Model.Teacher;
import com.example.dto.Service.AddressService;
import com.example.dto.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.dto.DTO.AddressDto;
import java.util.List;
@RestController
@RequiredArgsConstructor

@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        List<Teacher> teachers=teacherService.getTeacher();
        return ResponseEntity.status(200).body(teachers);
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teachers){
        teacherService.addTeacher(teachers);
        return ResponseEntity.status(200).body("Teacher added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @Valid @RequestBody Teacher teachers) {
        teacherService.UpdateTeacher(id, teachers);
        return ResponseEntity.status(200).body("Teacher updated");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);

        return ResponseEntity.status(200).body("Teacher deleted");


    }

    @PostMapping("/adddetails")
    public ResponseEntity addDetails(@RequestBody AddressDto addressDto){
        addressService.addaddressDetals(addressDto);
        return ResponseEntity.status(200).body("Teacher detail added");


    }
    @PutMapping("/updatedetails")
    public ResponseEntity updateTeacherdetails(@RequestBody AddressDto addressDto) {
        addressService.updatAaddresDetails(addressDto);
        return ResponseEntity.status(200).body("Teacher details updated");

    }
    @DeleteMapping("/deletdetails/{id}")
    public ResponseEntity deletTeacherDetails(@PathVariable Integer id){
        addressService.deleteAddressDetails(id);

        return ResponseEntity.status(200).body("Teacher details deleted");


    }
    @GetMapping("/getdetails/{id}")
    public ResponseEntity getTeacherdetails(@PathVariable Integer id,@RequestBody AddressDto addressDto){
        Address teachers=AddressService.getDetails(id,addressDto);
        return ResponseEntity.status(200).body(teachers);
    }


}
