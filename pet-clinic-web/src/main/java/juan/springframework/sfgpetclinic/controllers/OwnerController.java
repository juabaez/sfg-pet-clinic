package juan.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import juan.springframework.sfgpetclinic.model.Owner;
import juan.springframework.sfgpetclinic.services.OwnerService;
import juan.springframework.sfgpetclinic.services.map.OwnerServiceMap;

@RequestMapping("/owners")
@Controller
public class OwnerController {

  private final OwnerService ownerService;

  public OwnerController(OwnerService ownerService) {
    this.ownerService = ownerService;
  }

  @InitBinder
  public void setAllowFields(WebDataBinder dataBinder) {
    dataBinder.setDisallowedFields("id");
  }

  @RequestMapping({ "", "/", "/index", "/index.html" })
  public String listOwners(Model model) {
    model.addAttribute("owners", ownerService.findAll());
    System.out.println("Owners size " + ownerService.findAll().size());
    return "owners/index";
  }

  @RequestMapping("/find")
  public String findOwners() {
    return "notimplemented";
  }

  @GetMapping("/{ownerId}")
  public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
    ModelAndView mav = new ModelAndView("owners/ownerDetails");
    Owner owner = ownerService.findById(ownerId);
    mav.addObject(owner);
    return mav;
  }
}
