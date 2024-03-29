package juan.springframework.sfgpetclinic.boostrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import juan.springframework.sfgpetclinic.model.Owner;
import juan.springframework.sfgpetclinic.model.Pet;
import juan.springframework.sfgpetclinic.model.PetType;
import juan.springframework.sfgpetclinic.model.Speciality;
import juan.springframework.sfgpetclinic.model.Vet;
import juan.springframework.sfgpetclinic.services.OwnerService;
import juan.springframework.sfgpetclinic.services.PetTypeService;
import juan.springframework.sfgpetclinic.services.SpecialityService;
import juan.springframework.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialityService specialitiesServices;

  public DataLoader(OwnerService ownerService, VetService vetService,
      PetTypeService petTypeService, SpecialityService specialitiesServices) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
    this.specialitiesServices = specialitiesServices;
  }

  @Override
  public void run(String... args) throws Exception {
    int count = petTypeService.findAll().size();

    if (count == 0){
      loadData();
    }
  }

  private void loadData() {
    PetType dog = new PetType();
    dog.setName("Dog");
    PetType savedDogPetType = petTypeService.save(dog);

    PetType cat = new PetType();
    cat.setName("Cat");
    PetType savedCatPetType = petTypeService.save(cat);

    Speciality radiology = new Speciality();
    radiology.setDescription("Radiology");
    Speciality savedRadiology = specialitiesServices.save(radiology);

    Speciality surgery = new Speciality();
    surgery.setDescription("Surgery");
    Speciality savedSurgery = specialitiesServices.save(surgery);

    Speciality dentistry = new Speciality();
    dentistry.setDescription("Dentistry");
    Speciality savedDentistry = specialitiesServices.save(dentistry);

    Owner owner1 = new Owner();
    owner1.setFirstName("Michael");
    owner1.setLastName("Weston");
    owner1.setAddress("123 Brickerel");
    owner1.setCity("Miami");
    owner1.setTelephone("111231213");

    Pet mikesPet = new Pet();
    mikesPet.setPetType(savedDogPetType);
    mikesPet.setOwner(owner1);
    mikesPet.setBirthDate(LocalDate.now());
    mikesPet.setName("Rosco");
    owner1.getPets().add(mikesPet);

    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Fiona");
    owner2.setLastName("Glenanne");
    owner2.setAddress("123 Brickerel");
    owner2.setCity("Miami");
    owner2.setTelephone("111231213");

    Pet fionasCat = new Pet();
    fionasCat.setPetType(savedCatPetType);
    fionasCat.setOwner(owner2);
    fionasCat.setBirthDate(LocalDate.now());
    fionasCat.setName("Just Cat");
    owner2.getPets().add(fionasCat);

    ownerService.save(owner2);

    System.out.println("Loaded Owners.....");

    Vet vet1 = new Vet();
    vet1.setFirstName("Sam");
    vet1.setLastName("Axe");
    vet1.getSpecialities().add(savedRadiology);

    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setFirstName("Jessie");
    vet2.setLastName("Porter");
    vet2.getSpecialities().add(savedSurgery);

    vetService.save(vet2);

    System.out.println("Loaded Vets.....");
  }
}
