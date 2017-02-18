package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Model;

import java.util.List;

/**
 * Created by Admin on 25.01.2017.
 */
public class Controller {

    private Model model;

    public Controller(Model model) {
        if (model == null)
            throw new IllegalArgumentException();
        this.model = model;
    }

    public <T> List<T> userQuery(String cityName)
    {
        return model.userQuery(cityName);
    }
}
