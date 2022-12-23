package juan.springframework.sfgpetclinic.services.springdatajpa;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import juan.springframework.sfgpetclinic.model.Owner;
import juan.springframework.sfgpetclinic.repositories.OwnerRepository;
import juan.springframework.sfgpetclinic.repositories.PetRepository;
import juan.springframework.sfgpetclinic.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

  public static final String LAST_NAME = "Smith";
  Owner returnOwner;

  @Mock
  OwnerRepository ownerRepository;

  @Mock
  PetRepository petRepository;

  @Mock
  PetTypeRepository petTypeRepository;

  @InjectMocks
  OwnerSDJpaService service;

  @BeforeEach
  void setUp() {
    returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
  }

  @Test
  void findAll() {
    Set<Owner> returnOwnersSet = new HashSet<>();
    returnOwnersSet.add(Owner.builder().id(1L).build());
    returnOwnersSet.add(Owner.builder().id(2L).build());

    when(ownerRepository.findAll()).thenReturn(returnOwnersSet);
    Set<Owner> owners = service.findAll();

    assertNotNull(owners);
    assertEquals(2,owners.size());
  }

  @Test
  void findById() {
    when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

    Owner owner = service.findById(1L);
    assertNotNull(owner);
  }

  @Test
  void findByIdNotFound() {
    when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

    Owner owner = service.findById(1L);
    assertNull(owner);
  }

  @Test
  void save() {
    Owner ownerToSave = Owner.builder().id(1L).build();
    when(ownerRepository.save(any())).thenReturn(returnOwner);

    Owner owner = service.save(ownerToSave);
    assertNotNull(owner);
  }

  @Test
  void delete() {
    service.delete(returnOwner);

    verify(ownerRepository,times(1)).delete(any());
  }

  @Test
  void deleteById() {
    service.deleteById(1L);

    verify(ownerRepository).deleteById(anyLong());
  }

  @Test
  void findByLastName() {
    when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
    Owner smith = service.findByLastName(LAST_NAME);
    assertEquals(LAST_NAME, smith.getLastName());
  }
}
