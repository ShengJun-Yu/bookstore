package com.jun.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jun.domain.Book;
import com.jun.service.BookService01;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author : Bojack
 * @date : Created in 17:22 2022.11.02
 */
@SpringBootTest
public class TestBookService01 {
    @Autowired
    private BookService01 bookService;


    @Test
    void Insert() {
        Book book = new Book();
        book.setType("计算机科学");
        book.setName("mybatisPlus实战");
        book.setDescription("my batisPlus is readly");
        System.out.println(bookService.save(book));
    }

    @Test
    void contextFind() {
        System.out.println(bookService.getById(1));
    }

    @Test
    void delete() {
        System.out.println(bookService.removeById(15));
    }

    @Test
    void getAll() {
        System.out.println(bookService.list());
    }

    @Test
    void page() {
        IPage<Book> page=new Page<Book>(1,3);
        bookService.page(page);
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
        bookService.updateById(book);
    }

//    @Test
//    void getBookLikes() {
//        System.out.println(bookService.getBookLike("name", "spring"));
//    }

}