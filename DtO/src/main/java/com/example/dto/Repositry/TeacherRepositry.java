package com.example.dto.Repositry;

import com.example.dto.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepositry extends JpaRepository<Teacher,Integer> {

    Teacher findTeacherById(Integer id);


}
