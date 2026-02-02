package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstructs.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilies.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstructs.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
//@Data //Lombok şuan için çalışmıyor daha sonra düzeltilecek
//@AllArgsConstructor
//@NoArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    public ModelManager(ModelRepository modelRepository, ModelMapperService modelMapperService) {
        this.modelRepository = modelRepository;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public List<GetAllModelsResponse> getAll() {

        List<Model> models = this.modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponses= models.stream().map(model ->this.modelMapperService.forResponse()
                .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());

        return modelsResponses;

    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);

        this.modelRepository.save(model);
    }

    public ModelRepository getModelRepository() {
        return modelRepository;
    }

    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public ModelMapperService getModelMapperService() {
        return modelMapperService;
    }

    public void setModelMapperService(ModelMapperService modelMapperService) {
        this.modelMapperService = modelMapperService;
    }


}
