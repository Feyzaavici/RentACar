package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstructs.RentalService;
import kodlama.io.rentACar.business.requests.CreateRentalRequest;

import kodlama.io.rentACar.business.requests.ReturnRentalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals")
public class RentalsControllers {
    private RentalService rentalService;

    @Autowired
    public RentalsControllers(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    void add(@RequestBody CreateRentalRequest createRentalRequest){
        this.rentalService.add(createRentalRequest);
    }

    @PostMapping("/return")
    @ResponseStatus(HttpStatus.OK)
    public void returnRental(@RequestBody ReturnRentalRequest returnRentalRequest){
        this.rentalService.returnRental(returnRentalRequest);

    }



}
