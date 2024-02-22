package ee.fhir.fhirest.medication;

import ee.fhir.fhirest.rest.BaseFhirResourceServer;
import ee.fhir.fhirest.rest.model.FhirestRequest;
import ee.fhir.fhirest.rest.model.FhirestResponse;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Medication;
import org.hl7.fhir.r5.model.ResourceType;
import org.springframework.stereotype.Component;

@Component
public class MedicationController extends BaseFhirResourceServer {

  @Override
  public String getTargetType() {
    return ResourceType.Medication.name();
  }

  @Override
  public FhirestResponse read(FhirestRequest req) {
    Medication med = new Medication();
    med.setCode(new CodeableConcept().addCoding(new Coding().setCode("dummy")));
    med.setId(req.getPath());
    return new FhirestResponse(200, med);
  }

  @Override
  public FhirestResponse searchCompartment(FhirestRequest req) {
    return null;
  }
}
