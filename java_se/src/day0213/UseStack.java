package day0213;

import java.util.Stack;

/**
 * Stack: LIFO를 구현한 자료구조 
 */
public class UseStack {

	public UseStack() {
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("즐거운 하루 되세요");
		stack.push("입니다");
		stack.push("목요일");
		stack.push("오늘은");
		
		System.out.println("스택이 비었는지 ?" + stack.empty());
		
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop()); //더이상 없으면 에러
		
		String item = "";
		while(!stack.empty()) {
			item = stack.pop();
			System.out.println(item);
		}
		
		
//		System.out.println(stack + " 크기 " + stack.size()); 부모에서 제공하는 method는 
		//사용하면 안된다
		
		System.out.println(stack);
		
	}
	
	public static void main(String[] args) {

		new UseStack();
	}

}
