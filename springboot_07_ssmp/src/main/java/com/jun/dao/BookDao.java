package com.jun.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jun.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author : Bojack
 * @date : Created in 15:41 2022.11.01
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {
//    @Select("select * from tbl_book where id=#{id}")
//    Book findUserById(@Param("id") Integer id);
}
