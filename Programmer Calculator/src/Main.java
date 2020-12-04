import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// para maiba naman hehe
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int command = 0;
		do {
			System.out.println("\n\nProgrammer`s Calculator");
			System.out.println("1 - Binary To Decimal");
			System.out.println("2 - Binary To Octal");
			System.out.println("3 - Binary To Hexadecimal");
			System.out.println("--------------------------");
			System.out.println("4 - Octal To Binary");
			System.out.println("5 - Octal To Decimal");
			System.out.println("6 - Octal To Hexadecimal");
			System.out.println("--------------------------");
			System.out.println("7 - Decimal To Binary");
			System.out.println("8 - Decimal To Octal");
			System.out.println("9 - Decimal To Hexadecimal");
			System.out.println("--------------------------");
			System.out.println("10 - Hexadecimal To Binary");
			System.out.println("11 - Hexadecimal To Octal");
			System.out.println("12 - Hexadecimal To Decimal");
			System.out.println("--------------------------");
			System.out.println("13 - Exit");
			System.out.print("Select conversion(1-12): ");
			command = Integer.parseInt(br.readLine());
			Converter convert = new Converter();
			switch (command) {
			case 1: {
				System.out.print("\nEnter binary number: ");
				int binary = Integer.parseInt(br.readLine());
				
				if(!isBinaryNumber(binary)) {
					System.out.println("Invalid binary number: " + binary);
					continue;
				}
				
				int decimal = convert.binaryToDecimal(binary);
				System.out.println("\nBinary: " + binary + " = Decimal: " + decimal);
					
				continue;
			}
			case 2: {
				System.out.print("\nEnter binary number: ");
				int binary = Integer.parseInt(br.readLine());
				if(!isBinaryNumber(binary)) {
					System.out.println("Invalid binary number: " + binary);
					continue;
				}
				String octal = convert.binaryToOctal(binary);
				System.out.print("Binary: " + binary + " = Octal: " + octal);
				continue;
			}
			case 3: {
				System.out.print("\nEnter binary number: ");
				int binary = Integer.parseInt(br.readLine());
				
				if(!isBinaryNumber(binary)) {
					System.out.println("Invalid binary number: " + binary);
					continue;
				}
				
				String hex = convert.binaryToHexadecimal(binary);
				
				System.out.print("Binary: " + binary + " = Hexadecimal: " + hex);
				continue;
			}
			case 4: {
				System.out.print("\nEnter octal number: ");
				int octal = Integer.parseInt(br.readLine());
				if(!isOctalNumber(octal)) {
					System.out.println("Invalid octal number: " + octal);
					continue;
				}
				int binary = convert.octalToBinary(octal);
				System.out.print("Octal: " + octal + " = Binary: " + binary);
				continue;
			}
			case 5: {
				System.out.print("\nEnter octal number: ");
				int octal = Integer.parseInt(br.readLine());
				if(!isOctalNumber(octal)) {
					System.out.println("Invalid octal number: " + octal);
					continue;
				}
				int decimal = convert.octalToDecimal(octal);
				System.out.print("Octal: " + octal + " = Decimal: " + decimal);
				continue;
			}
			case 6: {
				System.out.print("\nEnter octal number: ");
				int octal = Integer.parseInt(br.readLine());
				if(!isOctalNumber(octal)) {
					System.out.println("Invalid octal number: " + octal);
					continue;
				}
				String hex = convert.octalToHexadecimal((octal));
				System.out.print("Octal: " + octal + " = Decimal: " + hex);
				continue;
			}
			case 7: {
				System.out.print("\nEnter decimal number: ");
				int decimal = Integer.parseInt(br.readLine());
				System.out.print("Decimal: " + decimal + " = Binary: " + convert.decimalToBinary((decimal)));
				continue;
			}
			case 8: {
				System.out.print("\nEnter decimal number: ");
				int decimal = Integer.parseInt(br.readLine());
				System.out.print("Decimal: " + decimal + " = Octal: " + convert.decimalToOctal((decimal)));
				continue;
			}
			case 9: {
				System.out.print("\nEnter decimal number: ");
				int decimal = Integer.parseInt(br.readLine());
				String hex = convert.decimalToHex(decimal);
				System.out.print("Decimal: " + decimal + " = Hexadecimal: " + hex);
				continue;
			}
			case 10: {
				System.out.print("\nEnter hexadecimal number: ");
				String hex = br.readLine();
				if(!isHexadecimalNumber(hex)) {
					System.out.println("Invalid hexadecimal number: " + hex);
					continue;
				}
				String binary = convert.hexadecimalToBinary(hex);
				System.out.println("Hexadecimal: " + hex + " = Binary: " + binary);
				continue;
			}
			case 11: {
				System.out.print("\nEnter hexadecimal number: ");
				String hex = br.readLine();
				if(!isHexadecimalNumber(hex)) {
					System.out.println("Invalid hexadecimal number: " + hex);
					continue;
				}
				String octal = convert.hexadecimalToOctal(hex);
				System.out.println("Hexadecimal: " + hex + " = Octal: " + octal);
				continue;
			}
			case 12: {
				System.out.print("\nEnter hexadecimal number: ");
				String hex = br.readLine();
				if(!isHexadecimalNumber(hex)) {
					System.out.println("Invalid hexadecimal number: " + hex);
					continue;
				}
				int decimal = convert.hexadecimalToDecimal(hex);
				System.out.println("Hexadecimal: " + hex + " = Decimal: " + decimal);
				continue;
			}
			case 13: {
				return;
			}
			default:
				System.out.println("Invalid Command.");
				continue;
			}

		} while (command != 13);

	}

	
	
	// NUMBER CHECKERS
	public static boolean isBinaryNumber(int num) {

		while (num > 0) {
			if (num % 10 > 1)
				return false;
			num /= 10;
		}
		return true;
	}

	public static boolean isOctalNumber(int octal) {
		while (octal > 0) {
			if (octal % 10 > 7)
				return false;
			octal /= 10;
		}
		return true;
	}

	public static boolean isHexadecimalNumber(String hex) {
		for (int i = 0; i < hex.length(); i++) {
			char ch = hex.charAt(i);
			if ((ch < '0' || ch > '9') && (ch < 'A' || ch > 'F')) return false;
		}
		return true;
	}
}
