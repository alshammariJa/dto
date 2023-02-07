package com.example.dto.Service;

import com.example.dto.Exeption.Api;
import com.example.dto.Model.Address;
import com.example.dto.Model.Teacher;
import com.example.dto.Repositry.AddressRepositry;
import com.example.dto.Repositry.TeacherRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.dto.DTO.AddressDto;
@Service

@RequiredArgsConstructor
public class AddressService {
    private final TeacherRepositry teacherRepositry;
    private  AddressRepositry addressRepositry;

    public void addaddressDetals(AddressDto addressDto){
        Teacher teacher=teacherRepositry.findTeacherById(addressDto.getTeacher_id());
        if (teacher==null){
            throw new Api("teacher not found");

        }
       Address nweT= new Address(null,addressDto.getArea(),addressDto.getStreet(),addressDto.getBuildingNumber(),teacher);
        addressRepositry.save(nweT);

    }



    public void updatAaddresDetails(AddressDto addressDto){
        Address teacherAddress=addressRepositry.findTeacherAddressById(addressDto.getTeacher_id());

        if (teacherAddress==null){
            throw new Api("teacher not found");

        }
        teacherAddress.setArea(addressDto.getArea());
        teacherAddress.setStreet(addressDto.getStreet());
        teacherAddress.setBuildingNumber(addressDto.getBuildingNumber());
        teacherAddress.save(teacherAddress);

    }

    public void deleteAddressDetails(Integer id){
        Address TeacherAddress=addressRepositry.findTeacherAddressById(id);
        if (TeacherAddress==null){
            throw new Api("teacher not found");
        }
        addressRepositry.delete(TeacherAddress);
    }

    public Address getDetails(Integer id, AddressDto addressDto){
        Address TeacherAddress=addressRepositry.findTeacherAddressById(id);
        if (TeacherAddress==null){
            throw new Api("teacher not found");
        }

        return addressRepositry.findAllById(id);


    }
}
