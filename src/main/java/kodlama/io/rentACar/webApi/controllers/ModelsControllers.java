package kodlama.io.rentACar.webApi.controllers;


import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstructs.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
/*
    @GetMapping()
    public List<GetAllModelsResponse> getAll(){

        return modelService.getAll();
    };

 */

    @GetMapping("/paging")
    public Page<GetAllModelsResponse> getAll(
            @RequestParam int page,
            @RequestParam int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return modelService.getAll(pageable);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add( @Valid @RequestBody CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }

}
