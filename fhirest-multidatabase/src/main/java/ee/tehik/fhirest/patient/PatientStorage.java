package ee.tehik.fhirest.patient;

import ee.tehik.fhirest.store.PgResourceStorage;
import org.hl7.fhir.r4.model.ResourceType;
import org.springframework.stereotype.Component;

@Component
public class PatientStorage extends PgResourceStorage {
  public PatientStorage(PatientRepository patientRepository) {
    super(patientRepository);
  }

  @Override
  public String getResourceType() {
    return ResourceType.Patient.name();
  }
}
