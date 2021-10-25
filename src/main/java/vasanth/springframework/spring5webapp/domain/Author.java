package vasanth.springframework.spring5webapp.domain;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@javax.persistence.Entity
public class Author {
    @Id
    @javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    @javax.persistence.ManyToMany(mappedBy="authors")
    private Set<Book> books= new HashSet<>();

    public Author() {}

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public long getId() {
    return id;
}
    public void setId(long id) {
    this.id = id;
}

    public java.lang.String getFirstName() {
    return firstName;
}
    public void setFirstName(java.lang.String firstName) {
    this.firstName = firstName;
}

    public java.lang.String getLastName() {
        return lastName;
    }
    public void setLastName(java.lang.String lastName) {this.lastName = lastName;}

    public java.util.Set<vasanth.springframework.spring5webapp.domain.Book> getBooks() {return books;}
    public void setBooks(java.util.Set<vasanth.springframework.spring5webapp.domain.Book> books) {this.books = books;}
}
