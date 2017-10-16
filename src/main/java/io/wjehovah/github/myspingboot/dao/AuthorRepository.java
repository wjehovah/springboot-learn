package io.wjehovah.github.myspingboot.dao;

import io.wjehovah.github.myspingboot.domain.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * @author wuyong
 */
public interface AuthorRepository extends PagingAndSortingRepository<Author, Integer> {
    /**
     * @param pageable
     * @param active
     * @return
     */
    Page<Author> findByState(Pageable pageable, Integer active);
}
