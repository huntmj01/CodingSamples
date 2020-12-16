using System;
using System.Windows.Forms;

/* 
 * Name:    Matthew Hunt
 * Project: Final Project
 * Date:    12/6/2017
 * Purpose: Allows a user to delete a folder and view/edit delete history.
 */
namespace IST_292_Final_Project
{
    public partial class frmHistory : Form
    {

        /// 
        /// private field
        /// 
        private TerminatorDBUtils dbUtils = new TerminatorDBUtils();

        /// <summary>
        /// constructor
        /// </summary>
        public frmHistory()
        {
            InitializeComponent();
            // populate the table
            DisplayTable();
        }

        /// <summary>
        /// user clicks the show all button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void tslShowAll_Click(object sender, EventArgs e)
        {
            DisplayTable();
        }

        /// <summary>
        /// user clicks the edit button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void tslEdit_Click(object sender, EventArgs e)
        {
            lblStatus.Text = "";

            // open the edit form
            if (dgvHistory.SelectedRows.Count > 0)
            {
                // pass the id to the edit from and show it
                long Id = (long)(dgvHistory.SelectedRows[0].Cells[0].Value);
                EditHistoryForm frmEdit = new EditHistoryForm();
                frmEdit.SetHistoryID(Id);
                frmEdit.ShowDialog();
                DisplayTable();
            }
            else
            {
                lblStatus.Text = "Click on a history item to select it";
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
            if (dgvHistory.SelectedRows.Count > 0)
            {
                // confirm that user wants to delete
                DialogResult dr =
                    MessageBox.Show("Deleting the selected history will permanently remove. Do you want to continue?",
                        "Confirm Delete", MessageBoxButtons.YesNo);

                if (dr == DialogResult.Yes)
                {
                    long selectedId = (long)dgvHistory.SelectedRows[0].Cells[0].Value;

                    // delete the selected item and reload the data if successful
                    if (dbUtils.DeleteHistory(selectedId) == true)
                    {
                        DisplayTable();
                        lblStatus.Text = "History deleted";

                    }
                    else
                    {
                        lblStatus.Text = "Error deleting history";
                    }
                }
            }
            else
            {
                lblStatus.Text = "No history selected";
            }
        }

        /// <summary>
        /// user clicks the add button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void tslAdd_Click(object sender, EventArgs e)
        {
            // display the new history form
            NewHistoryForm form = new NewHistoryForm();
            form.ShowDialog();
            DisplayTable();
        }

        /// <summary>
        /// user clicks the close button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void tslClose_Click(object sender, EventArgs e)
        {
            // close the form
            Close();
        }

        /// <summary>
        /// helper to display all the table data
        /// </summary>
        private void DisplayTable()
        {
            dgvHistory.DataSource = dbUtils.GetAllHistory();
            dgvHistory.ClearSelection();
        }
    }
}
