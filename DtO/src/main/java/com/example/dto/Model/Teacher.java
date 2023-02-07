package com.example.dto.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(columnDefinition = "varchar(30) not null")
    @Size(min = 4,message = "name must be more than 4 character")
    private String name;
    @NonNull
    private int age;
    @NonNull
    @Column(columnDefinition = "varchar(50) not null")
    @Email
    private String email;
     @NonNull
    private int salary;
    @OneToOne(cascade =CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    Address address;
}
