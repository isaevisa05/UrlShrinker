package ru.isaevisa05.urlshrinker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.isaevisa05.urlshrinker.entity.UrlShrinked;

@Repository
public interface UrlShrinkerRepository extends JpaRepository<UrlShrinked, Long> {
}
