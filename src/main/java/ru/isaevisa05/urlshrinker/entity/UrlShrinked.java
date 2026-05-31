package ru.isaevisa05.urlshrinker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "short_links")
public class UrlShrinked {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "url", nullable = false)
    private String url;
}
