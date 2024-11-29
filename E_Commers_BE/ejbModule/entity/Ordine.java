package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "ordine")
public class Ordine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "data_creazione", nullable = false)
    private Timestamp dataCreazione;

    @Column(name = "data_ultima_modifica", nullable = false)
    private Timestamp dataUltimaModifica;

    @ManyToOne
    @JoinColumn(name = "stato_ordine_id", nullable = false)
    private StatoOrdine statoOrdine;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @Column(name = "totale_da_pagare", nullable = false)
    private Double totaleDaPagare;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Timestamp dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public Timestamp getDataUltimaModifica() {
        return dataUltimaModifica;
    }

    public void setDataUltimaModifica(Timestamp dataUltimaModifica) {
        this.dataUltimaModifica = dataUltimaModifica;
    }

    public StatoOrdine getStatoOrdine() {
        return statoOrdine;
    }

    public void setStatoOrdine(StatoOrdine statoOrdine) {
        this.statoOrdine = statoOrdine;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Double getTotaleDaPagare() {
        return totaleDaPagare;
    }

    public void setTotaleDaPagare(Double totaleDaPagare) {
        this.totaleDaPagare = totaleDaPagare;
    }
}
