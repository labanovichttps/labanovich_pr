package com.labanovich.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Technic {
    private int id;
    private String name;
    private String producer;
    private Date produceDate;
    private Date service_date;
    private double cost;
    private String status;

    public Technic(int id, String name, String producer, Date produceDate, Date service_date, double cost) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.produceDate = produceDate;
        this.service_date = service_date;
        this.cost = cost;
    }
}
