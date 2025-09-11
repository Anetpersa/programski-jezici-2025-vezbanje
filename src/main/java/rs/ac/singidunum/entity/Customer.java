package rs.ac.singidunum.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    //koristimo wrapper klase da pomognemo Hibernatu da brze i lakse binduje objekte.
    //posto koristimo drugacije ime nego sto je u bazi, moramo da naglasimo to (sa @column) i generated value se podesava
    //da Spring zna da ce baza sama menadzovati ovu vrednost
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    //ako pisemo cammel case, automatski ce znati da mapira u first_name, a mozemo staviti i sa donjom crticom
    //Spring boot moze i sam da izgenerise bazu pri prvom pokretanju ako je vec nema i zato je na primer vazna ova anotacija ispod
    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String umcn;

    @Column(nullable = false, name = "tax_id")
    private String taxId;

    //Date je stari nacin iz Jave 8, a temporal (Java time) je novi nacin i tu imamo local datetime paket.
    // //To je zgodno jer baza uvek vraca podatak bez vremenske zone i posle ga konvertujemo u zoned datetime na osnovu zone klijenta
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(nullable = false, name = "deleted_at")
    private LocalDateTime deletedAt;
}
