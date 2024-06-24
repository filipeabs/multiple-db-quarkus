package dev.filipeabs.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "INFORMACOES", schema = "MYDB")
public class SecondDb implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public int id;

    @Column(name = "FIELD")
    public String field;

    @Column(name = "TS_STAMP")
    public LocalDateTime tsStamp = LocalDateTime.now();
}
