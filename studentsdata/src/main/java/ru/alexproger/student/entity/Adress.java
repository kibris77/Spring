package ru.alexproger.student.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "Adresses")
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "street")
    private String street;

    @Column(name = "home")
    private int home;

    @OneToOne (mappedBy="adress")
    private Student student;

    public Adress(String street, int home) {
        this.street = street;
        this.home = home;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adress)) return false;
        Adress adress = (Adress) o;
        return id == adress.id &&
                home == adress.home &&
                Objects.equals(street, adress.street) &&
                Objects.equals(student, adress.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, home, student);
    }
}
