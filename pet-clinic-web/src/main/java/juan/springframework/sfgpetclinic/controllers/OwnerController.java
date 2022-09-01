package juan.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import juan.springframework.sfgpetclinic.services.OwnerService;
import juan.springframework.sfgpetclinic.services.map.OwnerServiceMap;

@RequestMapping("/owners")
@Controller
public class OwnerController {

  private final OwnerService ownerService;

  public OwnerController(OwnerService ownerService) {
    this.ownerService = ownerService;
  }

  @RequestMapping({ "", "/", "/index", "/index.html" })
  public String listOwners(Model model) {

    model.addAttribute("owners", ownerService.findAll());
    System.out.println("Owners size " + ownerService.findAll().size());
    return "owners/index";
  }
}
