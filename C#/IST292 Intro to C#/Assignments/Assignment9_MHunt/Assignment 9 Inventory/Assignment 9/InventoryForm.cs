using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Assignment_9
{
    public partial class InventoryForm : Form
    {

        RetailItem CurrentItem;

        public InventoryForm()
        {
            InitializeComponent();
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            errProvider.Clear();
            double newPrice;
            int newUnits;

            if (!double.TryParse(txtPrice.Text, out newPrice) || newPrice < 0)
            {
                errProvider.SetError(txtPrice, "Price is not valid");
                return;
            }
            if (!int.TryParse(txtUnits.Text, out newUnits) || newUnits < 0)
            {
                errProvider.SetError(txtUnits, "Units not valid");
                return;
            }


        }

        public void UpdateSettings()
        {
            this.Text = "Update Form";
            txtDescription.Enabled = false;
            txtIdNumber.Enabled = false;
            btnUpdate.Visible = true;
            btnAdd.Visible = false;


        }

        public void AddSettings()
        {
            this.Text = "Add Form";
            txtDescription.Enabled = true;
            txtIdNumber.Enabled = true;
            btnAdd.Visible = true;
            btnUpdate.Visible = false;
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            errProvider.Clear();
            double newPrice;
            int newUnits;
            string newDescription = txtDescription.Text;
            int newIdNumber;

            if (!double.TryParse(txtPrice.Text, out newPrice) || newPrice < 0)
            {
                errProvider.SetError(txtPrice, "Price is not valid");
                return;
            }
            if (!int.TryParse(txtUnits.Text, out newUnits) || newUnits < 0)
            {
                errProvider.SetError(txtUnits, "Units not valid");
                return;
            }
            if (!int.TryParse(txtIdNumber.Text, out newIdNumber) || newIdNumber < 0)
            {
                errProvider.SetError(txtIdNumber, "Id Number not valid");
                return;
            }
            if (newDescription == "")
            {
                errProvider.SetError(txtDescription, "Description is blank");
                return;
            }

        }

        private void InventoryForm_Load(object sender, EventArgs e)
        {

        }
    }
}
