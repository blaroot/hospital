package ma.enset.hospital.entities.repositories;

import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezvousRepository extends JpaRepository<RendezVous,String> {
}
