package com.botscrew.task.sokyrynskyi.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String ISBN;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors = new ArrayList<>();

    public Book(String name){this.name=name;}

    public boolean addAuthor(Author author){
        return authors.add(author) && author.getBooks().add(this);
    }
    public boolean removeAuthor(Author author){
        return authors.remove(author) && author.getBooks().remove(this);
    }
}
