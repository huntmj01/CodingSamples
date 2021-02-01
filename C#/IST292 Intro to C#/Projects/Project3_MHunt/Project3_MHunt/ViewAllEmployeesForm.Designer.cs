namespace Project3_MHunt
{
    partial class ViewAllEmployeesForm
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
            this.dgvEmployees = new System.Windows.Forms.DataGridView();
            this.toolStrip1 = new System.Windows.Forms.ToolStrip();
            this.tslShowAll = new System.Windows.Forms.ToolStripLabel();
            this.toolStripSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.tslEmployee = new System.Windows.Forms.ToolStripLabel();
            this.tscEmployee = new System.Windows.Forms.ToolStripComboBox();
            this.toolStripSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.tslEdit = new System.Windows.Forms.ToolStripLabel();
            this.toolStripSeparator3 = new System.Windows.Forms.ToolStripSeparator();
            this.tslDelete = new System.Windows.Forms.ToolStripLabel();
            this.toolStripSeparator4 = new System.Windows.Forms.ToolStripSeparator();
            this.tslAdd = new System.Windows.Forms.ToolStripLabel();
            this.toolStripSeparator5 = new System.Windows.Forms.ToolStripSeparator();
            this.tslClose = new System.Windows.Forms.ToolStripLabel();
            this.lblStatus = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dgvEmployees)).BeginInit();
            this.toolStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // dgvEmployees
            // 
            this.dgvEmployees.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvEmployees.Location = new System.Drawing.Point(12, 28);
            this.dgvEmployees.Name = "dgvEmployees";
            this.dgvEmployees.Size = new System.Drawing.Size(421, 243);
            this.dgvEmployees.TabIndex = 0;
            // 
            // toolStrip1
            // 
            this.toolStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tslShowAll,
            this.toolStripSeparator2,
            this.tslEmployee,
            this.tscEmployee,
            this.toolStripSeparator1,
            this.tslEdit,
            this.toolStripSeparator3,
            this.tslDelete,
            this.toolStripSeparator4,
            this.tslAdd,
            this.toolStripSeparator5,
            this.tslClose});
            this.toolStrip1.Location = new System.Drawing.Point(0, 0);
            this.toolStrip1.Name = "toolStrip1";
            this.toolStrip1.Size = new System.Drawing.Size(445, 25);
            this.toolStrip1.TabIndex = 1;
            this.toolStrip1.Text = "toolStrip1";
            // 
            // tslShowAll
            // 
            this.tslShowAll.Name = "tslShowAll";
            this.tslShowAll.Size = new System.Drawing.Size(53, 22);
            this.tslShowAll.Text = "Show All";
            this.tslShowAll.Click += new System.EventHandler(this.tslShowAll_Click);
            // 
            // toolStripSeparator2
            // 
            this.toolStripSeparator2.Name = "toolStripSeparator2";
            this.toolStripSeparator2.Size = new System.Drawing.Size(6, 25);
            // 
            // tslEmployee
            // 
            this.tslEmployee.Name = "tslEmployee";
            this.tslEmployee.Size = new System.Drawing.Size(62, 22);
            this.tslEmployee.Text = "Employee:";
            // 
            // tscEmployee
            // 
            this.tscEmployee.Name = "tscEmployee";
            this.tscEmployee.Size = new System.Drawing.Size(121, 25);
            this.tscEmployee.SelectedIndexChanged += new System.EventHandler(this.tscEmployee_SelectedIndexChanged);
            // 
            // toolStripSeparator1
            // 
            this.toolStripSeparator1.Name = "toolStripSeparator1";
            this.toolStripSeparator1.Size = new System.Drawing.Size(6, 25);
            // 
            // tslEdit
            // 
            this.tslEdit.Name = "tslEdit";
            this.tslEdit.Size = new System.Drawing.Size(27, 22);
            this.tslEdit.Text = "Edit";
            this.tslEdit.Click += new System.EventHandler(this.tslEdit_Click);
            // 
            // toolStripSeparator3
            // 
            this.toolStripSeparator3.Name = "toolStripSeparator3";
            this.toolStripSeparator3.Size = new System.Drawing.Size(6, 25);
            // 
            // tslDelete
            // 
            this.tslDelete.Name = "tslDelete";
            this.tslDelete.Size = new System.Drawing.Size(40, 22);
            this.tslDelete.Text = "Delete";
            this.tslDelete.Click += new System.EventHandler(this.tslDelete_Click);
            // 
            // toolStripSeparator4
            // 
            this.toolStripSeparator4.Name = "toolStripSeparator4";
            this.toolStripSeparator4.Size = new System.Drawing.Size(6, 25);
            // 
            // tslAdd
            // 
            this.tslAdd.Name = "tslAdd";
            this.tslAdd.Size = new System.Drawing.Size(29, 22);
            this.tslAdd.Text = "Add";
            this.tslAdd.Click += new System.EventHandler(this.tslAdd_Click);
            // 
            // toolStripSeparator5
            // 
            this.toolStripSeparator5.Name = "toolStripSeparator5";
            this.toolStripSeparator5.Size = new System.Drawing.Size(6, 25);
            // 
            // tslClose
            // 
            this.tslClose.Name = "tslClose";
            this.tslClose.Size = new System.Drawing.Size(36, 22);
            this.tslClose.Text = "Close";
            this.tslClose.Click += new System.EventHandler(this.tslClose_Click);
            // 
            // lblStatus
            // 
            this.lblStatus.AutoSize = true;
            this.lblStatus.Location = new System.Drawing.Point(12, 261);
            this.lblStatus.Name = "lblStatus";
            this.lblStatus.Size = new System.Drawing.Size(0, 13);
            this.lblStatus.TabIndex = 2;
            // 
            // ViewAllEmployeesForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(445, 283);
            this.Controls.Add(this.lblStatus);
            this.Controls.Add(this.toolStrip1);
            this.Controls.Add(this.dgvEmployees);
            this.Name = "ViewAllEmployeesForm";
            this.Text = "ViewAllEmployeesForm";
            this.Load += new System.EventHandler(this.ViewAllEmployeesForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgvEmployees)).EndInit();
            this.toolStrip1.ResumeLayout(false);
            this.toolStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dgvEmployees;
        private System.Windows.Forms.ToolStrip toolStrip1;
        private System.Windows.Forms.ToolStripLabel tslShowAll;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator2;
        private System.Windows.Forms.ToolStripLabel tslEmployee;
        private System.Windows.Forms.ToolStripComboBox tscEmployee;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator1;
        private System.Windows.Forms.ToolStripLabel tslEdit;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator3;
        private System.Windows.Forms.ToolStripLabel tslDelete;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator4;
        private System.Windows.Forms.ToolStripLabel tslAdd;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator5;
        private System.Windows.Forms.ToolStripLabel tslClose;
        private System.Windows.Forms.Label lblStatus;
    }
}