package hu.unideb.inf.idopontfoglalo.service;


import hu.unideb.inf.idopontfoglalo.data.entity.FoglaltIdopontok;
import hu.unideb.inf.idopontfoglalo.data.repository.FoglaltIdopontokRepository;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@EnableScheduling
@Data
public class ScheduleTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduleTasks.class);

    private final FoglaltIdopontokRepository repo;

    public ScheduleTasks(FoglaltIdopontokRepository repo) {
        this.repo = repo;
    }

    /**
     * Naponta törli a lejárt kurzusokat az adatbázisból
     * */

    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteExpiredAppointments(){

        log.info("[ScheduleTasks] Deleting Expired Appointments");

        List<FoglaltIdopontok> expireDates = repo.findByIdopontBefore(LocalDateTime.now());

        log.info("[ScheduleTasks] Found Expired Appointments: {}", expireDates);

        repo.deleteAll(expireDates);

        log.info("[ScheduleTasks] Deleted Expired Appointments");

    }

}
