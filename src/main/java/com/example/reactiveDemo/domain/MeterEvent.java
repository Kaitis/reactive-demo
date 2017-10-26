package com.example.reactiveDemo.domain;

import com.example.reactiveDemo.components.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by andreaskaitis on 26/10/2017.
 * reactive-demo
 */

@Document(collection = "MeterEvent")
@Getter
@Setter
@NoArgsConstructor
public class MeterEvent extends AbstractEvent {

    private static final long serialVersionUID = 1L;

    private String meterId;
    private BigDecimal reading;

    @JsonSerialize(using = JsonDateSerializer.class)
    private Date timestamp;

    public MeterEvent(String meterId, BigDecimal reading, Date timestamp) {
        this.meterId = meterId;
        this.reading = reading;
        this.timestamp = timestamp;
    }
}
