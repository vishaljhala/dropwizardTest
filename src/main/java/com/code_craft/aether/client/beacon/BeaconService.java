package com.code_craft.aether.client.beacon;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.lifecycle.Managed;

@Singleton
public class BeaconService implements Managed {

  private final ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
  private static final Logger LOGGER = LoggerFactory.getLogger(BeaconService.class);

  public BeaconService() {
  }

  @Inject
  private FetchBlock fetchBlock;

  @Override
  public void start() throws Exception {
    LOGGER.info("BeaconService Started");
    //service.schedule(fetchBlock, 1, TimeUnit.SECONDS);
  }

  @Override
  public void stop() throws Exception {
    LOGGER.info("BeaconService stopped");
    service.shutdown();
  }
}
