package com.jun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jun.dao.BookDao;
import com.jun.domain.Book;
import com.jun.service.BookService01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Bojack
 * @date : Created in 18:59 2022.11.02
 */
@Service
public class BookService01Impl extends ServiceImpl<BookDao, Book> implements BookService01 {
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean modify(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public IPage<Book> getPage(Integer current, Integer size) {
        IPage page = new Page(current, size);
        bookDao.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Book> getPage(Integer current, Integer size, Book book) {
        IPage page = new Page(current, size);
        hh();
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper();
        lqw.like(book.getName() != null, Book::getName, book.getName());
        lqw.like(book.getType() != null, Book::getType, book.getType());
        lqw.like(book.getDescription() != null, Book::getDescription, book.getDescription());
        return bookDao.selectPage(page, lqw);
    }

    public static void hh() {
        System.out.println("ewcs");

    }

}
