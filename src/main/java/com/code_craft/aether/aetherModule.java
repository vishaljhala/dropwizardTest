package com.code_craft.aether;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jdbi.v3.core.Jdbi;

import com.code_craft.aether.db.BlockDAO;
import com.google.inject.Provides;

import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

public class aetherModule extends DropwizardAwareModule<aetherConfiguration> {

	@Override
	protected void configure() {

	}

	@Provides
	@Singleton
	Jdbi getJdbi(aetherConfiguration config, Environment environment) {
		Jdbi jdbi = new JdbiFactory().build(environment, config.getDataSourceFactory(), "aether");
		environment.jersey().register(jdbi);
		return jdbi;
	}

	@Provides
	@Inject
	BlockDAO getBlockDao(Jdbi jdbi) {
		return jdbi.onDemand(BlockDAO.class);
	}
	  
}
