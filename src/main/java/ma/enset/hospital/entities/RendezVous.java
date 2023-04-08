package ma.enset.hospital.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Data @AllArgsConstructor@NoArgsConstructor
public class RendezVous {
    @Id

    private  String id;

    private Date date;
    @Enumerated(EnumType.STRING)
    private statusRDV status;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;

}
