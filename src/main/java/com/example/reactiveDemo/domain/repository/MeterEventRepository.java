package com.example.reactiveDemo.domain.repository;

import com.example.reactiveDemo.domain.MeterEvent;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * Created by andreaskaitis on 26/10/2017.
 * reactive-demo
 */
public interface MeterEventRepository extends ReactiveCrudRepository<MeterEvent, String> {


}
