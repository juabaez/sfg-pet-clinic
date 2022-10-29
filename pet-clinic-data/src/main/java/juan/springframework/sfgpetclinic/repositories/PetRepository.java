package juan.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import juan.springframework.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
