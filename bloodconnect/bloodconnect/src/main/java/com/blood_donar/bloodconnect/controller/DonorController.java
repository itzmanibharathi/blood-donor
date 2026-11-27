
package com.blood_donar.bloodconnect.controller;

import com.blood_donar.bloodconnect.model.Donor;
import com.blood_donar.bloodconnect.service.DonorService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/donors")
@CrossOrigin
public class DonorController {

    private final DonorService donorService;

    public DonorController(DonorService donorService) {
        this.donorService = donorService;
    }

    @PostMapping
    public Donor addDonor(@RequestBody Donor donor) {
        return donorService.addDonor(donor);
    }

    @GetMapping
    public List<Donor> getAllDonors() {
        return donorService.getAllDonors();
    }

    @GetMapping("/{id}")
    public Donor getDonor(@PathVariable Long id) {
        return donorService.getDonorById(id);
    }

    @PutMapping("/{id}")
    public Donor updateDonor(
            @PathVariable Long id,
            @RequestBody Donor donor) {
        return donorService.updateDonor(id, donor);
    }

    @DeleteMapping("/{id}")
    public String deleteDonor(@PathVariable Long id) {
        donorService.deleteDonor(id);
        return "Donor deleted successfully";
    }

    @GetMapping("/search")
    public List<Donor> searchDonors(
            @RequestParam String bloodGroup,
            @RequestParam String city) {
        return donorService.findPotentialDonors(bloodGroup, city);
    }
}
