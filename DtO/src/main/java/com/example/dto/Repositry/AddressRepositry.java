package com.example.dto.Repositry;

import com.example.dto.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepositry extends JpaRepository<Address,Integer> {
    Address findTeacherAddressById(Integer id);
   Address findAllById(Integer id);
}
