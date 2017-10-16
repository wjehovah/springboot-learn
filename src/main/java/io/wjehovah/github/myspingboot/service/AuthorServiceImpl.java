package io.wjehovah.github.myspingboot.service;

import io.wjehovah.github.myspingboot.domain.Author;
import io.wjehovah.github.myspingboot.dto.RespWrapper;
import io.wjehovah.github.myspingboot.exception.BadRequestException;
import io.wjehovah.github.myspingboot.exception.DuplicateEntityException;
import io.wjehovah.github.myspingboot.dao.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author wuyong
 */
@Service("authorService")
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public RespWrapper<Author> findById(Integer id) {
        Author author = repository.findOne(id);
        return RespWrapper.<Author>ofCode("200").setData(author);
    }


    @Override
    public RespWrapper<Page<Author>> findByState(Pageable pageable, Integer active) {
        Page<Author> authors = repository.findByState(pageable, active);
        return RespWrapper.<Page<Author>>ofCode("200").setData(authors);
    }

    @Override
    public RespWrapper<Author> save(Author author) {

        if (author.getId() != null) {
            throw new BadRequestException("要保存对象的 id 必须为空");
        }
        Author save = repository.save(author);
        return RespWrapper.<Author>ofCode("200").setData(save).setMsg("保存成功");
    }


    @Override
    public RespWrapper<Author> update(Author author) {
        if (author.getId() != null) {
            if (repository.exists(author.getId())) {
                Author save = repository.save(author);
                return RespWrapper.<Author>ofCode("200").setData(save);
            }
        }

        throw new DuplicateEntityException("将要更新的" + author.getClass().getSimpleName() + "不存在,保存请调用 save 接口。id : " + author.getId());

    }


}
