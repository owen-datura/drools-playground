package io.datura.java.drools.calltest.rules;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfiguration {
	private static final String callLogic = "rules/call_ranking.drl";

	@Bean
	public KieContainer getKieContainer() {
		KieServices kieSvcs = KieServices.Factory.get();
		KieFileSystem kieFileSystem = kieSvcs.newKieFileSystem();
		// load the ranking logic file into the filesystem
		kieFileSystem.write(ResourceFactory.newClassPathResource(callLogic));
		KieBuilder kieBuilder = kieSvcs.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();
		KieModule kieModule = kieBuilder.getKieModule();

		return kieSvcs.newKieContainer(kieModule.getReleaseId());
	}
}
