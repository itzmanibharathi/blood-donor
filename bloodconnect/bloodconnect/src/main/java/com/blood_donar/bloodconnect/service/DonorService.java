
package com.blood_donar.bloodconnect.service;

import com.blood_donar.bloodconnect.model.Donor;
import com.blood_donar.bloodconnect.repository.DonorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorService {

    private final DonorRepository donorRepository;

    public DonorService(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    public Donor addDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public Donor getDonorById(Long id) {
        return donorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donor not found"));
    }

    public Donor updateDonor(Long id, Donor updatedDonor) {
        Donor donor = getDonorById(id);

        donor.setDonorName(updatedDonor.getDonorName());
        donor.setAge(updatedDonor.getAge());
        donor.setGender(updatedDonor.getGender());
        donor.setBloodGroup(updatedDonor.getBloodGroup());
        donor.setPhoneNumber(updatedDonor.getPhoneNumber());
        donor.setEmail(updatedDonor.getEmail());
        donor.setCity(updatedDonor.getCity());
        donor.setArea(updatedDonor.getArea());
        donor.setLastDonationDate(updatedDonor.getLastDonationDate());
        donor.setAvailability(updatedDonor.getAvailability());

        return donorRepository.save(donor);
    }

    public void deleteDonor(Long id) {
        donorRepository.delete(getDonorById(id));
    }

    public List<Donor> findPotentialDonors(String bloodGroup, String city) {
        return donorRepository
                .findByBloodGroupAndCityIgnoreCaseAndAvailabilityTrue(
                        bloodGroup, city
                );
    }
}
