package hu.unideb.inf.idopontfoglalo.service.impl;

import hu.unideb.inf.idopontfoglalo.data.entity.FoglaltIdopontok;
import hu.unideb.inf.idopontfoglalo.data.repository.FoglaltIdopontokRepository;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class IdopontServiceImplTest {

    @Mock
    private FoglaltIdopontokRepository foglaltIdopontokRepo;

    @InjectMocks
    private IdopontServiceImpl idopontService;

    @Test
    void getFoglaltIdopontok() {
        List<FoglaltIdopontok> mockAppointments = List.of(new FoglaltIdopontok(LocalDateTime.now(), "Nagy Szabolcs", "email@example.com", "06701234567"));
        when(foglaltIdopontokRepo.findAll()).thenReturn(mockAppointments);

        List<FoglaltIdopontok> result = idopontService.getFoglaltIdopontok();

        assertNotNull(result, "The list of appointments should not be null");
        assertTrue(true, "The result should be a List");
        assertEquals(mockAppointments.size(), result.size(), "The number of appointments returned should match the mock size");
        assertEquals(mockAppointments, result, "The returned appointments should match the mock appointments");

        verify(foglaltIdopontokRepo, times(1)).findAll();
        verifyNoMoreInteractions(foglaltIdopontokRepo);
    }

    @Test
    void getFoglaltIdopontokByBeforeDate() {
        LocalDateTime beforeDate = LocalDateTime.now().minusDays(1);
        List<FoglaltIdopontok> mockAppointments = List.of(
                new FoglaltIdopontok(beforeDate.minusDays(1), "Nagy Szabolcs", "email@example.com", "06701234567")
        );
        when(foglaltIdopontokRepo.findByIdopontBefore(beforeDate)).thenReturn(mockAppointments);

        List<FoglaltIdopontok> result = idopontService.getFoglaltIdopontokByBeforeDate(beforeDate);

        assertNotNull(result);
        assertEquals(mockAppointments.size(), result.size());
        assertEquals(mockAppointments, result);

        verify(foglaltIdopontokRepo, times(1)).findByIdopontBefore(beforeDate);
        verifyNoMoreInteractions(foglaltIdopontokRepo);
    }

    @Test
    void getFoglaltIdopontokByEqualDate() {
        LocalDateTime targetDate = LocalDateTime.now();
        List<FoglaltIdopontok> mockAppointments = List.of(
                new FoglaltIdopontok(targetDate, "Kovács Péter", "peter@example.com", "06707654321")
        );
        when(foglaltIdopontokRepo.findByIdopontEquals(targetDate)).thenReturn(mockAppointments);

        List<FoglaltIdopontok> result = idopontService.getFoglaltIdopontokByEqualDate(targetDate);

        assertNotNull(result);
        assertEquals(mockAppointments.size(), result.size());
        assertEquals(mockAppointments, result);

        verify(foglaltIdopontokRepo, times(1)).findByIdopontEquals(targetDate);
        verifyNoMoreInteractions(foglaltIdopontokRepo);
    }

    @Test
    void getFoglaltIdopontokByAfterDate() {
        LocalDateTime afterDate = LocalDateTime.now().plusDays(1);
        List<FoglaltIdopontok> mockAppointments = List.of(
                new FoglaltIdopontok(afterDate.plusDays(1), "Nagy Szabolcs", "email@example.com", "06701234567")
        );
        when(foglaltIdopontokRepo.findByIdopontAfter(afterDate)).thenReturn(mockAppointments);

        List<FoglaltIdopontok> result = idopontService.getFoglaltIdopontokByAfterDate(afterDate);

        assertNotNull(result);
        assertEquals(mockAppointments.size(), result.size());
        assertEquals(mockAppointments, result);

        verify(foglaltIdopontokRepo, times(1)).findByIdopontAfter(afterDate);
        verifyNoMoreInteractions(foglaltIdopontokRepo);
    }

    @Test
    void getFoglaltIdopontokByID() {
        Long appointmentId = 1L;
        FoglaltIdopontok mockAppointment = new FoglaltIdopontok(LocalDateTime.now(), "Nagy Szabolcs", "email@example.com", "06701234567");
        when(foglaltIdopontokRepo.findById(appointmentId)).thenReturn(Optional.of(mockAppointment));

        Optional<FoglaltIdopontok> result = idopontService.getFoglaltIdopontokByID(appointmentId);

        assertTrue(result.isPresent());
        assertEquals(mockAppointment, result.get());

        verify(foglaltIdopontokRepo, times(1)).findById(appointmentId);
        verifyNoMoreInteractions(foglaltIdopontokRepo);
    }

    @Test
    void getFoglaltIdopontokByEmail() {
        String email = "email@example.com";
        List<FoglaltIdopontok> mockAppointments = List.of(
                new FoglaltIdopontok(LocalDateTime.now(), "Nagy Szabolcs", email, "06701234567")
        );
        when(foglaltIdopontokRepo.findByEmail(email)).thenReturn(mockAppointments);

        List<FoglaltIdopontok> result = idopontService.getFoglaltIdopontokByEmail(email);

        assertNotNull(result);
        assertEquals(mockAppointments.size(), result.size());
        assertEquals(mockAppointments, result);

        verify(foglaltIdopontokRepo, times(1)).findByEmail(email);
        verifyNoMoreInteractions(foglaltIdopontokRepo);
    }

    @Test
    void getFoglaltIdopontokByPhone() {
        String phone = "06701234567";
        List<FoglaltIdopontok> mockAppointments = List.of(
                new FoglaltIdopontok(LocalDateTime.now(), "Nagy Szabolcs", "email@example.com", phone)
        );
        when(foglaltIdopontokRepo.findByPhoneNumber(phone)).thenReturn(mockAppointments);

        List<FoglaltIdopontok> result = idopontService.getFoglaltIdopontokByPhone(phone);

        assertNotNull(result);
        assertEquals(mockAppointments.size(), result.size());
        assertEquals(mockAppointments, result);

        verify(foglaltIdopontokRepo, times(1)).findByPhoneNumber(phone);
        verifyNoMoreInteractions(foglaltIdopontokRepo);
    }

    @Test
    void idopontFoglalas() {
        FoglaltIdopontok mockAppointment = new FoglaltIdopontok(LocalDateTime.now(), "Nagy Szabolcs", "email@example.com", "06701234567");
        when(foglaltIdopontokRepo.existsByIdopontEquals(mockAppointment.getIdopont())).thenReturn(false);

        idopontService.idopontFoglalas(mockAppointment);

        verify(foglaltIdopontokRepo, times(1)).save(mockAppointment);
        verifyNoMoreInteractions(foglaltIdopontokRepo);
    }

    @Test
    void userDataUpdate() {
        FoglaltIdopontok updatedAppointment = new FoglaltIdopontok(LocalDateTime.now(), "Nagy Szabolcs", "updated@example.com", "06701234567");
        when(foglaltIdopontokRepo.save(updatedAppointment)).thenReturn(updatedAppointment);

        idopontService.userDataUpdate(updatedAppointment);

        verify(foglaltIdopontokRepo, times(1)).save(updatedAppointment);
        verifyNoMoreInteractions(foglaltIdopontokRepo);
    }

    @Test
    void deleteAll() {
        idopontService.deleteAll();

        verify(foglaltIdopontokRepo, times(1)).deleteAll();
        verifyNoMoreInteractions(foglaltIdopontokRepo);
    }

    @Test
    void deleteByBeforeDate() {
        LocalDateTime beforeDate = LocalDateTime.now().minusDays(1);

        idopontService.deleteByBeforeDate(beforeDate);

        verify(foglaltIdopontokRepo, times(1)).deleteByIdopontBefore(beforeDate);
        verifyNoMoreInteractions(foglaltIdopontokRepo);
    }

    @Test
    void deleteByEqualDate() {
        LocalDateTime targetDate = LocalDateTime.now();

        idopontService.deleteByEqualDate(targetDate);

        verify(foglaltIdopontokRepo, times(1)).deleteByIdopontEquals(targetDate);
        verifyNoMoreInteractions(foglaltIdopontokRepo);
    }

    @Test
    void deleteByAfterDate() {
        LocalDateTime afterDate = LocalDateTime.now().plusDays(1);

        idopontService.deleteByAfterDate(afterDate);

        verify(foglaltIdopontokRepo, times(1)).deleteByIdopontAfter(afterDate);
        verifyNoMoreInteractions(foglaltIdopontokRepo);
    }

    @Test
    void deleteById() {
        Long appointmentId = 1L;

        idopontService.deleteById(appointmentId);

        verify(foglaltIdopontokRepo, times(1)).deleteById(appointmentId);
        verifyNoMoreInteractions(foglaltIdopontokRepo);
    }

    @Test
    void deleteByEmail() {
        String email = "email@example.com";

        idopontService.deleteByEmail(email);

        verify(foglaltIdopontokRepo, times(1)).deleteByEmail(email);
        verifyNoMoreInteractions(foglaltIdopontokRepo);
    }

    @Test
    void deleteByPhone() {
        String phone = "06701234567";

        idopontService.deleteByPhone(phone);

        verify(foglaltIdopontokRepo, times(1)).deleteAllByPhoneNumber(phone);
        verifyNoMoreInteractions(foglaltIdopontokRepo);
    }

    @Test
    void idopontFoglalasWithNullAppointment() {
        assertThrows(NullPointerException.class, () -> idopontService.idopontFoglalas(null));
    }

    @Test
    void getFoglaltIdopontokEmptyResult() {
        when(foglaltIdopontokRepo.findAll()).thenReturn(Collections.emptyList());
        List<FoglaltIdopontok> result = idopontService.getFoglaltIdopontok();
        assertTrue(result.isEmpty());
    }
}