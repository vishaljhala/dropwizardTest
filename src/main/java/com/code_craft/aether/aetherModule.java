package com.code_craft.aether;

import io.dropwizard.Configuration;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;
import io.dropwizard.setup.Environment;
import javax.inject.Singleton;
import com.google.inject.Provides;
import org.jdbi.v3.core.Jdbi;
import io.dropwizard.jdbi3.JdbiFactory;
import com.code_craft.aether.db.BlockDAO;

public class aetherModule extends DropwizardAwareModule<aetherConfiguration> {

  @Override
  protected void configure() {
    configuration();
    environment();
    bootstrap();
  }

  @Provides
  @Singleton
  Jdbi getJdbi(aetherConfiguration config, Environment environment) {
      Jdbi jdbi = new JdbiFactory().build(environment, config.getDataSourceFactory(), "postgresql");
      jdbi.onDemand(BlockDAO.class);
      return jdbi;
  }
}
