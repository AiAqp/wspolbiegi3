package com.wspolbiegi;

public class HWRecord {
    private final int id;
    private double height;
    private double weight;

    public HWRecord(int id, double height, double weight) {
        this.id = id;
        this.height = height;
        this.weight = weight;
    }

    public void toMetric() {
        this.height = this.height*0.0254;
        this.weight = this.weight*0.45359237;
    }

    public int getID() {
        return this.id;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getBMI() {
        return this.weight/(this.height*this.height);
    }

}
