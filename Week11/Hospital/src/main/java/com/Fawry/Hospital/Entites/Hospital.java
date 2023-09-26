package com.Fawry.Hospital.Entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Hospital", schema = "HospitalManagement _schema")
@Data
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "Name")
    private String Name;




}
