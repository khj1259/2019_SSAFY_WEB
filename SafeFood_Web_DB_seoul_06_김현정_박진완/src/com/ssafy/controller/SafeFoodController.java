package com.ssafy.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.service.FoodService;
import com.ssafy.service.FoodServiceImpl;
import com.ssafy.util.FoodSaxParser;
import com.ssafy.vo.EatFood;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;
import com.ssafy.vo.Food;
import com.ssafy.vo.User;

// FrontController에서 넘어온 요청을 DAO에 넘겨서 작업지시하는 객체
// DAO한테서 받은 결과를 저장하고, JSP로 넘어감 -> forward방식으로 넘어감

public class SafeFoodController {

	private FoodService service;

	public SafeFoodController() {
		service = new FoodServiceImpl();
	}

	public void searchFoodDetail(HttpServletRequest req, HttpServletResponse res) {
		String code = req.getParameter("code");
		Food food = service.search(Integer.parseInt(code));

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) { // 로그인 된 상태이면 식품에 포함된 알러지 경고
			String foodAllergy = food.getAllergy();
			String userAllergy = user.getAllergy();
			List<String> contains = service.containAllergy(foodAllergy, userAllergy);
			req.setAttribute("contains", contains);
		}

		req.setAttribute("food", food);
		RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/product_info.jsp");
		try {
			dispatcher.forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void signup(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("signup_id");
		String password = req.getParameter("signup_pw");
		String name = req.getParameter("signup_name");
		String address = req.getParameter("signup_address");
		String phone = req.getParameter("signup_phone");
		String[] check = req.getParameterValues("check");
		String allergy = String.join(",", check);
		service.addUser(id, password, name, address, phone, allergy);
		mainPage(req, res);
		return;
	}
	
	public void signin(HttpServletRequest req, HttpServletResponse res) {
		String id = req.getParameter("login_id");
		String password = req.getParameter("login_pw");
		User user = service.signIn(id, password);
		System.out.println(user);
		if (user.getId() != null && user.getPassword() != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			foodlist(req, res);
		} else {
			req.setAttribute("flag", 1);
			mainPage(req, res);
		}
		return;
	}

	public void logout(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		session.invalidate();
		mainPage(req, res);
		return;
	}

	public void userOutReady(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/userOut.jsp");
		try {
			dispatcher.forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void userOut(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String password = req.getParameter("out_passwd");
		if (password.equals(user.getPassword())) {
			session.invalidate();
			service.deleteUser(user);
			mainPage(req, res);
		} else {
			req.setAttribute("error", "비밀번호를 제대로 입력해주세요!");
			userOutReady(req, res);
		}
		return;
	}

	// 회원정보조회
	public void userInfo(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		User user2 = service.userInfo(user.getId());
		req.setAttribute("user", user2);
		RequestDispatcher dispathcer = req.getRequestDispatcher("/jsp/userInfo.jsp");
		try {
			dispathcer.forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	// 회원 정보 수정
	public void userEdit(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/userInfoEdit.jsp");
		try {
			dispatcher.forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	// 비밀번호 찾기
	public void searchPassword(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/password.jsp");
		String id= req.getParameter("search_id");
		String name=req.getParameter("search_name");
		String pass = service.searchPass(id, name);
		req.setAttribute("pass",pass);
		System.out.println("2	"+pass);
		try {
			dispatcher.forward(req, res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void userEditComplete(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String id = user.getId();
		String password = req.getParameter("signup_pw");
		String passwords = req.getParameter("signup_pw2");
		if (!password.equals(passwords)) {
			req.setAttribute("errorInfo", "비밀번호가 틀렸습니다!");
			userEdit(req, res);
			return;
		}
		
		String name = req.getParameter("signup_name");
		String address = req.getParameter("signup_address");
		String phone = req.getParameter("signup_phone");
		String[] check = req.getParameterValues("check");
		String allergy = String.join(",", check);
		service.modifyUser(id, password, name, address, phone, allergy);
		mainPage(req, res);
		return;
	}	

	// 메인 페이지 화면
	public void mainPage(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/main.jsp");
		try {
			dispatcher.forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	// 푸드 전체 리스트 화면
	public void foodlist(HttpServletRequest req, HttpServletResponse res) {
		List<Food> list = service.searchAll(null);
		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/foodlist.jsp");

		try {
			dispatcher.forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// key로 푸드 검색 (이름, 제조사, 원재료)
	public void search(HttpServletRequest req, HttpServletResponse res) {
		String key = req.getParameter("search_opt");
		String searchValue = req.getParameter("searchValue");
		FoodPageBean bean = new FoodPageBean(key, searchValue, "1", 1);
		List<Food> list = null;

		list = service.searchAll(bean);

		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/search_result.jsp");
		try {
			dispatcher.forward(req, res);
			return;
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 섭취 식품 추가
	public void eatFoodAdd(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) { // 로그인 된 상태이면 추가
			String id = user.getId();
			String code = req.getParameter("code");
			int cnt = Integer.valueOf(req.getParameter("cnt"));
			System.out.println("섭취식품 추가 :"+id+","+code+","+cnt);
			int result = service.insertEatFood(id, code, cnt);
			if(result == -1) {
				System.out.println("섭취식품 추가 실패");
			}
		}
	}

	//섭취 식품 리스트 검색
	public void eatFoodList(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String id = user.getId();
		List<EatFood> list = service.selectAllEatFood(id);
		List<Food> foodlist = new ArrayList<>();
		for (EatFood eatFood : list) {
			Food food = service.search(eatFood.getCode());
			foodlist.add(food);
		}
		req.setAttribute("list", list); // cnt를 위해서 
		req.setAttribute("foodlist", foodlist);
		try {
			req.getRequestDispatcher("/jsp/eatFoodList.jsp").forward(req, res);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void eatFoodDelete(HttpServletRequest req, HttpServletResponse res) {
//		System.out.println(req.getParameter("eatfoodcode"));
		int eatfoodcode = Integer.valueOf(req.getParameter("eatfoodcode"));
		int result = service.deleteEatFood(eatfoodcode);
		if(result == -1) {
			System.out.println("섭취식품 삭제 실패");
		}
	}

	public void eatFoodUpdate(HttpServletRequest req, HttpServletResponse res) {
		int eatfoodcode = Integer.valueOf(req.getParameter("eatfoodcode"));
		int cnt = Integer.valueOf(req.getParameter("cntval"));
		int result = service.updateEatFood(eatfoodcode, cnt);
		if(result == -1) {
			System.out.println("섭취식품 수정 실패");
		}
	}


}
