package com.sys.common.api;

import com.sys.manage.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EsBookRepository extends ElasticsearchRepository<Book, String> {
    // 根据书名字查询
    List<Book> queryByName(String name);

    //    根据相应价格统计书本的数量
    long countBooksByPrice(Integer price);

    //    根据名字删除
    void deleteByName(String name);

    Book queryEmployeeById(String id);

}