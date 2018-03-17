package newer;

import java.util.*;
public class Main{
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n,m;
        while(in.hasNext()){
            n = in.nextInt();
            m = in.nextInt();
            Combination(1,n,m,list);
        }
    }
    private static void Combination(int begin,int n,int m,List<Integer> list){
        if(m == 0){
            for(int j = 0;j<list.size()-1;j++)
                System.out.print(list.get(j)+" ");
            System.out.println(list.get(list.size()-1));
            return;
        }
        if(begin > n || m < 0){
            return;
        }
        list.add(begin);
        Combination(begin+1,n,m-begin,list);
        list.remove(list.size()-1);
        Combination(begin+1,n,m,list);
    }
}
