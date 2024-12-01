package hu.unideb.inf.idopontfoglalo.data.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "idopontok")

public class FoglaltIdopontok {

    @Valid
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @FutureOrPresent
    @Column(nullable = false, name = "idopont", updatable = false)
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

    @Column(name = "telefonszam", unique = true)
    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Invalid phone number format")
    private String phoneNumber;

    public FoglaltIdopontok(LocalDateTime idopont, String nev, String email, String phoneNumber) {
        this.idopont = idopont;
        this.nev = nev;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
