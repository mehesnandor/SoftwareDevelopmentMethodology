package hu.unideb.inf.idopontfoglalo.data.repository;

import hu.unideb.inf.idopontfoglalo.data.entity.FoglaltIdopontok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FoglaltIdopontokRepository extends JpaRepository<FoglaltIdopontok, Long> {


    List<FoglaltIdopontok> findByIdopontAfter(LocalDateTime nowAndAfter);
    List<FoglaltIdopontok> findByIdopontEquals(LocalDateTime now);
    List<FoglaltIdopontok> findByIdopontBefore(LocalDateTime before);
    List<FoglaltIdopontok> findByPhoneNumber(String phone);
    List<FoglaltIdopontok> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByIdopontEqualsAndEmailEquals(LocalDateTime now, String email);
    boolean existsByIdopontEquals(LocalDateTime now);
    boolean existsByIdopont(LocalDateTime now);

    void deleteByIdopontAfter(LocalDateTime nowAndAfter);
    void deleteByIdopontBefore(LocalDateTime expired);
    void deleteByIdopontEquals(LocalDateTime now);
    void deleteAllByPhoneNumber(String phoneNumber);
    void deleteByEmail(String email);

}
