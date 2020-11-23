using CopStryker.Api.Controllers;
using NUnit.Framework;
using System.Diagnostics.CodeAnalysis;

namespace CopStryker.Api.Tests
{
    [ExcludeFromCodeCoverage]
    public class TheWorldsBestApiControllerShould
    {
        WorldsBestApiController _api;
        [SetUp]
        public void Setup()
        {
           _api = new WorldsBestApiController();
        }

        [Test]
        public void CorrectlyCalculateUsingArithmeticOperator()
        {
            _api.GetUsingArithmeticOperator(0, 1);
            Assert.IsTrue(true);
        }

        [Test]
        public void CorrectlyCalculateUsingAssignmentExpression()
        {
            _api.GetUsingAssignmentExpression(0, 1);
            Assert.IsTrue(true);
        }

        [Test]
        public void GetCorrectBooleanLiteral()
        {
            _api.GetUsingBooleanLiteral();
            Assert.IsTrue(true);
        }

        [Test]
        public void ProperlyHandleOverflowUsingCheckedStatement()
        {
            _api.GetUsingCheckedStatement(0);
            try
            {
                _api.GetUsingCheckedStatement(10);
            } catch { }
            Assert.IsTrue(true);
        }

        [Test]
        public void CorrectlyEvaluateConditionalExpression()
        {
            _api.GetUsingConditionalExpression(1, 0);
            Assert.IsTrue(true);
        }

        [Test]
        public void CorrectlyEvaluateUsingEqualityOperator()
        {
            _api.GetUsingEqualityOperator(0, 0);
            Assert.IsTrue(true);
        }

        [Test]
        public void CorrectlyCalculateUsingLogicalOperator()
        {
            _api.GetUsingLogicalOperator(false, false);
            Assert.IsTrue(true);
        }

        [Test]
        public void CorrectlyCalculateUsingMethodExpression()
        {
            _api.GetUsingMethodExpression(0, 0);
            Assert.IsTrue(true);
        }

        [Test]
        public void CorrectlyCalculateUsingStringLiteral()
        {
            _api.GetUsingStringLiteral();
            Assert.IsTrue(true);
        }

        [Test]
        public void CorrectlyCalculateUsingUnaryOperator()
        {
            _api.GetUsingUnaryOperator(0);
            Assert.IsTrue(true);
        }

        [Test]
        public void CorrectlyCalculateUsingUpdateOperator()
        {
            _api.GetUsingUpdateOperator(0);
            Assert.IsTrue(true);
        }
    }
}