using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

/* 
 * Name: Matthew Hunt
 * Project: Assignment 11
 * Date: 11/02/17
 * Purpose: Allows a user to analyze population of cities database.
 */
namespace Population_MHunt
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'populationDataSet.Cities' table. You can move, or remove it, as needed.
            this.citiesTableAdapter.Fill(this.populationDataSet.Cities);

        }

        /// <summary>
        /// user clicks the show all button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnShowAll_Click(object sender, EventArgs e)
        {
            this.citiesTableAdapter.FindAll(this.populationDataSet.Cities);
        }

        /// <summary>
        /// user clicks the total population button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnTotalPopulation_Click(object sender, EventArgs e)
        {
            lblDisplayPopulation.Text = "Total Population: " + this.citiesTableAdapter.GetTotalPop();
        }

        /// <summary>
        /// user clicks the average population button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnAveragePopulation_Click(object sender, EventArgs e)
        {
            lblDisplayPopulation.Text = "Average Population: " + this.citiesTableAdapter.GetAvgPop();
        }

        /// <summary>
        /// user clicks the highest population button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnHighestPop_Click(object sender, EventArgs e)
        {
            this.citiesTableAdapter.GetMaxPop(this.populationDataSet.Cities);
        }

        /// <summary>
        /// user clicks the lowest population button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnLowestPop_Click(object sender, EventArgs e)
        {
            this.citiesTableAdapter.GetMinPop(this.populationDataSet.Cities);
        }

        /// <summary>
        /// user clicks the show by population button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnShowByPopulation_Click(object sender, EventArgs e)
        {
            
            int temp;
            
            // check if value in text box is an int
            if (int.TryParse(tbxPopulation.Text, out temp))
            {
                // check which radio button is checked
                if (rbnMaxPop.Checked)
                {
                    this.citiesTableAdapter.FindByMinPop(this.populationDataSet.Cities, int.Parse(tbxPopulation.Text));
                }
                else
                {
                    this.citiesTableAdapter.FindByMaxPop(this.populationDataSet.Cities, int.Parse(tbxPopulation.Text));
                }

            }
            else
            {
                errorProvider1.SetError(tbxPopulation, "Value must be int.");
            }
            
        }

        /// <summary>
        /// user clicks the search by city button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnSearchByCity_Click(object sender, EventArgs e)
        {
            // check which radio button is checked
            if (rbnExact.Checked)
            {
                this.citiesTableAdapter.FindByCity(this.populationDataSet.Cities, tbxCity.Text);
            }
            else
            {
                this.citiesTableAdapter.FindByPartOfCity(this.populationDataSet.Cities, tbxCity.Text);
            }
        }
    }
}
