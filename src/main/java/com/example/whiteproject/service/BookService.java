package com.example.whiteproject.service;

import com.example.whiteproject.dao.BookDao;
import com.example.whiteproject.pojo.Book;
import com.example.whiteproject.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;
    @Autowired
    CategoryService categoryService;

    public List<Book> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return bookDao.findAll(sort);
    }

    public void addOrUpdate(Book book) {
        bookDao.save(book);
    }

    public void deleteById(int id) {
        bookDao.deleteById(id);
    }

//    public List<Book> listByCategory(int cid) {
//        Category category = CategoryService.get(cid);
//        Sort sort = Sort.by(Sort.Direction.DESC, "id");
//        return bookDao.findAllByCategory(category);
//    }
}
