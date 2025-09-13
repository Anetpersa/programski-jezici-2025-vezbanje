package rs.ac.singidunum.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "customer")
@NoArgsConstructor
@Getter
@Setter
public class Projection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projection_id", nullable = false)
    private Integer id;

    @Column(name = "movie_id", nullable = false)
    private Integer movieId;

    @Column(nullable = false)
    private LocalDateTime time;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @JsonIgnore
    private LocalDateTime deletedAt;
}
