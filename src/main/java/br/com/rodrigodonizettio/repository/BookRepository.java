package br.com.rodrigodonizettio.repository;

import br.com.rodrigodonizettio.model.Book;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {
    public List<Book> getAll() {
        return List.of(
                new Book(1, "Essentialism", 272),
                new Book(2, "The Hard Things About Hard Things", 295)
        );
    }

    public Integer countAll() {
        return getAll().size();
    }

    public Optional<Book> getBookById(Integer id) {
        return getAll().stream().filter(b -> b.getId().equals(id)).findFirst();
    }
}