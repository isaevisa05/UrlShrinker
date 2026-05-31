package ru.isaevisa05.urlshrinker.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isaevisa05.urlshrinker.dto.AddRequest;
import ru.isaevisa05.urlshrinker.entity.UrlShrinked;
import ru.isaevisa05.urlshrinker.exceptions.ResourceNotFoundException;
import ru.isaevisa05.urlshrinker.repository.UrlShrinkerRepository;
import ru.isaevisa05.urlshrinker.util.Base58Converter;

@Slf4j
@Service
public class UrlShrinkerService {

    private final UrlShrinkerRepository repository;
    private final String appUrl;

    public UrlShrinkerService(UrlShrinkerRepository repository, @Value("${app.url}") String appUrl) {
        this.repository = repository;
        this.appUrl = appUrl;
    }

    @Transactional(readOnly = true)
    public String getResponse(String code) {
        long l = Base58Converter.toLong(code);
        if (l == -1) throw new IllegalArgumentException("Invalid code");
        return repository.findById(l).map(UrlShrinked::getUrl).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found"));
    }

    @Transactional
    public String create(AddRequest addRequest) {
        UrlShrinked urlShrinked = new UrlShrinked();
        urlShrinked.setUrl(addRequest.url());
        repository.saveAndFlush(urlShrinked);

        return Base58Converter.fromLong(urlShrinked.getId());
    }
}
