package serializationsafe;

import java.io.Serializable;

public class ConnectionPool implements Serializable {
	private static ConnectionPool pool;
	// this is a pool with only 1 connection
	private Connection connection = new Connection();

	private ConnectionPool() {
		// Prevent form the reflection api.
		if (pool != null) {
			throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
		}
	}

	public static ConnectionPool getPool() {
		// Double check locking pattern
		if (pool == null) { // Check for the first time
			synchronized (ConnectionPool.class) { // Check for the second time.
				if (pool == null)
					pool = new ConnectionPool();
			}
		}
		return pool;
	}

	public Connection getConnection() {
		return connection;
	}

	// This method is called immediately after an object of this class is deserialized.
	// This method returns the singleton instance.
	protected Object readResolve() {
		return getPool();
	}
}
