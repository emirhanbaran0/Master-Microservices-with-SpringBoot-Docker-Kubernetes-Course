package com.emirhanbaran.accounts.entity;

import com.emirhanbaran.accounts.audit.AuditAwareImpl;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class BaseClass {


    @Column(name = "created_at",updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "created_by",updatable = false)
    @CreatedBy
    private String createdBy;

    //When the object created  for FIRST TIME updatedAt and updatedBy columns will be null
    //because insertable=false

    @Column(name = "updated_at",insertable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;
}
