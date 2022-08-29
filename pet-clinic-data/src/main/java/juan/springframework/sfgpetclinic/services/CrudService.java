package juan.springframework.sfgpetclinic.services;

import java.util.Set;

import juan.springframework.sfgpetclinic.model.Pet;

public interface CrudService<T,ID> {

  Set<T> findAll();

  T findById(ID id);

  T save(T object);

  void delete(T object);

  void deleteById(ID id);
}
