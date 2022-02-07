package 栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20_有效的括号 {

	/**
	 * 1、遇见左字符，将左字符入栈
	 * 2、遇见右字符
	 * 	2.1、如果栈是空的，说明括号无效
	 * 	2.2、如果栈不为空，将栈顶字符出栈，与右字符之匹配
	 * 		2.2.1、如果左右字符不匹配，说明括号无效
	 * 		2.2.2、如果左右字符匹配，继续扫描下一个字符
	 * 3、所有字符扫描完毕后
	 * 	3.1、栈为空，说明括号有效
	 * 	3.2、栈不为空，说明括号无效
	 */
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i =0;i < s.length();i++) {
			char c = s.charAt(i);
			if(c == '(' || c == '{' || c == '[') {// 左括号
				stack.push(c);
			}else{// 右括号
				if(stack.isEmpty()) return false;
				char left = stack.pop();
				if(left == '(' && c != ')') return false;
				if(left == '[' && c != ']') return false;
				if(left == '{' && c != '}') return false;
			}
		}
		return stack.isEmpty();
	}
	
	public boolean isValid02(String s) {
		Map<Character, Character> map = new HashMap<>();
		map.put('(',')');
		map.put('[',']');
		map.put('{','}');
		Stack<Character> stack = new Stack<>();
		for(int i =0;i < s.length();i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {// 左括号
				stack.push(c);
			}else{// 右括号
				if(stack.isEmpty()) return false;
				if(c != map.get(stack.pop())) return false;
			}
		}
		return stack.isEmpty();
	}
	
	public boolean isValid01(String s) {
		while(s.contains("()") || s.contains("[]") || s.contains("{}")){
            if(s.contains("()")){
                s = s.replace("()","");
            }
            if(s.contains("{}")){
                s = s.replace("{}","");
            }
            if(s.contains("[]")){
                s = s.replace("[]","");
            }
        }
        return s.isEmpty();
	}
	
	public static void main(String[] args) {
		_20_有效的括号 test = new _20_有效的括号();
		System.out.println(test.isValid02("{()[()]}"));
	}
}
