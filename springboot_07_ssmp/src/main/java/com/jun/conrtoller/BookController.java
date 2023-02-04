package com.jun.conrtoller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jun.conrtoller.until.R;
import com.jun.domain.Book;
import com.jun.service.BookService01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Statement;
import java.util.List;

/**
 * @author : Bojack
 * @date : Created in 19:36 2022.11.02
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService01 bookService;

    @GetMapping
    public R getAllBook() {
        return new R(true, bookService.list());
    }

    @PostMapping
    public R insertBook(@RequestBody Book book) throws IOException {
        if (book.getName().equals("123")) throw new IOException();
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败=_=");
    }

    @PutMapping
    public R updataBook(@RequestBody Book book) {
        return new R(bookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R deleteBook(@PathVariable Integer id) {
        return new R(bookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getBookById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

//    @GetMapping("{current}/{size}")
//    public R getPage(@PathVariable Integer current, @PathVariable Integer size) {
//        IPage<Book> page = bookService.getPage(current, size);
//        //如果当前页码大于总页码值，那么以最大页码值为参数，重新执行查询分页方法
//        if (current > page.getPages()) {
//            page = bookService.getPage((int) page.getPages(), size);
//        }
//        return new R(true, page);
//    }

    @GetMapping("{current}/{size}")
    public R getPage(@PathVariable Integer current, @PathVariable Integer size, Book book) {
        System.out.println("book====>"+book);
        IPage<Book> page = bookService.getPage(current, size, book);
        //如果当前页码大于总页码值，那么以最大页码值为参数，重新执行查询分页方法
        if (current > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), size, book);
        }
        return new R(true, page);
    }
}
