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
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        System.out.println("Started in BootStrap");

       // System.out.println("Publishers:"+ publisherRepository.count());

        Author vasanth=new Author("Vasanth","Gentela");
        Book  prem=new Book("Prem Chand","123456");
        vasanth.getBooks().add(prem);
        prem.getAuthors().add(vasanth);


//        publisherRepository.save(UVCreations);

        Author rod=new Author("Rod","Johnson");
        Book  noEJB=new Book("J2EE Development without EJB","98523456");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        Publisher UVCreations=new Publisher("UVCreations","Madapur","Hyderabad","Telangana","501510");
        publisherRepository.save(UVCreations);

        noEJB.setPublisher(UVCreations);
        UVCreations.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        prem.setPublisher(UVCreations);
        UVCreations.getBooks().add(prem);
        authorRepository.save(vasanth);
        bookRepository.save(prem);

        publisherRepository.save(UVCreations);


        System.out.println("Number of Books:" + bookRepository.count()+" Number of Authors:"+authorRepository.count());
        System.out.println("Publisher Books:"+UVCreations.getBooks().size());



    }
}
