package hu.unideb.inf.idopontfoglalo.controller;

import hu.unideb.inf.idopontfoglalo.data.entity.FoglaltIdopontok;
import hu.unideb.inf.idopontfoglalo.service.IdopontService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Data
@RequestMapping("/api/v1")
public class IdopontController {

    private static final Logger log = LoggerFactory.getLogger(IdopontController.class);

    private final IdopontService idopontService;

    public IdopontController(IdopontService idopontService) {
        this.idopontService = idopontService;
    }

    /**
     * Időpont foglalását teszi lehetővé
     * */

    @PostMapping("/add")
    public void foglalas(@RequestBody FoglaltIdopontok foglaltIdopontok) {
        log.info("[Controller] - Foglalás (" + foglaltIdopontok + ") adatokkal");
        idopontService.idopontFoglalas(foglaltIdopontok);
    }

    // -----

    /**
     * Listázza az összes foglalást
     * */

    @GetMapping(path = "/list/all")
    public List<FoglaltIdopontok> getFoglaltIdopontok() {
        return idopontService.getFoglaltIdopontok();
    }

    /**
     * Listázzása a "date" elött
     * */

    @GetMapping(path = "/list/before")
    public List<FoglaltIdopontok> getFoglaltIdopontokByBeforeDate(@RequestParam LocalDateTime date_filter) {
        log.info("[Controller] - Listázzása (" + date_filter + ") elött");
        return idopontService.getFoglaltIdopontokByBeforeDate(date_filter);
    }

    /**
     * Listázzása a "date" -nek
     * */

    @GetMapping(path = "/list/equel")
    public List<FoglaltIdopontok> getFoglaltIdopontokByEqualDate(@RequestParam LocalDateTime date_filter) {
        log.info("[Controller] - Listázzása (" + date_filter + ") -nek");
        return idopontService.getFoglaltIdopontokByEqualDate(date_filter);
    }

    /**
     * Listázzása a "date" után
     * */

    @GetMapping(path = "/list/after")
    public List<FoglaltIdopontok> getFoglaltIdopontokByAfterDate(@RequestParam LocalDateTime date_filter) {
        log.info("[Controller] - Listázzása (" + date_filter + ") után");
        return idopontService.getFoglaltIdopontokByAfterDate(date_filter);
    }

    /**
     * Listázzás id alapján
     * */

    @GetMapping(path = "/list/{id}")
    public Optional<FoglaltIdopontok> getFoglaltIdopontokByID(@PathVariable("id") Long id) {
        log.info("[Controller] - Listázzás id alapján (" + id + ")");
        return idopontService.getFoglaltIdopontokByID(id);
    }

    /**
     * Listázzás email alapján
     * */

    @GetMapping(path = "/list")
    public List<FoglaltIdopontok> getFoglaltIdopontokByEmail(@RequestParam(required = false) String email,@RequestParam(required = false) String phone) {

        if (email != null && phone == null) {
            log.info("[Controller] - Listázzás email alapján (" + email + ")");
            return idopontService.getFoglaltIdopontokByEmail(email);
        }
        if (phone != null && email == null) {
            log.info("[Controller] - Törlés telefonszám alapján");
            return idopontService.getFoglaltIdopontokByPhone(phone);
        }

        log.error("[Controller] - Nem adott meg sem email-t sem phone-t vagy mind kettőt adta meg");
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Adj meg eggyet csak is eggyet: email vagy phone");

    }

    // -----

    /**
     * Frissiti a kliens adatait
     * */

    @PutMapping(path = "/update")
    public void userDataUpdate(@RequestBody FoglaltIdopontok foglaltIdopontok) {
        log.info("[Controller] - Frissitése a kliens adatainak");
        idopontService.userDataUpdate(foglaltIdopontok);
    }

    // -----

    /**
     * Törlöl minden adatot
     * */

    @DeleteMapping(path = "/delete/all")
    public void deleteAll() {
        idopontService.deleteAll();
    }

    /**
     * Törli a "date" elötti foglalásokat
     * */

    @DeleteMapping(path = "/delete/date/before")
    public void deleteByBeforeDate(@RequestParam("beforeDate") LocalDateTime date) {
        log.info("[Controller] - Törlése az (" + date + ") dátum elötti foglalásnak");
        idopontService.deleteByBeforeDate(date);
    }

    /**
     * Törli a "date" - el megeggyező foglalást
     * */

    @DeleteMapping(path = "/delete/date")
    public void deleteByEqualDate(@RequestParam("date") LocalDateTime date) {
        log.info("[Controller] - Törlése az (" + date + ") dátummal rendelkező foglalásnak");
        idopontService.deleteByEqualDate(date);
    }

    /**
     * Törli a "date" utánni foglalásokat
     * */

    @DeleteMapping(path = "/delete/date/after")
    public void deleteByAfterDate(@RequestParam("afterDate") LocalDateTime date) {
        log.info("[Controller] - Törlése az (" + date + ") dátum utánni foglalásnak");
        idopontService.deleteByAfterDate(date);
    }

    /**
     * Törli a foglalást ID alapján
     * */

    @DeleteMapping(path = "/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        log.info("[Controller] - Törlése az (" + id + ") ID-val rendelkező foglalásnak");
        idopontService.deleteById(id);
    }

    /**
     * Törli a foglalást email vagy phone alapján
     * */

    @DeleteMapping(path = "/delete")
    public void deleteByEmail(@RequestParam(required = false) String email, @RequestParam(required = false) String phone) {
        if (email != null) {
            log.info("[Controller] - Törlés email alapján");
            idopontService.deleteByEmail(email);
        }
        if (phone != null) {
            log.info("[Controller] - Törlés telefonszám alapján");
            idopontService.deleteByPhone(phone);
        }

        if (email == null && phone == null) {
            log.error("[Controller] - Nem adott meg sem email-t sem phone-t");
        }
    }

    // -----

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex){

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(
                (error) -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMassage = error.getDefaultMessage();
                    errors.put(fieldName, errorMassage);
                }
        );

        return errors;
    }
}
