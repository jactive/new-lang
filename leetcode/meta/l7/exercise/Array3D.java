package leetcode.meta.l7.exercise;

public class Array3D {
    public static void main(String[] args) {
        int[][][] fixed = new int[2][3][4];
        for (int i = 0; i < fixed.length; i++) {
            for (int j = 0; j < fixed[i].length; j++) {
                fixed[i][j] = new int[i + j];
                // change the fixed array length
            }
        }

        int[][][] varied = new int[2][3][];
        for (int i = 0; i < varied.length; i++) {
            for (int j = 0; j < varied[i].length; j++) {
                varied[i][j] = new int[i + j];
            }
        }


        int[][][] varied2 = new int[2][][];
        varied2[0] = new int[3][];
        varied2[0][0] = new int[0];
        varied2[0][1] = new int[1];
        varied2[0][2] = new int[2];

        varied2[1] = new int[5][];
        varied2[1][0] = new int[0];
        varied2[1][1] = new int[1];
        varied2[1][2] = new int[2];
        varied2[1][3] = new int[3];
        varied2[1][4] = new int[4];


        varied = new int[3][][];
        for (int i = 0; i < varied.length; i++) {
            varied[i] = new int[2 * i + 1][];
            for (int j = 0; j < varied[i].length; j++) {
                varied[i][j] = new int[2 * j + 1];
            }
        }

        System.out.println(varied);
    }
}

