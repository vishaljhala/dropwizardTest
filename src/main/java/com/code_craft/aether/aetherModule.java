package com.code_craft.aether;

import io.dropwizard.Configuration;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

public class aetherModule extends DropwizardAwareModule<aetherConfiguration> {

  @Override
  protected void configure() {
    configuration();
    environment();
    bootstrap();
  }
}
