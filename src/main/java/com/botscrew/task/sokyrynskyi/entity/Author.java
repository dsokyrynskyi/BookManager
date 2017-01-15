package com.botscrew.task.sokyrynskyi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString(of = {"name", "birthDate"})
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @ManyToMany(mappedBy = "authors",cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public Author(String name){this.name=name;}
}
