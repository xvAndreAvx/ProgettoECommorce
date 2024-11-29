package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stato_ordine")
public class StatoOrdine implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "stato", nullable = false)
    private String stato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
}
