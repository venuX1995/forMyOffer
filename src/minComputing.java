import java.util.Scanner;

public class minComputing {
    public static int computingCounts(int x,int y){
        if(x == y)
            return 0;
        if(x > y )
            return x-y;
        int count = 0;
        if(x*y>0){
            while( x<y ){
                if(x*y>0 && x>0){
                    if(y%2 == 0){
                        y /= 2;
                        count++;
                    }else{
                        y +=1;
                        y /= 2;
                        count +=2;
                    }
                }
            }
        }else if(x<0){
            count += 1-x;
            x = 1;
            while( x<y ){
                if(x*y>0 && x>0){
                    if(y%2 == 0){
                        y /= 2;
                        count++;
                    }else{
                        y +=1;
                        y /= 2;
                        count +=2;
                    }
                }
            }
        }
        count += x-y;
        return count;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] str = new String[2];
        if(in.hasNextLine()){
            String line = in.nextLine();
            str = line.split(",");
        }
        int x = Integer.valueOf(str[0]);
        int y = Integer.valueOf(str[1]);
        System.out.print(computingCounts(x,y));
    }
}
