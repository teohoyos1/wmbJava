package com.wmb.project.persistence.entity;

public enum Step {
    HOME("1"),
    REGISTER("2"),
    REGISTER_NAME("2.1"),
    LOGIN("3"),
    BANK("4");
    public final String step;

    Step(String step) {
        this.step = step;
    }
}
