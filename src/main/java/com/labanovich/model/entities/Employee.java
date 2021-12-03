package com.labanovich.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Employee {
    private long id;
    private String name;
    private String surname;
    private String position;
    private String phoneNumber;
}
