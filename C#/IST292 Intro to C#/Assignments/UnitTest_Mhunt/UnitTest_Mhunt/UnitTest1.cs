using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

/* 
 * Name: Matthew Hunt
 * Project: Unit Test Assignment
 * Date: 9/24/17
 * Purpose: Tests a time converter method.
 */

namespace UnitTest_Mhunt
{
    [TestClass]
    public class UnitTest1
    {

        [TestMethod]
        public void UnderLowEndTestMethod()
        {
            Assert.AreEqual("ERROR: time is under 0.", TimeConverter(-0.01));
        }

        [TestMethod]
        public void LowEndTestMethod()
        {
            Assert.AreEqual("0:00", TimeConverter(0.00));
        }

        [TestMethod]
        public void NineMinutesTestMethod()
        {
            Assert.AreEqual("9:00", TimeConverter(9.00));
        }

        [TestMethod]
        public void NineAndOneFourthMinutesTestMethod()
        {
            Assert.AreEqual("9:15", TimeConverter(9.25));
        }

        [TestMethod]
        public void NineAndAHalfMinutesTestMethod()
        {
            Assert.AreEqual("9:30", TimeConverter(9.50));
        }

        [TestMethod]
        public void NineAndThreeFourthsTestMethod()
        {
            Assert.AreEqual("9:45", TimeConverter(9.75));
        }

        [TestMethod]
        public void HighEndTestMethod()
        {
            Assert.AreEqual("99:59", TimeConverter(99.99));
        }

        [TestMethod]
        public void OverHighEndTestMethod()
        {
            Assert.AreEqual("ERROR: time is greater than 99.99", TimeConverter(100.00));
        }

        /// <summary>
        /// Converts a decimal time to clock time. Ex: 9.75 minutes is converted to 9:45 minutes.
        /// </summary>
        /// <param name="time">The decimal time to convert.</param>
        /// <returns>The converted time.</returns>
        private string TimeConverter(double time)
        {

            // check to make sure time is not under 0
            if (time < 0) return "ERROR: time is under 0.";
            // check to make sure time is not greater than 99.99
            if (time > 99.99) return "ERROR: time is greater than 99.99";

            // declare local varriables
            int min;        // holds the minute decimal time 
            double sec;     // holds the converted second decimal time

            string minute;  // holds the min variable parsed to a string
            string second;  // holds the second variable parsed to a string

            // get the minute and second of time
            min = (int)time;
            sec = (time - min)*60;

            // convert both to strings
            minute = min.ToString("N0");
            second = sec.ToString("N0");

            // check if second is only one char
            if (second.Length == 1) second = second + "0";

            // return the converted time
            return minute + ":" + second;

        }
    }
}
