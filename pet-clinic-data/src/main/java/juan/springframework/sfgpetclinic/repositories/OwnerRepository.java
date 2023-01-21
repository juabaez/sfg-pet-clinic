package juan.springframework.sfgpetclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import juan.springframework.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
  Owner findByLastName(String lastName);

  List<Owner> findAllByLastNameLike(String lastName);

}
