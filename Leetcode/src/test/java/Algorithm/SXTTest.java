package Algorithm;

import org.junit.Test;

public class SXTTest {

    /**
     * 二维数组-->稀疏数组
     */
    @Test
    public void SparseArrToChessArr(){
        int[][] chessArr = {
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,2,0,0,0,0,0,0,0},
                {0,0,0,0,2,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,2,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0}
        };

        int row = chessArr.length;
        int col = chessArr[0].length;
        int sum = 0;



        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (chessArr[i][j] != 0){
                    sum ++;
                }
            }
        }

        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = row;
        sparseArr[0][1] = col;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (chessArr[i][j] != 0){

                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];

                }
            }
        }

        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                System.out.print(sparseArr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 稀疏数组-->二维数组
     */
    @Test
    public void ChessArrToSparseArr(){
        int[][] sparseArr = {
                {11,11,6},
                {1,2,1},
                {2,3,2},
                {3,4,2},
                {4,5,1},
                {6,2,2},
                {7,3,1},
        };

        int[][] chessArr = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                chessArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
            }
        }

        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                System.out.print(chessArr[i][j] + "\t");
            }
            System.out.println();
        }
    }


    /**
     * 数组实现队列
     */
    @Test
    public void ArrayQueue(){
        ArrayQueue queue = new ArrayQueue(5);
        queue.addQueue(3);
        queue.addQueue(2);
        queue.addQueue(1);
        queue.addQueue(4);
        queue.addQueue(5);
        queue.addQueue(6);
        queue.showQueue();
    }
}

class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isFull(){
        return rear == maxSize - 1;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue( int n ){
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        rear ++;
        arr[rear] = n;
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能获取数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列空，没有数据");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+"\t");
        }
    }

    public int showFront(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能获取数据");
        }
        return arr[front + 1];
    }
}