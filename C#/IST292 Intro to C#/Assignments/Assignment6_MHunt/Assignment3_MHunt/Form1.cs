using System;
using System.Windows.Forms;

/* 
 * Name: Matthew Hunt
 * Project: Assignment 6
 * Date: 8/28/17
 * Purpose: Adds methods to Assignment 3.
 */

namespace Assignment3_MHunt
{
    public partial class frmAssgn6 : Form
    {
        
        // constants
        private const double TICKET_PRICE_CLASS_A = 16.25;  // class A ticket price
        private const double TICKET_PRICE_CLASS_B = 11.25;  // class B ticket price
        private const double TICKET_PRICE_CLASS_C = 8.50;   // class C ticket price

        private const string CURRENCY_SYMBOL = "$";         // default currency symbol

        /// <summary>
        /// constructor
        /// </summary>
        public frmAssgn6()
        {
            InitializeComponent();
        }

        /// <summary>
        /// on form load
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void frmAssgn3_Load(object sender, EventArgs e)
        {
            // set the Ticket Price Text Boxes to their default values
            tbxTicketPriceClassA.Text = FormatCurrency(TICKET_PRICE_CLASS_A);
            tbxTicketPriceClassB.Text = FormatCurrency(TICKET_PRICE_CLASS_B);
            tbxTicketPriceClassC.Text = FormatCurrency(TICKET_PRICE_CLASS_C);
        }

        /// <summary>
        /// user clicks the calculate revenue button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnCalculateRevenue_Click(object sender, EventArgs e)
        {

            // housekeeping
            tbxRevenueGeneratedClassA.Text = string.Empty;
            tbxRevenueGeneratedClassB.Text = string.Empty;
            tbxRevenueGeneratedClassC.Text = string.Empty;
            tbxRevnueGeneratedTotal.Text = string.Empty;
            lblStatus.Text = string.Empty;

            // declare local variables
            double totalClassA = 0; // holds the class A total revenue
            double totalClassB = 0; // holds the class B total revenue
            double totalClassC = 0; // holds the class C total revenue
            double total = 0;       // holds the sum of the three totals
            int input = 0;          // holds the int value of the parsed textbox

            // calculate the total class revenues by first attempting to validate
            // the user input and then multiplying the class ticket price
            // by the amount of tickets sold 
            if (ValidateInput(tbxTicketsSoldClassA, ref input))
            {
                totalClassA = TICKET_PRICE_CLASS_A * input;
            }
            else
            {
                return;
            }

            if (ValidateInput(tbxTicketsSoldClassB, ref input))
            {
                totalClassB = TICKET_PRICE_CLASS_B * input;
            }
            else
            {
                return;
            }

            if (ValidateInput(tbxTicketsSoldClassC, ref input))
            {
                totalClassC = TICKET_PRICE_CLASS_C * input;
            }
            else
            {
                return;
            }

            // calculate the total revenue by adding the
            // three class totals
            total = totalClassA + totalClassB + totalClassC;

            // display the total revenues
            tbxRevenueGeneratedClassA.Text = FormatCurrency(totalClassA);
            tbxRevenueGeneratedClassB.Text = FormatCurrency(totalClassB);
            tbxRevenueGeneratedClassC.Text = FormatCurrency(totalClassC);
            tbxRevnueGeneratedTotal.Text = FormatCurrency(total);
            
        }

        /// <summary>
        /// user clicks the clear button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnClear_Click(object sender, EventArgs e)
        {
            // clear the tickets sold textboxes
            tbxTicketsSoldClassA.Text = String.Empty;
            tbxTicketsSoldClassB.Text = String.Empty;
            tbxTicketsSoldClassC.Text = String.Empty;

            // clear the generated revenue textboxes
            tbxRevenueGeneratedClassA.Text = String.Empty;
            tbxRevenueGeneratedClassB.Text = String.Empty;
            tbxRevenueGeneratedClassC.Text = String.Empty;
            tbxRevnueGeneratedTotal.Text = String.Empty;

            // clear status label
            lblStatus.Text = string.Empty;

            // focus on the first control
            tbxTicketsSoldClassA.Focus();
        }

        /// <summary>
        /// user clicks the exit button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnExit_Click(object sender, EventArgs e)
        {
            // exit the application
            this.Close();
        }

        /// <summary>
        /// takes a double and formates it to a currency
        /// </summary>
        /// <param name="amount">the double to be dformated to a currency</param>
        /// <returns>the double formated as a currency</returns>
        private string FormatCurrency(double amount)
        {
            string formatedCurrency = CURRENCY_SYMBOL + amount.ToString("n2");
            return formatedCurrency;
        }

        /// <summary>
        /// takes a string and control, displays the error message to the
        /// status label and sets focus to the control
        /// </summary>
        /// <param name="control">The control to set the focus to</param>
        /// <param name="message">The message to display in the status label</param>
        private void SetError(Control control, string message)
        {
            // display message to status label
            lblStatus.Text = @"Status: " + message;

            // set the focus to the control
            control.Focus();
        }

        /// <summary>
        /// validates the input of a textbox by attempting to parse
        /// the text to an int
        /// </summary>
        /// <param name="tbx">the textbox to parse to an int</param>
        /// <param name="targetVariable">the variable to put the parsed int into</param>
        /// <returns>whether or not the textbox was parsed succesfully</returns>
        private bool ValidateInput(TextBox tbx, ref int targetVariable)
        {

            bool result = false;

            if (!int.TryParse(tbx.Text, out targetVariable))
            {
                SetError(tbx, tbx.Tag + " is invalid input");   
            }
            else if (targetVariable < 0)
            {
                SetError(tbx, tbx.Tag + " quantity must be greater than 0");
            }
            else
            {
                result = true;
            }

            return result;
        }
    }
}
