package com.sys.manage.controller;

import com.google.gson.Gson;
import com.sys.manage.model.Book;
import com.sys.manage.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping(value = "/es")
@Api(description = "ES book实体类测试")
public class EsController {
    @Autowired
    private BookService bookService;

    @ApiOperation(value = "批量保存book数据")
    @RequestMapping(value = "/batchSave", method = RequestMethod.PUT)
    public String testSaveBook(@RequestParam Integer n) {
        Random random = new Random();
        String[] names = {"三国志", "三国演义", "三国", "红楼梦", "红楼", "西游记", "三国演义"};
        Integer[] pageNums = {100, 200, 300, 400, 500};
        String[] introductions = {"这是一本很好的故事", "这里面有非常动人的故事", "孙悟空三大白骨精"};
        Double[] prices = {38.6, 35.8, 50.9, 40.7};
        Date date = new Date();
        Date[] dates = {date};
        for (int i = 0; i < n; i++) {
            Book b = new Book();
            String id = UUID.randomUUID().toString().replace("_", "").substring(0, 10);
            b.setId(id);
            b.setName(names[random.nextInt(names.length)]);
            b.setPageNum(pageNums[random.nextInt(pageNums.length)]);
            b.setPrice(prices[random.nextInt(prices.length)]);
            b.setIntroduction(introductions[random.nextInt(introductions.length)]);
            b.setDate(dates[random.nextInt(dates.length)]);
            bookService.save(b);
        }
        return "ok";
    }

    @ApiOperation(value = "单项查询")
    @RequestMapping(value = "/findBookByTermQuery", method = RequestMethod.GET)
    public List<Book> findBookByTermQuery(@RequestParam Integer pageNum) {
        List<Book> bookByTermQuery = bookService.findBookByTermQuery(pageNum);
        return bookByTermQuery;
    }

    @ApiOperation(value = "模糊查询")
    @RequestMapping(value = "/findBooksLikeByMatchQuery", method = RequestMethod.GET)
    public List<Book> findBooksLikeByMatchQuery(@RequestParam String word) {
        List<Book> books = bookService.findBooksLikeByMatchQuery(word);
        return books;
    }

    @ApiOperation(value = "范围查询")
    @RequestMapping(value = "/findBooksLikeByRangeQuery", method = RequestMethod.GET)
    public List<Book> findBooksLikeByRangeQuery(@RequestParam Integer min, @RequestParam Integer max) {
        List<Book> books = bookService.findBooksLikeByRangeQuery(min, max);
        return books;
    }

    @ApiOperation(value = "JPA-method-根据价格查询")
    @RequestMapping(value = "/countBooksByPrice", method = RequestMethod.GET)
    public long countBooksByPrice(@RequestParam Integer price) {
        long count = bookService.countBooksByPrice(price);
        return count;
    }

    @ApiOperation(value = "JPA-method-根据名字查询")
    @RequestMapping(value = "/queryByName", method = RequestMethod.GET)
    public List<Book> queryByName(@RequestParam String name) {
        List<Book> books = bookService.queryByName(name);
        return books;
    }

    @ApiOperation(value = "JPA-method-根据名字删除")
    @RequestMapping(value = "/deleteByName", method = RequestMethod.DELETE)
    public void deleteByName(@RequestParam String name) {
        bookService.deleteByName(name);
    }

    //增加
    @RequestMapping("/add")
    public String add(int n) {
        Random random = new Random();
        String[] names = {"三国志", "三国演义", "三国", "红楼梦", "红楼", "西游记", "三国演义"};
        Integer[] pageNums = {100, 200, 300, 400, 500};
        String[] introductions = {"这是一本很好的故事", "这里面有非常动人的故事", "孙悟空三大白骨精"};
        Double[] prices = {38.6, 35.8, 50.9, 40.7};
        Date date = new Date();
        Date[] dates = {date};
        for (int i = 0; i < n; i++) {
            Book elastic = new Book();
            String id = UUID.randomUUID().toString().replace("_", "").substring(0, 10);
            elastic.setId(id);
            elastic.setName(names[random.nextInt(names.length)]);
            elastic.setPageNum(pageNums[random.nextInt(pageNums.length)]);
            elastic.setPrice(prices[random.nextInt(prices.length)]);
            elastic.setIntroduction(introductions[random.nextInt(introductions.length)]);
            elastic.setDate(dates[random.nextInt(dates.length)]);
            bookService.save(elastic);
        }
        return "success";
    }

    //删除
    @RequestMapping("/delete")
    public String delete(String id) {
        Book employee = new Book();
        employee.setId(id);
        bookService.delete(employee);
        return "success";
    }

    //局部更新
    @RequestMapping("/update")
    public String update() {
        Book employee = bookService.queryEmployeeById("1");
        employee.setName("哈哈");
        bookService.save(employee);
        System.err.println("update a obj");
        return "success";
    }

    //查询
    @RequestMapping("/query/{id}")
    public Book query(@PathVariable("id") String id) {
        Book accountInfo = bookService.queryEmployeeById(id);
        System.err.println(new Gson().toJson(accountInfo));
        return accountInfo;
    }

}