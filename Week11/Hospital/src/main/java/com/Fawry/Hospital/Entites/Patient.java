package com.Fawry.Hospital.Entites;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`HospitalManagement _schema`.Patient")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "Name")
    private String Name;


    @ManyToOne()
    @JoinColumn(name = "Doctor_Id", referencedColumnName = "ID")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "Hopital_ID", referencedColumnName = "ID")
    private Hospital hospital;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "`HospitalManagement _schema`.Drug_Patints",
            joinColumns = @JoinColumn(name = "Patient_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "Drug_ID", referencedColumnName = "ID") )
    private List<Drug> drugs;


}
