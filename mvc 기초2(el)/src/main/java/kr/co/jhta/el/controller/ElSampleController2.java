package kr.co.jhta.el.controller;

import java.util.ArrayList;
import java.util.List;

import com.sample.model2.controller.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ElSampleController2 implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<CartItem> firstCart = null;
		List<CartItem> secondCart = new ArrayList<>();
		List<CartItem> thirdCart = new ArrayList<>();
		thirdCart.add(new CartItem(10, "색연필", 2500, 0.01, 1));
		thirdCart.add(new CartItem(20, "오리털 패딩", 550000, 0.05, 1));
		thirdCart.add(new CartItem(30, "런닝화", 210000, 0.0, 1));
		thirdCart.add(new CartItem(40, "무릎보호대", 35000, 0.01, 1));
		thirdCart.add(new CartItem(50, "기모바지", 150000, 0.5, 1));
		
		request.setAttribute("cart1", firstCart);
		request.setAttribute("cart2", secondCart);
		request.setAttribute("cart3", thirdCart);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/el/sample2.jsp");
		requestDispatcher.forward(request, response);
	}
	
	public class CartItem {
		int no;
		String name;
		int price;
		double discountedRate;
		int amount;
		
		public CartItem(int no, String name, int price, double discountedRate, int amount) {
			super();
			this.no = no;
			this.name = name;
			this.price = price;
			this.discountedRate = discountedRate;
			this.amount = amount;
		}
		
		public int getNo() {
			return no;
		}
		
		public String getName() {
			return name;
		}
		
		public int getPrice() {
			return price;
		}
		
		public double getDiscountedRate() {
			return discountedRate;
		}
		
		public int getAmount() {
			return amount;
		}
		
		// 할인비율 (%단위)
		public double getDiscountPercent() {
			return getDiscountedRate()*100;
		}
		
		// 할인가격
		public int getDiscountedPrice() {
			return (int)(price*(1-discountedRate));
		}
		
		// 구매가격
		public int getOrderPrice() {
			return getDiscountedPrice() * amount;
		}
	}
}
