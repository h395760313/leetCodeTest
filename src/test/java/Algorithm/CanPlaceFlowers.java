package Algorithm;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] ints = {0,0,1,0,0};
        System.out.println(canPlaceFlowers(ints,2));
    }


    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int count = 0;
        if (len == 1){
            if (flowerbed[0] == 0){
                count ++;
            }
            return count >= n;
        }
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            count ++;
        }
        for (int i = 1; i < len - 1; i++) {
            if (flowerbed[i-1] == 0 && flowerbed[i+1] == 0 && flowerbed[i] == 0){
                flowerbed[i] = 1;
                count++;
            }
        }
        if (flowerbed[len - 2] == 0 && flowerbed[len - 1] == 0) {
            flowerbed[len - 1] = 1;
            count ++;
        }
        return count >= n;
    }
}
