package com.code_craft.aether.db;
// import com.code_craft.aether.db.AetherDBSessionFactory;
// import javax.inject.Inject;
// import javax.inject.Singleton;
// import org.hibernate.Session;
// import org.hibernate.Query;
// import org.hibernate.Transaction;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import java.io.StringWriter;
// import java.io.PrintWriter;
// import com.code_craft.aether.core.Block;
// import java.util.List;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

public interface BlockDAO {
  @SqlQuery("select * from BLOCKDAO where pk = :id")
  String findNameById(@Bind("pk") int id);

  // public BlockDAO() {
  // }
  //
  // private static final Logger LOGGER = LoggerFactory.getLogger(BlockDAO.class);
  //
  // @Inject
  // AetherDBSessionFactory dbSession;
  //
  // public long getMaxBlockId() {
  //   Session session = null;
  //   Transaction transaction = null;
  //   try {
  //     if(dbSession == null)
  //       LOGGER.error("dbsession is null");
  //     session = dbSession.getNewSession();
  //     transaction = session.beginTransaction();
  //     Query query = session.createNativeQuery("SELECT max(pk) FROM blocks");
  //       List<Object> results = query.list();
  //       long maxBlockId = 0;
  //       if (results != null && results.size() > 0 && results.get(0) != null) {
  //         maxBlockId = Long.parseLong(results.get(0).toString());
  //       }
  //
  //     transaction.commit();
  //     return maxBlockId;
  //   }
  //   catch (Exception e) {
  //     StringWriter sw = new StringWriter();
  //     PrintWriter pw = new PrintWriter(sw);
  //     e.printStackTrace(pw);
  //     LOGGER.error(sw.toString());
  //     if (transaction != null)
  //       transaction.rollback();
  //   }
  //   finally {
  //     session.close();
  //   }
  //   return 0;
  // }
}

