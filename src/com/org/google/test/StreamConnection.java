package com.org.google.test;

import java.io.IOException;
import java.io.InputStream;

public class StreamConnection implements Connection {

	private final InputStream input;
	
	public StreamConnection(InputStream input){
		this.input = input;
	}
	@Override
	public int read() {
		try {
			return input.read();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void close() {
		try {
			input.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

}
