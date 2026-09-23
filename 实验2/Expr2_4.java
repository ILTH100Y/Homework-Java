import java.util.Scanner;

public class Expr2_4 {
    /* Return the number of digits in d */
    public static int getSize(long d){
        return String.valueOf(d).length();
    }

    /* Return the first k number of digits from number. */
    public static long getPrefix(long number, int k){
        String temp = String.valueOf(number);
        return temp.length() > k ? Long.parseLong(temp.substring(0, k)) : number;
    }

    /* Return true if the number d is a prefix for number */
    public static boolean prefixMatched(long number, int d){
        return getPrefix(number, getSize(d)) == d;
    }

    /* Return this number if it is a single digit, otherwise return sum of two digits */
    public static int getDigit(int number){
        return number / 10 + number % 10;
    }

    /* Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number){
        int sum = 0;
        number /= 10;
        while (number > 0) {
            int temp = (int)(number % 10);
            sum += getDigit(temp * 2);
            number /= 100;
        }
        return sum;
    }

    /* Return sum of odd place digits in number */
    public static int sumOfOddPlace(long number){
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 100;
        }
        return sum;
    }

    /* Return true if the card number is valid */
    public static boolean isValid(long number) {
        int size = getSize(number);
        if (size < 13 || size > 16) return false;

        if (!(prefixMatched(number, 4) ||
                prefixMatched(number, 5) ||
                prefixMatched(number, 37) ||
                prefixMatched(number, 6))) {
            return false;
        }

        int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        return sum % 10 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long card = sc.nextLong();
        sc.close();
        System.out.println(card + " : " + (isValid(card) ? "合法" : "不合法"));
    }
}