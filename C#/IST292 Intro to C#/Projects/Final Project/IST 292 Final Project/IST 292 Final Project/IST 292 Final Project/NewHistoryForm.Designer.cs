namespace IST_292_Final_Project
{
    partial class NewHistoryForm
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
            this.dtpDateDeleted = new System.Windows.Forms.DateTimePicker();
            this.tbxSuccess = new System.Windows.Forms.TextBox();
            this.lblSuccess = new System.Windows.Forms.Label();
            this.btnAdd = new System.Windows.Forms.Button();
            this.tbxPath = new System.Windows.Forms.TextBox();
            this.lblDateDeleted = new System.Windows.Forms.Label();
            this.lblPath = new System.Windows.Forms.Label();
            this.lblStatus = new System.Windows.Forms.Label();
            this.erp = new System.Windows.Forms.ErrorProvider(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.erp)).BeginInit();
            this.SuspendLayout();
            // 
            // dtpDateDeleted
            // 
            this.dtpDateDeleted.Location = new System.Drawing.Point(132, 80);
            this.dtpDateDeleted.Name = "dtpDateDeleted";
            this.dtpDateDeleted.Size = new System.Drawing.Size(95, 20);
            this.dtpDateDeleted.TabIndex = 36;
            // 
            // tbxSuccess
            // 
            this.tbxSuccess.Location = new System.Drawing.Point(132, 120);
            this.tbxSuccess.Name = "tbxSuccess";
            this.tbxSuccess.Size = new System.Drawing.Size(95, 20);
            this.tbxSuccess.TabIndex = 35;
            // 
            // lblSuccess
            // 
            this.lblSuccess.AutoSize = true;
            this.lblSuccess.Location = new System.Drawing.Point(61, 123);
            this.lblSuccess.Name = "lblSuccess";
            this.lblSuccess.Size = new System.Drawing.Size(51, 13);
            this.lblSuccess.TabIndex = 34;
            this.lblSuccess.Text = "Success:";
            // 
            // btnAdd
            // 
            this.btnAdd.Location = new System.Drawing.Point(95, 185);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(75, 23);
            this.btnAdd.TabIndex = 31;
            this.btnAdd.Text = "Create";
            this.btnAdd.UseVisualStyleBackColor = true;
            this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
            // 
            // tbxPath
            // 
            this.tbxPath.Location = new System.Drawing.Point(132, 39);
            this.tbxPath.Name = "tbxPath";
            this.tbxPath.Size = new System.Drawing.Size(95, 20);
            this.tbxPath.TabIndex = 32;
            // 
            // lblDateDeleted
            // 
            this.lblDateDeleted.AutoSize = true;
            this.lblDateDeleted.Location = new System.Drawing.Point(58, 80);
            this.lblDateDeleted.Name = "lblDateDeleted";
            this.lblDateDeleted.Size = new System.Drawing.Size(73, 13);
            this.lblDateDeleted.TabIndex = 33;
            this.lblDateDeleted.Text = "Date Deleted:";
            // 
            // lblPath
            // 
            this.lblPath.AutoSize = true;
            this.lblPath.Location = new System.Drawing.Point(58, 42);
            this.lblPath.Name = "lblPath";
            this.lblPath.Size = new System.Drawing.Size(32, 13);
            this.lblPath.TabIndex = 30;
            this.lblPath.Text = "Path:";
            // 
            // lblStatus
            // 
            this.lblStatus.AutoSize = true;
            this.lblStatus.Location = new System.Drawing.Point(12, 239);
            this.lblStatus.Name = "lblStatus";
            this.lblStatus.Size = new System.Drawing.Size(0, 13);
            this.lblStatus.TabIndex = 37;
            // 
            // erp
            // 
            this.erp.ContainerControl = this;
            // 
            // NewHistoryForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 261);
            this.Controls.Add(this.lblStatus);
            this.Controls.Add(this.dtpDateDeleted);
            this.Controls.Add(this.tbxSuccess);
            this.Controls.Add(this.lblSuccess);
            this.Controls.Add(this.btnAdd);
            this.Controls.Add(this.tbxPath);
            this.Controls.Add(this.lblDateDeleted);
            this.Controls.Add(this.lblPath);
            this.Name = "NewHistoryForm";
            this.Text = "NewHistoryForm";
            ((System.ComponentModel.ISupportInitialize)(this.erp)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DateTimePicker dtpDateDeleted;
        private System.Windows.Forms.TextBox tbxSuccess;
        private System.Windows.Forms.Label lblSuccess;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.TextBox tbxPath;
        private System.Windows.Forms.Label lblDateDeleted;
        private System.Windows.Forms.Label lblPath;
        private System.Windows.Forms.Label lblStatus;
        private System.Windows.Forms.ErrorProvider erp;
    }
}