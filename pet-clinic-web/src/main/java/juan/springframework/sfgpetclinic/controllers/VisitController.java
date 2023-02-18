package juan.springframework.sfgpetclinic.controllers;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import juan.springframework.sfgpetclinic.model.Owner;
import juan.springframework.sfgpetclinic.model.Pet;
import juan.springframework.sfgpetclinic.model.Visit;
import juan.springframework.sfgpetclinic.services.OwnerService;
import juan.springframework.sfgpetclinic.services.PetService;
import juan.springframework.sfgpetclinic.services.VisitService;

@Controller
public class VisitController {
  private final OwnerService ownerService;
  private final PetService petService;
  private final VisitService visitService;

  public VisitController(OwnerService ownerService, PetService petService,
      VisitService visitService) {
    this.ownerService = ownerService;
    this.petService = petService;
    this.visitService = visitService;
  }

  @InitBinder
  public void setAllowedFields(WebDataBinder dataBinder) {
    dataBinder.setDisallowedFields("id");

    dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
      @Override
      public void setAsText(String text) {
        setValue(LocalDate.parse(text));
      }
    });
  }

  /**
   * Called before each and every @RequestMapping annotated method. 2 goals: - Make sure
   * we always have fresh data - Since we do not use the session scope, make sure that
   * Pet object always has an id (Even though id is not part of the form fields)
   *
   * @param petId
   * @return Pet
   */
  @ModelAttribute("visit")
  public Visit loadPetWithVisit(@PathVariable("ownerId") Long ownerId, @PathVariable("petId") Long petId,
      Map<String, Object> model) {
    Owner owner = ownerService.findById(ownerId);
    Pet pet = petService.findById(petId);
    model.put("pet", pet);
    model.put("owner", owner);
    Visit visit = new Visit();
    pet.getVisits().add(visit);
    visit.setPet(pet);
    return visit;
  }

  // Spring MVC calls method loadPetWithVisit(...) before initNewVisitForm is
  // called
  @GetMapping("/owners/{ownerId}/pets/{petId}/visits/new")
  public String initNewVisitForm(@PathVariable("petId") int petId, Map<String, Object> model) {
    return "pets/createOrUpdateVisitForm";
  }

  // Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is
  // called
  @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
  public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
    if (result.hasErrors()) {
      return "pets/createOrUpdateVisxºitForm";
    } else {
      visitService.save(visit);
      return "redirect:/owners/{ownerId}";
    }
  }
}
