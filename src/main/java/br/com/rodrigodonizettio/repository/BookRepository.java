package br.com.rodrigodonizettio.repository;

import br.com.rodrigodonizettio.model.Book;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {
    @ConfigProperty(name = "book.translated", defaultValue = "false")
    private String isTranslated;

    public List<Book> getAll() {
        return List.of(
                new Book(1, "Essentialism", 272, isTranslated),
                new Book(2, "The Hard Things About Hard Things", 295, isTranslated)
        );
    }

    public Integer countAll() {
        return getAll().size();
    }

    public Optional<Book> getBookById(Integer id) {
        return getAll().stream().filter(b -> b.getId().equals(id)).findFirst();
    }
}