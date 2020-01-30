package com.bazi.ttmk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "mechevi",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id_lice_igrach_domakjin", "id_lice_igrach_gostin", "faza_id_turnir", "faza_id_kategorija", "faza_reden_broj"}),
                @UniqueConstraint(columnNames = {"id_lice_igrach_domakjin", "id_lice_igrach_gostin", "id_natprevar"})},
        schema = "project"
)
public class Mech implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mech", unique = true, nullable = false)
    private int idMech;

    @Column(name = "dobieni_setovi_domakjin")
    private int dobieniSetoviDomakjin;

    @Column(name = "dobieni_setovi_gostin")
    private int dobieniSetoviGostin;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_lice_igrach_domakjin", nullable = false)
    private Igrach domakjinIgrach;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_lice_igrach_gostin", nullable = false)
    private Igrach gostinIgrach;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_lice_sudija")
    private Sudija sudija;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "faza_id_turnir", referencedColumnName = "id_turnir", insertable = false, updatable = false),
            @JoinColumn(name = "faza_id_kategorija", referencedColumnName = "id_kategorija", insertable = false, updatable = false),
            @JoinColumn(name = "faza_reden_broj", referencedColumnName = "reden_broj", insertable = false, updatable = false)
    })
    private Faza faza;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_natprevar")
    private Natprevar natprevar;

    @OneToMany(mappedBy = "idSet", fetch = FetchType.EAGER)
    private List<Set> setovi;

}