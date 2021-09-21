package com.code_craft.aether.resources;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.code_craft.aether.api.Saying;
import com.code_craft.aether.db.BlockDAO;

@Path("/helloworld")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
  private final String template;
  private final String defaultName;
  private final AtomicLong counter;

  @Inject
  private BlockDAO blockDao;
   
  @Inject
  public HelloWorldResource(String template, String defaultName) {
    this.template = template;
    this.defaultName = defaultName;
    this.counter = new AtomicLong();
  }
  
  @GET
  public Saying sayHello(@QueryParam("name") Optional<String> name) {
    return new Saying(counter.incrementAndGet(), blockDao.getAll().get(0).getVersion());
  }
  
}
