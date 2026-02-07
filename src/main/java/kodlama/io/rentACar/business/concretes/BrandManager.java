package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstructs.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.GetByIdResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilies.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstructs.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import kodlama.io.rentACar.entities.concretes.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BrandManager implements BrandService {

    @Autowired
   private BrandRepository brandRepository;
   private ModelMapperService modelMapperService;
   private BrandBusinessRules brandBusinessRules;

   public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService,  BrandBusinessRules brandBusinessRules ) {
            this.brandRepository = brandRepository;
            this.modelMapperService = modelMapperService;
            this.brandBusinessRules=brandBusinessRules;
   }

   /*
    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
                .collect(Collectors.toList());
        return brandsResponse;
    }*/

    @Override
    public Page<GetAllBrandsResponse> getAll(Pageable pageable) {

        Page<Brand> brands = brandRepository.findAll(pageable);

        return brands.map(brand -> modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)
        );
    }

    @Override
    public GetByIdResponse getById(int id) {
       Brand brand = this.brandRepository.findById(id).orElseThrow();
       GetByIdResponse response =this.modelMapperService.forResponse().map(brand,GetByIdResponse.class);
       return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {

       this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);

        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
       this.brandRepository.deleteById(id);

    }


}
