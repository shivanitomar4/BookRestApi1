package com.api.book.bootrestbook.services;

import java.util.List;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // private static List <Book> list = new ArrayList<>();
            
    // // Creating A Fake List
    // static {
    //     list.add(new Book(12,"java Book","XYZ"));
    //     list.add(new Book(121,"Python Book","ABC"));
    //     list.add(new Book(212,"React Book","EFG"));
    // }
    
    // Get Book Method
    public List<Book> getAllBooks()
    {
       List<Book> list =(List<Book>)this.bookRepository.findAll();
        return list;
    }

    //  Getting single book by id
    public Book getBookById(int id)
    {
        Book book =null;
        try{
        
        // book = list.stream().filter(e->e.getId()==id).findFirst().get();
        book = this.bookRepository.findById(id);
       
        }
        catch(Exception e){
            System.out.print(e);
        }
        return book;
    }

    // Adding new book 
    public Book addBook(Book b)
    {
        // list.add(b);
       Book result = this.bookRepository.save(b);
        return result;
    }

    // deleting book
        public void deleteBook(int bid)
    {
        // list=list.stream().filter(e->e.getId()!=bid).collect(Collectors.toList()) ;
        
        this.bookRepository.deleteById(bid);
    }

    // Updating existing book
    public void updateBook(Book book, int bookId)
    {
            // list.stream().map(b->{
            //     if(b.getId()==bookId){
            //         b.setAuthor(book.getAuthor());
            //         b.setTitle(book.getTitle());
            //     }
            //     return b;
            // }).collect(Collectors.toList());

            book.setId(bookId);
            bookRepository.save(book);
    }
}
