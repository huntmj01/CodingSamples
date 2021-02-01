using System;
using System.Windows.Forms;

/* 
 * Name: Matthew Hunt
 * Project: Assignment 3
 * Date: 8/28/17
 * Purpose: Allows the user to enter a ticket price and amount 
 * of tickets sold then displays the total revenue.
 */

namespace Assignment3_MHunt
{
    public partial class frmAssgn3 : Form
    {
        
        // constants
        private const double TICKET_PRICE_CLASS_A = 16.25;  // class A ticket price
        private const double TICKET_PRICE_CLASS_B = 11.25;  // class B ticket price
        private const double TICKET_PRICE_CLASS_C = 8.50;   // class C ticket price

        private const string CURRENCY_SYMBOL = "$";         // default currency symbol

        /// <summary>
        /// constructor
        /// </summary>
        public frmAssgn3()
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
            tbxTicketPriceClassA.Text = CURRENCY_SYMBOL + TICKET_PRICE_CLASS_A.ToString("N2");
            tbxTicketPriceClassB.Text = CURRENCY_SYMBOL + TICKET_PRICE_CLASS_B.ToString("N2");
            tbxTicketPriceClassC.Text = CURRENCY_SYMBOL + TICKET_PRICE_CLASS_C.ToString("N2");
        }

        /// <summary>
        /// user clicks the calculate revenue button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnCalculateRevenue_Click(object sender, EventArgs e)
        {
            // try to calculate the total revenue
            try
            {
                // declare local variables
                double totalClassA; // holds the class A total revenue
                double totalClassB; // holds the class B total revenue
                double totalClassC; // holds the class C total revenue
                double total;       // holds the sum of the three totals

                // calculate the total class revenues by multiplying the class ticket price
                // by the amount of tickets sold 
                totalClassA = TICKET_PRICE_CLASS_A * double.Parse(tbxTicketsSoldClassA.Text);
                totalClassB = TICKET_PRICE_CLASS_B * double.Parse(tbxTicketsSoldClassB.Text);
                totalClassC = TICKET_PRICE_CLASS_C * double.Parse(tbxTicketsSoldClassC.Text);

                // calculate the total revenue by adding the
                // three class totals
                total = totalClassA + totalClassB + totalClassC;

                // display the total revenues
                tbxRevenueGeneratedClassA.Text = CURRENCY_SYMBOL + totalClassA.ToString("N2");
                tbxRevenueGeneratedClassB.Text = CURRENCY_SYMBOL + totalClassB.ToString("N2");
                tbxRevenueGeneratedClassC.Text = CURRENCY_SYMBOL + totalClassC.ToString("N2");
                tbxRevnueGeneratedTotal.Text = CURRENCY_SYMBOL + total.ToString("N2");
            }
            // catch any exception that may happen
            catch (Exception ex)
            {
                // notify the user that they messed up
                MessageBox.Show(ex.Message);
            }
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
    }
}
