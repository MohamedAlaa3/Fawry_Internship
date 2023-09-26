package com.Fawry.Hospital.Entites;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Doctor", schema = "HospitalManagement _schema")
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO  )
    @Column(name = "ID", nullable = false)
    private int ID ;

    @Column (name = "Name")
    private String Name;



//    @OneToMany(mappedBy = "doctor")
//    private List<Patient> patints;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Hopital_ID", referencedColumnName = "ID")
    private Hospital hospital;



}

