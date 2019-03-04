package com.ssafy.emp;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class EmpClient extends Thread {

	private List<Employee> emps;
	private String ip = "localhost";
	private int port = 6000;

	private Socket socket;
	private OutputStream os;
	private ObjectOutputStream oos;

	public EmpClient() {
		
	}

	public EmpClient(List<Employee> emps) {
		super();
		this.emps = emps;
	}

	@Override
	public void run() {
		try {
			// 소켓 생성
			socket = new Socket(ip, port);

			// io stream 생성
			os = socket.getOutputStream();
			oos = new ObjectOutputStream(os);

			oos.writeObject(emps);
			
			oos.close();
			os.close();
			socket.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
