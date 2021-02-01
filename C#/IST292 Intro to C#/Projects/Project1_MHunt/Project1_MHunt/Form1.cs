using System;
using System.Windows.Forms;

/* 
 * Name: Matthew Hunt
 * Project: Project 1
 * Date: 09/11/17
 * Purpose: Allows the user to buy a moto phone.
 */
namespace Project1_MHunt
{
    public partial class frmPhoneShoppe : Form
    {

        // global variables
        private const double MOTO_E_COST = 59.99;
        private const double MOTO_G_COST = 79.99;
        private const double MOTO_X_COST = 139.99;
        private const double STANDARD_SHIPPING = 2.99;
        private const double EXPEDITED_SHIPPING = 5.79;
        private const double OVERNIGHT_SHIPPING = 11.99;
        private const double OTTERBOX_CASE = 11.39;
        private const double CAR_MOUNT = 7.79;
        private const double SCREEN_PROTECTOR = 0.29;
        private const double GOLD_DISCOUNT = 0.20;
        private const double SILVER_DISCOUNT = 0.10;
        private const double BRONZE_DISCOUNT = 0.05;
        private const double SALES_TAX_RATE = 0.075;
        
        /// <summary>
        /// constructor
        /// </summary>
        public frmPhoneShoppe()
        {
            InitializeComponent();
        }

        /// <summary>
        /// on form load
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void frmPhoneShoppe_Load(object sender, EventArgs e)
        {

            // append price to radio buttons
            rbnMotoE.Text = rbnMotoE.Text + @" ($" + MOTO_E_COST + @")";
            rbnMotoG.Text = rbnMotoG.Text + @" ($" + MOTO_G_COST + @")";
            rbnMotoX.Text = rbnMotoX.Text + @" ($" + MOTO_X_COST + @")";

            rbnStandard.Text = rbnStandard.Text + @" ($" + STANDARD_SHIPPING + @")";
            rbnExpedited.Text = rbnExpedited.Text + @" ($" + EXPEDITED_SHIPPING + @")";
            rbnOvernight.Text = rbnOvernight.Text + @" ($" + OVERNIGHT_SHIPPING + @")";

            rbnGold.Text = rbnGold.Text + @" (" + GOLD_DISCOUNT * 100 + @"%)";
            rbnSilver.Text = rbnSilver.Text + @" (" + SILVER_DISCOUNT * 100 + @"%)";
            rbnBronze.Text = rbnBronze.Text + @" (" + BRONZE_DISCOUNT * 100 + @"%)";

            // append price to checkboxes
            cbxOtterboxCase.Text = cbxOtterboxCase.Text + @" ($" + OTTERBOX_CASE + @")";
            cbxCarMount.Text = cbxCarMount.Text + @" ($" + CAR_MOUNT + @")";
            cbxScreenProtector.Text = cbxScreenProtector.Text + @" ($" + SCREEN_PROTECTOR + @")";

            // append percent to labels
            lblSalesTax.Text = lblSalesTax.Text + @" (" + SALES_TAX_RATE * 100 + @"%)";

        }

        /// <summary>
        /// user checks/unchecks discount checkbox
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void cbxDiscount_CheckedChanged(object sender, EventArgs e)
        {
             gbxDiscountLevel.Enabled = cbxDiscount.Checked;
        }

        /// <summary>
        /// user checks/unchecks the otterbox case
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void cbxOtterbox_CheckedChanged(object sender, EventArgs e)
        {
            tbxOtterboxCase.Enabled = cbxOtterboxCase.Checked;
        }

        /// <summary>
        /// user checks/unchecks the car mount
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void cbxCarMount_CheckedChanged(object sender, EventArgs e)
        {
            tbxCarMount.Enabled = cbxCarMount.Checked;
        }

        /// <summary>
        /// user checks/unchecks the screen protector
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void cbxScreenProtector_CheckedChanged(object sender, EventArgs e)
        {
            tbxScreenProtector.Enabled = cbxScreenProtector.Checked;
        }

