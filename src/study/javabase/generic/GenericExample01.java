package study.javabase.generic;

/**
 * API에서 전달되는 객체에 따라서 영문 Upper Letter로 구분해준다.
 * Type: <T>
 * Element: <E>
 * Key: <K>
 * Value: <V>
 * @author Emrys
 * @param <T>
 */
class GenericExample1<T> {
	
	T[] values;
	
	public void set(T[] values) {
		this.values = values;
	}
	
	public void print() {
		for(T value: values) System.out.println(value);
	}
}

public class GenericExample01 {

	public static void main(String[] args) {
		
		/**
		 * 제네릭을 잘 보여주는 사례이다.
		 * <T> 어떤 자료형의 Type이 올것이라고 명시한 제네릭 함수에 String과 Integer형으로 각각 다르게 Type을 넣어준다.
		 * 이 예시는 하나의 메소드임에도 여러 가지 자료형으로 사용할 수 있음을 보여준다.
		 */
		GenericExample1<String> genericString = new GenericExample1<String>();
		String[] stringValues = {"Yubi", "ChaoChao", "SonJerry"};
		genericString.set(stringValues);
		genericString.print();
		
		GenericExample1<Integer> genericInteger = new GenericExample1<Integer>();
		Integer[] intValues = {8,1,2,8};
		genericInteger.set(intValues);
		genericInteger.print();
	}

}
