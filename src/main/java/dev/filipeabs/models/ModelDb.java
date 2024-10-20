package dev.filipeabs.models;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "INFORMACOES", schema = "MYDB")
public class ModelDb implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_entity_id_seq")
    @SequenceGenerator(name = "my_entity_id_seq", sequenceName = "INFORMACOES_SEQ", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    public int id;

    @Column(name = "FIELD")
    public String field;

    @Column(name = "TS_STAMP")
    public LocalDateTime tsStamp = LocalDateTime.now();
}
