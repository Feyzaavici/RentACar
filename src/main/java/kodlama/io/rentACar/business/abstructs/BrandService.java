package kodlama.io.rentACar.business.abstructs;

import kodlama.io.rentACar.entities.concretes.Brand;
import java.util.List;

public interface BrandService {
    List<Brand> getAll();
}
