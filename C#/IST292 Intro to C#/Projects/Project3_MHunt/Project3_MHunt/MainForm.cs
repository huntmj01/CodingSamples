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
    public partial class MainForm : Form
    {
        ///
        /// fields
        /// 
        private LoginsTableAdapter loginAdapter = new LoginsTableAdapter();

        /// <summary>
        /// constructor 
        /// </summary>
        public MainForm()
        {
            InitializeComponent();
        }

        /// <summary>
        /// on form load
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void MainForm_Load(object sender, EventArgs e)
        {
            // fill table adapeter
            this.employeesTableAdapter1.Fill(this.employeesDataSet1.Employees);

            // uncomment following line upon completion
            this.AcceptButton = btnLogin;
        }

        ///
        /// MENU STRIP
        /// 

        /// <summary>
        /// user clicks the logout button
        /// file->logout
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void logoutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            // show the login panel, hide the main panel
            panelLogin.Show();
            panelMain.Hide();
            panelLogin.Dock = DockStyle.Fill;
            this.AcceptButton = btnLogin;
        }

        /// <summary>
        /// user clicks the exit button
        /// file->exit
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            // exit the application
            Application.Exit();
        }

        /// <summary>
        /// user clicks the view all employees button
        /// Employees->View all
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void viewAllToolStripMenuItem_Click(object sender, EventArgs e)
        {
            // display the view all employees form
            ViewAllEmployeesForm form = new ViewAllEmployeesForm();
            form.Show();
        }

        /// <summary>
        /// user clicks the payroll report button
        /// Employees->Payroll Report
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void payrollReportToolStripMenuItem_Click(object sender, EventArgs e)
        {
            // show the payroll form
            PayrollForm form = new PayrollForm();
            form.Show();
        }

        /// <summary>
        /// user clicks the view all logins button
        /// logins->view all
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void viewAllToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            // show the view all logins form
            ViewAllLoginsForm form = new ViewAllLoginsForm();
            form.Show();
        }

        /// <summary>
        /// user clicks the new login button
        /// logins->new
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void newMenuItemsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            // display the new login form
            NewLoginForm form = new NewLoginForm();
            form.Show();
        }

        ///
        /// EVENT HANDLERS
        /// 

        /// <summary>
        /// user clicks login button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnLogin_Click(object sender, EventArgs e)
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

            // to hold password
            int pass = 0;

            // validate the password: must be int
            if (!int.TryParse(tbxPassword.Text, out pass))
            {
                // display error message and stop
                errorProvider1.SetError(tbxPassword, "Password must be int.");
                return;
            }

            // login to the system
            if (loginAdapter.Search(loginAdapter.GetData(), tbxUserName.Text, pass) > 0)
            {
                panelLogin.Hide();
                panelMain.Show();
                panelMain.Dock = DockStyle.Fill;
                this.AcceptButton = null;
                tbxPassword.Clear();
                tbxUserName.Clear();
            }
            else if (loginAdapter.SearchUsername(loginAdapter.GetData(), tbxUserName.Text) > 0)
            {
                lblStatus.Text = "Invalid password";
            }
            else
            {
                lblStatus.Text = "Invalid credentials";
            }
        }

        ///
        /// Helper Methods
        ///

        /// /// <summary>
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
