package com.glb.practice.lab_4.model;

import java.util.ArrayList;
import java.util.List;

import com.glb.practice.lab_4.controller.Observer;

public interface Observable {
    List<Observer> observers = new ArrayList<>();

    default void addObserver(Observer observer) {
        observers.add(observer);
    }

    default void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    default void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
