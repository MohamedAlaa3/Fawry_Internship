package com.Fawry.Hospital;

import com.Fawry.Hospital.Entites.Doctor;
import com.Fawry.Hospital.Entites.Hospital;
import com.Fawry.Hospital.Rep.DoctorRepository;
import com.Fawry.Hospital.Sevice.DoctorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest

public class DoctorServiceTest {
    private DoctorService doctorService = new DoctorService();
    private DoctorRepository doctorRepository = mock(DoctorRepository.class);
    //Tsting the Doctor Service
    @Test
    void TstFindAllDoctors() {
        //Arrange

        //Act
        //Assert


    }
    @Test
    public void testGetAllDoctors() {
        List<Doctor> doctorList = new ArrayList<>();
        Doctor doctor1 = new Doctor();
        doctor1.setName("Ahmed");
        Hospital hospital1 = new Hospital();
        hospital1.setName("El Salam");
        doctor1.setHospital(hospital1);
        doctorRepository.save(doctor1);
        doctorList.add(doctor1);


        when(doctorRepository.findAll()).thenReturn(doctorList);

        List<Doctor> retrievedDoctors = doctorService.getAllDoctors();

        assertNotNull(retrievedDoctors);
        assertEquals(doctorList, retrievedDoctors);
    }
}
