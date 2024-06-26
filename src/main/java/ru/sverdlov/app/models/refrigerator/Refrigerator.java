package ru.sverdlov.app.models.refrigerator;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import ru.sverdlov.app.models.Model;

@Entity
@Table(name = "Refrigerator")
public class Refrigerator {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "У холодильника должна быть модель")
    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private Model model;

    @NotNull(message = "Количество дверей в холодильнике должно быть указано")
    @Positive(message = "Количество дверей в холодильнике должно быть больше 0")
    @Column(name = "number_doors")
    private Integer numberOfDoors;

    @NotNull(message = "Тип компрессора в холодильнике должен быть указан")
    @Enumerated(EnumType.STRING)
    @Column(name = "compressor_type")
    private CompressorType compressorType;

    public Refrigerator() {}

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public CompressorType getCompressorType() {
        return compressorType;
    }

    public void setCompressorType(CompressorType compressorType) {
        this.compressorType = compressorType;
    }
}
