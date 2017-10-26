package com.example.reactiveDemo.controller;

import com.example.reactiveDemo.domain.MeterEvent;
import com.example.reactiveDemo.domain.repository.MeterEventRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by andreaskaitis on 26/10/2017.
 * reactive-demo
 */
@RestController
public class ReactiveRestController {

    private final MeterEventRepository repository;

    public ReactiveRestController(MeterEventRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/events")
    Mono<Void> create(@RequestBody Flux<MeterEvent> meterEventStream) {
        return this.repository.saveAll(meterEventStream).then();
    }

    @Tailable
    @GetMapping(value = "/streamEvents", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<MeterEvent> getAllEvents() {
        return this.repository.findAll();
    }
}
