package ee.fhir.fhirest;

import ee.fhir.fhirest.core.api.conformance.HapiValidationSupportProvider;
import org.hl7.fhir.common.hapi.validation.support.RemoteTerminologyServiceValidationSupport;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationSupportFactory {

//  @Bean
  public HapiValidationSupportProvider getRemoteTerminologyServiceValidationSupport() {
    return context -> new RemoteTerminologyServiceValidationSupport(context, "https://terminology.kodality.dev/api/fhir");
  }
}
