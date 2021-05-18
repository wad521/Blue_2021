package LeetCode_3月;

/**
 * @author:yxl
 **/
public class 设计停车场系统 {

}

class ParkingSystem {
    public int big, medium, small;
    public int[] count = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
        count[0] = big;
        count[1] = medium;
        count[2] = small;
    }

    public boolean addCar(int carType) {
        if (count[carType - 1] > 0) {
            count[carType - 1]--;
            return true;
        } else {
            return false;
        }
    }
}
