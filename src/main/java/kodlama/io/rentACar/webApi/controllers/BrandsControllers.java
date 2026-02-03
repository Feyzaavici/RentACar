package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstructs.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdResponse;
import kodlama.io.rentACar.entities.concretes.Brand;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brands")
public class BrandsControllers {

    private BrandService brandService;

    @Autowired
    public BrandsControllers(BrandService brandService){
        this.brandService=brandService;

    }
    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){

        return brandService.getAll();
    };

    @GetMapping("/{id}")
    public GetByIdResponse getByIdResponse( @PathVariable int id){
        return brandService.getById(id);
    }


    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@Valid @RequestBody CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }

    @PutMapping
    public void update( @RequestBody  UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);

    }

}




