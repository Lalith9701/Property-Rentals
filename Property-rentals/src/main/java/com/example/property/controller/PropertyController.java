package com.example.property.controller;


import com.example.property.model.Property;
import com.example.property.repo.PropertyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/properties")
@CrossOrigin
public class PropertyController {


private final PropertyRepository repo;


public PropertyController(PropertyRepository repo) {
this.repo = repo;
}


@GetMapping
public List<Property> all() {
return repo.findAll();
}


@GetMapping("/{id}")
public ResponseEntity<Property> get(@PathVariable Long id) {
return repo.findById(id)
.map(ResponseEntity::ok)
.orElse(ResponseEntity.notFound().build());
}


@PostMapping
public Property create(@RequestBody Property p) {
return repo.save(p);
}


@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
if (repo.existsById(id)) {
repo.deleteById(id);
return ResponseEntity.noContent().build();
}
return ResponseEntity.notFound().build();
}
}