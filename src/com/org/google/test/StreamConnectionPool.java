package com.org.google.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StreamConnectionPool {
	List<StreamConnection> freeConnections = openConnections();
	public StreamConnection getConnections(){
		if(freeConnections.isEmpty())
			throw new RuntimeException("No free connections avaialble");
		return freeConnections.remove(0);
	}
	
	public void returnConnections(StreamConnection conn){
		freeConnections.add(conn);
	}
	
	public List<StreamConnection> openConnections(){
		
		List<StreamConnection> connections = new ArrayList<StreamConnection>();
		for(int i=0;i<5;i++){
			try {
				StreamConnection streamConnection = new StreamConnection(new FileInputStream("/temp/file"+i));
				connections.add(streamConnection);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return connections;
		
	}
	

}
