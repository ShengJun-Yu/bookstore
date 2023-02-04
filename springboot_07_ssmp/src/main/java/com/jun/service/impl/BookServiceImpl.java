package com.jun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jun.dao.BookDao;
import com.jun.domain.Book;
import com.jun.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Bojack
 * @date : Created in 16:59 2022.11.02
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean insert(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public boolean updata(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(Integer current, Integer size) {
        IPage page = new Page(current, size);
        return bookDao.selectPage(page, null);
    }

    @Override
    public List<Book> getBookLike(String name, String value) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper();
        lqw.like(name != null, Book::getName, value);
        return bookDao.selectList(lqw);
    }
}
