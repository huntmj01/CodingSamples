using System;
using System.Windows.Forms;
using Project3_MHunt.EmployeesDataSetTableAdapters;

/* 
 * Name:    Matthew Hunt
 * Project: Project 3
 * Date:    11/29/2017
 * Purpose: Allows a user to manipulate a database of logins and employees.
 */
namespace Project3_MHunt
{
    public partial class EditEmployeeForm : Form
    {

        /// 
        /// fields
        /// 
        private EmployeesDataSetTableAdapters.EmployeesTableAdapter adapter;
        private int mEmployeeID;

        /// <summary>
        /// constructor
        /// </summary>
        public EditEmployeeForm()
        {
            InitializeComponent();
        }

        /// <summary>
        /// on form load
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void EditEmployeeForm_Load(object sender, EventArgs e)
        {
            adapter = new EmployeesTableAdapter();

            // try to load the employee
            try
            {
                EmployeesDataSet.EmployeesDataTable table;
                table = adapter.GetData();
                EmployeesDataSet.EmployeesRow row;
                row = table.FindById(mEmployeeID);
                tbxName.Text = row.Name;
                tbxPosition.Text = row.Position;
                tbxHourlyRate.Text = ""+row.HourlyRate;
                dtpDate.Text = row.HireDate.ToShortDateString();
            }
            catch (Exception ex)
            {
                lblStatus.Text = "Error loading employee information";
            }
        }


        /// <summary>
        /// user clicks the update button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnUpdate_Click(object sender, EventArgs e)
        {
            lblStatus.Text = "";

            // validate the name: cannot be blank
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

            // validate the hourly: must be double
            if (!double.TryParse(tbxHourlyRate.Text, out hourPay))
            {
                // display error message and stop
                errorProvider1.SetError(tbxHourlyRate, "Hourly Pay must be double.");
                return;
            }

            // for valid input update employee in the database
            try
            {
                adapter.Update(tbxName.Text, tbxPosition.Text, hourPay, mEmployeeID);
                lblStatus.Text = "Employee Updated";
            }
            catch
            {
                lblStatus.Text = "Error updating employee.";
            }

        }

        ///
        /// SETTER
        /// 

        /// <summary>
        /// 
        /// </summary>
        /// <param name="pId"></param>
        public void SetEmployeeID(int pId)
        {
            mEmployeeID = pId;
        }

    }
}
