package ee.fhir.fhirest.patient;

import ee.fhir.fhirest.store.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PatientRepository extends ResourceRepository {

  public PatientRepository(@Qualifier("patientStoreAppJdbcTemplate") JdbcTemplate jdbcTemplate) {
    super(jdbcTemplate);
  }
}
