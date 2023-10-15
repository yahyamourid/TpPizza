package com.example.pizza.services;

import com.example.pizza.classes.Pizza;
import com.example.pizza.dao.IDao;

import java.util.ArrayList;
import java.util.List;

public class PizzaService implements IDao<Pizza> {

    private List<Pizza> pizzas;
    private static PizzaService instance;

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public static PizzaService getInstance() {
        if (instance == null)
            instance = new PizzaService();
        return instance;
    }

    public static void setInstance(PizzaService instance) {
        PizzaService.instance = instance;
    }

    public PizzaService() {
        this.pizzas = new ArrayList<>();
    }

    @Override
    public boolean create(Pizza p) {
        pizzas.add(p);
        return true;
    }

    @Override
    public boolean update(Pizza p) {
        Pizza pizza = this.findById(p.getId());
        pizza.setNom(p.getNom());
        pizza.setDuree(p.getDuree());
        pizza.setPhoto(p.getPhoto());
        return true;
    }

    ;

    @Override
    public boolean delete(Pizza p) {
        pizzas.remove(p);
        return true;
    }

    @Override
    public List<Pizza> findAll() {

        return pizzas;
    }

    @Override
    public Pizza findById(int id) {
        for (Pizza pizza : pizzas) {
            if (pizza.getId() == id)
                return pizza;
        }
        return null;
    }
}
