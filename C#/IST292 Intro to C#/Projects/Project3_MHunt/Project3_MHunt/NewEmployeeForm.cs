using System;
using System.Windows.Forms;

/* 
 * Name:    Matthew Hunt
 * Project: Project 3
 * Date:    11/29/2017
 * Purpose: Allows a user to manipulate a database of logins and employees.
 */
namespace Project3_MHunt
{
    public partial class NewEmployeeForm : Form
    {

        ///
        /// fields
        /// 

        private EmployeesDataSetTableAdapters.EmployeesTableAdapter adapter;

        /// <summary>
        /// constructor
        /// </summary>
        public NewEmployeeForm()
        {
            InitializeComponent();
        }

        /// <summary>
        /// on form load
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void NewEmployeeForm_Load(object sender, EventArgs e)
        {
            adapter = new EmployeesDataSetTableAdapters.EmployeesTableAdapter();
            dtpDate.MaxDate = DateTime.Now;
        }

        /// <summary>
        /// user clicks the add button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnAdd_Click(object sender, EventArgs e)
        {
            // validate the username: cannot be blank
            if (tbxName.Text == string.Empty)
            {
                // display error message and stop
                errorProvider1.SetError(tbxName, "Name cannot be blank.");
                return;
            }

            // validate the position: cannot be blank
            if (tbxPosition.Text == string.Empty)
            {
                // display error message and stop
                errorProvider1.SetError(tbxPosition, "Position cannot be blank.");
                return;
            }

            double hourPay = 0;

            // validate the hourly rate: must be double
            if (!double.TryParse(tbxHourlyRate.Text, out hourPay))
            {
                // display error message and stop
                errorProvider1.SetError(tbxHourlyRate, "Hourly Pay must be double.");
                return;
            }

            // for valid input add to the database
            try
            {
                adapter.Insert(tbxName.Text, tbxPosition.Text, hourPay, dtpDate.Value);
                lblStatus.Text = "Employee added";
            }
            catch
            {
                lblStatus.Text = "Error adding employee";
            }
        }

    }
}
