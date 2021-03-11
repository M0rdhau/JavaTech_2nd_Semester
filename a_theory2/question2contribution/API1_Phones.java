package ee.ttu.cs.team12jakarta.project2.theory;


import ee.ttu.cs.team12jakarta.project2.theory.classes.Phone;

import java.util.List;

@RestController
@RequestMapping("phones")
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

    @GetMapping(value = "/")
    public List<Phone> allphones(){ return phoneService.getAllPhones() }

    @GetMapping(value = "/phone/")
    public Phone phoneById(@RequestParam String id){ return phoneService.getPhoneById(id) }

    @Getmapping(value = "/manufacturer")
    public List<Phone> phonesByManufacturer(@RequestParam String manufacturer){
        return allphones().stream().filter(each -> each.manufacturer == manufacturer).collect(Collectors.toList());
    }


    //todo theoretical assignment
    // F write pseudocode for saving a new phone (add annotations or http method names, urls, necessary parameters)
    // G write pseudocode for updating existing phone (add annotations or http method names, urls, necessary parameters)
    // H write pseudocode for deleting a phone (add annotations or http method names, urls, necessary parameters)
}
