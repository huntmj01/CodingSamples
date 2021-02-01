using System;
using System.Windows.Forms;

/* 
 * Name: Matthew Hunt
 * Project: Assignment 2
 * Date: 8/21/17
 * Purpose: Allows the user to click on a picture box and display what 
 * the pet they clicked was in a label.
 */

namespace Assignment2_Hunt
{
    public partial class frmAssignment2 : Form
    {

        /// <summary>
        /// Constructor
        /// </summary>
        public frmAssignment2()
        {
            InitializeComponent();
        }

        /// <summary>
        /// user clicks the first picture box
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void pbxImg1_Click(object sender, EventArgs e)
        {
            // display bog in the label
            lblPet.Text = "Dog";
        }

        /// <summary>
        /// user clicks the second picture box
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void pbxImg2_Click(object sender, EventArgs e)
        {
            // display cat in the label
            lblPet.Text = "Cat";
        }

        /// <summary>
        /// user clicks the third picture box
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void pbxImg3_Click(object sender, EventArgs e)
        {
            // display lion in the label
            lblPet.Text = "Lion";
        }

        /// <summary>
        /// user clicks the fourth picture box
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void pbxImg4_Click(object sender, EventArgs e)
        {
            // display bird in the label
            lblPet.Text = "Bird";
        }

        /// <summary>
        /// user clicks the fifth picture box
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void pbxImg5_Click(object sender, EventArgs e)
        {
            // display gerbil in the picture box
            lblPet.Text = "Gerbil";
        }
 
        /// <summary>
        /// user clicks the hide button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnHide_Click(object sender, EventArgs e)
        {
            // hide all the picture boxes
            pbxImg1.Visible = false;
            pbxImg2.Visible = false;
            pbxImg3.Visible = false;
            pbxImg4.Visible = false;
            pbxImg5.Visible = false;
        }

        /// <summary>
        /// user clicks the show button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnShow_Click(object sender, EventArgs e)
        {
            // show all the picture boxes
            pbxImg1.Visible = true;
            pbxImg2.Visible = true;
            pbxImg3.Visible = true;
            pbxImg4.Visible = true;
            pbxImg5.Visible = true;
        }

        /// <summary>
        /// user clicks the clear button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnClear_Click(object sender, EventArgs e)
        {
            // clear the label
            lblPet.Text = String.Empty;
        }

        /// <summary>
        /// user clicks the exit button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnExit_Click(object sender, EventArgs e)
        {
            // close the program
            this.Close();
        }
    }
}
