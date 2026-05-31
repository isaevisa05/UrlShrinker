package ru.isaevisa05.urlshrinker.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isaevisa05.urlshrinker.dto.AddRequest;
import ru.isaevisa05.urlshrinker.service.UrlShrinkerService;

@RestController
@RequiredArgsConstructor
public class UrlShrinkerController {

    private final UrlShrinkerService service;

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .header("Location", service.getResponse(shortCode))
                .build();
    }

    @PostMapping("/~add")
    public ResponseEntity<String> create(@Valid @RequestBody AddRequest addRequest) {
        return new ResponseEntity<>(service.create(addRequest), HttpStatus.CREATED);
    }

    @PostMapping("/--")
    public ResponseEntity<String> create2(@Valid AddRequest addRequest) {
        return new ResponseEntity<>(service.create(addRequest), HttpStatus.CREATED);
    }
}
