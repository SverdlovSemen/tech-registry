package ru.sverdlov.app.models.smartphone;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import ru.sverdlov.app.models.Model;

@Entity
@Table(name = "Smartphone")
public class Smartphone {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "У смартфона должна быть модель")
    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private Model model;

    @NotNull(message = "Память в телефоне должна быть указана")
    @Positive(message = "Память в телефоне должна быть больше 0")
    @Column(name = "memory")
    private Integer memory;

    @NotNull(message = "Количество камер в телефоне должно быть указано")
    @Positive(message = "Количество камер в телефоне должно быть больше 0")
    @Column(name = "number_cameras")
    private Integer numberOfCameras;

    public Smartphone(){}

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Integer getNumberOfCameras() {
        return numberOfCameras;
    }

    public void setNumberOfCameras(Integer numberOfCameras) {
        this.numberOfCameras = numberOfCameras;
    }
}
