package com.code_craft.dropwizardTest.datastructures.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EthNode {
    public EthNode() {
    }
  @JsonProperty
  public String url;

  @JsonProperty
  public int port;

  @JsonProperty
  public int connectionTimeout;

  @JsonProperty
  public int readTimeout;
}
