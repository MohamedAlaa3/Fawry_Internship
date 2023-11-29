package org.example;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "`HospitalManagement _schema`.Drug")
@Entity
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "Name")
    private String Name;

    @ManyToMany(mappedBy = "drugs", fetch = FetchType.EAGER)
    private List<Patient> patients;



}
