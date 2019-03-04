package com.ssafy.server;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.ssafy.emp.Employee;

public class EmpServer {

	private int port = 6000;

	public void receive() {
		// 서버 구현
		try {
			//소켓 생성
			ServerSocket svr = new ServerSocket(port);
			System.out.println("ServerSocket ok. port="+port);
			System.out.println("server ready...");
			
			
			while(true) {
				try {
					//연결 
					Socket socket = svr.accept();
					//io stream 생성
					InputStream is = socket.getInputStream();
					ObjectInputStream ois = new ObjectInputStream(is);
					
					List<Employee> emps = (List<Employee>) ois.readObject();
					for (Employee employee : emps) {
						System.out.println(employee.toString());
					}
					System.out.println("=====================================");
				} catch(SocketException e) {
					System.out.println("종료");
					break;
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new EmpServer().receive();
	}

}