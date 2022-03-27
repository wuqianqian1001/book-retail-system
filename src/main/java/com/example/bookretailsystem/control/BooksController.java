package com.example.bookretailsystem.control;

import com.example.bookretailsystem.common.DateResult;
import com.example.bookretailsystem.common.ResultCode;
import com.example.bookretailsystem.entity.Books;
import com.example.bookretailsystem.repository.BooksRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuqianqian
 * @date 2022-03-27
 */

@RestController
@RequestMapping("/books")
public class BooksController {
    @Resource
    private BooksRepository booksRepository;


    @GetMapping("/booksList")
    public DateResult<List> list() {
        List<Books> booksList = booksRepository.findAll();
        DateResult<List> result = new DateResult<List>();
        result.setCode(ResultCode.SUCCESS.code());
        result.setMsg("查询成功");
        result.setData(booksList);
        return result;
    }

    @GetMapping("/getById/{id}")
    public DateResult<Books> getById(@PathVariable("id") Long id) {
        Books books = booksRepository.getById(id);
        DateResult<Books> result = new DateResult<Books>();
        result.setCode(ResultCode.SUCCESS.code());
        result.setMsg("查询成功");
        result.setData(books);
        return result;
    }

    @GetMapping("/getByName/{name}")
    public DateResult<List> getById(@PathVariable("name") String name) {
        List<Books> booksList = booksRepository.findByBookSName(name);
        DateResult<List> result = new DateResult<List>();
        result.setCode(ResultCode.SUCCESS.code());
        result.setMsg("查询成功");
        result.setData(booksList);
        return result;
    }
}
