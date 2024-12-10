package hu.unideb.inf.idopontfoglalo.service;

import hu.unideb.inf.idopontfoglalo.data.entity.FoglaltIdopontok;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IdopontService {

    List<FoglaltIdopontok> getFoglaltIdopontok();

    List<FoglaltIdopontok> getFoglaltIdopontokByBeforeDate(LocalDateTime date_filter);

    List<FoglaltIdopontok> getFoglaltIdopontokByEqualDate(LocalDateTime date_filter);

    List<FoglaltIdopontok> getFoglaltIdopontokByAfterDate(LocalDateTime date_filter);

    Optional<FoglaltIdopontok> getFoglaltIdopontokByID(Long id);

    List<FoglaltIdopontok> getFoglaltIdopontokByEmail(String email);

    List<FoglaltIdopontok> getFoglaltIdopontokByPhone(String phone);

    // ---------------POST&PUT--------------- //

    void idopontFoglalas(FoglaltIdopontok idopont);

    void userDataUpdate(FoglaltIdopontok foglaltIdopontok);

    // ----------------DELETE---------------- //

    void deleteAll();

    void deleteByBeforeDate(LocalDateTime date);

    void deleteByEqualDate(LocalDateTime date);

    void deleteByAfterDate(LocalDateTime date);

    void deleteById(Long id);

    void deleteByEmail(String email);

    void deleteByPhone(String phone);

}