package com.library.libraryApi.core;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class AbstractEntity implements BaseEntity{
    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;
    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;
    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @PreUpdate
    private void beforeUpdate() {

//        setUpdatedBy(authorLogic.getCurrentUserId());
        setUpdatedDate(LocalDateTime.now());
    }

    @PrePersist
    private void beforePersist() {

//        entity.setCreatedBy(authorLogic.getCurrentUserId());
        setCreatedDate(LocalDateTime.now());
    }
}
