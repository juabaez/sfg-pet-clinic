package juan.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import juan.springframework.sfgpetclinic.model.Visit;
import juan.springframework.sfgpetclinic.services.VisitService;

@Service
@Profile({"default","map"})
public class VisistServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

  @Override
  public Set<Visit> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public Visit save(Visit visit) {
    if (visit.getPet()== null || visit.getPet().getOwner()==null || visit.getPet().getId()==null){
      throw new RuntimeException("invalida visit");
    }

    return super.save(visit);
  }

  @Override
  public void delete(Visit object) {
    super.delete(object);
  }

  @Override
  public Visit findById(Long id) {
    return super.findById(id);
  }
}
