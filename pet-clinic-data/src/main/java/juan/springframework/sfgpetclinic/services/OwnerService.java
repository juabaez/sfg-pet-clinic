package juan.springframework.sfgpetclinic.services;

import java.util.List;
import java.util.Set;

import juan.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

  Owner findByLastName(String lastName);

  List<Owner> findAllByLastNameLike(String lastName);
}
