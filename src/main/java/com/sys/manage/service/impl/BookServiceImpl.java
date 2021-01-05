package com.sys.manage.service.impl;

import com.sys.manage.model.Book;
import com.sys.manage.service.BookService;
import com.sys.common.api.EsBookRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private EsBookRepository bookRepository;

    //  完全匹配项查询
    @Override
    public List<Book> findBookByTermQuery(Integer pageNum) {
        TermQueryBuilder termQuery = QueryBuilders.termQuery("pageNum", pageNum);
        Iterable<Book> bookIterable = bookRepository.search(termQuery);
        Iterator<Book> iterator = bookIterable.iterator();
//      遍历该迭代器，取出相应结果
        List<Book> books = new ArrayList<>();
        while (iterator.hasNext()) {
            books.add(iterator.next());
        }
        return books;
    }

    //    模糊匹配查询
    @Override
    public List<Book> findBooksLikeByMatchQuery(String word) {
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("introduction", word);
        Iterable<Book> bookIterable = bookRepository.search(matchQueryBuilder);
        Iterator<Book> iterator = bookIterable.iterator();
//      遍历该迭代器，取出相应结果
        List<Book> books = new ArrayList<>();
        while (iterator.hasNext()) {
            books.add(iterator.next());
        }
        return books;
    }

    //    范围查询
    @Override
    public List<Book> findBooksLikeByRangeQuery(Integer minPageNum, Integer maxPageNum) {
        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("pageNum").gte(minPageNum).lte(maxPageNum);
        Iterable<Book> bookIterable = bookRepository.search(rangeQueryBuilder);
        Iterator<Book> iterator = bookIterable.iterator();
//      遍历该迭代器，取出相应结果
        List<Book> books = new ArrayList<>();
        while (iterator.hasNext()) {
            books.add(iterator.next());
        }
        return books;
    }

    @Override
    public void save(Book b) {
        bookRepository.save(b);
    }

    @Override
    public long countBooksByPrice(Integer price) {
        return bookRepository.countBooksByPrice(price);
    }

    @Override
    public List<Book> queryByName(String name) {
        return bookRepository.queryByName(name);
    }

    @Override
    public void deleteByName(String name) {
        bookRepository.deleteByName(name);
    }

    @Override
    public void delete(Book employee) {
        bookRepository.delete(employee);
    }

    @Override
    public Book queryEmployeeById(String s) {
        return bookRepository.queryEmployeeById(s);
    }
}