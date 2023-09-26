package com.Fawry.Hospital;

import com.Fawry.Hospital.Entites.Hospital;
import com.Fawry.Hospital.Rep.HospitalRepository;
import com.Fawry.Hospital.Sevice.HospitalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class HospitalServiceTest {

    @Autowired
    private HospitalService hospitalService;

    @MockBean
    private HospitalRepository hospitalRepository;

    @BeforeEach
    public void setUp() {
        // Define behavior for hospitalRepository mocks
        Hospital hospital = new Hospital();
        hospital.setId(1);
        hospital.setName("Sample Hospital");



        when(hospitalRepository.findById(eq(1))).thenReturn(Optional.of(hospital));
        when(hospitalRepository.findById(eq(2))).thenReturn(Optional.empty());
    }
    @Test
    public void testUpdateHospital() {
        Hospital hospital = new Hospital();
        hospital.setId(1);
        hospital.setName("Updated Hospital");

        Hospital updatedHospital = hospitalService.updateHospital(hospital);



        // Assert that the returned hospital has the expected name
        assertEquals("Updated Hospital", updatedHospital.getName());
    }

}
