package ma.enset.hospital;

import ma.enset.hospital.entities.*;
import ma.enset.hospital.entities.repositories.ConsultationRepository;
import ma.enset.hospital.entities.repositories.MedecinRepository;
import ma.enset.hospital.entities.repositories.PatientRepository;
import ma.enset.hospital.entities.repositories.RendezvousRepository;
import ma.enset.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication  {

	public static void main(String[] args) {

		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
CommandLineRunner start(IHospitalService hospitalService,PatientRepository patientRepository,RendezvousRepository rendezvousRepository,ConsultationRepository consultationRepository,MedecinRepository medecinRepository) {
		return arg -> {

			Stream.of("Mohamed", "Hassan", "Najat")
					.forEach(name -> {
						Patient patient = new Patient();
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						hospitalService.savePatient(patient);
					});
			Stream.of("Lahlou", "Berada", "Andaloussi")
					.forEach(name -> {
						Medecin  medecin= new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name+"@gmail.com");
						medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
						hospitalService.saveMedecin(medecin);

					});
			Patient patient=patientRepository.findById(1L).orElse(null);
			Patient patient1=patientRepository.findByNom("Mohamed");
			Medecin medecin=medecinRepository.findByNom("Lahlou");
			RendezVous rendezVous=new RendezVous();
			rendezVous.setStatus(statusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
		    RendezVous SaveRDV=hospitalService.saveRDV(rendezVous);
			System.out.println(SaveRDV.getId());
			RendezVous rendezVous1=rendezvousRepository.findAll().get(0);
			Consultation consultation=new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de la consultation....");
			hospitalService.saveConsultation(consultation);
		};
	}}
