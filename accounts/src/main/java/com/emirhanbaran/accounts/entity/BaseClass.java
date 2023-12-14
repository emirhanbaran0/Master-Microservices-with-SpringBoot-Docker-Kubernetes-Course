package com.emirhanbaran.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseClass {

    @NotNull
    @Column(name = "created_at",updatable = false)
    private LocalDateTime createdAt;
    @NotNull
    @Column(name = "created_by",updatable = false)
    private LocalDateTime createdBy;

    //When the object created  for FIRST TIME updatedAt and updatedBy columns will be null
    //because insertable=false
    @NotNull
    @Size(max = 20)
    @Column(name = "updated_at",insertable = false)
    private LocalDateTime updatedAt;
    @NotNull
    @Column(name = "updated_by",insertable = false)
    @Size(max = 20)
    private LocalDateTime updatedBy;
}
