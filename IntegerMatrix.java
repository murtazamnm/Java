public class IntegerMatrix {
    private int rowNum;
    private int colNum;
    private int[][] data;

    public IntegerMatrix(int rowNum,int colNum,int[] linearData) {
        if (rowNum*colNum != linearData.length) {
            throw new IllegalArgumentException();
        }
        this.rowNum = rowNum;
        this.colNum = colNum;
        data = new int[rowNum][colNum];

        for (int i =0;i < linearData.length;i++){

            int row = (int)Math.floor(i/colNum);
            int col = i % colNum;
            data[row][col] = linearData[i];
            // for(int j = 0; j < colNum;j++,ind++){
            //     data[i][j] = linearData[ind];
            // }
        }
    }

    //1,2,3;4,5,6
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String rowDelim = "";
        String colDelin = "";
        for (int[] row: data) { //foreach loop
            sb.append(rowDelim);
            rowDelim = "\n";
            for (int element : row) {
                sb.append(colDelin);
                colDelin = ",";
                sb.append(element);
            }
            colDelin = "";
        }
        return sb.toString();

    }
} 