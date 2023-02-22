package com.ziwei.midtermpart2.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "student")
public class ProcessorEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "processor_name")
    private String processorName = "";

    @Column(name = "manu_facture")
    private String manuFacture = "";

    @Column(name = "Windows_11_ready")
    private Boolean supportWindows = false;

}
