package com.code_craft.aether.core;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "blocks")
public class Block {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  public long pk;

  @Column(columnDefinition= "TIMESTAMP WITHOUT TIME ZONE")
  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  public Date createdAt;

  @Column(columnDefinition= "TIMESTAMP WITHOUT TIME ZONE")
  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  public Date updatedAt;

  @Column
  @NotNull
  public long slotId;

  @Column
  public String version;
}
