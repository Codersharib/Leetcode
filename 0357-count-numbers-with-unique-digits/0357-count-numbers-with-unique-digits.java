class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int num = 1;
        while (n > 0) {
            num *= 10;
            n--;
        }
        int count = 0;
        for (int i = 0; i < num; i++) {
            if (!is_equal(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean is_equal(int n) {
        boolean[] seen = new boolean[10];
        if (n == 0)
            return false;
        while (n > 0) {
            int dig = n % 10;
            if (seen[dig])
                return true;
            seen[dig] = true;
            n /= 10;
        }
        return false;

    }
}