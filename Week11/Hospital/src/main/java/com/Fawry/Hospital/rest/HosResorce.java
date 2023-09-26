package com.Fawry.Hospital.rest;

import com.Fawry.Hospital.Entites.Doctor;
import com.Fawry.Hospital.Entites.Hospital;
import com.Fawry.Hospital.Rep.HospitalRepository;
import com.Fawry.Hospital.Sevice.HospitalService;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospital")
public class HosResorce {
    @Autowired
    HospitalService hospitalService;

    @GetMapping()
    public Iterable<Hospital> getAllHospitals(){
        return hospitalService.getAllHospitals();
    }


    @GetMapping("/{id}")
    public Hospital getHospital(@PathVariable("id") int id){
        return hospitalService.getHospital(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteHospital(@PathVariable("id") int id){
        hospitalService.deleteHospital(id);
    }

    @PutMapping("/updateName/{id}")
    public Hospital updateHospital(@PathVariable("id") int id, @RequestBody String name){
        return hospitalService.updateHospitaNamel(id, name);
    }
    //add
    @PostMapping("/add")
    public void addHospital(@RequestBody Hospital hospital){
        hospitalService.addHospital(hospital);
    }


}
