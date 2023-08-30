package com.waxes27.lmstemplate.LMS.models;


import javax.persistence.*;

@Entity
public class LmsPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
