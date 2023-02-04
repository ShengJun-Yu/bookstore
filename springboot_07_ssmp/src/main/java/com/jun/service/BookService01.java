package com.jun.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jun.domain.Book;

import java.util.List;

/**
 * @author : Bojack
 * @date : Created in 18:42 2022.11.02
 */
public interface BookService01 extends IService<Book> {
    boolean modify(Book book);
    IPage<Book> getPage(Integer current,Integer size);
    IPage<Book> getPage(Integer current,Integer size,Book book);
}
