package fr.ensicaen.si.jersey.init;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import fr.ensicaen.si.core.dao.ClientDao;
import fr.ensicaen.si.core.dao.DbClientDao;
import fr.ensicaen.si.core.dao.DbOperationDao;
import fr.ensicaen.si.core.dao.OperationDao;
import fr.ensicaen.si.core.db.DbManagement;
import fr.ensicaen.si.core.db.MySqlDbManagement;
import fr.ensicaen.util.ILog.LogLevel;
import fr.ensicaen.util.MyLog;

public class ServletContextClass implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent ev) {
		MyLog.setLogLevel(LogLevel.DEBUG);
		MyLog.setTimestamp(true);
		
		DbManagement dbm = DbManagement.getInstance();
		try {
			if (!dbm.isDelegated()) dbm.setDelegate(new MySqlDbManagement()); // the DB is MySql
		} catch(SQLException e) {
			throw new RuntimeException("SQLException : "+e.getMessage());
		}
		
		ClientDao cd = ClientDao.getInstance();
		if (!cd.isDelegated()) cd.setDelegate(new DbClientDao()); // Data are in a DB
		
		OperationDao od = OperationDao.getInstance();
		if (!od.isDelegated()) od.setDelegate(new DbOperationDao()); // Data are in a DB
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent ev) {
		try {
			DbManagement.getInstance().disconnection();
		} catch (SQLException e) {
			throw new RuntimeException("SQLException : "+e.getMessage());
		}
		
		// This manually deregisters JDBC driver, which prevents Tomcat 7 from complaining about memory leaks wrto this class
//        Enumeration<Driver> drivers = DriverManager.getDrivers();
//        while (drivers.hasMoreElements()) {
//            Driver driver = drivers.nextElement();
//            try {
//                DriverManager.deregisterDriver(driver);
//                MyLog.i(this.getClass().getSimpleName(), String.format("deregistering jdbc driver: %s", driver));
//            } catch (SQLException e) {
//                MyLog.e(this.getClass().getSimpleName(), String.format("Error deregistering driver %s : %s", driver, e.getMessage()));
//            }
//        }
		
		// Needed for MySql otherwise an exception is thrown when unregistering the driver.
		// @See : https://github.com/spring-projects/spring-boot/issues/2612
		try {
            MyLog.i(this.getClass().getSimpleName(), "Calling MySQL AbandonedConnectionCleanupThread shutdown");
            com.mysql.jdbc.AbandonedConnectionCleanupThread.shutdown();

        } catch (InterruptedException e) {
            MyLog.e(this.getClass().getSimpleName(), "Error calling MySQL AbandonedConnectionCleanupThread shutdown ("+e.getMessage()+")");
            return;
        }
        
		// Now deregister JDBC drivers in this context's ClassLoader:
		// Get the webapp's ClassLoader
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		// Loop through all drivers
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while (drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			if (driver.getClass().getClassLoader() == cl) {
				// This driver was registered by the webapp's ClassLoader, so deregister it:
				try {
					MyLog.i(this.getClass().getSimpleName(), "Deregistering JDBC driver (" + driver + ")");
					DriverManager.deregisterDriver(driver);
				} catch (SQLException ex) {
					MyLog.e(this.getClass().getSimpleName(), "Error deregistering JDBC driver (" + ex + ")");
				}
			} else {
				// driver was not registered by the webapp's ClassLoader and may be in use elsewhere
				System.out.println("Not deregistering JDBC driver {} as it does not belong to this webapp's ClassLoader" + driver);
			}
		}
	}

}
