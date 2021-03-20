package ee.taltech.a_theory2.question2contribution;


@RestController
@RequestMapping("/cake")
public class API2_Cakes {

    // done this is contribution question
    //  this assignment is only for one team member (if this code is not committed by that team member how do I know this code was theirs?)

    // done
    //  this assignment consists of 2 parts
    //  practical assignment A, B, C, D, E
    //          All classes are available in classes package
    //          If you want to test these practical assignments add these to your project.
    //          Example: If you Application.java is in the package ee.taltech, make sure theory is in package ee.taltech as well (ee.taltech.theory)
    //  theoretical assignment F, G, H

    // done practical assignment
    // Management wants to define an API endpoint so frontend can display data about cakes (think cake e-shop)
    // A Add necessary annotations to this class so this class can serve data
    // B Add a method to query all the cakes (method content is not important - I am grading urls, annotations, names, and parameters)
    // C Add a method to query a single cake by it's unique identifier (method content is not important - I am grading urls, annotations, names, and parameters)
    // D Modify an existing method to query/filter cakes by weight while keeping existing functionality
    // E Modify an existing method to query/filter cakes by name while keeping existing functionality

    @Autowired
    private CakeService cakeService;

    @GetMapping
    public List<Cake> findAll(
            @RequestParam(value = "weight", required = false) String weight,
            @RequestParam(value = "name", required = false) String name
    ) {
        // Assuming carService findAll method handles the search
        return cakeService.findAll(weight, name);
    }

    @GetMapping(value = "{id}")
    public Cake findById(@PathVariable Long id) {
        return cakeService.findById(id);
    }


    // done theoretical assignment
    // F write pseudocode for saving a new cake (add annotations or http method names, urls, necessary parameters)
    //
    @PostMapping
    public Cake save(@RequestBody cake) {
        return cakeService.save(cake);
    }

    // G write pseudocode for updating existing cake (add annotations or http method names, urls, necessary parameters)
    //
    @PutMapping("{id}")
    public Cake update(@RequestBody cake, @PathVariable Long id) {
        return cakeService.update(cake, id);
    }

    // H write pseudocode for deleting a cake (add annotations or http method names, urls, necessary parameters)
    //
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        cakeService.delete(id);
    }
}
