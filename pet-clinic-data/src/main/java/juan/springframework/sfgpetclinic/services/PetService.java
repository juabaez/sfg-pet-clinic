package juan.springframework.sfgpetclinic.services;

import java.util.Set;

import juan.springframework.sfgpetclinic.model.Pet;

public interface PetService {

  Pet findById(Long id);

  Pet save(Pet pet);

  Set<Pet> findAll();
}
