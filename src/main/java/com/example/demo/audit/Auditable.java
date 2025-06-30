package com.example.demo.audit;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class Auditable {

    @CreatedBy
    protected String createdBy;

    @CreatedDate
    protected LocalDateTime createdDt;

    @LastModifiedBy
    protected String updatedBy;

    @LastModifiedDate
    protected LocalDateTime updatedDt;

    @Version
    protected Long version;

}
