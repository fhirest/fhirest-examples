package ee.tehik.fhirest.patient;

import ee.tehik.fhirest.PgTransactionManager;
import ee.tehik.fhirest.SpringLiquibaseBuilder;
import javax.sql.DataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class PatientDatabaseConfig {

  @Bean
  @ConfigurationProperties("spring.datasource.patient-store-app")
  public DataSourceProperties patientStoreAppDataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean
  public DataSource patientStoreAppDataSource() {
    return patientStoreAppDataSourceProperties().initializeDataSourceBuilder().build();
  }

  @Bean
  public JdbcTemplate patientStoreAppJdbcTemplate() {
    return new JdbcTemplate(patientStoreAppDataSource());
  }

  @Bean
  public PgTransactionManager patientStoreAppTransactionManager() {
    return new PgTransactionManager(patientStoreAppDataSource());
  }

  @Bean
  @ConfigurationProperties("spring.datasource.patient-store-admin")
  public DataSourceProperties patientStoreAdminDataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean
  public DataSource patientStoreAdminDataSource() {
    return patientStoreAdminDataSourceProperties().initializeDataSourceBuilder().build();
  }

  @Bean
  public JdbcTemplate patientStoreAdminJdbcTemplate() {
    return new JdbcTemplate(patientStoreAdminDataSource());
  }


  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.patient-store-admin.liquibase")
  public LiquibaseProperties patientStoreAdminLiquibaseProperties() {
    return new LiquibaseProperties();
  }

  @Bean
  public SpringLiquibase patientStoreAdminLiquibase(@Qualifier("patientStoreAdminDataSource") DataSource dataSource,
                                                    @Qualifier("patientStoreAdminLiquibaseProperties") LiquibaseProperties properties) {
    return SpringLiquibaseBuilder.build(dataSource, properties);
  }

}
