package array.assign;

public class arrfanzhuan {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        int[] arr_add = new int[arr.length - 1];
        for (int i = 0; i < arr_add.length; i++) {
            arr_add[i] = arr[i];
        }
        arr = arr_add;

//        int temp = 0;
//        for (int i = 0; i < arr.length / 2; i++) {
//            temp = arr[i];
//            arr[i] = arr[arr.length - 1 - i];
//            arr[arr.length - 1 - i] = temp;
//        }
//
        for(int wert : arr) {
            System.out.print(wert + " ");
        }


    }
}
