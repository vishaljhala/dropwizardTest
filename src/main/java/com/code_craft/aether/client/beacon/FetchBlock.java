package com.code_craft.aether.client.beacon;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.client.Client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.code_craft.aether.aetherConfiguration;
import com.code_craft.aether.db.BlockDAO;

import io.dropwizard.lifecycle.Managed;

@Singleton
public class FetchBlock implements Managed {

  private static final Logger LOGGER = LoggerFactory.getLogger(FetchBlock.class);

  private Client client;
  
  @Inject
  BlockDAO blockDao;

  @Inject
  public FetchBlock() {
	  
  }

  @Override
  public void start() throws Exception {
    LOGGER.info("BeaconService Started");
    System.out.println(">>>>>>>>>>>>" + blockDao.getAll().get(0).getVersion());
  }

  @Override
  public void stop() throws Exception {
    LOGGER.info("BeaconService stopped");
   // service.shutdown();
  }

}
