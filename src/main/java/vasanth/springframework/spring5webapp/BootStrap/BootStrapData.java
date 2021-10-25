package vasanth.springframework.spring5webapp.BootStrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vasanth.springframework.spring5webapp.domain.Author;
import vasanth.springframework.spring5webapp.domain.Book;
import vasanth.springframework.spring5webapp.domain.Publisher;
import vasanth.springframework.spring5webapp.repositories.AuthorRepository;
import vasanth.springframework.spring5webapp.repositories.BookRepository;
import vasanth.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author vasanth=new Author("Vasanth","Gentela");
        Book  prem=new Book("Prem Chand","123456");
        vasanth.getBooks().add(prem);
        prem.getAuthors().add(vasanth);
        authorRepository.save(vasanth);
        bookRepository.save(prem);
        Author rod=new Author("Rod","Johnson");
        Book  noEJB=new Book("J2EE Developoment without EJB","98523456");
        vasanth.getBooks().add(noEJB);
        prem.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher kishor=new Publisher("Kishor","Tengeda, 508243");
        publisherRepository.save(kishor);
        System.out.println("Books are goind to display");
        System.out.println("Total books "+bookRepository.count()+'/'+"Toatal Publishers:"+publisherRepository.count());

    }
}
