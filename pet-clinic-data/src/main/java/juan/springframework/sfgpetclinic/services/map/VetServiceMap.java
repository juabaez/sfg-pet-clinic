package juan.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import juan.springframework.sfgpetclinic.model.Speciality;
import juan.springframework.sfgpetclinic.model.Vet;
import juan.springframework.sfgpetclinic.services.SpecialityService;
import juan.springframework.sfgpetclinic.services.VetService;

@Service
@Profile({"default","map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
  private final SpecialityService specialitiesServices;

  public VetServiceMap(SpecialityService specialitiesServices) {
    this.specialitiesServices = specialitiesServices;
  }

  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Vet object) {
    super.delete(object);
  }

  @Override
  public Vet save(Vet object) {
    if (object != null) {
      if (object.getSpecialities() != null) {
        object.getSpecialities().forEach(speciality -> {
          if (speciality.getId() == null) {
            Speciality savedSpecialty = specialitiesServices.save(speciality);
            speciality.setId(savedSpecialty.getId());
          }
        });
      }
      return super.save(object);
    } else {
      return null;
    }
  }

  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }
}
