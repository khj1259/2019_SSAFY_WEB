package com.ssafy.emp;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class EmpMgrImpl implements IEmpMgr{	
	
    /** 직원나 매니저의 정보를 저장하기 위한 리스트 */
	private List<Employee> emps = new ArrayList<Employee>();
	
	private static EmpMgrImpl instance;

	private EmpMgrImpl() {
		load("emp.dat");
	}
	
	/** getInstace() : 객체 생성하는 메서드 */
	public static EmpMgrImpl getInstance() {
		if(instance == null) {
			instance = new EmpMgrImpl();
		}
		return instance;
	}

	
	/** 파일로 부터 자료 읽어서 메모리(ArrayList)에 저장하기*/
	public void load(String filename) {
		File  file=new File(filename);
		System.out.println(file);
		if (!file.exists()) return; 
		emps.clear();
		ObjectInputStream ois=null;
		Object ob=null;
		try{	
			ois=new ObjectInputStream(new FileInputStream(file));
			while(true){//마지막 EOF Exception발생
				ob=ois.readObject();
				emps.add((Employee)ob);
			}
		}catch(EOFException ee){System.out.println("읽기 완료");
		}catch(FileNotFoundException fe){
			System.out.println("파일이 존재하지 않습니다");
		}catch(IOException ioe){
			System.out.println(ioe);
		}catch(ClassNotFoundException ce){
			System.out.println("같은 클래스 타입이 아닙니다");
		}finally{
			if(ois !=null){
				try{
					ois.close();
				}catch(IOException oe){System.out.println("파일을 닫는데 실패했습니다");}
			}
		}
	}
  
	// 전체 직원정보를 리턴하는 메서드
	public List<Employee>  search(){
    	return emps;
    }

	// List에 저장된 직원 정보를 파일에 저장한다 
	@Override
	public void save(String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Employee employee : emps) {
				oos.writeObject(employee);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 파라메터로 전달된 직원정보를 List에 저장한다. 
	@Override
	public void add(Employee b) throws DuplicateException {
		for (Employee employee : emps) {
			if(employee.getEmpNo() == b.getEmpNo()) {
				throw new DuplicateException();
			}
		}
		emps.add(b);
	}

	// 번호를 이용하여 검색된 직원을 리턴하는 메서드
	@Override
	public Employee search(int num) throws RecordNotFoundException {
		for (Employee employee : emps) {
			if(employee.getEmpNo() == num) {
				return employee;
			}
		}
		throw new RecordNotFoundException();
	}

	// 번호를 찾아 직원정보를 수정하는 메서드
	@Override
	public void update(Employee b) throws RecordNotFoundException {
		boolean exist = false;
		for(int i=0; i<emps.size(); i++) {
			if(emps.get(i).getEmpNo() == b.getEmpNo()) {
				emps.get(i).setDept(b.getDept());
				emps.get(i).setPosition(b.getPosition());
				exist = true;
			}
		}
		if(!exist) throw new RecordNotFoundException();
	}

	// 번호를 찾아 직원 정보를 삭제하는 메서드
	@Override
	public void delete(int num) throws RecordNotFoundException {
		boolean exist = false;
		for(int i=0; i<emps.size(); i++) {
			if(emps.get(i).getEmpNo() == num) {
				emps.remove(i);
				exist = true;
			}
		}
		if(!exist) throw new RecordNotFoundException();
	}
	
	
	
	
	

}
