package kodlama.io.rentACar.business.abstructs;

import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ModelService {
    //List<GetAllModelsResponse> getAll();
    Page<GetAllModelsResponse> getAll(Pageable pageable);
    void add(CreateModelRequest createModelRequest);
}
