public class Pattern {
    public static void main(String[] args){
        printPattern(5);
        printPattern2(4, "*");
        printPattern3(3);
        printPattern4(4);
    }
    private static void printPattern(int n ){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(n);
            }
            System.out.print("\n");
        }
    }
    private static void printPattern2(int n ,String ch ){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(ch);
            }
            System.out.print("\n");
        }
    }
    private static void printPattern3(int n ){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(j);
            }
            System.out.print("\n");
        }
    }
    private static void printPattern4(int n ){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(i);
            }
            System.out.print("\n");
        }
    }
}
