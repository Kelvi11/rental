package com.kelvin.rental.model;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.kelvin.rental.managment.AppConstants.HOUSE_TABLE_NAME;


//@Data
@Entity
@Table(name = HOUSE_TABLE_NAME)

@FilterDef(name = "like.created_by", parameters = @ParamDef(name = "created_by", type = "string"))
@Filter(name = "like.created_by", condition = "lower(created_by) LIKE :created_by")

public class House {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "uuid", unique = true)
    @Id
    public String uuid;

    public double total_price;
    public LocalDateTime created_date;
    public String created_by;
}
