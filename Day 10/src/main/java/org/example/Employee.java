package org.example;

import jakarta.persistence.*;
import org.hibernate.Length;

@Entity
@Table(name = "emp_table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id" )
    private int id;
    @Column(name = "emp_name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
