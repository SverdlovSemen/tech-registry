package ru.sverdlov.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sverdlov.test.models.Model;
import ru.sverdlov.test.repositories.ModelRepository;
import ru.sverdlov.test.models.util.utilModel.ModelNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {
    private final ModelRepository modelRepository;

    @Autowired
    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public List<Model> findAll(){
        return modelRepository.findAll();
    }

    public Model findOne(int id){
        Optional<Model> model = modelRepository.findById(id);
        return model.orElseThrow(ModelNotFoundException::new);
    }

    public Optional<Model> findOne(Model foundModel){
        return modelRepository.findOneByNameAndColorAndSizeAndPriceAndIsAvailableAndTechnic(
                foundModel.getName(),
                foundModel.getColor(),
                foundModel.getSize(),
                foundModel.getPrice(),
                foundModel.getAvailable(),
                foundModel.getTechnic()
        );
    }

    public void save(Model model){
        modelRepository.save(model);
    }
}
