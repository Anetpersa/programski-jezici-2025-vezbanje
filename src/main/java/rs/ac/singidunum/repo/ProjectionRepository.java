package rs.ac.singidunum.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.entity.Projection;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectionRepository extends JpaRepository<Projection, Integer> {

    List<Projection> findAllByDeletedAtIsNull();

    Optional<Projection> findByIdAndDeletedAtIsNull(Integer id);

    List<Projection> findAllByTimeAfterAndDeletedAtIsNull(LocalDateTime time);
}
