package com.example.dto.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   @NonNull
    private String area;
  @NonNull
    private String street;
   @NonNull
    private int buildingNumber;
   @OneToOne
   @MapsId

   @JsonIgnore
    private Teacher teacher;
}
