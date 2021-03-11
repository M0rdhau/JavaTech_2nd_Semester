package ee.ttu.cs.team12jakarta.project2.theory;


import ee.ttu.cs.team12jakarta.project2.theory.classes.Phone;

import java.util.List;

@RestController
@RequestMapping("phones/API")
public class API1_Phones {

    // todo this is contribution question
    //  this assignment is only for one team member (if this code is not committed by that team member how do I know this code was theirs?)

    // todo
    //  this assignment consists of 2 parts
    //  practical assignment A, B, C, D, E
    //     * All classes are available in classes package
    //     * If you want to test these practical assignments add these to your project.
    //       Example: If you Application.java is in the package ee.taltech, make sure theory is in package ee.taltech as well (ee.taltech.theory)
    //  theoretical assignment F, G, H

    //todo practical assignment
    // Management wants to define an API endpoint so frontend can display data about phones (think phone e-shop)
    // A Add necessary annotations to this class so this class can serve data
    // B Add a method to query all the phones (method content is not important - I am grading urls, annotations, names, and parameters)
    // C Add a method to query a single phone by it's unique identifier (method content is not important - I am grading urls, annotations, names, and parameters)
    // D Modify an existing method to query/filter phones by manufacturer while keeping existing functionality
    // E Modify an existing method to query/filter phones by release year while keeping existing functionality

    @Autowired
    private PhoneService phoneService;

    //Assuming that phoneService will handle empty strings
    @GetMapping(value = "/all")
    public List<Phone> allphones(@RequestParam String manufacturer, @RequestParam String year){
        return phoneService.getAllPhones(manufacturer.orElse(""), year.orElse(""))
    }

    //assuming phoneService will convert the id to Long in the method
    @GetMapping(value = "/phone")
    public Phone phoneById(@RequestParam String id){ return phoneService.getPhoneById(id) }


    //todo theoretical assignment
    // F write pseudocode for saving a new phone (add annotations or http method names, urls, necessary parameters)
    //  Assuming that JSON list will automatically get converted to local dto
    //  @Postmapping(value = "/")
    //  public Phone addPhone(@RequestParam Phone phone){
    //    return phoneService.addPhone(phone);
    //   }
    // G write pseudocode for updating existing phone (add annotations or http method names, urls, necessary parameters)
    //  phoneService finds the phone listing by updatePhone.id in the database and updates it
    //  @Putmapping(value = "/phone")
    //  public Phone updatePhone(@RequestParam Phone updatedPhone){
    //      return phoneService.updatePhone(updatedPhone);
    //  }
    // H write pseudocode for deleting a phone (add annotations or http method names, urls, necessary parameters)
    //  need to respond with "200 - OK" on deletion or "400 - BAD REQUEST" if phone is not found
    //  @Deletemapping(value = "/phone")
    //  public Response deletePhone(@RequestParam String id){
    //      return phoneService.deletePhone(id);
    //  }
}
