package com.jun.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jun.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : Bojack
 * @date : Created in 16:53 2022.11.02
 */

public interface BookService {
    boolean insert(Book book);

    boolean updata(Book book);

    boolean delete(@Param("id") Integer id);

    Book getById(@Param("id") Integer id);

    List<Book> getAll();

    IPage<Book> getPage(Integer current, Integer size);

    List<Book> getBookLike(String name, String value);


}
