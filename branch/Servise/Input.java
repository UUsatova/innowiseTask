package branch.Servise;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    public static int inputInt(){

        Scanner in = new Scanner(System.in);
        System.out.print( ">>");
        while (!in.hasNextInt()) {
            in.nextLine();
            System.out.print(">> ");   
        }
        return in.nextInt();
        
    }

    public static String input(){

        Scanner in = new Scanner(System.in);
        return in.nextLine();
        
    }

    public static String input(String rex){
        String str = input();
        while (!formCheking(rex,str)) {
            str = input();
           
        }
        return str;
    }

    public static boolean formCheking(String rex,String str){

        Pattern pattern = Pattern.compile(rex); 
        Matcher matcher = pattern.matcher(str);
        if(!matcher.matches()) System.out.print("Неверная запись.Попробуйте еще раз:\n>>");
        return matcher.matches();

    }
}
