package org.io.crud.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int id;
    @NotNull
    private String name;
    @NotNull
    private int roll;
    @NotNull
    private int reg;
    @NotNull
    private String email;
    @NotNull
    private String department;
    @NotNull
    private String semester;
}
