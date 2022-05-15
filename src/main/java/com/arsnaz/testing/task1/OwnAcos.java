package com.arsnaz.testing.task1;

public class OwnAcos {
    public static double acos(double x) {
        boolean neg = false;
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        if (Double.isInfinite(x)) {
            return Double.NaN;
        }
        if (Double.compare(Math.abs(x), 1.0) == 1) {
            return Double.NaN;
        }
        if (x < 0) {
            neg = true;
            x = -x;
        }
        double ans = x;
        double a = 1;
        double b = 2;
        double tmp = 1;
        double i = 2;
        while (tmp > 0.0000001) {
            tmp = Math.pow(x, 2 * i - 1) * a / (b * (2 * i - 1));
            ans += tmp;
            a *= 2L * i - 1;
            b *= 2L * i;
            i++;
        }
        double result = Math.PI / 2 - ans;
        if (neg) {
            result = Math.PI - result;
        }
        return result;
    }

}