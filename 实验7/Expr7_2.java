import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.io.BufferedReader;

public class Expr7_2 {

//    private static final Pattern wordPattern = Pattern.compile("\\W+");

    public static void main(String[] args){
        if (args.length<2){
            System.out.println("命令行参数不足");
            return;
        }
        File file = new File(args[0]);
        String Keyword = args[1];
        if (!file.exists()){
            System.out.println("该文件不存在");
            return;
        }
        long lines=0;
        long chars=0;
        long words=0;
        long keylines=0;
        try (Scanner scanner = new Scanner(file, "UTF-8")) {
            String temp1=Keyword.toLowerCase();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines++;
                chars += line.length();

                if (line.toLowerCase().indexOf(temp1) != -1) {
                    System.out.println(lines + ":" + line);
                    keylines++;
                }

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


//        try(BufferedReader reader= Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)) {
//            String line;
//            String temp1=Keyword.toLowerCase();
//            while ((line=reader.readLine())!=null){
//                lines++;
//                chars+=line.length();
//
//                if (line.toLowerCase().indexOf(temp1)!=-1) {
//                    System.out.println(lines + ":" + line);
//                    keylines++;
//                }
//
//                String[] parts=wordPattern.split(line);
//                for(String part:parts){
//                    if (!part.isEmpty())
//                        words++;
//                }
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("总行数:"+lines);
        System.out.println("总单词数:"+words);
        System.out.println("总字符数(不含换行):"+chars);
        System.out.println("包含关键词的行数:"+keylines);

    }
}
