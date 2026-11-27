
package com.blood_donar.bloodconnect.controller;

import com.blood_donar.bloodconnect.model.BloodRequest;
import com.blood_donar.bloodconnect.model.Donor;
import com.blood_donar.bloodconnect.service.BloodRequestService;
import com.blood_donar.bloodconnect.service.DonorService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin
public class BloodRequestController {

    private final BloodRequestService requestService;
    private final DonorService donorService;

    public BloodRequestController(
            BloodRequestService requestService,
            DonorService donorService) {
        this.requestService = requestService;
        this.donorService = donorService;
    }

    @PostMapping
    public BloodRequest createRequest(@RequestBody BloodRequest request) {
        return requestService.createRequest(request);
    }

    @GetMapping
    public List<BloodRequest> getAllRequests() {
        return requestService.getAllRequests();
    }

    @GetMapping("/{id}")
    public BloodRequest getRequest(@PathVariable Long id) {
        return requestService.getRequestById(id);
    }

    @PutMapping("/{id}")
    public BloodRequest updateRequest(
            @PathVariable Long id,
            @RequestBody BloodRequest request) {
        return requestService.updateRequest(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteRequest(@PathVariable Long id) {
        requestService.deleteRequest(id);
        return "Blood request deleted successfully";
    }

    @GetMapping("/{id}/donors")
    public List<Donor> findDonors(@PathVariable Long id) {

        BloodRequest request = requestService.getRequestById(id);

        return donorService.findPotentialDonors(
                request.getBloodGroup(),
                request.getLocation()
        );
    }
}
