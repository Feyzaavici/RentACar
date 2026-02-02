package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.dataAccess.abstructs.BrandRepository;
import kodlama.io.rentACar.core.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class BrandBusinessRules {

    private BrandRepository brandRepository;

    public BrandBusinessRules(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void checkIfBrandNameExists(String name){
        if(this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand already exists.");
        }

    }


}
