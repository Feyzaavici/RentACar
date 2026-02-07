package kodlama.io.rentACar.business.abstructs;

import kodlama.io.rentACar.business.requests.CreateRentalRequest;
import kodlama.io.rentACar.business.requests.ReturnRentalRequest;

public interface RentalService {

    void add(CreateRentalRequest createRentalRequest);
    void returnRental(ReturnRentalRequest returnRentalRequest);

}
