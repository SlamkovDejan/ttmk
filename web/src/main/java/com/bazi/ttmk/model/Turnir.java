package com.bazi.ttmk.model;

import com.bazi.ttmk.web.FaziController;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(TurnirId.class)
@Table(
        name = "turniri",
        uniqueConstraints = @UniqueConstraint(columnNames = {"ime_turnir", "id_sezona", "data_na_odrzhuvanje", "id_kategorija"}),
        schema = "project"
)
public class Turnir implements java.io.Serializable {

    @Id
    @Column(name = "id_turnir", nullable = false, columnDefinition="serial")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project.turniri_id_turnir_seq")
    private int idTurnir;

    @Id
    @Column(name = "id_kategorija", nullable = false)
    private int idKategorija;

    @Column(name = "ime_turnir", nullable = false, length = 50)
    private String imeTurnir;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_na_odrzhuvanje", nullable = false, length = 13)
    private Date dataNaOdrzhuvanje;

    @Column(name = "participacija", nullable = false)
    private int participacija;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kategorija", nullable = false, insertable = false, updatable = false)
    private Kategorija kategorija;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sala", nullable = false)
    private Sala salaNaOdrzuvanje;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sezona", nullable = false)
    @JsonIgnore
    private Sezona sezona;

    @OneToMany(mappedBy = "turnir")
    @JsonIgnore
    private List<Faza> fazi;

}