package gov.tech.cdit.repositories;

import gov.tech.cdit.entities.UrlEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShorterRepository extends CrudRepository<UrlEntry, String> {
}
