package com.johanlindkvist.rehapp;

public class Exercise {
    private String name;
    private double weight;
    private int reps;
    private int sets;

    public Exercise(String name, double weight, int reps, int sets) {
        this.name = name;
        this.weight = weight;
        this.reps = reps;
        this.sets = sets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }
}
