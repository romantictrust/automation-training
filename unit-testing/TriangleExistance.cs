using System;

namespace unit_testing
{
    class Program
    {
        private static String NEGATIVE_OR_ZERO_SIDE = "The side of triangle can't be negative or equal to 0";
        public static bool isTriangleExists(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0)
            throw new NotImplementedException(NEGATIVE_OR_ZERO_SIDE);
        return (a + b) > c && (b + c) > a && (a + c) > b;
    }
    }
}
