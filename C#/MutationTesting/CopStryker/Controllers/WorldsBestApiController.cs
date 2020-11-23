using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

namespace CopStryker.Api.Controllers
{
    [Route("api")]
    [ApiController]
    public class WorldsBestApiController : ControllerBase
    {

        public WorldsBestApiController()
        {
        }

        [Route("ArithmeticOperator/{factor1}/{factor2}")]
        [HttpGet]
        public int GetUsingArithmeticOperator(int factor1, int factor2)
        {
            int product = factor1 * factor2;
            return product;
        }

        [Route("AssignmentExpression/{dividend}/{divisor}")]
        [HttpGet]
        public int GetUsingAssignmentExpression(int dividend, int divisor)
        {
            int quotient = dividend /= divisor;
            return quotient;
        }

        [Route("BooleanLiteral")]
        [HttpGet]
        public bool GetUsingBooleanLiteral()
        {
            bool literal = true;
            return literal;
        }

        [Route("CheckedStatement/{increment}")]
        [HttpGet]
        public int GetUsingCheckedStatement(int increment)
        {
            // The following example causes compiler error CS0220 because 2147483647
            // is the maximum value for integers. 
            //int i1 = 2147483647 + 10;

            // The following example, which includes variable ten, does not cause
            // a compiler error.
            //int ten = 10;
            //int i2 = 2147483647 + ten;

            // By default, the overflow in the previous statement also does
            // not cause a run-time exception. The following line displays 
            // -2,147,483,639 as the sum of 2,147,483,647 and 10.
            //Console.WriteLine(i2);

            int overflow;
            //int overflow = 2147483647 + increment; // will not raise an excpetion!
            try
            {
                overflow = checked(2147483647 + increment);
            } catch (OverflowException)
            {
                throw new OverflowException();
            }
           
            return overflow;
        }

        [Route("ConditionalExpression/{firstNumber}/{secondNumber}")]
        [HttpGet]
        public int GetUsingConditionalExpression(int firstNumber, int secondNumber)
        {
            int result = firstNumber - secondNumber;

            if (firstNumber > secondNumber)
            {
                result = firstNumber + secondNumber;
            }

            return result;
        }


        [Route("EqualityOperator/{firstNumber}/{secondNumber}")]
        [HttpGet]
        public bool GetUsingEqualityOperator(int firstNumber, int secondNumber)
        {
            bool result = firstNumber == secondNumber;
            return result;
        }

        [Route("LogicalOperator/{firstCondition}/{secondCondition}")]
        [HttpGet]
        public bool GetUsingLogicalOperator(bool firstCondition, bool secondCondition)
        {
            bool result = firstCondition && secondCondition;
            return result;
        }

        [Route("MethodExpression/{firstNumber}/{secondNumber}")]
        [HttpGet]
        public int GetUsingMethodExpression(int firstNumber, int secondNumber)
        {
            List<int> list = new List<int>
            {
                firstNumber,
                secondNumber
            };
            int result = list.First();
            return result;
        }


        [Route("MethodExpression")]
        [HttpGet]
        public string GetUsingStringLiteral()
        {
            string literal = "The worlds best API";
            return literal;
        }

        [Route("UnaryOperator/{number}")]
        [HttpGet]
        public int GetUsingUnaryOperator(int number)
        {
            int result = -number;
            return result;
        }

        [Route("UpdateOperator/{number}")]
        [HttpGet]
        public int GetUsingUpdateOperator(int number)
        {
            int result = number++;
            return result;
        }
    }
}