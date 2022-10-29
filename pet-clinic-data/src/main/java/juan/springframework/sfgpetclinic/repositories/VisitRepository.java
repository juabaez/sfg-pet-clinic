package juan.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import juan.springframework.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
