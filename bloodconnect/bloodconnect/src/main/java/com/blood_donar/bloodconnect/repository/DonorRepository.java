
package com.blood_donar.bloodconnect.repository;

import com.blood_donar.bloodconnect.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonorRepository extends JpaRepository<Donor, Long> {

    List<Donor> findByBloodGroupAndCityIgnoreCaseAndAvailabilityTrue(
            String bloodGroup,
            String city
    );
}
