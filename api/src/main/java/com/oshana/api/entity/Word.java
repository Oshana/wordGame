package com.oshana.api.entity;

import javax.persistence.*;

@Entity
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String word;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    public Long getId() {
        return id;
    }

    public String getword() { return word; }

    public void setword(String word) {
        this.word = word;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
