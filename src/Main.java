import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int var1, var2;
        char znak = 0;
        String result;


        System.out.println("Input: ");
        String userInput = scan.nextLine();
        char[] oper_char = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            oper_char[i] = userInput.charAt(i);
            if (oper_char[i] == '+') {
                znak = '+';
            }
            if (oper_char[i] == '-') {
                znak = '-';
            }
            if (oper_char[i] == '*') {
                znak = '*';
            }
            if (oper_char[i] == '/') {
                znak = '/';
            }
        }

        String oper_charString = String.valueOf(oper_char);
        String[] signs = oper_charString.split("[+-/*]");
        String stb0 = signs[0];
        String stb1 = signs[1];
        String strings = stb1.trim();
        if (signs.length > 2
        )
            throw new ArrayIndexOutOfBoundsException("Не более двух операндов!");
        else {
            try {
                Integer.parseInt(stb0); // проверяем, есть ли в строке арабские цифры
                Integer.parseInt(strings);
                var1 = Integer.parseInt(stb0);
                var2 = Integer.parseInt(strings);
                result = calc(var1, var2, znak);
                System.out.println("Output:");
                System.out.println(var1 + " " + znak + " " + var2 + " = " + result); //вывод результата операции между арабскими цифрами

            }

            catch (NumberFormatException e) { //  в строке нет арабских цифр, значит операция между римскими цифрами

                var1 = Enum.convertRomanToArab(stb0);
                var2 = Enum.convertRomanToArab(strings);


                result = calc(var1, var2, znak);
                System.out.println("Output:");
                String resultRoman = Enum.convertNumToRoman(Integer.parseInt(result));
                System.out.println(stb0 + " " + znak + " " + strings + " = " + resultRoman);



            }
        }



    }


    public static String calc(int var1, int var2, char znak){
       if (var1 <= 0 || var1 > 10 || var2 <= 0 || var2 > 10) throw new IllegalArgumentException("Число больше 10");
        String result = "";
        switch (znak){
            case '+':
                result = String.valueOf(var1+var2);
                break;
            case '-':
                result = String.valueOf(var1-var2);
                break;
            case '*':
                result = String.valueOf(var1*var2);
                break;
            case '/':
                try {
                    result = String.valueOf(var1 / var2);
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Допускаются только целые числа");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак!");

        }
        return result;
    }


static class Enum {



    static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        return roman[numArabian];
    }



    static int convertRomanToArab(String numRoman) {
        try {
            switch (numRoman) {
                case "I" -> {
                    return 1;
                }
                case "II" -> {
                    return 2;
                }
                case "III" -> {
                    return 3;
                }
                case "IV" -> {
                    return 4;
                }
                case "V" -> {
                    return 5;
                }
                case "VI" -> {
                    return 6;
                }
                case "VII" -> {
                    return 7;
                }
                case "VIII" -> {
                    return 8;
                }
                case "IX" -> {
                    return 9;
                }
                case "X" -> {
                    return 10;
                }
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException();
        }

        return 0;
    }







}
}
