package io.wjehovah.github.myspingboot.controller;

import io.wjehovah.github.myspingboot.domain.Author;
import io.wjehovah.github.myspingboot.dto.RespWrapper;
import io.wjehovah.github.myspingboot.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author wuyong
 */
@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService service;

    @Autowired
    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public RespWrapper<Author> findOne(@PathVariable @NotNull Integer id) {
        return service.findById(id);
    }

    @GetMapping("/")
    public RespWrapper<Page<Author>> findAll(@PageableDefault(sort = {"age","id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return service.findByState(pageable,1);
    }


    @PostMapping("/save")
    public RespWrapper<Author> save(@RequestBody @Valid Author author) {
        return service.save(author);
    }

    @PostMapping("/update")
    public RespWrapper<Author> update(@RequestBody @Valid Author author) {
        return service.update(author);
    }
}
