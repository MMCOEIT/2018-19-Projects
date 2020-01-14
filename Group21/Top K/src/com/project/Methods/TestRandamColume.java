package com.project.Methods;

import java.util.Random;

public class TestRandamColume {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] fruits = {"Apple","Mango","Peach","Banana","Orange","Grapes","Watermelon","Tomato"};
		
		String random = (fruits[new Random().nextInt(fruits.length)]);
		
		System.out.println("randam Value id "+random);
		
		

	}

}
