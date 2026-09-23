import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Expr7_3 {
    private static boolean is_Vowel(char letter){
        return letter == 'a'||letter == 'e'||letter == 'i'||letter == 'o'||letter == 'u';
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("命令行参数不足，请提供文件名！");
            return;
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("该文件不存在：" + args[0]);
            return;
        }

        long lines = 0;
        long chars = 0;
        long words = 0;
        long v_letters = 0;
        int maxLineLength = 0;

        try (Scanner scanner = new Scanner(file, "UTF-8")) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                lines++;
                chars += line.length();

                if (line.length() > maxLineLength) {
                    maxLineLength = line.length();
                }

                for (int i=0;i<line.length();i++)
                    if (is_Vowel(line.toLowerCase().charAt(i)))
                        v_letters++;

                try (Scanner wordScanner = new Scanner(line)) {
                    while (wordScanner.hasNext()) {
                        wordScanner.next();
                        words++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("字符总数: " + chars);
        System.out.println("单词总数: " + words);
        System.out.println("总行数: " + lines);
        System.out.println("最长行的长度: " + maxLineLength);
        System.out.println("元音字母个数: " + v_letters);
    }
}
