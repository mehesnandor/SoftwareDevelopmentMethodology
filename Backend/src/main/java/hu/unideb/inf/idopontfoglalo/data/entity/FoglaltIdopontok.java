package hu.unideb.inf.idopontfoglalo.data.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "idopontok")

public class FoglaltIdopontok {

    @Valid
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @FutureOrPresent
    @Column(nullable = false, name = "idopont", updatable = false, unique = true)
    private LocalDateTime idopont;

    @NotBlank( message = "You didn't gave a valid Kliens_Name")
    @Size(min = 2, max = 200)
    @Column(nullable = false, name = "nev")
    private String nev;

    @NotBlank( message = "You didn't gave a valid Kliens_Email")
    @Email
    @Size(min = 5, max = 150)
    @Column(nullable = false, name = "email")
    private String email;

    @Column(name = "telefonszam")
    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Invalid phone number format")
    private String phoneNumber;

    public FoglaltIdopontok(LocalDateTime idopont, String nev, String email, String phoneNumber) {
        this.idopont = idopont;
        this.nev = nev;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public FoglaltIdopontok(){

    }

    public @NotNull @FutureOrPresent LocalDateTime getIdopont() {
        return idopont;
    }

    public void setId(@Valid Long id) {
        this.id = id;
    }

    public void setIdopont(@NotNull @FutureOrPresent LocalDateTime idopont) {
        this.idopont = idopont;
    }

    public void setNev(@NotBlank(message = "You didn't gave a valid Kliens_Name") @Size(min = 2, max = 200) String nev) {
        this.nev = nev;
    }

    public void setEmail(@NotBlank(message = "You didn't gave a valid Kliens_Email") @Email @Size(min = 5, max = 150) String email) {
        this.email = email;
    }

    public void setPhoneNumber(@Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Invalid phone number format") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @Valid Long getId() {
        return id;
    }

    public @NotBlank(message = "You didn't gave a valid Kliens_Name") @Size(min = 2, max = 200) String getNev() {
        return nev;
    }

    public @NotBlank(message = "You didn't gave a valid Kliens_Email") @Email @Size(min = 5, max = 150) String getEmail() {
        return email;
    }

    public @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Invalid phone number format") String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "FoglaltIdopontok{" +
                "id=" + id +
                ", idopont=" + idopont +
                ", nev='" + nev + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
