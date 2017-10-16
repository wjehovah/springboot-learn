package io.wjehovah.github.myspingboot.service;

import io.wjehovah.github.myspingboot.domain.Author;
import io.wjehovah.github.myspingboot.dto.RespWrapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService {
    RespWrapper<Author> findById(Integer id);

    RespWrapper<Page<Author>> findByState(Pageable pageable, Integer state);

    RespWrapper<Author> save(Author author);

    RespWrapper<Author> update(Author author);
}
