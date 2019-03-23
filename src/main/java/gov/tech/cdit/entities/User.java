package gov.tech.cdit.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private double salary;
}
