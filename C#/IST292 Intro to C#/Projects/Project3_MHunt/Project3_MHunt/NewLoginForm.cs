using System;
using System.Net.Mail;
using System.Windows.Forms;
using Project3_MHunt.LoginsDataSetTableAdapters;

/* 
 * Name:    Matthew Hunt
 * Project: Project 3
 * Date:    11/29/2017
 * Purpose: Allows a user to manipulate a database of logins and employees.
 */
namespace Project3_MHunt
{
    public partial class NewLoginForm : Form
    {

        // 
        // private fields
        //
        private LoginsTableAdapter loginAdapter = new LoginsTableAdapter();

        /// <summary>
        /// constructor
        /// </summary>
        public NewLoginForm()
        {
            InitializeComponent();
        }

        /// <summary>
        /// user clicks the add button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnAdd_Click(object sender, EventArgs e)
        {
            // validate the username: cannot be blank
            if (tbxUserName.Text == string.Empty)
            {
                // display error message and stop
                errorProvider1.SetError(tbxUserName, "Username cannot be blank.");
                return;
            }

            // validate the username: must be email
            if (!VerifyEmail(tbxUserName.Text))
            {
                // display error message and stop
                errorProvider1.SetError(tbxUserName, "Username must be email.");
                return;
            }

            int temp = 0;

            // validate the password: must be int
            if (!int.TryParse(tbxPassword.Text, out temp))
            {
                // display error message and stop
                errorProvider1.SetError(tbxPassword, "Password must be int.");
                return;
            }

            // for valid input, add new login to database
            try
            {
                loginAdapter.Insert(tbxUserName.Text, int.Parse(tbxPassword.Text));
                lblStatus.Text = "New login added";
            }
            catch
            {
                lblStatus.Text = "Error creating new login";
            }

        }


        /// <summary>
        /// a nice helper method I found on stack
        /// https://stackoverflow.com/questions/36035941/check-valid-email-address-in-c-sharp
        /// </summary>
        /// <param name="email"></param>
        /// <returns></returns>
        private bool VerifyEmail(string email)
        {
            try
            {
                var mail = new MailAddress(email);

                return mail.Host.Contains(".");
            }
            catch
            {
                return false;
            }

        }
    }

}
