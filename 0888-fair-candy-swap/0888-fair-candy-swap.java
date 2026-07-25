class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int aliceSum = 0;
        int bobSum = 0;

        for (int candy : aliceSizes) {
            aliceSum += candy;
        }

        for (int candy : bobSizes) {
            bobSum += candy;
        }

        int diff = (aliceSum - bobSum) / 2;

        HashSet<Integer> set = new HashSet<>();

        for (int candy : aliceSizes) {
            set.add(candy);
        }

        for (int candy : bobSizes) {
            if (set.contains(candy + diff)) {
                return new int[]{candy + diff, candy};
            }
        }

        return new int[]{};
    }
}