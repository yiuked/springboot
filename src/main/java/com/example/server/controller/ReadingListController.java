package com.example.server.controller;

import com.example.server.properties.SpreadProperties;
import com.example.server.entity.Book;
import com.example.server.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {
    private ReadingListRepository readingListRepository;
    private SpreadProperties spreadProperties;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository, SpreadProperties spreadProperties) {
        this.readingListRepository = readingListRepository;
        this.spreadProperties = spreadProperties;
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(
            @PathVariable("reader") String reader,
            Model model
    ) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("unionKey", spreadProperties.getUnionKey());
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(
            @PathVariable("reader") String reader,
            Book book
    ) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }
}
