namespace Student_Directory
{
    partial class MainForm
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
            this.label1 = new System.Windows.Forms.Label();
            this.txtName = new System.Windows.Forms.TextBox();
            this.txtID = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.txtMajor = new System.Windows.Forms.TextBox();
            this.lblMajor = new System.Windows.Forms.Label();
            this.radUndergraduate = new System.Windows.Forms.RadioButton();
            this.radGraduate = new System.Windows.Forms.RadioButton();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.txtSpecial = new System.Windows.Forms.TextBox();
            this.lblSpecial = new System.Windows.Forms.Label();
            this.btnAdd = new System.Windows.Forms.Button();
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.lblStatus = new System.Windows.Forms.ToolStripStatusLabel();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuItemExit = new System.Windows.Forms.ToolStripMenuItem();
            this.optionsToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuItemViewAll = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuItemViewUndergrad = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuItemViewGrad = new System.Windows.Forms.ToolStripMenuItem();
            this.lstStudents = new System.Windows.Forms.ListBox();
            this.radAudit = new System.Windows.Forms.RadioButton();
            this.mnuItemViewAudit = new System.Windows.Forms.ToolStripMenuItem();
            this.txtCreditHours = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.groupBox1.SuspendLayout();
            this.statusStrip1.SuspendLayout();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(134, 148);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(38, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Name:";
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(178, 144);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(100, 20);
            this.txtName.TabIndex = 1;
            // 
            // txtID
            // 
            this.txtID.Location = new System.Drawing.Point(178, 170);
            this.txtID.Name = "txtID";
            this.txtID.Size = new System.Drawing.Size(100, 20);
            this.txtID.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(151, 174);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(21, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "ID:";
            // 
            // txtMajor
            // 
            this.txtMajor.Location = new System.Drawing.Point(178, 196);
            this.txtMajor.Name = "txtMajor";
            this.txtMajor.Size = new System.Drawing.Size(100, 20);
            this.txtMajor.TabIndex = 5;
            // 
            // lblMajor
            // 
            this.lblMajor.AutoSize = true;
            this.lblMajor.Location = new System.Drawing.Point(136, 200);
            this.lblMajor.Name = "lblMajor";
            this.lblMajor.Size = new System.Drawing.Size(36, 13);
            this.lblMajor.TabIndex = 4;
            this.lblMajor.Text = "Major:";
            // 
            // radUndergraduate
            // 
            this.radUndergraduate.AutoSize = true;
            this.radUndergraduate.Checked = true;
            this.radUndergraduate.Location = new System.Drawing.Point(19, 15);
            this.radUndergraduate.Name = "radUndergraduate";
            this.radUndergraduate.Size = new System.Drawing.Size(96, 17);
            this.radUndergraduate.TabIndex = 6;
            this.radUndergraduate.TabStop = true;
            this.radUndergraduate.Tag = "0";
            this.radUndergraduate.Text = "Undergraduate";
            this.radUndergraduate.UseVisualStyleBackColor = true;
            this.radUndergraduate.CheckedChanged += new System.EventHandler(this.radioButtons_CheckedChanged);
            // 
            // radGraduate
            // 
            this.radGraduate.AutoSize = true;
            this.radGraduate.Location = new System.Drawing.Point(19, 38);
            this.radGraduate.Name = "radGraduate";
            this.radGraduate.Size = new System.Drawing.Size(69, 17);
            this.radGraduate.TabIndex = 7;
            this.radGraduate.Tag = "1";
            this.radGraduate.Text = "Graduate";
            this.radGraduate.UseVisualStyleBackColor = true;
            this.radGraduate.CheckedChanged += new System.EventHandler(this.radioButtons_CheckedChanged);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.radAudit);
            this.groupBox1.Controls.Add(this.radUndergraduate);
            this.groupBox1.Controls.Add(this.radGraduate);
            this.groupBox1.Location = new System.Drawing.Point(113, 33);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(134, 85);
            this.groupBox1.TabIndex = 8;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Select Type";
            // 
            // txtSpecial
            // 
            this.txtSpecial.Location = new System.Drawing.Point(178, 248);
            this.txtSpecial.Name = "txtSpecial";
            this.txtSpecial.Size = new System.Drawing.Size(100, 20);
            this.txtSpecial.TabIndex = 10;
            // 
            // lblSpecial
            // 
            this.lblSpecial.AutoSize = true;
            this.lblSpecial.Location = new System.Drawing.Point(82, 252);
            this.lblSpecial.Name = "lblSpecial";
            this.lblSpecial.Size = new System.Drawing.Size(90, 13);
            this.lblSpecial.TabIndex = 9;
            this.lblSpecial.Text = "Academic Status:";
            // 
            // btnAdd
            // 
            this.btnAdd.Location = new System.Drawing.Point(143, 283);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(75, 23);
            this.btnAdd.TabIndex = 11;
            this.btnAdd.Text = "Add";
            this.btnAdd.UseVisualStyleBackColor = true;
            this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
            // 
            // statusStrip1
            // 
            this.statusStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.lblStatus});
            this.statusStrip1.Location = new System.Drawing.Point(0, 450);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Size = new System.Drawing.Size(360, 22);
            this.statusStrip1.TabIndex = 12;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // lblStatus
            // 
            this.lblStatus.Name = "lblStatus";
            this.lblStatus.Size = new System.Drawing.Size(0, 17);
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem,
            this.optionsToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(360, 24);
            this.menuStrip1.TabIndex = 13;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // fileToolStripMenuItem
            // 
            this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.mnuItemExit});
            this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
            this.fileToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
            this.fileToolStripMenuItem.Text = "File";
            // 
            // mnuItemExit
            // 
            this.mnuItemExit.Name = "mnuItemExit";
            this.mnuItemExit.Size = new System.Drawing.Size(92, 22);
            this.mnuItemExit.Text = "Exit";
            this.mnuItemExit.Click += new System.EventHandler(this.mnuItemExit_Click);
            // 
            // optionsToolStripMenuItem
            // 
            this.optionsToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.mnuItemViewAll,
            this.mnuItemViewUndergrad,
            this.mnuItemViewGrad,
            this.mnuItemViewAudit});
            this.optionsToolStripMenuItem.Name = "optionsToolStripMenuItem";
            this.optionsToolStripMenuItem.Size = new System.Drawing.Size(61, 20);
            this.optionsToolStripMenuItem.Text = "Options";
            // 
            // mnuItemViewAll
            // 
            this.mnuItemViewAll.Name = "mnuItemViewAll";
            this.mnuItemViewAll.Size = new System.Drawing.Size(230, 22);
            this.mnuItemViewAll.Text = "View All";
            this.mnuItemViewAll.Click += new System.EventHandler(this.mnuItemViewAll_Click);
            // 
            // mnuItemViewUndergrad
            // 
            this.mnuItemViewUndergrad.Name = "mnuItemViewUndergrad";
            this.mnuItemViewUndergrad.Size = new System.Drawing.Size(230, 22);
            this.mnuItemViewUndergrad.Text = "View Undergraduate Students";
            this.mnuItemViewUndergrad.Click += new System.EventHandler(this.mnuItemViewUndergrad_Click);
            // 
            // mnuItemViewGrad
            // 
            this.mnuItemViewGrad.Name = "mnuItemViewGrad";
            this.mnuItemViewGrad.Size = new System.Drawing.Size(230, 22);
            this.mnuItemViewGrad.Text = "View Graduate Students";
            this.mnuItemViewGrad.Click += new System.EventHandler(this.mnuItemViewGrad_Click);
            // 
            // lstStudents
            // 
            this.lstStudents.FormattingEnabled = true;
            this.lstStudents.Location = new System.Drawing.Point(15, 326);
            this.lstStudents.Name = "lstStudents";
            this.lstStudents.Size = new System.Drawing.Size(330, 95);
            this.lstStudents.TabIndex = 14;
            // 
            // radAudit
            // 
            this.radAudit.AutoSize = true;
            this.radAudit.Location = new System.Drawing.Point(19, 61);
            this.radAudit.Name = "radAudit";
            this.radAudit.Size = new System.Drawing.Size(49, 17);
            this.radAudit.TabIndex = 8;
            this.radAudit.Tag = "2";
            this.radAudit.Text = "Audit";
            this.radAudit.UseVisualStyleBackColor = true;
            this.radAudit.CheckedChanged += new System.EventHandler(this.radioButtons_CheckedChanged);
            // 
            // mnuItemViewAudit
            // 
            this.mnuItemViewAudit.Name = "mnuItemViewAudit";
            this.mnuItemViewAudit.Size = new System.Drawing.Size(230, 22);
            this.mnuItemViewAudit.Text = "View Audit Students";
            this.mnuItemViewAudit.Click += new System.EventHandler(this.mnuItemViewAudit_Click);
            // 
            // txtCreditHours
            // 
            this.txtCreditHours.Location = new System.Drawing.Point(178, 222);
            this.txtCreditHours.Name = "txtCreditHours";
            this.txtCreditHours.Size = new System.Drawing.Size(100, 20);
            this.txtCreditHours.TabIndex = 16;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(104, 226);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(68, 13);
            this.label4.TabIndex = 15;
            this.label4.Text = "Credit Hours:";
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(360, 472);
            this.Controls.Add(this.txtCreditHours);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.lstStudents);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.menuStrip1);
            this.Controls.Add(this.btnAdd);
            this.Controls.Add(this.txtSpecial);
            this.Controls.Add(this.lblSpecial);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.txtMajor);
            this.Controls.Add(this.lblMajor);
            this.Controls.Add(this.txtID);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txtName);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;
            this.MainMenuStrip = this.menuStrip1;
            this.MaximizeBox = false;
            this.Name = "MainForm";
            this.Text = "Student Directory";
            this.Load += new System.EventHandler(this.MainForm_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.statusStrip1.ResumeLayout(false);
            this.statusStrip1.PerformLayout();
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.TextBox txtID;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtMajor;
        private System.Windows.Forms.Label lblMajor;
        private System.Windows.Forms.RadioButton radUndergraduate;
        private System.Windows.Forms.RadioButton radGraduate;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TextBox txtSpecial;
        private System.Windows.Forms.Label lblSpecial;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.ToolStripStatusLabel lblStatus;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem mnuItemExit;
        private System.Windows.Forms.ToolStripMenuItem optionsToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem mnuItemViewAll;
        private System.Windows.Forms.ToolStripMenuItem mnuItemViewUndergrad;
        private System.Windows.Forms.ToolStripMenuItem mnuItemViewGrad;
        private System.Windows.Forms.ListBox lstStudents;
        private System.Windows.Forms.RadioButton radAudit;
        private System.Windows.Forms.ToolStripMenuItem mnuItemViewAudit;
        private System.Windows.Forms.TextBox txtCreditHours;
        private System.Windows.Forms.Label label4;
    }
}

