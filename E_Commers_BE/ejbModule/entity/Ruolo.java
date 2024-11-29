package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ruolo")
public class Ruolo implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "ruolo", nullable = false)
    private String ruolo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }
}
