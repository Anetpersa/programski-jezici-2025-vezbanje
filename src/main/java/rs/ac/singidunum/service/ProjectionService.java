package rs.ac.singidunum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.entity.Customer;
import rs.ac.singidunum.entity.Projection;
import rs.ac.singidunum.repo.CustomerRepository;
import rs.ac.singidunum.repo.ProjectionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectionService {

    private final ProjectionRepository repository;

    public List<Projection> getProjections() {
        return repository.findAllByDeletedAtIsNull();
    }

    public List<Projection> futureProjections() {
        return repository.findAllByTimeAfterAndDeletedAtIsNull(LocalDateTime.now());
    }

    public Optional<Projection> getProjectionById(Integer id) {
        return repository.findByIdAndDeletedAtIsNull(id);
    }

    public Projection createProjection(Projection model) {
        Projection projection = new Projection();
        projection.setTime(model.getTime());
        projection.setMovieId(model.getMovieId());
        projection.setCreatedAt(LocalDateTime.now());
        return repository.save(projection);
    }

    public Projection updateProjection(Integer id, Projection model) {
        Projection projection = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();

        projection.setTime(model.getTime());
        projection.setMovieId(model.getMovieId());
        projection.setCreatedAt(LocalDateTime.now());
        return repository.save(projection);
    }

    public void deleteProjection(Integer id) {
        Projection projection = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        projection.setDeletedAt(LocalDateTime.now());
        repository.save(projection);
    }
}
