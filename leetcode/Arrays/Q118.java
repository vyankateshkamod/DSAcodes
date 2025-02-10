import java.util.*;
public class Q118 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        System.out.print("Enter Number : ");
        int numRows = scanner.nextInt() ;
        
        List<List<Integer>> triangle = generate2(numRows) ;

        for(List<Integer> row : triangle){
            System.out.println(row);
        }
        scanner.close();
    }

    // Optimal
    // tc : n2
    // sc : n2

    public static List<List<Integer>> generate(int numRows) { 
        List<List<Integer>> ans = new ArrayList<>() ;

        for(int row = 1 ; row <= numRows ; row++){
            ans.add(generateRow(row)) ;
        }

        return ans ;
    }

    public static List<Integer> generateRow(int row){
        List<Integer> row_ans = new ArrayList<>() ;
        int ans = 1 ;
        row_ans.add(ans) ;
        for(int col = 1 ;col<row ;col++){    // generating row element with nCr fomula
            ans = ans*(row-col) ;            
            ans = ans/col ;
            row_ans.add(ans) ;
        }
        return row_ans ;
    }

    //Optimal //My solution
    //tc : n2
    //sc : n2
    public static List<List<Integer>> generate2(int numRows) {
        
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < numRows; i++) {

            if (i == 0) {
                list.get(0).add(1);
            }
            else if(i==1){
                list.get(1).add(1);
                list.get(1).add(1);
            }
            else{
                list.get(i).add(1);
                for(int j = 1 ; j < list.get(i-1).size() ;j++){
                    int first = list.get(i-1).get(j) ;
                    int second = list.get(i-1).get(j-1) ;
                    list.get(i).add(first+second) ;
                }
                list.get(i).add(1);
            }
        }
        return list ;
    }
}
