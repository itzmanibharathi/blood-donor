
package com.blood_donar.bloodconnect.repository;

import com.blood_donar.bloodconnect.model.BloodRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodRequestRepository
        extends JpaRepository<BloodRequest, Long> {
}
