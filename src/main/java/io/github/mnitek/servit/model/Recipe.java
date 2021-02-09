package io.github.mnitek.servit.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Pole Nazwa nie może być puste")
    private String name;
    @Pattern(regexp = "^[0-9]:[0-5][0-9]$", message = "Czas przygotowania musi być w formacie H:mm")
    private String timeToPrepare;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredients = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<Step> steps = new ArrayList<>();
    private boolean planned;
    private LocalDateTime createdAt;

    public Recipe() {
        steps.add(new Step());
        ingredients.add(new Ingredient());
    }

    /*
    public Recipe(String name) {
        this.name = name;
    }
     */

    @PrePersist
    public void setCreatedAt() {
        createdAt = LocalDateTime.now();
    }
}
