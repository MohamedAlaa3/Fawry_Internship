package com.Fawry.Hospital.Sevice;

import com.Fawry.Hospital.Entites.Hospital;
import com.Fawry.Hospital.Rep.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {
    @Autowired
    HospitalRepository hospitalRepository;

//get all hospitals
public List<Hospital> getAllHospitals(){
    return hospitalRepository.findAll();
}

//get hospital by id
public Hospital getHospital(int id){
    return hospitalRepository.findById(id).orElse(null);
}

//add new hospital
public Hospital addHospital(Hospital hospital) {
   return hospitalRepository.save(hospital);
}
//delete hospital
public void deleteHospital(int id) {
     hospitalRepository.deleteById(id);
}
//update hospital
public Hospital updateHospital(Hospital hospital) {
    return hospitalRepository.save(hospital);
}

    public Hospital updateHospitaNamel(int id, String name) {
        Hospital hospital = hospitalRepository.findById(id).orElse(null);
        hospital.setName(name);
        return hospitalRepository.save(hospital);
    }
//get hospital by id



}
