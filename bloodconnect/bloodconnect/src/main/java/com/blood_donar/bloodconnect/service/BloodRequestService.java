
package com.blood_donar.bloodconnect.service;

import com.blood_donar.bloodconnect.model.BloodRequest;
import com.blood_donar.bloodconnect.repository.BloodRequestRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BloodRequestService {

    private final BloodRequestRepository requestRepository;

    public BloodRequestService(BloodRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public BloodRequest createRequest(BloodRequest request) {
        return requestRepository.save(request);
    }

    public List<BloodRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    public BloodRequest getRequestById(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Blood request not found"));
    }

    public BloodRequest updateRequest(Long id, BloodRequest updatedRequest) {
        BloodRequest request = getRequestById(id);

        request.setPatientName(updatedRequest.getPatientName());
        request.setBloodGroup(updatedRequest.getBloodGroup());
        request.setRequiredUnits(updatedRequest.getRequiredUnits());
        request.setHospitalName(updatedRequest.getHospitalName());
        request.setLocation(updatedRequest.getLocation());
        request.setRequiredDate(updatedRequest.getRequiredDate());
        request.setContactNumber(updatedRequest.getContactNumber());
        request.setRequestStatus(updatedRequest.getRequestStatus());

        return requestRepository.save(request);
    }

    public void deleteRequest(Long id) {
        requestRepository.delete(getRequestById(id));
    }
}
