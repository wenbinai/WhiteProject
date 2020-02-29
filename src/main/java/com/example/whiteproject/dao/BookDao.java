package com.example.whiteproject.dao;

import com.example.whiteproject.pojo.Book;
import com.example.whiteproject.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {
    List<Book> findAllByCategory(Category category);
//    List<Book> findAllByTitleLikeOrAuthorOrLike(String keyword1, String keyword2);
}
