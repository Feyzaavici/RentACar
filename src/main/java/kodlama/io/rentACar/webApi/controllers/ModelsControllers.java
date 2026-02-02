package kodlama.io.rentACar.webApi.controllers;


import kodlama.io.rentACar.business.abstructs.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelsControllers {

    private ModelService modelService;

    public ModelsControllers(ModelService modelService){
        this.modelService=modelService;

    }

    @GetMapping()
    public List<GetAllModelsResponse> getAll(){

        return modelService.getAll();
    };

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add( @RequestBody CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }

}
