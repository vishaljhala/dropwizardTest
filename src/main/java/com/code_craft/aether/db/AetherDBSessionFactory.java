package com.code_craft.aether.db;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import javax.inject.Singleton;

@Singleton
public class AetherDBSessionFactory {
  private static SessionFactory sessionFactory = null;

  public AetherDBSessionFactory(){
  }

  public static void setSessionFactory(SessionFactory factory) {
    sessionFactory = factory;
  }

  public static Session getNewSession() {
    return sessionFactory.openSession();
  }
}
