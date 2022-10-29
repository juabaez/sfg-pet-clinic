package juan.springframework.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import juan.springframework.sfgpetclinic.model.PetType;
import juan.springframework.sfgpetclinic.repositories.PetTypeRepository;
import juan.springframework.sfgpetclinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {
  private PetTypeRepository petTypeRepository;

  @Override
  public Set<PetType> findAll() {
    Set<PetType> petTypes = new HashSet<>();
    petTypeRepository.findAll().forEach(petTypes::add);
    return petTypes;
  }

  @Override
  public PetType findById(Long aLong) {
    return petTypeRepository.findById(aLong).orElse(null);
  }

  @Override
  public PetType save(PetType object) {
    return petTypeRepository.save(object);
  }

  @Override
  public void delete(PetType object) {
    petTypeRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    petTypeRepository.deleteById(aLong);
  }
}
