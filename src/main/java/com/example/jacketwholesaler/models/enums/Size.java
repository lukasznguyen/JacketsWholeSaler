package com.example.jacketwholesaler.models.enums;

public enum Size {
    S(1), M(2), L(3), XL(4);

    private int id;

    Size(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
