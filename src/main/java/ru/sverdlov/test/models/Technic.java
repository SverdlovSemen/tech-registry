package ru.sverdlov.test.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Technic")
public class Technic {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 3, max = 100, message = "Название техники должно быть в пределах от 3 до 100 символов")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Страна производитель не должна быть пустой")
    @Size(min = 3, max = 100, message = "Страна производитель должна быть от 3 до 100 символов")
    @Column(name="country_origin")
    private String countryOfOrigin;

    @NotEmpty(message = "Фирма производитель не должна быть пустой")
    @Size(min = 3, max = 100, message = "Страна производитель должна быть от 3 до 100 символов")
    @Column(name="manufacturer")
    private String manufacturer;

    @NotNull(message = "Возможность заказа онлайн должна быть указана")
    @Column(name = "is_possible_order_online")
    private Boolean isPossibleOrderOnline;

    @NotNull(message = "Фирма производитель должна быть указана")
    @Column(name = "is_possible_make_installments")
    private Boolean isPossibleMakeInstallments;

    @OneToMany(mappedBy = "technic")
    private List<Model> models;

    public Technic(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Boolean getPossibleOrderOnline() {
        return isPossibleOrderOnline;
    }

    public void setPossibleOrderOnline(Boolean possibleOrderOnline) {
        isPossibleOrderOnline = possibleOrderOnline;
    }

    public Boolean getPossibleMakeInstallments() {
        return isPossibleMakeInstallments;
    }

    public void setPossibleMakeInstallments(Boolean possibleMakeInstallments) {
        isPossibleMakeInstallments = possibleMakeInstallments;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}
