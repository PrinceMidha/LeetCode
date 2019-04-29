package com.algo.kotlin.FrogJump;

import java.util.Arrays;

public class FrogJump {

    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();

        System.out.println(frogJump.canCross(new int[]{0,1,3,5,6,8,12,17}));
    }

    public boolean canCross(int[] stones) {
        return can_Cross(stones, 0, 0);
    }

    public boolean can_Cross(int[] stones, int ind, int jumpsize) {
        if (ind == stones.length - 1) {
            return true;
        }
        int ind1 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize);
        if (ind1 >= 0 && can_Cross(stones, ind1, jumpsize)) {
            return true;
        }
        int ind2 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize - 1);
        if (ind2 >= 0 && can_Cross(stones, ind2, jumpsize - 1)) {
            return true;
        }
        int ind3 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize + 1);
        if (ind3 >= 0 && can_Cross(stones, ind3, jumpsize + 1)) {
            return true;
        }
        return false;
    }
}
