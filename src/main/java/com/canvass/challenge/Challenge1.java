package com.canvass.challenge;

public class Challenge1 {
	public static void main(String[] args) {
		Challenge1 cl=new Challenge1();
		StringBuilder sb=new StringBuilder();
		
		for(int i=1000;i<=3000;i++) {
			if(cl.check(i)) {
				sb.append(i+",");		
			}
		}
		System.out.println(sb.toString().substring(0,sb.length()-1));
	}
	
	public boolean check(int num) {
		while(num>0) {
			int rem=num%10;
			if(rem%2!=0) return false;
			num=num/10;
		}
		return true;
	}
}
