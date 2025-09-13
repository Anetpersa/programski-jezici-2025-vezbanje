package rs.ac.singidunum.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Projection;
import rs.ac.singidunum.service.ProjectionService;

import java.util.List;

@Data
@RestController
@RequestMapping(path = "/api/customer")
@CrossOrigin
@RequiredArgsConstructor
public class ProjectionController {

    private final ProjectionService service;

    @GetMapping
    public List<Projection> getProjections() {
        return service.getProjections();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Projection> getCustomerById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getProjectionById(id));
    }

    @PostMapping
    public Projection savedCustomer(@RequestBody Projection model) {

        return service.createProjection(model);
    }

    @PutMapping(path = "/{id}")
    public Projection updateProjection(@PathVariable Integer id, @RequestBody Projection model) {

        return service.updateProjection(id, model);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProjection(@PathVariable Integer id) {
        service.deleteProjection(id);
    }
}
