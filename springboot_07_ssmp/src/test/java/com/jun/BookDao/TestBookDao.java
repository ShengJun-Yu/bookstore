package com.jun.BookDao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jun.dao.BookDao;
import com.jun.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestBookDao {
    @Autowired
    private BookDao bookDao;

    @Test
    void contextInsert() {
        Book book = new Book();
        book.setType("计算机科学");
        book.setName("mybatisPlus实战");
        book.setDescription("my batisPlus is readly");
        System.out.println(bookDao.insert(book));
    }

    @Test
    void contextFind() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void delete() {
        System.out.println(bookDao.deleteById(13));
    }

    @Test
    void getAll() {
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void page() {
        IPage page = new Page(2, 3);
        bookDao.selectPage(page, null);
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
    void contextUpdata() {
        Book book = new Book();
        book.setId(1);
        book.setType("计算机科学");
        book.setName("mybatisPlus实战");
        book.setDescription("my batisPlus is readly");
        bookDao.updateById(book);
    }

    @Test
    void findByName(){
//        QueryWrapper<Book> qw=new QueryWrapper<>();
//        qw.like("name","mybatis");
        String name="1";
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<>();
        lqw.like(name !=null,Book::getName,"mybatis");
        bookDao.selectList(lqw);
    }

}
