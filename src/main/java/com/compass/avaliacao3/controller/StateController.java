package com.compass.avaliacao3.controller;

import com.compass.avaliacao3.controller.dto.StateDto;
import com.compass.avaliacao3.model.State;
import com.compass.avaliacao3.controller.form.StateForm;
import com.compass.avaliacao3.controller.form.UpdateStateForm;
import com.compass.avaliacao3.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @GetMapping
    public Page<StateDto> list(@RequestParam(required = false) String region, @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable pageable) {
        if (region != null) return StateDto.convert(stateRepository.findByRegionContains(region, pageable));
        return StateDto.convert(stateRepository.findAll(pageable));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<StateDto> create(@RequestBody @Valid StateForm form, UriComponentsBuilder uriBuilder) {
        State state = form.convert();
        stateRepository.save(state);

        URI uri = uriBuilder.path("/states/{id}").buildAndExpand(state.getId()).toUri();
        return ResponseEntity.created(uri).body(new StateDto(state));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateDto> detail(@PathVariable Long id) {
        Optional<State> state = stateRepository.findById(id);
        return state.map(value -> ResponseEntity.ok(new StateDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<StateDto> update(@PathVariable Long id, @RequestBody @Valid UpdateStateForm form) {
        Optional<State> optional = stateRepository.findById(id);

        if (optional.isPresent()) {
            State state = form.update(id, stateRepository);
            return ResponseEntity.ok(new StateDto(state));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remove(@PathVariable Long id) {
        Optional<State> optional = stateRepository.findById(id);
        if (optional.isPresent()) {
            stateRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
