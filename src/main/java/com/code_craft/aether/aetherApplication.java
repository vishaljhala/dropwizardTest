package com.code_craft.aether;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class aetherApplication extends Application<aetherConfiguration> {

  public static void main(final String[] args) throws Exception {
    new aetherApplication().run(args);
  }

  @Override
  public String getName() {
    return "aether";
  }

  @Override  
  public void initialize(final Bootstrap<aetherConfiguration> bootstrap) {
     bootstrap.addBundle(GuiceBundle.builder().enableAutoConfig(getClass().getPackage().getName()).modules(new aetherModule()).build());
  }

  @Override
  public void run(final aetherConfiguration configuration, final Environment environment) {
  }
}
