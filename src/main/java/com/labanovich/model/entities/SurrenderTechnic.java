package com.labanovich.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class SurrenderTechnic {
    private int id;
    private int userId;
    private int technicId;
    private Date surrenderDate;
    private Date receiveDate;
}
