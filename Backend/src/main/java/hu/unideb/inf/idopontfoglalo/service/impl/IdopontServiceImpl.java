package hu.unideb.inf.idopontfoglalo.service.impl;

import hu.unideb.inf.idopontfoglalo.data.entity.FoglaltIdopontok;
import hu.unideb.inf.idopontfoglalo.data.repository.FoglaltIdopontokRepository;
import hu.unideb.inf.idopontfoglalo.service.IdopontService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
@Slf4j
public class IdopontServiceImpl implements IdopontService {

    @Autowired
    private FoglaltIdopontokRepository foglaltIdopontokRepo;

    // ----------------- GET ---------------- //

    @Override
    public List<FoglaltIdopontok> getFoglaltIdopontok(){
        log.info("[Service] - List everything");
        return foglaltIdopontokRepo.findAll();
    }

    @Override
    public List<FoglaltIdopontok> getFoglaltIdopontokByBeforeDate(LocalDateTime date_filter){
        log.info("[Service] - List by beforeDate");
        return foglaltIdopontokRepo.findByIdopontBefore(date_filter);

    }

    @Override
    public List<FoglaltIdopontok> getFoglaltIdopontokByEquelDate(LocalDateTime date_filter){
        log.info("[Service] - List by date");
        return foglaltIdopontokRepo.findByIdopontEquals(date_filter);
    }

    @Override
    public List<FoglaltIdopontok> getFoglaltIdopontokByAfterDate(LocalDateTime date_filter){
        log.info("[Service] - List by afterDate");
        return foglaltIdopontokRepo.findByIdopontAfter(date_filter);
    }

    @Override
    public Optional<FoglaltIdopontok> getFoglaltIdopontokByID(Long id){
        log.info("[Service] - List by id");
        return foglaltIdopontokRepo.findById(id);
    }

    @Override
    public List<FoglaltIdopontok> getFoglaltIdopontokByEmail(String email){
        log.info("[Service] - List by email");
        return foglaltIdopontokRepo.findByEmail(email);
    }

    @Override
    public List<FoglaltIdopontok> getFoglaltIdopontokByPhone(String phone){
        log.info("[Service] - List by phone");
        return foglaltIdopontokRepo.findByPhoneNumber(phone);
    }

    // ---------------POST&PUT--------------- //

    @Override
    public void idopontFoglalas(FoglaltIdopontok idopont){

        if (foglaltIdopontokRepo.existsByIdopontEquals(idopont.getIdopont())) {
            log.info("[Service] - Appointment already exists");
            throw new ResponseStatusException(HttpStatus.FOUND, "FoglaltIdopont already exists");
        }

        log.info("[Service] - Making an Appointment");
        foglaltIdopontokRepo.save(idopont);
    }

    @Override
    public void userDataUpdate(FoglaltIdopontok idopont){
        log.info("[Service] - Update an Appointment");
        foglaltIdopontokRepo.save(idopont);
    }

    // ----------------DELETE---------------- //

    @Override
    public void deleteAll(){
        log.info("[Service] - Delete everything");
        foglaltIdopontokRepo.deleteAll();
    }

    @Override
    public void deleteByBeforeDate(LocalDateTime date){
        log.info("[Service] - Delete by beforeDate");
        foglaltIdopontokRepo.deleteByIdopontBefore(date);
    }

    @Override
    public void deleteByEquleDate(LocalDateTime date){
        log.info("[Service] - Delete by date");
        foglaltIdopontokRepo.deleteByIdopontEquals(date);
    }

    @Override
    public void deleteByAfterDate(LocalDateTime date){
        log.info("[Service] - Delete by afterDate");
        foglaltIdopontokRepo.deleteByIdopontAfter(date);
    }

    @Override
    public void deleteById(Long id){
        log.info("[Service] - Delete by id");
        foglaltIdopontokRepo.deleteById(id);
    }

    @Override
    public void deleteByEmail(String email){
        log.info("[Service] - Delete by email");
        foglaltIdopontokRepo.deleteByEmail(email);
    }

    @Override
    public void deleteByPhone(String phone){
        log.info("[Service] - Delete by phone");
        foglaltIdopontokRepo.deleteAllByPhoneNumber(phone);
    }

}
