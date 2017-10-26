package com.example.reactiveDemo.domain;

import com.example.reactiveDemo.components.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by andreaskaitis on 26/10/2017.
 * reactive-demo
 */
@Data
@Document
public abstract class AbstractEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @CreatedDate
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date createdTime;

}
