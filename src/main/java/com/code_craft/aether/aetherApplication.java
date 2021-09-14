package com.code_craft.aether;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
// import com.code_craft.aether.core.*;
import ru.vyarus.dropwizard.guice.GuiceBundle;
// import io.dropwizard.hibernate.HibernateBundle;
// import io.dropwizard.db.DataSourceFactory;
// import com.code_craft.aether.db.AetherDBSessionFactory;

public class aetherApplication extends Application<aetherConfiguration> {

  public static void main(final String[] args) throws Exception {
    new aetherApplication().run(args);
  }


  // private final HibernateBundle<aetherConfiguration> hibernate = new HibernateBundle<aetherConfiguration>(Block.class) {
  //   @Override
  //   public DataSourceFactory getDataSourceFactory(aetherConfiguration configuration) {
  //     return configuration.getDataSourceFactory();
  //   }
  // };

  @Override
  public String getName() {
    return "aether";
  }

  @Override
  public void initialize(final Bootstrap<aetherConfiguration> bootstrap) {
    bootstrap.addBundle(
        GuiceBundle.builder().enableAutoConfig(getClass().getPackage().getName()).modules(new aetherModule()).build());
    // bootstrap.addBundle(hibernate);
  }

  @Override
  public void run(final aetherConfiguration configuration, final Environment environment) {
    // AetherDBSessionFactory dbFactory = new AetherDBSessionFactory();
    // dbFactory.setSessionFactory(hibernate.getSessionFactory());
  }
}
