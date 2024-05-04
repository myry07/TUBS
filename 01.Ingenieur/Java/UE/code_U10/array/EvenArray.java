package array;

public class EvenArray {
    public static int[][] buildEvenArray(int a, int b) {
	    if (a < b) {
        	int tmp = a;
        	a = b;
	    	b = tmp;
	    }

	    int[][] arr = new int[a][b];
	
        for (int i = 0; i < a; ++i) {
		    for (int j = 0; j < b; ++j) {
			    arr[i][j] = i * j;
			    if (i * j % 2 != 0) {
			    	arr[i][j] -= 1;
			    }
		    }
	    }
	    return arr;
    }
}