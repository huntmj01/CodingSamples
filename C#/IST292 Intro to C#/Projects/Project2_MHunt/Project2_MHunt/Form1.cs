using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Project2_MHunt
{
    public partial class frmEmployeeDirectory : Form
    {
        // Declare a structure, Employee
        struct Employee
        {
            public int id;
            public string name;
            public string department;
            public string jobTitle;
            public string phoneNumber;
            public double salary;

            public override string ToString()
            {
                return id + ", " + name + ", " + department + ", " + jobTitle + ", " + phoneNumber + ", $" + salary;
            }

            public bool Equals(Employee e)
            {
                bool isEqual = this.name == e.name && this.phoneNumber == e.phoneNumber;
                return isEqual;
            }
        }


        // global variables
        List<Employee> employees = new List<Employee>();                // list of all employees

        private const string FILENAME_EMPLOYEES = "employees.txt";
        private const string FILENAME_DEPARTMENTS = "departments.txt";
        private const string FILENAME_JOB_TITLES = "job_titles.txt";

        private bool dataChanged;                                       // used to indicate if the list has been changed
        private int nextIDNumber;                                       // keep track of next available id number
               
        public frmEmployeeDirectory()
        {
            InitializeComponent();
        }

        private void frmEmployeeDirectory_Load(object sender, EventArgs e)
        {
            // Read the employees.txt file. Create a new Employee. Add to the list. 
            StreamReader inputFile;
            inputFile = File.OpenText(FILENAME_EMPLOYEES);
            nextIDNumber = 1;
            // reads the text file. As the text file is read, Employee objects are created and 
            // added to the List

            string line;
            while ((line = inputFile.ReadLine()) != null)
            {
                var fields = line.Split(',');

                Employee employee = new Employee
                {
                    id = int.Parse(fields[0]),
                    name = fields[1],
                    department = fields[2],
                    jobTitle = fields[3],
                    phoneNumber = fields[4],
                    salary = double.Parse(fields[5])
                };

                employees.Add(employee);
                nextIDNumber++;
            }

            // close the connection
            inputFile.Close();

            // Read the departments.txt file. Add the departments to the combo box.
            inputFile = File.OpenText(FILENAME_DEPARTMENTS);
            line = "";
            while ((line = inputFile.ReadLine()) != null)
            {
                cbxDepartment.Items.Add(line);
            }
            inputFile.Close();

            // Read the departments.txt file. Add the departments to the combo box.
            inputFile = File.OpenText(FILENAME_DEPARTMENTS);
            line = "";
            while ((line = inputFile.ReadLine()) != null)
            {
                cbxDepartment.Items.Add(line);
            }
            inputFile.Close();

            //Read the job_titles.txt file. Add the job titles to the combo box.
            inputFile = File.OpenText(FILENAME_JOB_TITLES);
            line = "";
            while ((line = inputFile.ReadLine()) != null)
            {
                cbxJobTitle.Items.Add(line);
            }
            inputFile.Close();

            // Be sure to assign nextIDNumber the appropriate value.
            tbxIDNumber.Text = "" + nextIDNumber;

        }

        /// <summary>
        /// on form closing
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void frmEmployeeDirectory_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (dataChanged)
            {
                DialogResult = MessageBox.Show("You have unsaved changes. Do you want to save?", "Data Changed",
                    MessageBoxButtons.YesNoCancel);

                if (DialogResult == DialogResult.No)
                {
                    e.Cancel = false;
                }else if (DialogResult == DialogResult.Yes)
                {
                    Close();
                }
                else
                {
                    e.Cancel = true;
                }
            }
        }

        /// <summary>
        /// user clicks add button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnAdd_Click(object sender, EventArgs e)
        {
            bool isNotValid = false;
            int temp = 0;
            double temp2 = 0;

            // Validate that the text boxes are not blank
            if (tbxIDNumber.Text == string.Empty) isNotValid = SetError(tbxIDNumber, "Textbox can not be empty.");
            if (tbxName.Text == string.Empty) isNotValid = SetError(tbxName, "Textbox can not be empty.");
            if (tbxPhone.Text == string.Empty) isNotValid = SetError(tbxPhone, "Textbox can not be empty.");
            if (tbxSalary.Text == string.Empty) isNotValid = SetError(tbxSalary, "Textbox can not be empty.");

            // Validate that the text boxes do not contain any commas
            if (tbxIDNumber.Text.Contains(",")) isNotValid = SetError(tbxIDNumber, "Textbox can not contain comma.");
            if (tbxName.Text.Contains(",")) isNotValid = SetError(tbxName, "Textbox can not contain comma.");
            if (tbxPhone.Text.Contains(",")) isNotValid = SetError(tbxPhone, "Textbox can not contain comma.");
            if (tbxSalary.Text.Contains(",")) isNotValid = SetError(tbxSalary, "Textbox can not contain comma.");

            // Validate that text boxes can be parsed
            if (!int.TryParse(tbxIDNumber.Text, out temp)) isNotValid = SetError(tbxIDNumber, "Textbox must contain number.");
            if (!double.TryParse(tbxSalary.Text, out temp2)) isNotValid = SetError(tbxIDNumber, "Textbox must contain number.");

            // Validate that the combo boxes are not blank
            if (cbxDepartment.SelectedItem == null) isNotValid = SetError(cbxDepartment, "Combobox can not be blank.");
            if (cbxJobTitle.SelectedItem == null) isNotValid = SetError(cbxJobTitle, "Combobox can not be blank.");

            if (isNotValid) return;

            // For valid input, create a new Employee with the input information. 
            Employee employee = new Employee
            {
                id = int.Parse(tbxIDNumber.Text),
                name = tbxName.Text,
                department = cbxDepartment.SelectedItem.ToString(),
                jobTitle = cbxJobTitle.SelectedItem.ToString(),
                phoneNumber = tbxPhone.Text,
                salary = double.Parse(tbxSalary.Text)
            };


            // Use the List’s Contains method to determine if t
            // he employee exists, display an error message to the
            //  name and phone number text boxes
            if (employees.Contains(employee))
            {
               SetError(tbxIDNumber, "Employee with same name and phone number already exists.");
               SetError(tbxPhone, "Employee with same name and phone number already exists.");
               return;
            }

            // if the employee does not already exist, add them to the list.
            employees.Add(employee);

            // Display to the status label that the employee was added and the employee’s information
            lblStatus.Text = @"Employee was added. " + employee.ToString();

            nextIDNumber++;
            tbxIDNumber.Text = "" + nextIDNumber;
            dataChanged = true;
        }

        /// <summary>
        /// user clicks the find button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnFind_Click(object sender, EventArgs e)
        {
            // clear list box
            lbxOutput.Items.Clear();

            // determine which radio button is selected
            if (rbnIdNumber.Checked)
            {
                //  Loop through the list and add matching employees to the list box.
                foreach (Employee emp in employees)
                {
                    int searchId = 0;
                    int.TryParse(tbxSearch.Text, out searchId);
                    if (emp.id == searchId)
                    {
                        lbxOutput.Items.Add(emp.ToString());
                    }
                    
                }
            }
            else
            {
                //  Loop through the list and add matching employees to the list box.
                foreach (Employee emp in employees)
                {
                    if (emp.name.Contains(tbxSearch.Text))
                    {
                        lbxOutput.Items.Add(emp.ToString());
                    }
                }
            }

            // If there are no matches, display to the status label
            if (lbxOutput.Items.Count == 0) lblStatus.Text = @"No employee found";
        }

        /// <summary>
        /// user clicks delete button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnDelete_Click(object sender, EventArgs e)
        {
            // Validate that a selection has been made from the list box.
            if (lbxOutput.SelectedItem == null)
            {
                SetError(lbxOutput, "You must first select an employee.");
                return;
            } 

            // get selected employee from the list box
            DialogResult = MessageBox.Show(@"Are you sure you want to delte this employee?", @"Confirm Delete", MessageBoxButtons.YesNo);
            if (DialogResult == DialogResult.No)
            {
                return;
            }
            else if (DialogResult == DialogResult.Yes)
            {
                // remove selected employee from list
                var fields = lbxOutput.SelectedItem.ToString().Split();
                employees.RemoveAt(int.Parse(fields[0].Remove(1)) - 1);
                lblStatus.Text = @"Employee has been deleted";   // also display employee information
                lbxOutput.Items.Clear();
            }

            dataChanged = true;
        }

        /// <summary>
        /// user clicks the save button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnSave_Click(object sender, EventArgs e)
        {
            // write to file
            StreamWriter outputFile;
            outputFile = File.CreateText(FILENAME_EMPLOYEES);

            foreach (Employee emp in employees)
            {
                outputFile.WriteLine(emp.ToString());
            }

            outputFile.Close();

            dataChanged = false;
        }

        /// <summary>
        /// user clicks the salary analysis button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnSalaryAnalysis_Click(object sender, EventArgs e)
        {
            // display max and avg salary to the status label
            lblStatus.Text = "Max Salary: " + MaximumSalary() + ", Avg Salary: " + AverageSalary();
        }

        /// <summary>
        /// user clicks the create report button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnCreateReport_Click(object sender, EventArgs e)
        {
            // write to file
            StreamWriter outputFile;
            outputFile = File.CreateText("reports.txt");

            outputFile.WriteLine("Employee Directory");
            outputFile.WriteLine("---------------");
            foreach (Employee emp in employees)
            {
                outputFile.WriteLine(emp.ToString());
            }
            outputFile.WriteLine("");
            outputFile.WriteLine("Maximum Salary: $" + MaximumSalary());
            outputFile.WriteLine("Average Salary: $" + AverageSalary());

            outputFile.Close();
        }

        /// <summary>
        /// user clicks the exit button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnExit_Click(object sender, EventArgs e)
        {
            Close();
        }

        /// HELPER METHODS

        private bool SetError(Control ctrl, string message)
        {
            errorProvider1.SetError(ctrl, message);
            ctrl.Focus();
            return true;
        }


        /// <summary>
        ///  finds the highest salary of all the employees
        /// </summary>
        /// <returns></returns>
        private double MaximumSalary()
        {
            double maxSalary = 0;
            foreach (Employee employee in employees)
            {
                if (employee.salary > maxSalary)
                {
                    maxSalary = employee.salary;
                }
            }

            return maxSalary;
        }

        /// <summary>
        /// finds the average salary of all employees
        /// </summary>
        /// <returns></returns>
        private double AverageSalary()
        {
            double avgSalary = 0;
            double sumSalary = 0;

            foreach (Employee employee in employees)
            {
                sumSalary += employee.salary;
            }

            if (employees.Count != 0)
            {
                avgSalary = sumSalary / employees.Count;
            }

            return avgSalary;
        }
    }
}
