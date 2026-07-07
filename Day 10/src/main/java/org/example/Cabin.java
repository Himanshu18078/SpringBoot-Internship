package org.example;

import jakarta.persistence.*;

@Entity
public class Cabin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cabin_id")
    private int cabinId;

    @Column(name = "cabin_name")
    private String cabinName;

    // ============================================================
    // GETTERS
    // ============================================================

    public int getCabinId() {
        return cabinId;
    }

    public String getCabinName() {
        return cabinName;
    }


    // ============================================================
    // SETTERS
    // ============================================================

    public void setCabinId(int cabinId) {
        this.cabinId = cabinId;
    }

    public void setCabinName(String cabinName) {
        this.cabinName = cabinName;
    }

}