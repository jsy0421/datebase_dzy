package market.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.beans.PropertyVetoException;
import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBUtil {
//	private static final String jdbcUrl="jdbc:mysql://localhost:3306/personplan?useSSL=false";
//	private static final String dbUser="root";
//	private static final String dbPwd="jsyjsy20000421";
//	static{
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public static Connection getConnection() throws java.sql.SQLException{
//		return java.sql.DriverManager.getConnection(jdbcUrl, dbUser, dbPwd);
//	}
	private static DBUtil dbPool;
	private static ComboPooledDataSource dataSource;
	static {
		dbPool = new DBUtil();
	}
	public DBUtil() {
		try {
			dataSource = new ComboPooledDataSource();
			dataSource.setUser("root");
			dataSource.setPassword("jsyjsy20000421");
			dataSource
					.setJdbcUrl("jdbc:mysql://localhost:3306/dzy?characterEncoding=gbk&useSSL=false");
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setInitialPoolSize(2);  //初始连接数
			dataSource.setMinPoolSize(1);  //最小连接数
			dataSource.setMaxPoolSize(10);  //获取连接数
			dataSource.setMaxStatements(50);  //最大连接数
			dataSource.setMaxIdleTime(60);  //最大空闲时间
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
	}

	public final static DBUtil getInstance() {
		return dbPool;
	}

	public final static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("无法从数据源获取连接 ", e);
		}
	}
}
