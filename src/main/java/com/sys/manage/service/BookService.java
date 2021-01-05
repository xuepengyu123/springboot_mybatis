package com.sys.manage.service;

import com.sys.manage.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findBookByTermQuery(Integer pageNum);

    List<Book> findBooksLikeByMatchQuery(String word);

    List<Book> findBooksLikeByRangeQuery(Integer minPageNum, Integer maxPageNum);

    void save(Book b);


    long countBooksByPrice(Integer price);

    List<Book> queryByName(String name);

    void deleteByName(String name);

    void delete(Book employee);

    Book queryEmployeeById(String s);
}
