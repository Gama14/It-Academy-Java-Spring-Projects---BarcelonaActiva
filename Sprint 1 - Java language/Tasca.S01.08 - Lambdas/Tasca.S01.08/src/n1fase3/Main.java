package n1fase3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReverseInterface reverseString = (str) -> {
			String result = "";
			for (int i=str.length()-1;i>=0;i--) {
				result += str.charAt(i);
			}
			return result;
		};
		System.out.println(reverseString.getReversed("Al raves"));
	}
}
