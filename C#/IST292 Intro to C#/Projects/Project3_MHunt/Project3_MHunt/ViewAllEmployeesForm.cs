using System;
using System.Data;
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
    public partial class ViewAllEmployeesForm : Form
    {

        // fields
        private EmployeesDataSetTableAdapters.EmployeesTableAdapter adapter;
        private bool formLoading = true;

        /// <summary>
        /// constructor
        /// </summary>
        public ViewAllEmployeesForm()
        {
            InitializeComponent();
        }

        /// <summary>
        /// on form load
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void ViewAllEmployeesForm_Load(object sender, EventArgs e)
        {
            adapter = new EmployeesTableAdapter();
            UpdateForm();
            dgvEmployees.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
            dgvEmployees.MultiSelect = false;
        }


        /// 
        /// TOOL STRIP
        /// 


        /// <summary>
        /// user clicks the show all button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void tslShowAll_Click(object sender, EventArgs e)
        {
            // display all data to data grid
            dgvEmployees.DataSource = adapter.GetData();
        }

        /// <summary>
        /// user selectes a different user in the employees combo box
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void tscEmployee_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (!formLoading)
            {
                
                // load that particular employee
                int selectedId = (int)tscEmployee.ComboBox.SelectedValue;
                dgvEmployees.DataSource = GetById(selectedId);
                
            }
        }

        /// <summary>
        /// user clicks the edit button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void tslEdit_Click(object sender, EventArgs e)
        {
            lblStatus.Text = "";

            if (dgvEmployees.SelectedRows.Count > 0)
            {
                // pass the id to the edit from and show it
                int Id = (int)(dgvEmployees.SelectedRows[0].Cells[0].Value);
                EditEmployeeForm frmEdit = new EditEmployeeForm();
                frmEdit.SetEmployeeID(Id);
                frmEdit.ShowDialog();
                formLoading = true;
                UpdateForm();
            }
            else
            {
                lblStatus.Text = "Click on a name to select an employee";
            }
        }

        /// <summary>
        /// user clicks the delete button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void tslDelete_Click(object sender, EventArgs e)
        {
            lblStatus.Text = "";
            if (dgvEmployees.SelectedRows.Count > 0)
            {
                // confirm that user wants to delete
                DialogResult dr =
                    MessageBox.Show("Deleting the selected employee will permanently remove. Do you want to continue?",
                        "Confirm Delete", MessageBoxButtons.YesNo);

                if (dr == DialogResult.Yes)
                {
                    int selectedId = (int)dgvEmployees.SelectedRows[0].Cells[0].Value;

                    // delete the selected item and reload the data if successful
                    if (adapter.Delete(selectedId) > 0)
                    {
                        dgvEmployees.DataSource = adapter.GetData();
                        formLoading = true;
                        UpdateForm();
                        lblStatus.Text = "Employee deleted";

                    }
                    else
                    {
                        lblStatus.Text = "Error deleting this employee";
                    }
                }
            }
            else
            {
                lblStatus.Text = "No employee selected";
            }
        }

        /// <summary>
        /// user clicks the add button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void tslAdd_Click(object sender, EventArgs e)
        {
            // display the new employee form
            NewEmployeeForm form = new NewEmployeeForm();
            form.ShowDialog();
            formLoading = true;
            UpdateForm();
        }

        /// <summary>
        /// user clicks the close button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void tslClose_Click(object sender, EventArgs e)
        {
            // close the current form
            Close();
        }

        ///
        /// HELPER METHODS
        /// 

        public void UpdateForm()
        {
            tscEmployee.ComboBox.DataSource = adapter.GetData();
            tscEmployee.ComboBox.DisplayMember = "Name";
            tscEmployee.ComboBox.ValueMember = "Id";
            tscEmployee.ComboBox.DropDownStyle = ComboBoxStyle.DropDownList;
            tscEmployee.SelectedIndex = -1;
            dgvEmployees.DataSource = adapter.GetData();
            formLoading = false;
        }

        private DataTable GetById(int pId)
        {
            DataTable table = adapter.GetData();
            table.DefaultView.RowFilter = "Id = " + pId;
            return table;
        }

        
    }
    
}
