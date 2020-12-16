namespace IST_292_Final_Project
{
    partial class EditHistoryForm
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
            this.tbxSuccess = new System.Windows.Forms.TextBox();
            this.lblSuccess = new System.Windows.Forms.Label();
            this.btnUpdate = new System.Windows.Forms.Button();
            this.tbxPath = new System.Windows.Forms.TextBox();
            this.lblDateDeleted = new System.Windows.Forms.Label();
            this.lblPath = new System.Windows.Forms.Label();
            this.dtpDateDeleted = new System.Windows.Forms.DateTimePicker();
            this.lblStatus = new System.Windows.Forms.Label();
            this.erp = new System.Windows.Forms.ErrorProvider(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.erp)).BeginInit();
            this.SuspendLayout();
            // 
            // tbxSuccess
            // 
            this.tbxSuccess.Location = new System.Drawing.Point(132, 115);
            this.tbxSuccess.Name = "tbxSuccess";
            this.tbxSuccess.Size = new System.Drawing.Size(95, 20);
            this.tbxSuccess.TabIndex = 28;
            // 
            // lblSuccess
            // 
            this.lblSuccess.AutoSize = true;
            this.lblSuccess.Location = new System.Drawing.Point(61, 118);
            this.lblSuccess.Name = "lblSuccess";
            this.lblSuccess.Size = new System.Drawing.Size(51, 13);
            this.lblSuccess.TabIndex = 27;
            this.lblSuccess.Text = "Success:";
            // 
            // btnUpdate
            // 
            this.btnUpdate.Location = new System.Drawing.Point(105, 204);
            this.btnUpdate.Name = "btnUpdate";
            this.btnUpdate.Size = new System.Drawing.Size(75, 23);
            this.btnUpdate.TabIndex = 23;
            this.btnUpdate.Text = "Update";
            this.btnUpdate.UseVisualStyleBackColor = true;
            this.btnUpdate.Click += new System.EventHandler(this.btnUpdate_Click);
            // 
            // tbxPath
            // 
            this.tbxPath.Location = new System.Drawing.Point(132, 34);
            this.tbxPath.Name = "tbxPath";
            this.tbxPath.Size = new System.Drawing.Size(95, 20);
            this.tbxPath.TabIndex = 24;
            // 
            // lblDateDeleted
            // 
            this.lblDateDeleted.AutoSize = true;
            this.lblDateDeleted.Location = new System.Drawing.Point(58, 75);
            this.lblDateDeleted.Name = "lblDateDeleted";
            this.lblDateDeleted.Size = new System.Drawing.Size(73, 13);
            this.lblDateDeleted.TabIndex = 25;
            this.lblDateDeleted.Text = "Date Deleted:";
            // 
            // lblPath
            // 
            this.lblPath.AutoSize = true;
            this.lblPath.Location = new System.Drawing.Point(58, 37);
            this.lblPath.Name = "lblPath";
            this.lblPath.Size = new System.Drawing.Size(32, 13);
            this.lblPath.TabIndex = 22;
            this.lblPath.Text = "Path:";
            // 
            // dtpDateDeleted
            // 
            this.dtpDateDeleted.Location = new System.Drawing.Point(132, 75);
            this.dtpDateDeleted.Name = "dtpDateDeleted";
            this.dtpDateDeleted.Size = new System.Drawing.Size(95, 20);
            this.dtpDateDeleted.TabIndex = 29;
            // 
            // lblStatus
            // 
            this.lblStatus.AutoSize = true;
            this.lblStatus.Location = new System.Drawing.Point(12, 239);
            this.lblStatus.Name = "lblStatus";
            this.lblStatus.Size = new System.Drawing.Size(0, 13);
            this.lblStatus.TabIndex = 30;
            // 
            // erp
            // 
            this.erp.ContainerControl = this;
            // 
            // EditHistoryForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 261);
            this.Controls.Add(this.lblStatus);
            this.Controls.Add(this.dtpDateDeleted);
            this.Controls.Add(this.tbxSuccess);
            this.Controls.Add(this.lblSuccess);
            this.Controls.Add(this.btnUpdate);
            this.Controls.Add(this.tbxPath);
            this.Controls.Add(this.lblDateDeleted);
            this.Controls.Add(this.lblPath);
            this.Name = "EditHistoryForm";
            this.Text = "EditHistoryForm";
            this.Load += new System.EventHandler(this.EditHistoryForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.erp)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.TextBox tbxSuccess;
        private System.Windows.Forms.Label lblSuccess;
        private System.Windows.Forms.Button btnUpdate;
        private System.Windows.Forms.TextBox tbxPath;
        private System.Windows.Forms.Label lblDateDeleted;
        private System.Windows.Forms.Label lblPath;
        private System.Windows.Forms.DateTimePicker dtpDateDeleted;
        private System.Windows.Forms.Label lblStatus;
        private System.Windows.Forms.ErrorProvider erp;
    }
}