package com.Fawry.Hospital.Sevice;

import com.Fawry.Hospital.Entites.Doctor;
import com.Fawry.Hospital.Rep.HospitalRepository;
import com.Fawry.Hospital.Rep.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    private HospitalRepository hospitalRepository;

    public void addDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }

    public void deleteDoctor(int id){
        doctorRepository.deleteById(id);
    }
    public Doctor updateDoctor(Doctor doctor){
        doctorRepository.save(doctor);
        return doctor;
    }
    public Optional<Doctor> getDoctor(int id){
         return doctorRepository.findById(id);
    }
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor UpdateDoctor(int id, String newName) {
        Optional<Doctor> optionalDoctor = getDoctor(id);
        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            doctor.setName(newName); // Update the name
            return doctorRepository.save(doctor);
        }
        else {
            return null;
        }
    }
    //update doctor's hospital
//    public Doctor updateDoctor(int id, int newHospital){
//        Optional<Doctor> optionalDoctor = getDoctor(id);
//        if (optionalDoctor.isPresent()) {
//            Doctor doctor = optionalDoctor.get();
//            doctor.setHospital(); // Update the name
//            return doctorRepository.save(doctor);
//        }
//        else {
//            return null;
//        }
//    }


}
