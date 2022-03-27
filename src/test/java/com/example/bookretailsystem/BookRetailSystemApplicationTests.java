package com.example.bookretailsystem;

import com.example.bookretailsystem.entity.Books;
import com.example.bookretailsystem.repository.BooksRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
class BookRetailSystemApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private BooksRepository booksService;

    @Test
    public void saveTest() throws Exception {
        Books books = new Books();
        books.setBookName("java编程思想");
        books.setCount(100);
        books.setUnitPrice(new BigDecimal(108));
        books.setCreateTime(new Date());
        books.setModifyTime(new Date());
        books.setEnableFlag("Y");
        booksService.save(books);

        Books b = new Books();
        b.setBookName("算法导读");
        b.setCount(10);
        b.setUnitPrice(new BigDecimal(128));
        b.setCreateTime(new Date());
        b.setModifyTime(new Date());
        b.setEnableFlag("Y");
        booksService.save(b);

        Books b2 = new Books();
        b2.setBookName("Spring实战");
        b2.setCount(50);
        b2.setUnitPrice(new BigDecimal(99));
        b2.setCreateTime(new Date());
        b2.setModifyTime(new Date());
        b2.setEnableFlag("Y");
        booksService.save(b2);

        Books b3 = new Books();
        b3.setBookName("SpringBoot编程思想");
        b3.setCount(60);
        b3.setUnitPrice(new BigDecimal(118.5));
        b3.setCreateTime(new Date());
        b3.setModifyTime(new Date());
        b3.setEnableFlag("Y");
        booksService.save(b3);
    }

}
