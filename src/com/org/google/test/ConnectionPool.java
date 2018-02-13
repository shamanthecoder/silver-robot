package com.org.google.test;

public class ConnectionPool {
	
	StreamConnectionPool streamPool = new StreamConnectionPool();
	public Connection getConnection() {
        final StreamConnection realConnection = streamPool.getConnections();
        return new Connection(){
            private boolean closed = false;
            public int read () {
                if (closed) throw new IllegalStateException("Connection closed"); 
                return realConnection.read();
            }
            public void close() {
                if (!closed) {
                    closed = true;
                    streamPool.returnConnections(realConnection);
                }
            }
            protected void finalize() throws Throwable {
                try {
                    close();
                } finally {
                    super.finalize();
                }
            }
        };
}
	
	public static void main(String[] args){
		ConnectionPool pool = new ConnectionPool();
		Connection conn = pool.getConnection();
		conn.read();
		conn.close();
	}
}
