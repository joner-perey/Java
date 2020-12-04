
public class Converter {

	public int binaryToDecimal(int binary) {
		int decimal = 0;
		int n = 0;
		while (binary > 0) {
			long temp = binary % 10;
			decimal += temp * Math.pow(2, n);
			binary = binary / 10;
			n++;
		}
		return decimal;
	}

	public String binaryToOctal(int binary) {
		StringBuilder oct = new StringBuilder();
		int quot = binaryToDecimal(binary);

		while (quot > 0) {
			oct.append(quot % 8);
			quot = quot / 8;
		}
		return oct.reverse().toString();
	}

	public String binaryToHexadecimal(int binary) {

		StringBuilder result = new StringBuilder();
		int dec = binaryToDecimal(binary);

		int[] hex = new int[20];
		int i = 0;
		while (dec != 0) {
			hex[i] = dec % 16;
			dec = dec / 16;
			i++;
		}

		for (int j = i - 1; j >= 0; j--) {
			if (hex[j] > 9)
				result.append((char) (hex[j] + 55));
			else
				result.append(hex[j]);
		}

		return result.toString();
	}

	public int octalToBinary(int octal) {
		int[] octalValues = { 0, 1, 10, 11, 100, 101, 110, 111 };

		int temp = octal;
		int binary = 0;
		int place = 1;
		while (temp != 0) {
			int rem = (int) (temp % 10);
			binary = octalValues[rem] * place + binary;
			temp /= 10;
			place *= 1000;
		}
		return binary;
	}

	public int octalToDecimal(int octal) {
		int decimal = 0;
		int n = 0;
		while (octal != 0) {
			int temp = octal % 10;
			decimal += temp * Math.pow(8, n);
			octal = octal / 10;
			n++;
		}
		return decimal;
	}

	public String octalToHexadecimal(int octal) {
		int decimal = octalToDecimal(octal);
		String hex = decimalToHex(decimal);
		return hex;
	}

	public String decimalToBinary(int decimal) {
		StringBuilder binary = new StringBuilder();

		while (decimal > 0) {
			binary.append(decimal % 2);
			decimal = decimal / 2;
		}

		return binary.reverse().toString();
	}

	public String decimalToOctal(int decimal) {
		int rem;
		StringBuilder octal = new StringBuilder();
		char octalchars[] = { '0', '1', '2', '3', '4', '5', '6', '7' };

		while (decimal > 0) {
			rem = (int) decimal % 8;
			octal.append(octalchars[rem]);
			decimal = decimal / 8;
		}

		return octal.reverse().toString();
	}

	public String decimalToHex(int decimal) {
		StringBuilder hex = new StringBuilder();
		char hexValues[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		while (decimal > 0) {
			int rem = decimal % 16;
			hex.append(hexValues[rem]);
			decimal = decimal / 16;
		}
		return hex.reverse().toString();
	}

	public String hexadecimalToBinary(String hex) {
		int decimal = hexadecimalToDecimal(hex);
		String binary = decimalToBinary(decimal);
		return binary;
	}

	public String hexadecimalToOctal(String hex) {
		int decimal = hexadecimalToDecimal(hex);
		String octal = decimalToOctal(decimal);
		return octal;
	}

	public int hexadecimalToDecimal(String hex) {
		String digits = "0123456789ABCDEF";
		hex = hex.toUpperCase();
		int val = 0;
		for (int i = 0; i < hex.length(); i++) {
			char c = hex.charAt(i);
			int d = digits.indexOf(c);
			val = 16 * val + d;
		}
		return val;
	}

}
