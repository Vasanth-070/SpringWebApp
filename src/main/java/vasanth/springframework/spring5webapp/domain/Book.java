package vasanth.springframework.spring5webapp.domain;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@javax.persistence.Entity
public class Book {
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    private String title;
    private String isBn;
    @ManyToOne
    private Publisher publisher;

    @javax.persistence.ManyToMany
    @javax.persistence.JoinTable(name="author_book",joinColumns=@javax.persistence.JoinColumn(name="book_id"),
            inverseJoinColumns=@javax.persistence.JoinColumn(name="author_id"))
    private Set<Author>authors=new HashSet<>();

    public Book() {}
    public Book(String title,String isBn){
        this.title=title;
        this.isBn=isBn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isBn='" + isBn + '\'' +
                ", publisher=" + publisher
                ;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public java.lang.String getTitle() {
    return title;
}
    public void setTitle(java.lang.String title) {
    this.title = title;
}

    public long getId() {
    return id;
}
    public void setId(long id) {
    this.id = id;
}

    public java.lang.String getIsBn() {
    return isBn;
}
    public void setIsBn(java.lang.String isBn) {this.isBn = isBn;}

    public java.util.Set<vasanth.springframework.spring5webapp.domain.Author> getAuthors() {return authors;}
    public void setAuthors(java.util.Set<vasanth.springframework.spring5webapp.domain.Author> authors) {this.authors = authors;}
}


