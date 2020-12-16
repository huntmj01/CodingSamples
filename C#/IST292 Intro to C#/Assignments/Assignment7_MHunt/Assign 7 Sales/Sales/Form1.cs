using System;
using System.Collections.Generic;
using System.Windows.Forms;
using System.IO;

namespace Sales
{
    public partial class frmTotalSales : Form
    {
        private List<double> saleAmounts = new List<double>();  // the list of sales
        private bool saved = true;                             // holds whether the list has been saved to the file or not
        private const string FILENAME = "Sales.txt";

        /// <summary>
        /// constructor
        /// </summary>
        public frmTotalSales()
        {
            InitializeComponent();
        }

        /// <summary>
        /// on form load
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void Form1_Load(object sender, EventArgs e)
        {

        }

        /// <summary>
        /// on form closing
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void frmTotalSales_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (saved == false)
            {
                DialogResult result = MessageBox.Show("You have unsaved data. Do you want to save?", "Total Sales", MessageBoxButtons.YesNo);

                if (result == DialogResult.Yes)
                {
                    try
                    {
                        StreamWriter outputFile;
                        outputFile = File.CreateText(FILENAME);

                        foreach (double value in saleAmounts)
                        {
                            outputFile.WriteLine(value);
                        }

                        outputFile.Close();
                    }
                    catch (Exception ex)
                    {
                        lblStatus.Text = @"Error saving the file";
                    }
                }
            }
        }

        /// <summary>
        /// main menu -> file -> exit
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void fileExit_Click(object sender, EventArgs e)
        {
            // exit the application
            Close();
        }

        /// <summary>
        /// main menu -> file -> save
        /// saves list to text filefile
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void fileSave_Click(object sender, EventArgs e)
        {
            // 
            StreamWriter outputFile = null;

            // try to write to file
            try
            {
                // create/open sales.txt
                outputFile = File.CreateText(FILENAME);

                // loop through each item in sale amounts
                foreach (double item in saleAmounts)
                {
                    // write item to output file
                    outputFile.WriteLine(item);
                }

                // set saved flag to true
                saved = true;
            }
            catch (Exception ex)
            {
                // display error to user
                lblStatus.Text = @"Error saving file.";
            }
            finally
            {
                // close the file stream
                outputFile?.Close();
            }
            
        }

        /// <summary>
        /// main menu -> file -> create report
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void fileCreateReport_Click(object sender, EventArgs e)
        {
            SaveFileDialog saveFileDialog1 = new SaveFileDialog();

            saveFileDialog1.Filter = "Word Document (*.doc)|*.doc|Open Document Text (*.odt)|*.odt|Text (*.txt)|*.txt|Rich Text Format (*.rtf)|*.rtf";
            saveFileDialog1.FilterIndex = 3;
            saveFileDialog1.RestoreDirectory = true;

            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                // 
                StreamWriter outputFile = null;

                // try to write to file
                try
                {
                    // create/open sales.txt
                    outputFile = File.CreateText("report.txt");

                    outputFile.WriteLine("Sales are:");

                    // loop through each item in sale amounts
                    foreach (double item in saleAmounts)
                    {
                        // write item to output file
                        outputFile.WriteLine(item);
                    }

                    outputFile.WriteLine(@"Total number of sales: " + saleAmounts.Count);
                    outputFile.WriteLine(@"The total is $" + sum(saleAmounts));
                    outputFile.WriteLine(@"The average is $" + average(saleAmounts));
                    outputFile.WriteLine(@"The largest value is $" + max(saleAmounts));
                    outputFile.WriteLine(@"The smallest value is $" + min(saleAmounts));

                    // set saved flag to true
                    saved = true;
                }
                catch (Exception ex)
                {
                    // display error to user
                    lblStatus.Text = @"Error saving file.";
                }
                finally
                {
                    // close the file stream
                    outputFile?.Close();
                }
            }
        }

        /// <summary>
        /// user clicks the add sale button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnAddSale_Click(object sender, EventArgs e)
        {
            // clear form
            lblOutput.Text = string.Empty;
            lblStatus.Text = string.Empty;
            lstSales.Items.Clear();
            saved = false;

            // local variable
            double sale = 0;
            bool valid = double.TryParse(txtSale.Text, out sale);

            // check if not valid
            if (!valid)
            {
                lblStatus.Text = @"Error: invalid input";
                return;
            }

            saleAmounts.Add(sale);
            DisplayValues(saleAmounts);
            Calculate(saleAmounts);

            txtSale.Text = string.Empty;
        }

        // helper methods

        /// <summary>
        /// calculates the sum of a list of doubles
        /// </summary>
        /// <param name="list">the list of doubles who's sums we should calculate</param>
        /// <returns>the sum of the doubles in the list</returns>
        private double sum(List<double> list)
        {
            // local variables
            double sum = 0;     // holds sum of doubles in list

            // iterate through each item in the list
            foreach (double item in list)
            {
                // add to the sum
                sum += item;
            }

            // return the sum
            return sum;
        }
        
        /// <summary>
        /// calculates the average of a list of doubles
        /// </summary>
        /// <param name="list">the list of doubles whose average is to be found</param>
        /// <returns>the average of the list of doubles</returns>
        private double average(List<double> list)
        {
            // local variables
            double sum = this.sum(list);     // holds sum of doubles in list
            double average = 0; // holds the average of the doubles in the list

            // calcualte the average
            average = sum / list.Count;

            // return the average
            return average;
        }

        /// <summary>
        /// finds the highest number in a list of doubles
        /// </summary>
        /// <param name="list">the list of doubles whose max is to be found</param>
        /// <returns>the highest number in the list</returns>
        private double max(List<double> list)
        {
            // local variables
            double max = 0;     // holds the maximum number in the list
            
            // iterate through each item in the list
            foreach (double item in list)
            {
                // set new max if the current item is larger
                // than the current max
                if (item > max) max = item;
            }

            // return the max
            return max;
        }

        /// <summary>
        /// finds the lowest number in a list of doubles
        /// </summary>
        /// <param name="list">the list of doubles whose min is to be found</param>
        /// <returns>the lowest number in the list</returns>
        private double min(List<double> list)
        {
            // local variables
            double min = 0;        // holds the minimum number in the list
            bool first = true;  // holds wether current list item is the first item in the list

            // iterate through each item in the list
            foreach (double item in list)
            {
                // check if first item in list
                if (first)
                {
                    // set first item to true and set min number as first
                    // in the list and then continue the loop
                    first = false;
                    min = item;
                    continue;
                }

                // set new min if the current item is less
                // than the current min
                if (item < min) min = item;
            }

            // return the min
            return min;
        }

        /// <summary>
        /// displays a list of doubles to the listbox
        /// </summary>
        /// <param name="list">the list of doubles to display</param>
        private void DisplayValues(List<double> list)
        {
            // clear the list box
            // iterate through each item in the list
            foreach (double item in list)
            {
                // add item to listbox
                lstSales.Items.Add(item);
            }
        }

        /// <summary>
        /// displays the sum, max, min, and average to the output label
        /// </summary>
        /// <param name="list">The list to display to the output label</param>
        private void Calculate(List<double> list)
        {
            // clear current output
            lblOutput.Text = String.Empty;

            // display output
            lblOutput.Text += @"Total number of sales: " + list.Count;
            lblOutput.Text += "\nThe total is $" + sum(list);
            lblOutput.Text += "\nThe average is $" + average(list);
            lblOutput.Text += "\nThe largest value is $" + max(list);
            lblOutput.Text += "\nThe smallest value is $" + min(list);
        }
    }
}
