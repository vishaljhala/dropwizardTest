package com.code_craft.dropwizardTest.client.beacon;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import com.code_craft.dropwizardTest.dropwizardTestConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.code_craft.dropwizardTest.util.UInt64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;

public class FetchBlock implements Runnable {

  private Client client;

  private static final Logger LOGGER = LoggerFactory.getLogger(FetchBlock.class);

  @Inject
  private dropwizardTestConfiguration dropwizardTestConfig;

  public FetchBlock() {
  }

  @Override
  public void run() {
    UInt64 slotId = UInt64.valueOf(0);
    LOGGER.info("before initialize");
    initializeClient();
    LOGGER.info("after initialize");
    UInt64 maxSlotId = UInt64.valueOf(1000);
    try {
      while (true) {
        while (slotId.isLessThan(maxSlotId)) {
          String s = fetchBlock(slotId);
          //Insert in DB.
          LOGGER.info("SlotId " + s + " persisted.");
          slotId = slotId.plus(1);
        }
        try { Thread.sleep(60000);}
        catch(InterruptedException e) {
          LOGGER.info("Timer Exception");
          break;
        }
      }
    }
    finally {
      client.close();
      LOGGER.info("FetchBlock Thread terminating");
    }
  }

  private void initializeClient() {
    ClientConfig configuration = new ClientConfig();
    configuration = configuration.property(ClientProperties.CONNECT_TIMEOUT, dropwizardTestConfig.ethNode.connectionTimeout);
    configuration = configuration.property(ClientProperties.READ_TIMEOUT, dropwizardTestConfig.ethNode.readTimeout);

    client = ClientBuilder.newClient(configuration);
  }


  private String fetchBlock(UInt64 slotId) {
    try {
      String url = dropwizardTestConfig.ethNode.url + ":" + dropwizardTestConfig.ethNode.port;
      WebTarget target = client.target(url);
      String s = target.request().get(String.class);
      ObjectMapper mapper = new ObjectMapper();
      String block = mapper.readValue(s, String.class);
      return block;
    } catch (IOException e) {
      LOGGER.error("" + e);
    }
    return null;
  }
}
