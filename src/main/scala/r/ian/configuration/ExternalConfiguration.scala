package r.ian.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

/**
 * Created by: mSmith
 * Date: 10.02.2022
 */
//@Configuration
//@ConfigurationProperties("app")
class ExternalConfiguration{

  @Value("${app.name}")
  var name: String = _

  @Value("${app.beanJobName}")
  var beanJobName: String = _

}
