package com.code_craft.aether.client.beacon;

import javax.ws.rs.client.Client;
import com.code_craft.aether.aetherConfiguration;
import com.code_craft.aether.util.UInt64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import javax.inject.Singleton;
import com.code_craft.aether.db.BlockDAO;

@Singleton
public class FetchBlock implements Runnable {

  private Client client;

  private static final Logger LOGGER = LoggerFactory.getLogger(FetchBlock.class);

  @Inject
  aetherConfiguration aetherConfig;

  @Inject
  private BlockDAO blockDAO;

  public FetchBlock() {
  }

  @Override
  public void run() {

    // UInt64 slotId = UInt64.valueOf(blockDAO.getMaxBlockId());
  }
}
