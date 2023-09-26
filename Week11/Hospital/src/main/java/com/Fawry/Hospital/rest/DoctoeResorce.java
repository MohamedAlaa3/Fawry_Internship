package com.Fawry.Hospital.rest;

import com.Fawry.Hospital.Entites.Doctor;
import com.Fawry.Hospital.Sevice.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctoeResorce {
    @Autowired
    DoctorService doctorService;

    @GetMapping()
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

//find doctor by id
@GetMapping("/{id}")
public Optional<Doctor> getDoctor(@PathVariable ("id") int id){
        return doctorService.getDoctor(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteDoctor(@PathVariable ("id") int id){
        doctorService.deleteDoctor(id);
    }


    // Update doctor's name by id
    @PutMapping("/{id}/updateName")
    public Doctor updateDoctorName(@PathVariable("id") int id, @RequestBody String newName){
        return doctorService.UpdateDoctor(id, newName);
    }
    //Update doctor's name by id
//    @PutMapping("/{id}/updateHospital")
//    public Doctor updateDoctor(@PathVariable("id") int id, @RequestBody String ){
//
//        return doctorService.updateDoctor(doctor);
//    }

    //add new doctor
    @PostMapping("/add")
    public void addDoctor(@RequestBody Doctor doctor){
        doctorService.addDoctor(doctor);
    }

}
