public class PascalTriangle {
    // A 2-D array representing PascalTriangle
    // holding values for PascalTrianglet
    private int[][] pascalTriangleArr;
    
    public int[][] getPascalTriangleArr(){
        return pascalTriangleArr;
    }
    public void setPascalTriangleArr(int[][] pascalTriangleArr) {
        this.pascalTriangleArr = pascalTriangleArr;
    }


    // print pascal triangle method
    public void printPascalTriangle() {
        for(int row=0; row<pascalTriangleArr.length; i++){
            for(int cols=0; cols<pascalTriangleArr[0].length; cols++){
                System.out.println();
            }
        }
    }

    // calculate pascal triangle given the level

    // 

}