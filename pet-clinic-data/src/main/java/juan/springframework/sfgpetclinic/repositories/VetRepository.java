package juan.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import juan.springframework.sfgpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
