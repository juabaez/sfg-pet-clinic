package juan.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import juan.springframework.sfgpetclinic.model.Speciality;
import juan.springframework.sfgpetclinic.services.SpecialityService;

@Service
@Profile({"default","map"})
public class SpecialtyServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {
  @Override
  public Set<Speciality> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public Speciality save(Speciality object) {
    return super.save(object);
  }

  @Override
  public void delete(Speciality object) {
    super.delete(object);
  }

  @Override
  public Speciality findById(Long id) {
    return null;
  }
}
