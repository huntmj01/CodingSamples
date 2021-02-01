namespace Project2_MHunt
{
    partial class frmEmployeeDirectory
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
            this.lblIDNumber = new System.Windows.Forms.Label();
            this.tbxIDNumber = new System.Windows.Forms.TextBox();
            this.tbxPhone = new System.Windows.Forms.MaskedTextBox();
            this.tbxName = new System.Windows.Forms.TextBox();
            this.lblName = new System.Windows.Forms.Label();
            this.cbxDepartment = new System.Windows.Forms.ComboBox();
            this.lblDepartment = new System.Windows.Forms.Label();
            this.lblJobTitle = new System.Windows.Forms.Label();
            this.cbxJobTitle = new System.Windows.Forms.ComboBox();
            this.lblPhoneNumber = new System.Windows.Forms.Label();
            this.tbxSalary = new System.Windows.Forms.TextBox();
            this.lblSalary = new System.Windows.Forms.Label();
            this.btnAdd = new System.Windows.Forms.Button();
            this.gbxSearchBy = new System.Windows.Forms.GroupBox();
            this.rbnName = new System.Windows.Forms.RadioButton();
            this.rbnIdNumber = new System.Windows.Forms.RadioButton();
            this.tbxSearch = new System.Windows.Forms.TextBox();
            this.btnFind = new System.Windows.Forms.Button();
            this.btnDelete = new System.Windows.Forms.Button();
            this.btnCreateReport = new System.Windows.Forms.Button();
            this.btnSalaryAnalysis = new System.Windows.Forms.Button();
            this.btnSave = new System.Windows.Forms.Button();
            this.btnExit = new System.Windows.Forms.Button();
            this.errorProvider1 = new System.Windows.Forms.ErrorProvider(this.components);
            this.lblStatus = new System.Windows.Forms.Label();
            this.lbxOutput = new System.Windows.Forms.ListBox();
            this.gbxSearchBy.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).BeginInit();
            this.SuspendLayout();
            // 
            // lblIDNumber
            // 
            this.lblIDNumber.AutoSize = true;
            this.lblIDNumber.Location = new System.Drawing.Point(19, 28);
            this.lblIDNumber.Name = "lblIDNumber";
            this.lblIDNumber.Size = new System.Drawing.Size(61, 13);
            this.lblIDNumber.TabIndex = 0;
            this.lblIDNumber.Text = "ID Number:";
            // 
            // tbxIDNumber
            // 
            this.tbxIDNumber.Location = new System.Drawing.Point(83, 25);
            this.tbxIDNumber.Name = "tbxIDNumber";
            this.tbxIDNumber.Size = new System.Drawing.Size(62, 20);
            this.tbxIDNumber.TabIndex = 1;
            // 
            // tbxPhone
            // 
            this.tbxPhone.Location = new System.Drawing.Point(83, 137);
            this.tbxPhone.Mask = "000-0000";
            this.tbxPhone.Name = "tbxPhone";
            this.tbxPhone.Size = new System.Drawing.Size(62, 20);
            this.tbxPhone.TabIndex = 2;
            // 
            // tbxName
            // 
            this.tbxName.Location = new System.Drawing.Point(83, 56);
            this.tbxName.Name = "tbxName";
            this.tbxName.Size = new System.Drawing.Size(121, 20);
            this.tbxName.TabIndex = 4;
            // 
            // lblName
            // 
            this.lblName.AutoSize = true;
            this.lblName.Location = new System.Drawing.Point(39, 59);
            this.lblName.Name = "lblName";
            this.lblName.Size = new System.Drawing.Size(38, 13);
            this.lblName.TabIndex = 3;
            this.lblName.Text = "Name:";
            // 
            // cbxDepartment
            // 
            this.cbxDepartment.FormattingEnabled = true;
            this.cbxDepartment.Location = new System.Drawing.Point(83, 83);
            this.cbxDepartment.Name = "cbxDepartment";
            this.cbxDepartment.Size = new System.Drawing.Size(121, 21);
            this.cbxDepartment.TabIndex = 5;
            // 
            // lblDepartment
            // 
            this.lblDepartment.AutoSize = true;
            this.lblDepartment.Location = new System.Drawing.Point(15, 86);
            this.lblDepartment.Name = "lblDepartment";
            this.lblDepartment.Size = new System.Drawing.Size(65, 13);
            this.lblDepartment.TabIndex = 6;
            this.lblDepartment.Text = "Department:";
            // 
            // lblJobTitle
            // 
            this.lblJobTitle.AutoSize = true;
            this.lblJobTitle.Location = new System.Drawing.Point(27, 113);
            this.lblJobTitle.Name = "lblJobTitle";
            this.lblJobTitle.Size = new System.Drawing.Size(50, 13);
            this.lblJobTitle.TabIndex = 8;
            this.lblJobTitle.Text = "Job Title:";
            // 
            // cbxJobTitle
            // 
            this.cbxJobTitle.FormattingEnabled = true;
            this.cbxJobTitle.Location = new System.Drawing.Point(83, 110);
            this.cbxJobTitle.Name = "cbxJobTitle";
            this.cbxJobTitle.Size = new System.Drawing.Size(121, 21);
            this.cbxJobTitle.TabIndex = 7;
            // 
            // lblPhoneNumber
            // 
            this.lblPhoneNumber.AutoSize = true;
            this.lblPhoneNumber.Location = new System.Drawing.Point(-1, 140);
            this.lblPhoneNumber.Name = "lblPhoneNumber";
            this.lblPhoneNumber.Size = new System.Drawing.Size(81, 13);
            this.lblPhoneNumber.TabIndex = 9;
            this.lblPhoneNumber.Text = "Phone Number:";
            // 
            // tbxSalary
            // 
            this.tbxSalary.Location = new System.Drawing.Point(83, 163);
            this.tbxSalary.Name = "tbxSalary";
            this.tbxSalary.Size = new System.Drawing.Size(121, 20);
            this.tbxSalary.TabIndex = 11;
            // 
            // lblSalary
            // 
            this.lblSalary.AutoSize = true;
            this.lblSalary.Location = new System.Drawing.Point(39, 166);
            this.lblSalary.Name = "lblSalary";
            this.lblSalary.Size = new System.Drawing.Size(39, 13);
            this.lblSalary.TabIndex = 10;
            this.lblSalary.Text = "Salary:";
            // 
            // btnAdd
            // 
            this.btnAdd.Location = new System.Drawing.Point(51, 204);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(75, 23);
            this.btnAdd.TabIndex = 12;
            this.btnAdd.Text = "Add";
            this.btnAdd.UseVisualStyleBackColor = true;
            this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
            // 
            // gbxSearchBy
            // 
            this.gbxSearchBy.Controls.Add(this.rbnName);
            this.gbxSearchBy.Controls.Add(this.rbnIdNumber);
            this.gbxSearchBy.Location = new System.Drawing.Point(250, 25);
            this.gbxSearchBy.Name = "gbxSearchBy";
            this.gbxSearchBy.Size = new System.Drawing.Size(150, 100);
            this.gbxSearchBy.TabIndex = 13;
            this.gbxSearchBy.TabStop = false;
            this.gbxSearchBy.Text = "Search By:";
            // 
            // rbnName
            // 
            this.rbnName.AutoSize = true;
            this.rbnName.Location = new System.Drawing.Point(6, 53);
            this.rbnName.Name = "rbnName";
            this.rbnName.Size = new System.Drawing.Size(53, 17);
            this.rbnName.TabIndex = 1;
            this.rbnName.Text = "Name";
            this.rbnName.UseVisualStyleBackColor = true;
            // 
            // rbnIdNumber
            // 
            this.rbnIdNumber.AutoSize = true;
            this.rbnIdNumber.Checked = true;
            this.rbnIdNumber.Location = new System.Drawing.Point(6, 30);
            this.rbnIdNumber.Name = "rbnIdNumber";
            this.rbnIdNumber.Size = new System.Drawing.Size(76, 17);
            this.rbnIdNumber.TabIndex = 0;
            this.rbnIdNumber.TabStop = true;
            this.rbnIdNumber.Text = "ID Number";
            this.rbnIdNumber.UseVisualStyleBackColor = true;
            // 
            // tbxSearch
            // 
            this.tbxSearch.Location = new System.Drawing.Point(407, 55);
            this.tbxSearch.Name = "tbxSearch";
            this.tbxSearch.Size = new System.Drawing.Size(100, 20);
            this.tbxSearch.TabIndex = 14;
            // 
            // btnFind
            // 
            this.btnFind.Location = new System.Drawing.Point(359, 140);
            this.btnFind.Name = "btnFind";
            this.btnFind.Size = new System.Drawing.Size(75, 23);
            this.btnFind.TabIndex = 15;
            this.btnFind.Text = "Find";
            this.btnFind.UseVisualStyleBackColor = true;
            this.btnFind.Click += new System.EventHandler(this.btnFind_Click);
            // 
            // btnDelete
            // 
            this.btnDelete.Location = new System.Drawing.Point(359, 217);
            this.btnDelete.Name = "btnDelete";
            this.btnDelete.Size = new System.Drawing.Size(75, 23);
            this.btnDelete.TabIndex = 17;
            this.btnDelete.Text = "Delete";
            this.btnDelete.UseVisualStyleBackColor = true;
            this.btnDelete.Click += new System.EventHandler(this.btnDelete_Click);
            // 
            // btnCreateReport
            // 
            this.btnCreateReport.Location = new System.Drawing.Point(172, 257);
            this.btnCreateReport.Name = "btnCreateReport";
            this.btnCreateReport.Size = new System.Drawing.Size(94, 23);
            this.btnCreateReport.TabIndex = 18;
            this.btnCreateReport.Text = "Create Report";
            this.btnCreateReport.UseVisualStyleBackColor = true;
            this.btnCreateReport.Click += new System.EventHandler(this.btnCreateReport_Click);
            // 
            // btnSalaryAnalysis
            // 
            this.btnSalaryAnalysis.Location = new System.Drawing.Point(268, 257);
            this.btnSalaryAnalysis.Name = "btnSalaryAnalysis";
            this.btnSalaryAnalysis.Size = new System.Drawing.Size(105, 23);
            this.btnSalaryAnalysis.TabIndex = 19;
            this.btnSalaryAnalysis.Text = "Salary Analysis";
            this.btnSalaryAnalysis.UseVisualStyleBackColor = true;
            this.btnSalaryAnalysis.Click += new System.EventHandler(this.btnSalaryAnalysis_Click);
            // 
            // btnSave
            // 
            this.btnSave.Location = new System.Drawing.Point(172, 286);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(94, 23);
            this.btnSave.TabIndex = 20;
            this.btnSave.Text = "Save";
            this.btnSave.UseVisualStyleBackColor = true;
            this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(268, 286);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(105, 23);
            this.btnExit.TabIndex = 21;
            this.btnExit.Text = "Exit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // errorProvider1
            // 
            this.errorProvider1.ContainerControl = this;
            // 
            // lblStatus
            // 
            this.lblStatus.AutoSize = true;
            this.lblStatus.Location = new System.Drawing.Point(12, 341);
            this.lblStatus.Name = "lblStatus";
            this.lblStatus.Size = new System.Drawing.Size(40, 13);
            this.lblStatus.TabIndex = 22;
            this.lblStatus.Text = "Status:";
            // 
            // lbxOutput
            // 
            this.lbxOutput.FormattingEnabled = true;
            this.lbxOutput.Location = new System.Drawing.Point(256, 168);
            this.lbxOutput.Name = "lbxOutput";
            this.lbxOutput.Size = new System.Drawing.Size(262, 43);
            this.lbxOutput.TabIndex = 23;
            // 
            // frmEmployeeDirectory
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(562, 380);
            this.Controls.Add(this.lbxOutput);
            this.Controls.Add(this.lblStatus);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.btnSave);
            this.Controls.Add(this.btnSalaryAnalysis);
            this.Controls.Add(this.btnCreateReport);
            this.Controls.Add(this.btnDelete);
            this.Controls.Add(this.btnFind);
            this.Controls.Add(this.tbxSearch);
            this.Controls.Add(this.gbxSearchBy);
            this.Controls.Add(this.btnAdd);
            this.Controls.Add(this.tbxSalary);
            this.Controls.Add(this.lblSalary);
            this.Controls.Add(this.lblPhoneNumber);
            this.Controls.Add(this.lblJobTitle);
            this.Controls.Add(this.cbxJobTitle);
            this.Controls.Add(this.lblDepartment);
            this.Controls.Add(this.cbxDepartment);
            this.Controls.Add(this.tbxName);
            this.Controls.Add(this.lblName);
            this.Controls.Add(this.tbxPhone);
            this.Controls.Add(this.tbxIDNumber);
            this.Controls.Add(this.lblIDNumber);
            this.Name = "frmEmployeeDirectory";
            this.Text = "Form1";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.frmEmployeeDirectory_FormClosing);
            this.Load += new System.EventHandler(this.frmEmployeeDirectory_Load);
            this.gbxSearchBy.ResumeLayout(false);
            this.gbxSearchBy.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblIDNumber;
        private System.Windows.Forms.TextBox tbxIDNumber;
        private System.Windows.Forms.MaskedTextBox tbxPhone;
        private System.Windows.Forms.TextBox tbxName;
        private System.Windows.Forms.Label lblName;
        private System.Windows.Forms.ComboBox cbxDepartment;
        private System.Windows.Forms.Label lblDepartment;
        private System.Windows.Forms.Label lblJobTitle;
        private System.Windows.Forms.ComboBox cbxJobTitle;
        private System.Windows.Forms.Label lblPhoneNumber;
        private System.Windows.Forms.TextBox tbxSalary;
        private System.Windows.Forms.Label lblSalary;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.GroupBox gbxSearchBy;
        private System.Windows.Forms.RadioButton rbnName;
        private System.Windows.Forms.RadioButton rbnIdNumber;
        private System.Windows.Forms.TextBox tbxSearch;
        private System.Windows.Forms.Button btnFind;
        private System.Windows.Forms.Button btnDelete;
        private System.Windows.Forms.Button btnCreateReport;
        private System.Windows.Forms.Button btnSalaryAnalysis;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.ErrorProvider errorProvider1;
        private System.Windows.Forms.Label lblStatus;
        private System.Windows.Forms.ListBox lbxOutput;
    }
}

