package vasanth.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import vasanth.springframework.spring5webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
