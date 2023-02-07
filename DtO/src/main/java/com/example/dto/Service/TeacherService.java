package com.example.dto.Service;

import com.example.dto.Exeption.Api;
import com.example.dto.Model.Teacher;
import com.example.dto.Repositry.TeacherRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    public final TeacherRepositry teacherRepositry;

    public List<Teacher> getTeacher(){
        return teacherRepositry.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepositry.save(teacher);
    }

    public void UpdateTeacher(Integer id,Teacher teacher){
        Teacher m=teacherRepositry.findTeacherById(id);

        if(m==null){
            throw new Api("some thang error");
        }


    }
    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepositry.findTeacherById(id);

        if (teacher == null) {
            throw new Api("some thang error");

        }

        teacherRepositry.delete(teacher);

    }
}