        /// <summary>
        /// user clicks the order button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnOrder_Click(object sender, EventArgs e)
        {
            // perform housekeeping tasks
            tbxPhoneCost.Text = String.Empty;
            tbxAccessories.Text = String.Empty;
            tbxSubtotal.Text = String.Empty;
            tbxDiscountAmount.Text = String.Empty;
            tbxSalesTax.Text = String.Empty;
            tbxShippingAmount.Text = String.Empty;
            tbxAmountDue.Text = String.Empty;
            tbxMessage.Text = String.Empty;

            // declare necessary local variables
            double phoneCost = 0.0;
            double accessoriesTotal = 0.0;
            double subtotal = 0.0;
            double discountAmount = 0.0;
            double salesTax = 0.0;
            double shippingAmount = 0.0;
            double amountDue = 0.0;
            bool underZero = false;
            bool invalidInput = false;

            // perform input validation using TryParse methods
            if (rbnMotoE.Checked)
            {
                phoneCost = MOTO_E_COST;
            }
            else if(rbnMotoG.Checked)
            {
                phoneCost = MOTO_G_COST;
            }
            else if (rbnMotoX.Checked)
            {
                phoneCost = MOTO_X_COST;
            }

            // calculate accessory total
            if (cbxOtterboxCase.Checked)
            {
                double temp = 0.0;
                bool result = double.TryParse(tbxOtterboxCase.Text, out temp);
                accessoriesTotal += temp * OTTERBOX_CASE;
                if (temp < 0) underZero = true;
                if (!result) invalidInput = true;
            }

            if (cbxCarMount.Checked)
            {
                double temp = 0.0;
                bool result = double.TryParse(tbxCarMount.Text, out temp);
                accessoriesTotal += temp * CAR_MOUNT;
                if (temp < 0) underZero = true;
                if (!result) invalidInput = true;
            }

            if (cbxScreenProtector.Checked)
            {
                double temp = 0.0;
                bool result = double.TryParse(tbxScreenProtector.Text, out temp);
                accessoriesTotal += temp * SCREEN_PROTECTOR;
                if (temp < 0) underZero = true;
                if (!result) invalidInput = true;
            }

            // calculate subtotal
            subtotal = phoneCost + accessoriesTotal;

            // calculate discount
            if (cbxDiscount.Checked)
            {
                if (rbnGold.Checked)
                {
                    discountAmount = subtotal * GOLD_DISCOUNT;
                }
                else if (rbnSilver.Checked)
                {
                    discountAmount = subtotal * SILVER_DISCOUNT;
                }
                else if (rbnBronze.Checked)
                {
                    discountAmount = subtotal * BRONZE_DISCOUNT;
                }
            }

            // calculate sales tax
            salesTax = (subtotal - discountAmount) * SALES_TAX_RATE;

            // calculate shipping
            if (rbnStandard.Checked)
            {
                shippingAmount = STANDARD_SHIPPING;
            }
            else if (rbnExpedited.Checked)
            {
                shippingAmount = EXPEDITED_SHIPPING;
            }
            else if (rbnOvernight.Checked)
            {
                shippingAmount = OVERNIGHT_SHIPPING;
            }

            // calculate total
            amountDue = (subtotal - discountAmount) + salesTax + shippingAmount;

            // display output
            if (underZero)
            {
                tbxMessage.Text = @"Accessories quanity must be greater than 0.";
            }
            else if (invalidInput)
            {
                tbxMessage.Text = @"Accessories quantity must be a number.";
            }
            else
            {
                tbxPhoneCost.Text = @"$" + phoneCost.ToString("n2");
                tbxAccessories.Text = @"$" + accessoriesTotal.ToString("n2");
                tbxSubtotal.Text = @"$" + subtotal.ToString("n2");
                tbxDiscountAmount.Text = @"$" + discountAmount.ToString("n2");
                tbxSalesTax.Text = @"$" + salesTax.ToString("n2");
                tbxShippingAmount.Text = @"$" + shippingAmount.ToString("n2");
                tbxAmountDue.Text = @"$" + amountDue.ToString("n2");
            }
        }

        /// <summary>
        /// user clicks the clear button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnClear_Click(object sender, EventArgs e)
        {

            // reset radio buttons to default
            rbnMotoE.Checked = true;
            rbnStandard.Checked = true;
            rbnGold.Checked = true;

            // uncheck all checkboxes
            cbxOtterboxCase.Checked = false;
            cbxCarMount.Checked = false;
            cbxScreenProtector.Checked = false;
            cbxDiscount.Checked = false;

            // clear all textboxes
            tbxOtterboxCase.Text = String.Empty;
            tbxCarMount.Text = String.Empty;
            tbxScreenProtector.Text = String.Empty;
            tbxPhoneCost.Text = String.Empty;
            tbxAccessories.Text = String.Empty;
            tbxSubtotal.Text = String.Empty;
            tbxDiscountAmount.Text = String.Empty;
            tbxSalesTax.Text = String.Empty;
            tbxShippingAmount.Text = String.Empty;
            tbxAmountDue.Text = String.Empty;
            tbxMessage.Text = String.Empty;

            // reset the focus to the order button
            btnOrder.Focus();

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
