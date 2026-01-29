package kodlama.io.rentACar.webApi.controllers;

import java.util.List;
import kodlama.io.rentACar.business.abstructs.BrandService;
import kodlama.io.rentACar.entities.concretes.Brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brands")
public class BrandsControllers {

    private BrandService brandService;

    @Autowired
    public BrandsControllers(BrandService brandService){
        this.brandService=brandService;

    }
    @GetMapping("/getall")
    public List<Brand> getAll(){
        return brandService.getAll();
    };
}
