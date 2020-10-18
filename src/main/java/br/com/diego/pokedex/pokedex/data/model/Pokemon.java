package br.com.diego.pokedex.pokedex.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pokemon {

    @Id
    private String id;

    private String name;
    private String category;
    private String habilities;
    private Double weight;

    public Pokemon(String name, String category, String habilities, Double weight) {
        this.name = name;
        this.category = category;
        this.habilities = habilities;
        this.weight = weight;
    }

    public Pokemon(Pokemon pokemon){
        this.name = pokemon.getName();
        this.category = pokemon.getCategory();
        this.habilities = pokemon.getHabilities();
        this.weight = pokemon.getWeight();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHabilities() {
        return habilities;
    }

    public void setHabilities(String habilities) {
        this.habilities = habilities;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", habilities='" + habilities + '\'' +
                ", weight=" + weight +
                '}';
    }


}
