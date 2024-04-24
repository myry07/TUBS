package array.assign;

public class test {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = n1;
        n2 = 80;
        System.out.println(n1);
        System.out.println(n2);

        int[] arr1 = {1, 2};
        int[] arr2 = arr1;
        arr2[0] = 10;

        for(int wert: arr1) {
            System.out.print(wert + " ");
        }

        int[] arr3 = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }

        arr3[0] = 40;

        for(int wert: arr3) {
            System.out.print(wert + " ");
        }


    }
}
