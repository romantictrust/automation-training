using System;
using NUnit.Framework;

namespace unit_testing
{
    [TestFixture]
    public class PrimeService_IsPrimeShould
    {
        [Test]
        public void arbitraryTriangle()
        {
            double a = 9, b = 10, c = 11;
            var result = Program.isTriangleExists(a, b, c);
            Assert.IsTrue(result);
        }

        [Test]
        public void isoscelesTriangle()
        {
            double a = 11.11, b = 1.1, c = 11.11;
            var result = Program.isTriangleExists(a, b, c);
            Assert.IsTrue(result);
        }

        [Test]
        public void equilateralTriangle()
        {
            double a = 11.1, b = 11.1, c = 11.1;
            var result = Program.isTriangleExists(a, b, c);
            Assert.IsTrue(result);
        }

        [Test]
        public void rightTriangle()
        {
            double a = 3, b = 4, c = 5;
            var result = Program.isTriangleExists(a, b, c);
            Assert.IsTrue(result);
        }

        [Test]
        public void allSidesAreInfinity()
        {
            double a = Double.PositiveInfinity, b = Double.PositiveInfinity, c = Double.PositiveInfinity;
            var result = Program.isTriangleExists(a, b, c);
            Assert.IsFalse(result, "One side is infinity");
        }

        [Test]
        public void sumOfTwoIsLessThanThird()
        {
            double a = 1, b = 11, c = 13;
            var result = Program.isTriangleExists(a, b, c);
            Assert.IsFalse(result, "The sum of 2 sides is more than third.");
        }

        [Test]
        public void oneSideIsZero()
        {
            double a = 11, b = 11, c = 0;
            Assert.Throws<NotImplementedException>(() => Program.isTriangleExists(a, b, c));
        }

        [Test]
        public void oneSideIsNegative()
        {
            double a = 11, b = 11, c = -11;
            Assert.Throws<NotImplementedException>(() => Program.isTriangleExists(a, b, c));
        }

        [Test]
        public void sumOfTwoIsEqualsThird()
        {
            double a = 11, b = 11, c = 22;
            var result = Program.isTriangleExists(a, b, c);
            Assert.IsFalse(result);
        }

        [Test]
        public void oneSideIsNaN()
        {
            double a = 11, b = 11, c = Double.NaN;
            var result = Program.isTriangleExists(a, b, c);
            Assert.IsFalse(result);
        }

    }
}