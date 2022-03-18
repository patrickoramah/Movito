package com.group6.reviewservice;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Review {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID userId;
    private UUID movieId;
    private double rating = 0.0;
    @Column(columnDefinition = "TEXT")
    private String body;
    @Column(updatable=false)
    @CreationTimestamp
    private Date dateCreated;
    @CreationTimestamp
    private Date lastUpdated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Review review = (Review) o;
        return id != null && Objects.equals(id, review.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
