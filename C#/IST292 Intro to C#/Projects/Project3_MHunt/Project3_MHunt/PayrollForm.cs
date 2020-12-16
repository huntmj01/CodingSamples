using System;
using System.IO;
using System.Windows.Forms;
/* 
 * Name:    Matthew Hunt
 * Project: Project 3
 * Date:    11/29/2017
 * Purpose: Allows a user to manipulate a database of logins and employees.
 */
namespace Project3_MHunt
{
    public partial class PayrollForm : Form
    {
        ///
        /// fields
        /// 

        private EmployeesDataSetTableAdapters.EmployeesTableAdapter adapter;
        private const double WORK_HOURS = 40;

        enum ReportType
        {
            TextFile,
            ListBox
        }

        /// <summary>
        /// constructor
        /// </summary>
        public PayrollForm()
        {
            InitializeComponent();
        }

        /// <summary>
        /// on form load
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void PayrollForm_Load(object sender, EventArgs e)
        {
            adapter = new EmployeesDataSetTableAdapters.EmployeesTableAdapter();
            lblStatus.Text = "";

            if (!RunPayroll(ReportType.ListBox))
            {
                lblStatus.Text = "Error running payroll";
            }
        }

        /// <summary>
        /// user clicks the create button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void createToolStripMenuItem_Click(object sender, EventArgs e)
        {
            lblStatus.Text = "";

            if (!RunPayroll(ReportType.TextFile))
            {
                lblStatus.Text = "Error running payroll";
            }
        }

        ///
        /// HELPER METHODS
        /// 

        private bool RunPayroll(ReportType param)
        {
            lblStatus.Text = "";
            double totalPayroll = 0;

            EmployeesDataSet.EmployeesDataTable table;

            try
            {
                table = adapter.GetData();
            }
            catch
            {
                lblStatus.Text = "Error accessing database";
                return false;
            }

            if (param.Equals(ReportType.TextFile))
            {
                try
                {
                    StreamWriter outFile;
                    if (saveFileDialog.ShowDialog() == DialogResult.OK)
                    {
                        outFile = File.CreateText(saveFileDialog.FileName);

                        outFile.WriteLine("C# Industries Payroll Report");
                        outFile.WriteLine("----------------------------");

                        foreach (EmployeesDataSet.EmployeesRow row in table)
                        {
                            double amountPaid = WORK_HOURS * row.HourlyRate;
                            outFile.WriteLine(row.Name + ": " + amountPaid.ToString("C"));
                            totalPayroll += amountPaid;
                        }

                        outFile.WriteLine("");
                        outFile.WriteLine("Total Payroll: " + totalPayroll.ToString("C"));

                        outFile.Close();

                    }
                }
                catch
                {
                    lblStatus.Text = "Error saving report";
                    return false;
                }
                return true;
            }
            else
            {
                lstOutput.Items.Clear();
                foreach (EmployeesDataSet.EmployeesRow row in table)
                {
                    double amountPaid = WORK_HOURS * row.HourlyRate;
                    lstOutput.Items.Add(row.Name + ": " + amountPaid.ToString("C"));
                    totalPayroll += amountPaid;
                }

                lstOutput.Items.Add("");
                lstOutput.Items.Add("Total Payroll: " + totalPayroll.ToString("C"));
                return true;
            }
        }

    }
}
