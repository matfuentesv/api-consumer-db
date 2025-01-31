package cl.hospital.apiconsumerdb.repository;

import cl.hospital.apiconsumerdb.model.SignosVitales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<SignosVitales,Long> {


}
