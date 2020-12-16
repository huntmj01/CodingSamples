using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;

namespace Assignment_9
{
    public partial class MainForm : Form
    {
        private const string ID_COLUMN = "IdNumber";
        private const string DESCRIPTION_COLUMN = "Description";
        private const string UNITS_COLUMN = "Units";
        private const string PRICE_COLUMN = "Price";

        public MainForm()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //Create RetailItem objects. Add to CurrentInventory

            DisplayInventory();
        }

        private void DisplayInventory()
        {
            BindingSource bs = new BindingSource();
            bs.DataSource = Program.CurrentInventory.Items();

            dgvInventory.DataSource = bs;

            dgvInventory.Columns[ID_COLUMN].DisplayIndex = 0;
            dgvInventory.Columns[DESCRIPTION_COLUMN].DisplayIndex = 1;
            dgvInventory.Columns[UNITS_COLUMN].DisplayIndex = 2;
            dgvInventory.Columns[PRICE_COLUMN].DisplayIndex = 3;
            dgvInventory.Columns[ID_COLUMN].HeaderText = "Id Number";
            dgvInventory.Columns[DESCRIPTION_COLUMN].HeaderText = "Description";
            dgvInventory.Columns[UNITS_COLUMN].HeaderText = "Units on Hand";
            dgvInventory.Columns[PRICE_COLUMN].HeaderText = "Price";
            dgvInventory.ClearSelection();
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            lblStatus.Text = "";

            if (dgvInventory.SelectedRows.Count == 0)
            {
                lblStatus.Text = "No item selected";
            } 
            else
            {
                int selected = (int)dgvInventory.SelectedRows[0].Cells[1].Value;

                InventoryForm frmInventory = new InventoryForm();
                frmInventory.CurrentItem = Program.CurrentInventory.GetItem(selected);
                frmInventory.UpdateSettings();

                frmInventory.ShowDialog();
                DisplayInventory();
            }
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            lblStatus.Text = "";
            InventoryForm frmInventory = new InventoryForm();
            frmInventory.AddSettings();
            frmInventory.ShowDialog();

            DisplayInventory();
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            lblStatus.Text = "";

            if (dgvInventory.SelectedRows.Count == 0)
            {
                lblStatus.Text = "No item selected";
                return;
            }
            else
            {
                int selected = (int)dgvInventory.SelectedRows[0].Cells[1].Value;
                //Program.CurrentInventory.DeleteItem(selected);
                lblStatus.Text = Program.CurrentInventory.LastStatus;
                DisplayInventory();
            }
        }

        private void btnTotalCost_Click(object sender, EventArgs e)
        {
            lblStatus.Text = "Total cost of goods in inventory: " + Program.CurrentInventory.TotalCostOfGoods().ToString("C");
        }
    }
}
