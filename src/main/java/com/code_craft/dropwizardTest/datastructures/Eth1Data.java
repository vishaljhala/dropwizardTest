package com.code_craft.dropwizardTest.datastructures;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Eth1Data {
  @JsonProperty
    public String deposit_root;
    @JsonProperty
    public String deposit_count;
    @JsonProperty
    public String block_hash;
}

