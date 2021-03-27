package com.zsy.datastructure.sparsearray;

/**
 * 使用稀疏数组，来保存二维数组棋盘(11*11)
 * 把稀疏数组存盘，并且可以重新恢复原来的二维数组数组
 *
 * @author zhangshuaiyin
 * @date: 2021/3/27 19:09
 */
public class SparseArray {
    /**
     * 初始二维数组棋盘大小
     */
    private final static int ROW = 11;
    private final static int COL = 11;

    public static void main(String[] args) {
        /* *****************************二维数组转稀疏数组******************************** */
        System.out.println("*****************************二维数组转稀疏数组********************************");
        // 初始化棋盘二维数组, 其中0代表空棋盘，1代表黑子，2代表蓝子
        int[][] chessArray = new int[ROW][COL];
        chessArray[0][1] = 1;
        chessArray[1][3] = 2;
        chessArray[2][5] = 1;
        // 输出二维数组棋盘
        System.out.println("二维数组棋盘：");
        printChessArray(chessArray);

        // 2. 获取二维数组有效数据个数(棋盘中棋子个数)
        int sum = getChessSum(chessArray);
        System.out.println("棋盘中有效数据个数：" + sum);

        // 3. 初始化稀疏数组 稀疏数组行数为有效棋子数加1, 列数为3
        int[][] sparseArray = new int[sum + 1][3];
        // 稀疏数组第一行三个数据分别代表：棋盘行数 棋盘列数 棋子个数
        sparseArray[0][0] = ROW;
        sparseArray[0][1] = COL;
        sparseArray[0][2] = sum;

        // 4. 将二维数组数据保存到稀疏数组
        chessToSparse(chessArray, sparseArray);
        // 输出稀疏数组
        System.out.println("稀疏数组：");
        printSparseArray(sparseArray);

        /* *****************************稀疏数组转二维数组******************************** */
        System.out.println("*****************************稀疏数组转二维数组********************************");
        chessArray = sparseToChess(sparseArray);
        // 输出二维数组棋盘
        System.out.println("恢复的二维数组棋盘：");
        printChessArray(chessArray);
    }

    /**
     * 稀疏数组还原二维数组棋盘
     *
     * @param sparseArray 稀疏数组
     * @return 棋盘
     */
    private static int[][] sparseToChess(int[][] sparseArray) {
        // 1. 读取稀疏数组第一行，获取棋盘信息
        int row = sparseArray[0][0];
        int col = sparseArray[0][1];
        int[][] chessArray = new int[row][col];
        // 2. 读取稀疏数组其余行，获取棋子信息
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return chessArray;
    }

    /**
     * 输出二维数组棋盘
     *
     * @param chessArray 棋盘数组
     */
    public static void printChessArray(int[][] chessArray) {
        for (int[] rows : chessArray) {
            for (int item : rows) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }

    /**
     * 获取棋盘中棋子个数
     *
     * @param chessArray 棋盘数组
     * @return 棋子个数
     */
    public static int getChessSum(int[][] chessArray) {
        int sum = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    /**
     * 输出稀疏数组
     *
     * @param sparseArray 稀疏数组
     */
    public static void printSparseArray(int[][] sparseArray) {
        for (int[] rows : sparseArray) {
            for (int item : rows) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }

    /**
     * 二维数组数据保存到稀疏数组中
     * line：稀疏数组的行号
     * <p>
     * 稀疏数组数据保存结构：
     * 第一行：棋盘行数 棋盘列数 棋子个数
     * 第二行：棋子行数 棋子列数 棋子值
     * ......
     *
     * @param chessArray  棋盘数组
     * @param sparseArray 稀疏数组
     */
    public static void chessToSparse(int[][] chessArray, int[][] sparseArray) {
        // 稀疏数组行号
        int line = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (chessArray[i][j] != 0) {
                    line++;
                    sparseArray[line][0] = i;
                    sparseArray[line][1] = j;
                    sparseArray[line][2] = chessArray[i][j];
                }
            }
        }
    }
}
