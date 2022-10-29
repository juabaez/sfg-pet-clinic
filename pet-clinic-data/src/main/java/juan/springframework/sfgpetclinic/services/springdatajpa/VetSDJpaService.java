package juan.springframework.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import juan.springframework.sfgpetclinic.model.Owner;
import juan.springframework.sfgpetclinic.model.Vet;
import juan.springframework.sfgpetclinic.repositories.SpecialityRepository;
import juan.springframework.sfgpetclinic.repositories.VetRepository;
import juan.springframework.sfgpetclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {
  private final VetRepository vetRepository;
  private final SpecialityRepository specialityRepository;

  public VetSDJpaService(juan.springframework.sfgpetclinic.repositories.VetRepository vetRepository,
      SpecialityRepository specialityRepository) {
    this.vetRepository = vetRepository;
    this.specialityRepository = specialityRepository;
  }

  @Override
  public Set<Vet> findAll() {
    Set<Vet> vets = new HashSet<>();

    vetRepository.findAll().forEach(vets::add);
    return vets;
  }

  @Override
  public Vet findById(Long aLong) {
    return vetRepository.findById(aLong).orElse(null);
  }

  @Override
  public Vet save(Vet object) {
    return vetRepository.save(object);
  }

  @Override
  public void delete(Vet object) {
    vetRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    vetRepository.deleteById(aLong);
  }
}
