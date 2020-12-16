using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SQLite_Assignment
{
    public partial class Form1 : Form
    {
        PopulationDBUtils populationDb = new PopulationDBUtils();

        public Form1()
        {
            InitializeComponent();
        }

        private void btnShowAll_Click(object sender, EventArgs e)
        {
            DisplayTable();
        }

        private void DisplayTable()
        {
            cityDataGridView.DataSource = populationDb.GetAllCities();
            cityDataGridView.ClearSelection();
        }

        private void btnTotalPopulation_Click(object sender, EventArgs e)
        {
            lblStatus.Text = "" + populationDb.GetTotalPopulation();
        }

        private void btnAverage_Click(object sender, EventArgs e)
        {
            lblStatus.Text = "" + populationDb.GetAveragePopulation();
        }

        private void radAdd_CheckedChanged(object sender, EventArgs e)
        {
            RadioCheckedChanged();
        }

        private void radDelete_CheckedChanged(object sender, EventArgs e)
        {
            RadioCheckedChanged();
        }

        private void RadioCheckedChanged()
        {
            txtCity.Clear();
            txtPopulation.Clear();

            if (radAdd.Checked)
            {
                txtCity.Enabled = true;
                txtPopulation.Enabled = true;
            }
            else if (radDelete.Checked)
            {
                txtCity.Enabled = true;
                txtPopulation.Enabled = false;
            }
            else if (radEdit.Checked)
            { 
                txtCity.Enabled = true;
                txtPopulation.Enabled = true;
            }
            else if (radFindByName.Checked)
            {
                txtCity.Enabled = true;
                txtPopulation.Enabled = false;
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void btnProcess_Click(object sender, EventArgs e)
        {
            try//DONT DO THIS
            {
                lblStatus.Text = "";

                String population = "";
                String city = "";

                if (radAdd.Checked)
                {
                    city = txtCity.Text;
                    population = txtPopulation.Text;
                    

                    if (populationDb.AddCity(city,population))
                    {
                        DisplayTable();
                    }

                    lblStatus.Text = populationDb.LastStatus;
                }
                else if (radDelete.Checked)
                {
                    city = txtCity.Text;

                    if (populationDb.DeleteCity(city))
                    {
                        DisplayTable();
                    }
                }
                else if (radEdit.Checked)
                {
                    city = txtCity.Text;
                    population = txtPopulation.Text;

                    if (cityDataGridView.SelectedCells.Count == 0)
                    {
                        lblStatus.Text = "No employee selected";
                        return;
                    }

                    if (populationDb.EditCity(city, population))
                    {
                        DisplayTable();
                    }

                    lblStatus.Text = populationDb.LastStatus;
                }
                else if (radFindByName.Checked)
                {
                    city = txtCity.Text;
                    cityDataGridView.DataSource = populationDb.FindByCity(city);
                    cityDataGridView.ClearSelection();

                }
                //else if (radFindId.Checked)
                //{
                //    enteredId = int.Parse(idTextBox.Text);

                //}
            }
            catch (Exception crap)
            {
                lblStatus.Text = crap.Message;
            }
        }

        private void radEdit_CheckedChanged(object sender, EventArgs e)
        {
           RadioCheckedChanged();
        }

        private void radFindByName_CheckedChanged(object sender, EventArgs e)
        {
            RadioCheckedChanged();
        }
    }
}
