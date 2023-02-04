package com.jun.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jun.domain.Book;
import com.jun.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author : Bojack
 * @date : Created in 17:22 2022.11.02
 */
@SpringBootTest
public class TestBookService {
    @Autowired
    private BookService bookService;


    @Test
    void Insert() {
        Book book = new Book();
        book.setType("计算机科学");
        book.setName("mybatisPlus实战");
        book.setDescription("my batisPlus is readly");
        System.out.println(bookService.insert(book));
    }

    @Test
    void contextFind() {
        System.out.println(bookService.getById(1));
    }

    @Test
    void delete() {
        System.out.println(bookService.delete(15));
    }

    @Test
    void getAll() {
        System.out.println(bookService.getAll());
    }

    @Test
    void page() {
        IPage page = bookService.getPage(1, 3);
//        第几页
        System.out.println(page.getCurrent());
//        每页多少条数据
        System.out.println(page.getSize());
//        总条数
        System.out.println(page.getTotal());
//        分页获取的数据
        System.out.println(page.getRecords());
    }

    @Test
    void Updata() {
        Book book = new Book();
        book.setId(14);
        book.setType("计算机技术");
        book.setName("SpringMVC实战");
        book.setDescription("my SpringMVC is readly");
        bookService.updata(book);
    }

    @Test
    void getBookLikes() {
        System.out.println(bookService.getBookLike("name", "spring"));
    }

}