package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstructs.BrandService;
import kodlama.io.rentACar.dataAccess.abstructs.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BrandManager implements BrandService {

    @Autowired
    private BrandRepository brandRepository;
    public BrandManager(BrandRepository brandRepository){
        super();
        this.brandRepository=brandRepository;
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }
}
