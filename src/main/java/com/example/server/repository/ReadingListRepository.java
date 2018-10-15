package com.example.server.repository;

import com.example.server.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReadingListRepository extends JpaRepository<Book,Long>{
    List<Book> findByReader(String reader);
}
