package org.example;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "`HospitalManagement _schema`.Hospital")
@Data
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "Name")
    private String Name;




}
