/*
 * Study reference inform 
 * Reference site URL: http://nowonbun.tistory.com/318
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
	
	// Prior symbol.
	private final String[] OPERATION_PRIOR = { "(", ")", "," };
	// Factorial operator.
	private final String[] OPERATION_FACTORIAL = { "!" };
	// Arithmetic operators.
	private final String[] OPERATION_ARITH = { "+", "-", "*", "/", "^", "%" };
	// Numberless Word operators.
	private final String[] WORDOPERATION_NUMBERLESS = { "pi", "e" };
	// Require one number Word operators.
	private final String[] WORDOPERATION_ONENUMBER = { "sin", "sinh", "asin", "cos", "cosh", "acos", 
			"tan", "tanh", "atan", "sqrt", "exp", "abs", "log", "ceil", "floor", "round" };
	// Require two number Word operators.
	private final String[] WORDOPERATION_TWONUMBER = { "pow" };
	// Rounding digits
	private int HALF_ROUND_UP = 6;
	
	// Singleton.
	private static Calculator instance = null;
	
	/**
	 * Constructor.
	 */
	private Calculator() { }
	
	/**
	 * Singleton.
	 */
	private static Calculator getInstance() {
		if(instance==null) instance = new Calculator();
		return instance;
	}
	
	/**
	 * @function() Requested calculating function from external side.
	 * @param (String)data : calculus.
	 * @return (function)calculation.
	 */
	public static BigDecimal Calculate(String data) {
		return Calculator.getInstance().calculation(data);
	}
	
	/**
	 * Calling calculating function from internal side.
	 * @param (String)data : calculus.
	 * @return (BicDecimal).
	 */
	private BigDecimal calculation(String data) {
		data = data.replace(" ", "");
		List< Object > tokenStack = makeTokens(data);
		tokenStack = convertPostOrder(tokenStack);
		Stack< Object > calculationStack = new Stack< Object >();
		for( Object token : tokenStack ) {
			calculationStack.push(token);
			calculationStack = calculationPostOrder(calculationStack);
		}
		if(calculationStack.size() != 1) {
			throw new RuntimeException("Calculator Error");
		}
		return (BigDecimal) calculationStack.pop();
	}
	
	/**
	 * @function() Calculate postfix notation order.
	 * @param (Stack)calculationStack.
	 * @return (Stack)calculationStack.
	 */
	private Stack< Object > calculationPostOrder(Stack< Object > calculationStack) {
		
		if (calculationStack.lastElement().getClass().equals(BigDecimal.class)) return calculationStack;
		
		BigDecimal op1 = null;
		BigDecimal op2 = null;
		String opcode = null;
		
		if(calculationStack.size() >= 2) {
			
			opcode = (String) calculationStack.pop();
			op1 = (BigDecimal) calculationStack.pop();
			
			if(!opCodeCheck(opcode)) {
				op2 = (BigDecimal) calculationStack.pop();
			}
			BigDecimal result = calculateByOpCode(op1,op2,opcode);
			calculationStack.push(result);
		}
		
		return calculationStack;
	}
	
	/**
	 * @function() Check the requiring count for operator.
	 * @param (String)opcode: operator.
	 * @return (boolean): true == expect(requiring count <= 1) , false == expect(requiring count == 2).
	 */
	private boolean opCodeCheck(String opcode) {
		return containWord(opcode, WORDOPERATION_ONENUMBER) || containWord(opcode, WORDOPERATION_NUMBERLESS);
	}
	
	/**
	 * @function() Calculate by opcode.
	 * @param (BigDecimal)op1.
	 * @param (BigDecimal)op2.
	 * @param (String)opcode: Operator.
	 * @return (BicDecimal).
	 */
	private BigDecimal calculateByOpCode(BigDecimal op1, BigDecimal op2, String opcode) {
		if (OPERATION_ARITH[0].equals(opcode)) {
			// Add
			return op1.add(op2);
		} else if (OPERATION_ARITH[1].equals(opcode)){
			// Subtract
			return op1.subtract(op2);
		} else if (OPERATION_ARITH[2].equals(opcode)) {
			// Multiply
			return op1.multiply(op2);
		} else if (OPERATION_ARITH[3].equals(opcode)) {
			// Divide
			op2.divide(op1,HALF_ROUND_UP, BigDecimal.ROUND_HALF_UP);
		} else if (OPERATION_ARITH[4].equals(opcode)) {
			// Power
			op2.pow(op1.intValue());
		} else if (OPERATION_ARITH[5].equals(opcode)) {
			// Remain
			return op2.remainder(op1);
		} else if (OPERATION_FACTORIAL[0].equals(opcode)) {
			// Factorial
			return calculateFactorial(op1);
		} else if (WORDOPERATION_ONENUMBER[0].equals(opcode)) {
			// sin
			return BigDecimal.valueOf(Math.sin(op1.doubleValue()));
		} else if (WORDOPERATION_ONENUMBER[1].equals(opcode)) {
			// sinh
			return BigDecimal.valueOf(Math.sinh(op1.doubleValue()));
		} else if (WORDOPERATION_ONENUMBER[2].equals(opcode)) {
			// asin
			return BigDecimal.valueOf(Math.asin(op1.doubleValue()));
		} else if (WORDOPERATION_ONENUMBER[3].equals(opcode)) {
			// cos
			return BigDecimal.valueOf(Math.cos(op1.doubleValue()));
		} else if (WORDOPERATION_ONENUMBER[4].equals(opcode)) {
			// cosh
			return BigDecimal.valueOf(Math.cosh(op1.doubleValue()));
		} else if (WORDOPERATION_ONENUMBER[5].equals(opcode)) {
			// acos
			return BigDecimal.valueOf(Math.acos(op1.doubleValue()));
		} else if (WORDOPERATION_ONENUMBER[6].equals(opcode)) {
			// tan
			return BigDecimal.valueOf(Math.tan(op1.doubleValue()));
		} else if (WORDOPERATION_ONENUMBER[7].equals(opcode)) {
			// tanh
			return BigDecimal.valueOf(Math.tanh(op1.doubleValue()));
		} else if (WORDOPERATION_ONENUMBER[8].equals(opcode)) {
			// atan
			return BigDecimal.valueOf(Math.atan(op1.doubleValue()));
		} else if (WORDOPERATION_ONENUMBER[9].equals(opcode)) {
			// sqrt
			return BigDecimal.valueOf(Math.sqrt(op1.doubleValue()));
		} else if (WORDOPERATION_ONENUMBER[10].equals(opcode)) {
			// exp
			return BigDecimal.valueOf(Math.exp(op1.doubleValue()));
		} else if (WORDOPERATION_ONENUMBER[11].equals(opcode)) {
			// abs
			return BigDecimal.valueOf(Math.abs(op1.doubleValue()));
		} else if (WORDOPERATION_ONENUMBER[12].equals(opcode)) {
			// log
			return BigDecimal.valueOf(Math.log(op1.doubleValue()));
		} else if (WORDOPERATION_ONENUMBER[13].equals(opcode)) {
			// ceil
			return BigDecimal.valueOf(Math.ceil(op1.doubleValue()));
		} else if (WORDOPERATION_ONENUMBER[14].equals(opcode)) {
			// floor
			return BigDecimal.valueOf(Math.floor(op1.doubleValue()));
		} else if (WORDOPERATION_ONENUMBER[15].equals(opcode)) {
			// round
			return BigDecimal.valueOf(Math.round(op1.doubleValue()));
		} else if (WORDOPERATION_TWONUMBER[0].equals(opcode)) {
			// power
			return op2.pow(op1.intValue());
		}
		
		throw new RuntimeException("Operation Error");
	}
	
	/**
	 * @Recursivefunction() Calculate factorial.
	 * @param (BigDecimal)input.
	 * @return (BigDecimal).
	 */
	private BigDecimal calculateFactorial(BigDecimal input) {
		if(BigDecimal.ONE.equals(input)) return BigDecimal.ONE;
		return calculateFactorial(input.subtract(BigDecimal.ONE)).multiply(input);
	}
	
	
	/**
	 * @function() Convert Postfix notation.
	 * @param (List< Object >)tokenStack.
	 * @return (List< Object >)postOrderList.
	 */
	private List<Object> convertPostOrder(List< Object > tokenStack){
		List< Object > postOrderList = new ArrayList<>();
		Stack<String> exprStack = new Stack<>();
		Stack<String> wordStack = new Stack<>();
		for(Object token: tokenStack) {
			if(BigDecimal.class.equals(token.getClass())) postOrderList.add(token);
			else exprAppend((String)token,exprStack,wordStack,postOrderList);
		}
		String item = null;
		while(!exprStack.isEmpty()) {
			item = exprStack.pop();
			postOrderList.add(item);
		}
		return postOrderList;
	}
	
	/**
	 * @function() Process for operators of postfix notation.
	 * @param (String)token.
	 * @param (Stack)exprStack: for Symbol Type operators.
	 * @param (Stack)wordStack: for Character Type operators.
	 * @param (List< Object >)postOrderList.
	 */
	private void exprAppend(String token, Stack<String> exprStack, Stack<String> wordStack, List< Object > postOrderList) {
		if(isWordOperation(token)) {
			BigDecimal wordValue = convertingWordResult(token);
			if(wordValue != null) postOrderList.add(wordValue);
			else wordStack.push(token);
		} else if (OPERATION_PRIOR[0].equals(token)) {
			// Left Parentheses.
			exprStack.push(token);
		} else if (OPERATION_PRIOR[1].equals(token)) {
			// Right Parentheses.
			String opcode = null;
			while(true) {
				if(wordStack.size() > 0) {
					opcode = exprStack.pop();
					if(OPERATION_PRIOR[0].equals(opcode)) {
						opcode = wordStack.pop();
						postOrderList.add(opcode);
						break;
					}
					postOrderList.add(opcode);
				} else {
					if(exprStack.size() < 1) {
						break;
					}
					opcode = exprStack.pop();
					if(OPERATION_PRIOR[0].equals(opcode)) {
						break;
					}
					postOrderList.add(opcode);
				}
			}
		} else if (OPERATION_PRIOR[2].equals(token)) {
			if(wordStack.size() < 1) {
				throw new RuntimeException("Data error");
			}
			String opcode = null;
			while(true) {
				if(exprStack.size() < 1) {
					break;
				}
				if(OPERATION_PRIOR[0].equals(exprStack.lastElement())) {
					break;
				}
				opcode = exprStack.pop();
				postOrderList.add(opcode);
			}
		} else if (isOperation(token)) {
			String opcode = null;
			while (true) {
				if(exprStack.isEmpty()) {
					exprStack.push(token);
					break;
				}
				opcode = exprStack.pop();
				if(exprOrder(opcode) <= exprOrder(token)) {
					exprStack.push(opcode);
					exprStack.push(token);
					break;
				}
				postOrderList.add(opcode);
			}
		}
	}
	
	/**
	 * @function() Converting Word Type numberless operators(PI, E).
	 * @param (String)wordToken.
	 * @return (BigDecimal). 
	 */
	private BigDecimal convertingWordResult(String wordToken) {
		if(containWord(wordToken, WORDOPERATION_NUMBERLESS)) {
			if(WORDOPERATION_NUMBERLESS[0].equals(wordToken.toLowerCase())) {
				return BigDecimal.valueOf(Math.PI);
			} else if (WORDOPERATION_NUMBERLESS[1].equals(wordToken.toLowerCase())) {
				return BigDecimal.valueOf(Math.E);
			}
		}
		return null;
	}
	
	/**
	 * @function() Comparison priority operators.
	 * @param (String)operator.
	 * @return (Integer)order.
	 */
	private int exprOrder(String operator) {
		if (operator == null) throw new NullPointerException();
		int order = -1;
		if ("-".equals(operator) || "+".equals(operator)) order = 0;
		else if ("*".equals(operator) || "/".equals(operator) || "%".equals(operator)) order = 1;
		else if ("!".equals(operator)) order = 3;
		else if ("^".equals(operator)) order = 4;
		return order;
	}
	
	/**
	 * @function() Make tokens from data.
	 * @param (String)inputData : calculus.
	 * @return (List<Object>)tokenStack.
	 */
	private List< Object > makeTokens(String inputData){
		List< Object > tokenStack = new ArrayList<>();
		StringBuffer numberTokenBuffer = new StringBuffer();
		StringBuffer wordTokenBuffer = new StringBuffer();
		int argSize = inputData.length();
		char token;
		for(int i=0;i<argSize;i++){
			token = inputData.charAt(i);
			// Check operation
			if(!isOperation(token)) {
				setWordOperation(tokenStack, wordTokenBuffer);
				numberTokenBuffer.append(token);
				if(i==argSize-1) {
					setNumber(tokenStack, numberTokenBuffer);
				}
			} else {
				// if( token is Operation )
				setNumber(tokenStack, numberTokenBuffer);
				if(setOperation(tokenStack, token)) {
					continue;
				}
				wordTokenBuffer.append(token);
				setWordOperation(tokenStack,wordTokenBuffer);
			}
		}
		return tokenStack;
	}
	
	/**
	 * @function() if(Check) Set operation.
	 * @param (List<Object>)tokenStack.
	 * @param (Character)token.
	 * @return (boolean)
	 */
	private boolean setOperation(List< Object > tokenStack, char token) {
		String tokenBuffer = Character.toString(token);
		if (containWord(tokenBuffer, OPERATION_PRIOR) || containWord(tokenBuffer, OPERATION_ARITH) || containWord(tokenBuffer, OPERATION_FACTORIAL)) {
			tokenStack.add(tokenBuffer);
			return true;
		}
		return false;
	}
	
	/**
	 * @function() Set number.
	 * @param tokenStack.
	 * @param tokenBuffer.
	 */
	private void setNumber(List< Object > tokenStack, StringBuffer tokenBuffer) {
		if(tokenBuffer.length() > 0) {
			BigDecimal number = new BigDecimal(tokenBuffer.toString());
			tokenStack.add(number);
			tokenBuffer.setLength(0);
		}
	}
	
	/**
	 * @function() Set word operation.
	 * @param (List<Object>)tokenStack.
	 * @param (StringBuffer)tokenBuffer.
	 */
	private void setWordOperation(List<Object> tokenStack, StringBuffer tokenBuffer) {
		if(isWordOperation(tokenBuffer)) {
			tokenStack.add(tokenBuffer.toString());
			tokenBuffer.setLength(0);
		}
	}
	
	/**
	 * @function() Check parameter whether word operator or not.
	 * @param (StringBuffer)wordTokenBuffer.
	 * @return (function)isWordOperation(String).
	 */
	private boolean isWordOperation(StringBuffer wordTokenBuffer) {
		String wordToken = wordTokenBuffer.toString();
		return isWordOperation(wordToken);
	}
	
	/**
	 * @function() Check parameter whether word operator or not.
	 * @param (String)wordToken.
	 * @return (boolean).
	 */
	private boolean isWordOperation(String wordToken) {
		return containWord(wordToken, WORDOPERATION_NUMBERLESS) || containWord(wordToken, WORDOPERATION_ONENUMBER)
				|| containWord(wordToken, WORDOPERATION_TWONUMBER);
	}
	
	
	
	/**
	 * @function() Check a Symbol operator for Char.
	 * @param (Character)token.
	 * @return (boolean).
	 */
	private boolean isOperation(char token) {
		if((token >= 48 && token <=57) || token == 46) return false;
		else return true;
	}
	
	/**
	 * @function() Check a Symbol operator for String.
	 * @param (String)token.
	 * @return (boolean).
	 */
	private boolean isOperation(String token) {
		return containWord(token, OPERATION_ARITH) || containWord(token, OPERATION_FACTORIAL);
	}
	
	/**
	 * @function() Check a operator whether to include in listSet.
	 * @param (String)token.
	 * @param (String[])listSet.
	 * @return (boolean).
	 */
	private boolean containWord(String token, String[] listSet) {
		if(token == null) return false;
		for(String word: listSet) if(word.equals(token)) return true;
		return false;
	}
	
}
