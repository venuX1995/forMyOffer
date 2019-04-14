import java.util.Scanner;

public class StringUnfold {
    public static String unfold(String input){
        if(input == null ||input.length()==0)
            return null;
        StringBuffer sb = new StringBuffer();
        StringBuffer num = new StringBuffer();
        for(int i=input.length()-1;i>=0;i--){
            char cha = input.charAt(i);
            if(cha!='(' && cha!=')' && cha!='[' && cha!=']' && cha!='{' && cha!='}'){
                System.out.print(cha);
                byte ascii = (byte)cha;
                if((ascii>=65 && ascii<=90)||(ascii>=97 && ascii<=122)){
                    if(num.length()!=0){
                        int count = Integer.valueOf(num.toString());
                        System.out.print(count);
                        System.out.print(sb.length());
                        char temp = sb.charAt(sb.length()-1);
                        for(int j=1;j<count;j++){
                            sb.append(temp);
                        }
                        num.delete(0,num.length()-1);
                    }
                    sb.append(cha);
                }
                if(ascii>=48 && ascii<=57){
                    num.append(cha);
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = "";
        if(in.hasNextLine()){
            input = in.nextLine();
        }
        System.out.print(unfold(input));
    }
}
