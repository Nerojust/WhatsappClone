package com.example.lessonproject.models;

public class CountriesModel {

    private String name;
    private String description;
    private String continent;
    private String countryImage;

    public CountriesModel(String name, String description, String continent, String countryImage) {
        this.name = name;
        this.description = description;
        this.continent = continent;
        this.countryImage = countryImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountryImage() {
        return countryImage;
    }

    public void setCountryImage(String countryImage) {
        this.countryImage = countryImage;
    }
}
