package com.familyfirstsoftware.departmentManager.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // builder pattern
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    // validation
    //@Length(max = 5, min = 3)
    //@Size(max = 10, min = 0);
    //@Email
    @NotBlank(message = "Please add Department Name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;



}
