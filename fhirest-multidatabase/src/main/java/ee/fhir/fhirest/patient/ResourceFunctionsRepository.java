/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ee.fhir.fhirest.patient;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

//@Component
public class ResourceFunctionsRepository {
  private final JdbcTemplate adminJdbcTemplate;

  public ResourceFunctionsRepository(@Qualifier("storeAdminJdbcTemplate") JdbcTemplate adminJdbcTemplate) {
    this.adminJdbcTemplate = adminJdbcTemplate;
  }

  public void defineResource(String type) {
    adminJdbcTemplate.queryForObject("SELECT store.define_resource(?)", String.class, type);
  }
}
