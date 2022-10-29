package juan.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import juan.springframework.sfgpetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
