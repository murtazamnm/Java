package basics;
public class Matrix {
    private double data[][];
    private int colNum;
    private int rowNum;
    private static double idMatrix[][];

    //constructor overloading
    public Matrix(){

    }
    //when the user wants to creat an empty Matrix
    public Matrix(int rowNum, int colNum){
        this.rowNum = rowNum;
        this.colNum = colNum;
        data = new double[rowNum][colNum];
    }

    public Matrix(int rowNum, int colNum, double[] linearData){
        if( rowNum * colNum != linearData.length) throw new IllegalArgumentException();
        this.rowNum = rowNum;
        this.colNum = colNum;
        data = new double[rowNum][colNum];
        for (int i =0;i < linearData.length;i++){
            int row = (int)Math.floor(i/colNum);
            int col = i % colNum;
            data[row][col] = linearData[i];
        }
    }
    
    //creates an identity matrix of size n x n
    public static void identityMatrix(int size){

        idMatrix = new double[size][size];
        for (int i =0;i < size*size ;i++){
            int row = (int)Math.floor(i/size);
            int col = i % size;
            if(row != col){
                idMatrix[row][col] = 0;
            }
            else{
                idMatrix[row][col] = 1;
            }
        }
    }

    //transposes a matrix
    public Matrix transpose(){
        Matrix tr = new Matrix(colNum,rowNum);
        for(int i = 0; i< rowNum;i++){
            for(int j = 0; j < colNum; j++){
                tr.data[j][i] = data[i][j]; 
            }
        }
        return tr;
    }

    //adds two matrices
    public Matrix addMatrix(Matrix dataTwo){
        //if size is not equal we throw an exception
        if(dataTwo.rowNum != rowNum && dataTwo.colNum != colNum){
            throw new IllegalArgumentException();
        }
        Matrix addedMatrix = new Matrix(rowNum,colNum);
        for(int i = 0; i < rowNum; i++ ){
            for(int j = 0; j< colNum; j++){
                addedMatrix.data[i][j] = data[i][j] + dataTwo.data[i][j];
            }
        }
        return addedMatrix;
    }

    //gives the difference of two matrices
    public Matrix diffMatrix(Matrix dataTwo){
        //if size is not equal we throw an exception
        if(dataTwo.rowNum != rowNum && dataTwo.colNum != colNum){
            throw new IllegalArgumentException();
        }
        Matrix diffedMatrix = new Matrix(rowNum,colNum);
        for(int i = 0; i < rowNum; i++ ){
            for(int j = 0; j< colNum; j++){
                diffedMatrix.data[i][j] = data[i][j] - dataTwo.data[i][j];
            }
        }
        return diffedMatrix;
    }

    //string representation of a matrix
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String rowDelim = "\n";
        String colDelim = "";
        for(double[] row : data){

            for(double element: row){
                sb.append(colDelim);
                sb.append(element);
                colDelim = ", ";
            }
            colDelim = "";
            sb.append(rowDelim);
        }
        return sb.toString();
    }
}
