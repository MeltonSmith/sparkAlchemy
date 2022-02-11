package r.ian.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.{Configuration, PropertySource}

/**
 * Created by: mSmith
 * Date: 10.02.2022
 */
@Configuration
@PropertySource(Array("application.yaml"))
class ConfigurationProperties{

  @Value("${app.name}")
  var appName: String = _
}
