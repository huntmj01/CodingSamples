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
    public partial class ViewAllLoginsForm : Form
    {

        /// <summary>
        /// constructor
        /// </summary>
        public ViewAllLoginsForm()
        {
            InitializeComponent();
        }

        /// <summary>
        /// on form load
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void frmViewAllLogins_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'loginsDataSet.Logins' table. You can move, or remove it, as needed.
            this.loginsTableAdapter.Fill(this.loginsDataSet.Logins);
        }
    }
}
