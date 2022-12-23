package juan.springframework.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import juan.springframework.sfgpetclinic.model.Owner;

class OwnerServiceMapTest {
  OwnerServiceMap ownerMapService;
  final Long OWNER_ID = 1L;
  final String lastName = "Smith";

  @BeforeEach
  void setUp() {
    ownerMapService = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
    ownerMapService.save(Owner.builder().id(OWNER_ID).lastName(lastName).build());
  }

  @Test
  void findAll() {
    Set<Owner> ownerSet = ownerMapService.findAll();
    assertEquals(1, ownerSet.size());
  }

  @Test
  void deleteById() {
    ownerMapService.deleteById(OWNER_ID);
    assertEquals(0, ownerMapService.findAll().size());
  }

  @Test
  void delete() {
    ownerMapService.delete(ownerMapService.findById(OWNER_ID));
    assertEquals(0, ownerMapService.findAll().size());
  }

  @Test
  void saveExistingId() {
    Long id = 2L;
    Owner ownerSaved = ownerMapService.save(Owner.builder().id(id).build());
    assertEquals(id, ownerSaved.getId());
  }

  @Test
  void saveWithoutId() {
    Owner ownerSaved = ownerMapService.save(Owner.builder().build());
    assertNotNull(ownerSaved);
    assertNotNull(ownerSaved.getId());
  }

  @Test
  void findById() {
    Owner owner = ownerMapService.findById(OWNER_ID);
    assertEquals(OWNER_ID, owner.getId());
  }

  @Test
  void findByLastName() {
    Owner smith = ownerMapService.findByLastName(lastName);
    assertNotNull(smith);
    assertEquals(OWNER_ID,smith.getId());
  }
}
