namespace Population_MHunt
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.cityDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.populationDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.citiesBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.populationDataSet = new Population_MHunt.populationDataSet();
            this.btnShowAll = new System.Windows.Forms.Button();
            this.btnTotalPopulation = new System.Windows.Forms.Button();
            this.btnAveragePopulation = new System.Windows.Forms.Button();
            this.btnHighestPop = new System.Windows.Forms.Button();
            this.btnLowestPop = new System.Windows.Forms.Button();
            this.lblDisplayPopulation = new System.Windows.Forms.Label();
            this.citiesTableAdapter = new Population_MHunt.populationDataSetTableAdapters.CitiesTableAdapter();
            this.tbxPopulation = new System.Windows.Forms.TextBox();
            this.rbnMaxPop = new System.Windows.Forms.RadioButton();
            this.rbnMinPopulation = new System.Windows.Forms.RadioButton();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.btnShowByPopulation = new System.Windows.Forms.Button();
            this.errorProvider1 = new System.Windows.Forms.ErrorProvider(this.components);
            this.errorProvider2 = new System.Windows.Forms.ErrorProvider(this.components);
            this.btnSearchByCity = new System.Windows.Forms.Button();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.rbnStarts = new System.Windows.Forms.RadioButton();
            this.rbnExact = new System.Windows.Forms.RadioButton();
            this.tbxCity = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.citiesBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.populationDataSet)).BeginInit();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.errorProvider2)).BeginInit();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.cityDataGridViewTextBoxColumn,
            this.populationDataGridViewTextBoxColumn});
            this.dataGridView1.DataSource = this.citiesBindingSource;
            this.dataGridView1.Location = new System.Drawing.Point(12, 24);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(313, 225);
            this.dataGridView1.TabIndex = 0;
            // 
            // cityDataGridViewTextBoxColumn
            // 
            this.cityDataGridViewTextBoxColumn.DataPropertyName = "City";
            this.cityDataGridViewTextBoxColumn.HeaderText = "City";
            this.cityDataGridViewTextBoxColumn.Name = "cityDataGridViewTextBoxColumn";
            // 
            // populationDataGridViewTextBoxColumn
            // 
            this.populationDataGridViewTextBoxColumn.DataPropertyName = "Population";
            this.populationDataGridViewTextBoxColumn.HeaderText = "Population";
            this.populationDataGridViewTextBoxColumn.Name = "populationDataGridViewTextBoxColumn";
            // 
            // citiesBindingSource
            // 
            this.citiesBindingSource.DataMember = "Cities";
            this.citiesBindingSource.DataSource = this.populationDataSet;
            // 
            // populationDataSet
            // 
            this.populationDataSet.DataSetName = "populationDataSet";
            this.populationDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // btnShowAll
            // 
            this.btnShowAll.Location = new System.Drawing.Point(331, 38);
            this.btnShowAll.Name = "btnShowAll";
            this.btnShowAll.Size = new System.Drawing.Size(179, 23);
            this.btnShowAll.TabIndex = 1;
            this.btnShowAll.Text = "Show All";
            this.btnShowAll.UseVisualStyleBackColor = true;
            this.btnShowAll.Click += new System.EventHandler(this.btnShowAll_Click);
            // 
            // btnTotalPopulation
            // 
            this.btnTotalPopulation.Location = new System.Drawing.Point(331, 67);
            this.btnTotalPopulation.Name = "btnTotalPopulation";
            this.btnTotalPopulation.Size = new System.Drawing.Size(179, 23);
            this.btnTotalPopulation.TabIndex = 2;
            this.btnTotalPopulation.Text = "Total Population (All Cities)";
            this.btnTotalPopulation.UseVisualStyleBackColor = true;
            this.btnTotalPopulation.Click += new System.EventHandler(this.btnTotalPopulation_Click);
            // 
            // btnAveragePopulation
            // 
            this.btnAveragePopulation.Location = new System.Drawing.Point(331, 96);
            this.btnAveragePopulation.Name = "btnAveragePopulation";
            this.btnAveragePopulation.Size = new System.Drawing.Size(179, 23);
            this.btnAveragePopulation.TabIndex = 3;
            this.btnAveragePopulation.Text = "Average Population (All Cities)";
            this.btnAveragePopulation.UseVisualStyleBackColor = true;
            this.btnAveragePopulation.Click += new System.EventHandler(this.btnAveragePopulation_Click);
            // 
            // btnHighestPop
            // 
            this.btnHighestPop.Location = new System.Drawing.Point(331, 125);
            this.btnHighestPop.Name = "btnHighestPop";
            this.btnHighestPop.Size = new System.Drawing.Size(179, 23);
            this.btnHighestPop.TabIndex = 4;
            this.btnHighestPop.Text = "City of Highest Population";
            this.btnHighestPop.UseVisualStyleBackColor = true;
            this.btnHighestPop.Click += new System.EventHandler(this.btnHighestPop_Click);
            // 
            // btnLowestPop
            // 
            this.btnLowestPop.Location = new System.Drawing.Point(331, 154);
            this.btnLowestPop.Name = "btnLowestPop";
            this.btnLowestPop.Size = new System.Drawing.Size(179, 23);
            this.btnLowestPop.TabIndex = 5;
            this.btnLowestPop.Text = "City of Lowest Population";
            this.btnLowestPop.UseVisualStyleBackColor = true;
            this.btnLowestPop.Click += new System.EventHandler(this.btnLowestPop_Click);
            // 
            // lblDisplayPopulation
            // 
            this.lblDisplayPopulation.AutoSize = true;
            this.lblDisplayPopulation.Location = new System.Drawing.Point(333, 233);
            this.lblDisplayPopulation.Name = "lblDisplayPopulation";
            this.lblDisplayPopulation.Size = new System.Drawing.Size(0, 13);
            this.lblDisplayPopulation.TabIndex = 6;
            // 
            // citiesTableAdapter
            // 
            this.citiesTableAdapter.ClearBeforeFill = true;
            // 
            // tbxPopulation
            // 
            this.tbxPopulation.Location = new System.Drawing.Point(80, 255);
            this.tbxPopulation.Name = "tbxPopulation";
            this.tbxPopulation.Size = new System.Drawing.Size(100, 20);
            this.tbxPopulation.TabIndex = 7;
            // 
            // rbnMaxPop
            // 
            this.rbnMaxPop.AutoSize = true;
            this.rbnMaxPop.Checked = true;
            this.rbnMaxPop.Location = new System.Drawing.Point(14, 19);
            this.rbnMaxPop.Name = "rbnMaxPop";
            this.rbnMaxPop.Size = new System.Drawing.Size(98, 17);
            this.rbnMaxPop.TabIndex = 8;
            this.rbnMaxPop.TabStop = true;
            this.rbnMaxPop.Text = "Max Population";
            this.rbnMaxPop.UseVisualStyleBackColor = true;
            // 
            // rbnMinPopulation
            // 
            this.rbnMinPopulation.AutoSize = true;
            this.rbnMinPopulation.Location = new System.Drawing.Point(138, 19);
            this.rbnMinPopulation.Name = "rbnMinPopulation";
            this.rbnMinPopulation.Size = new System.Drawing.Size(95, 17);
            this.rbnMinPopulation.TabIndex = 9;
            this.rbnMinPopulation.Text = "Min Population";
            this.rbnMinPopulation.UseVisualStyleBackColor = true;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.rbnMinPopulation);
            this.groupBox1.Controls.Add(this.rbnMaxPop);
            this.groupBox1.Location = new System.Drawing.Point(12, 281);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(242, 45);
            this.groupBox1.TabIndex = 10;
            this.groupBox1.TabStop = false;
            // 
            // btnShowByPopulation
            // 
            this.btnShowByPopulation.Location = new System.Drawing.Point(74, 335);
            this.btnShowByPopulation.Name = "btnShowByPopulation";
            this.btnShowByPopulation.Size = new System.Drawing.Size(112, 23);
            this.btnShowByPopulation.TabIndex = 0;
            this.btnShowByPopulation.Text = "Show By Population";
            this.btnShowByPopulation.UseVisualStyleBackColor = true;
            this.btnShowByPopulation.Click += new System.EventHandler(this.btnShowByPopulation_Click);
            // 
            // errorProvider1
            // 
            this.errorProvider1.ContainerControl = this;
            // 
            // errorProvider2
            // 
            this.errorProvider2.ContainerControl = this;
            // 
            // btnSearchByCity
            // 
            this.btnSearchByCity.Location = new System.Drawing.Point(330, 335);
            this.btnSearchByCity.Name = "btnSearchByCity";
            this.btnSearchByCity.Size = new System.Drawing.Size(112, 23);
            this.btnSearchByCity.TabIndex = 11;
            this.btnSearchByCity.Text = "Search By City Name";
            this.btnSearchByCity.UseVisualStyleBackColor = true;
            this.btnSearchByCity.Click += new System.EventHandler(this.btnSearchByCity_Click);
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.rbnStarts);
            this.groupBox2.Controls.Add(this.rbnExact);
            this.groupBox2.Location = new System.Drawing.Point(268, 281);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(242, 45);
            this.groupBox2.TabIndex = 13;
            this.groupBox2.TabStop = false;
            // 
            // rbnStarts
            // 
            this.rbnStarts.AutoSize = true;
            this.rbnStarts.Location = new System.Drawing.Point(138, 19);
            this.rbnStarts.Name = "rbnStarts";
            this.rbnStarts.Size = new System.Drawing.Size(77, 17);
            this.rbnStarts.TabIndex = 9;
            this.rbnStarts.Text = "Starts With";
            this.rbnStarts.UseVisualStyleBackColor = true;
            // 
            // rbnExact
            // 
            this.rbnExact.AutoSize = true;
            this.rbnExact.Checked = true;
            this.rbnExact.Location = new System.Drawing.Point(14, 19);
            this.rbnExact.Name = "rbnExact";
            this.rbnExact.Size = new System.Drawing.Size(85, 17);
            this.rbnExact.TabIndex = 8;
            this.rbnExact.TabStop = true;
            this.rbnExact.Text = "Exact Match";
            this.rbnExact.UseVisualStyleBackColor = true;
            // 
            // tbxCity
            // 
            this.tbxCity.Location = new System.Drawing.Point(336, 255);
            this.tbxCity.Name = "tbxCity";
            this.tbxCity.Size = new System.Drawing.Size(100, 20);
            this.tbxCity.TabIndex = 12;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(523, 370);
            this.Controls.Add(this.btnSearchByCity);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.tbxCity);
            this.Controls.Add(this.btnShowByPopulation);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.tbxPopulation);
            this.Controls.Add(this.lblDisplayPopulation);
            this.Controls.Add(this.btnLowestPop);
            this.Controls.Add(this.btnHighestPop);
            this.Controls.Add(this.btnAveragePopulation);
            this.Controls.Add(this.btnTotalPopulation);
            this.Controls.Add(this.btnShowAll);
            this.Controls.Add(this.dataGridView1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.citiesBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.populationDataSet)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.errorProvider2)).EndInit();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private populationDataSet populationDataSet;
        private System.Windows.Forms.BindingSource citiesBindingSource;
        private populationDataSetTableAdapters.CitiesTableAdapter citiesTableAdapter;
        private System.Windows.Forms.DataGridViewTextBoxColumn cityDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn populationDataGridViewTextBoxColumn;
        private System.Windows.Forms.Button btnShowAll;
        private System.Windows.Forms.Button btnTotalPopulation;
        private System.Windows.Forms.Button btnAveragePopulation;
        private System.Windows.Forms.Button btnHighestPop;
        private System.Windows.Forms.Button btnLowestPop;
        private System.Windows.Forms.Label lblDisplayPopulation;
        private System.Windows.Forms.TextBox tbxPopulation;
        private System.Windows.Forms.RadioButton rbnMaxPop;
        private System.Windows.Forms.RadioButton rbnMinPopulation;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button btnShowByPopulation;
        private System.Windows.Forms.ErrorProvider errorProvider1;
        private System.Windows.Forms.Button btnSearchByCity;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.RadioButton rbnStarts;
        private System.Windows.Forms.RadioButton rbnExact;
        private System.Windows.Forms.TextBox tbxCity;
        private System.Windows.Forms.ErrorProvider errorProvider2;
    }
}

