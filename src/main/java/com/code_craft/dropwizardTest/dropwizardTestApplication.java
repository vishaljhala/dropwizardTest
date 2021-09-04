package com.code_craft.dropwizardTest;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.code_craft.dropwizardTest.resources.HelloWorldResource;
import com.code_craft.dropwizardTest.health.TemplateHealthCheck;
import com.code_craft.dropwizardTest.client.beacon.BeaconService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
// import ru.vyarus.dropwizard.guice.GuiceBundle;

public class dropwizardTestApplication extends Application<dropwizardTestConfiguration> {

  public static void main(final String[] args) throws Exception {
    new dropwizardTestApplication().run(args);
  }

  @Override
  public String getName() {
    return "dropwizardTest";
  }

  @Override
  public void initialize(final Bootstrap<dropwizardTestConfiguration> bootstrap) {
    // bootstrap.addBundle(GuiceBundle.builder()
    //                     .enableAutoConfig(getClass().getPackage().getName())
    //                     .modules(new dropwizardTestModule())
    //                     .build());
  }

  @Override
  public void run(final dropwizardTestConfiguration configuration, final Environment environment) {
    environment
      .jersey()
      .register(
        new AbstractBinder() {
          @Override
          protected void configure() {
            bind(configuration);
          }
        }
        );


    environment.jersey().register(configuration);
    environment.lifecycle().manage(new BeaconService());
  }
}
