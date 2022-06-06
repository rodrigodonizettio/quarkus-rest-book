package br.com.rodrigodonizettio.inbound;

import br.com.rodrigodonizettio.model.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/book")
public class BookResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAll() {
        return List.of(
                new Book(1, "Essentialism", 272),
                new Book(2, "The Hard Things About Hard Things", 295)
        );
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer countAll() {
        return getAll().size();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Book> getBookById(@PathParam("id") Integer id) {
        return getAll().stream().filter(b -> b.getId().equals(id)).findFirst();
    }
}