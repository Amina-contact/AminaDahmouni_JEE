package ma.enset.hospital.Service;
import ma.enset.hospital.Entities.Consultation;
import ma.enset.hospital.Entities.Medecin;
import ma.enset.hospital.Entities.Patient;
import ma.enset.hospital.Entities.RendezVous;
public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}

