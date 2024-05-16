package com.edanur.service;

import com.edanur.core.exception.DuplicationException;
import com.edanur.core.exception.NotFoundException;
import com.edanur.core.mapper.DoctorMapper;
import com.edanur.core.utilities.Message;
import com.edanur.dto.request.DoctorRequest;
import com.edanur.dto.response.DoctorResponse;
import com.edanur.entity.Doctor;
import com.edanur.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public List<DoctorResponse> findAll() {
        return doctorMapper.asOutput(doctorRepository.findAll());
    }

    public DoctorResponse getById(Long id) {
        return doctorMapper.asOutput(doctorRepository.findById(id).orElseThrow(() ->
                new NotFoundException(Message.NOT_FOUND + " Doctor with id " + id + " not found!")));
    }

    public DoctorResponse create(DoctorRequest request) {
        Optional<Doctor> isDoctorExist = doctorRepository.findByMail(request.getMail());
        if (isDoctorExist.isEmpty()) {
            Doctor doctorSaved = doctorRepository.save(doctorMapper.asEntity(request));
            return doctorMapper.asOutput(doctorSaved);
        }
        throw new DuplicationException(Message.ALREADY_EXIST + " This doctor has already been registered in the system!");
    }

    public DoctorResponse update(Long id, DoctorRequest request) {
        Optional<Doctor> doctorFromDb = doctorRepository.findById(id);
        Optional<Doctor> isDoctorExist = doctorRepository.findByMail(request.getMail());
        if (doctorFromDb.isEmpty()) {
            throw new NotFoundException(Message.NOT_FOUND + " The doctor with the ID " + id + " that you are trying to update could not be found in the system!");
        }
        if (isDoctorExist.isPresent()) {
            throw new DuplicationException(Message.ALREADY_EXIST + " This email has already been registered in the system.");
        }
        Doctor doctor = doctorFromDb.get();
        doctorMapper.update(doctor, request);
        return doctorMapper.asOutput((doctorRepository.save(doctor)));
    }

    public void deleteById(Long id) {
        Optional<Doctor> doctorFromDb = doctorRepository.findById(id);
        if (doctorFromDb.isPresent()) {
            doctorRepository.delete(doctorFromDb.get());
        } else {
            throw new NotFoundException(Message.NOT_FOUND + " The doctor with the ID " + id + " could not be found in the system!");
        }
    }
}


