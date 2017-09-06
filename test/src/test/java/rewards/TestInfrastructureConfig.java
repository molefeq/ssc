package rewards;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import config.RewardsConfig;

@Configuration
@Import({
	TestInfrastructureDevConfig.class,
	TestInfrastructureProductionConfig.class,
	RewardsConfig.class })
@Profile("jdbc-production")
public class TestInfrastructureConfig {

	public LoggingBeanPostProcessor loggingBean(){
		return new LoggingBeanPostProcessor();
	}
}
