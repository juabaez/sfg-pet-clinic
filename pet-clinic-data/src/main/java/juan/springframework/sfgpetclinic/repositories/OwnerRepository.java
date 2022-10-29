package juan.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import juan.springframework.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
