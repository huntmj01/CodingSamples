namespace IST_292_Final_Project
{
    partial class frmFolderTerminator
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
            this.mspMain = new System.Windows.Forms.MenuStrip();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.closeToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.viewHistoryToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tbxDirectory = new System.Windows.Forms.TextBox();
            this.btnBrowse = new System.Windows.Forms.Button();
            this.btnTerminate = new System.Windows.Forms.Button();
            this.fbdMain = new System.Windows.Forms.FolderBrowserDialog();
            this.erp = new System.Windows.Forms.ErrorProvider(this.components);
            this.mspMain.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.erp)).BeginInit();
            this.SuspendLayout();
            // 
            // mspMain
            // 
            this.mspMain.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem,
            this.viewHistoryToolStripMenuItem});
            this.mspMain.Location = new System.Drawing.Point(0, 0);
            this.mspMain.Name = "mspMain";
            this.mspMain.Size = new System.Drawing.Size(471, 24);
            this.mspMain.TabIndex = 0;
            this.mspMain.Text = "menuStrip1";
            // 
            // fileToolStripMenuItem
            // 
            this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.closeToolStripMenuItem});
            this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
            this.fileToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
            this.fileToolStripMenuItem.Text = "File";
            // 
            // closeToolStripMenuItem
            // 
            this.closeToolStripMenuItem.Name = "closeToolStripMenuItem";
            this.closeToolStripMenuItem.Size = new System.Drawing.Size(103, 22);
            this.closeToolStripMenuItem.Text = "Close";
            this.closeToolStripMenuItem.Click += new System.EventHandler(this.closeToolStripMenuItem_Click);
            // 
            // viewHistoryToolStripMenuItem
            // 
            this.viewHistoryToolStripMenuItem.Name = "viewHistoryToolStripMenuItem";
            this.viewHistoryToolStripMenuItem.Size = new System.Drawing.Size(85, 20);
            this.viewHistoryToolStripMenuItem.Text = "View History";
            this.viewHistoryToolStripMenuItem.Click += new System.EventHandler(this.viewHistoryToolStripMenuItem_Click);
            // 
            // tbxDirectory
            // 
            this.tbxDirectory.Location = new System.Drawing.Point(35, 102);
            this.tbxDirectory.Name = "tbxDirectory";
            this.tbxDirectory.Size = new System.Drawing.Size(376, 20);
            this.tbxDirectory.TabIndex = 1;
            // 
            // btnBrowse
            // 
            this.btnBrowse.Location = new System.Drawing.Point(151, 132);
            this.btnBrowse.Name = "btnBrowse";
            this.btnBrowse.Size = new System.Drawing.Size(75, 23);
            this.btnBrowse.TabIndex = 2;
            this.btnBrowse.Text = "Browse";
            this.btnBrowse.UseVisualStyleBackColor = true;
            this.btnBrowse.Click += new System.EventHandler(this.btnBrowse_Click);
            // 
            // btnTerminate
            // 
            this.btnTerminate.Location = new System.Drawing.Point(246, 132);
            this.btnTerminate.Name = "btnTerminate";
            this.btnTerminate.Size = new System.Drawing.Size(75, 23);
            this.btnTerminate.TabIndex = 3;
            this.btnTerminate.Text = "Terminate";
            this.btnTerminate.UseVisualStyleBackColor = true;
            this.btnTerminate.Click += new System.EventHandler(this.btnTerminate_Click);
            // 
            // erp
            // 
            this.erp.ContainerControl = this;
            // 
            // frmFolderTerminator
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(471, 244);
            this.Controls.Add(this.btnTerminate);
            this.Controls.Add(this.btnBrowse);
            this.Controls.Add(this.tbxDirectory);
            this.Controls.Add(this.mspMain);
            this.MainMenuStrip = this.mspMain;
            this.Name = "frmFolderTerminator";
            this.Text = "Folder Terminator";
            this.mspMain.ResumeLayout(false);
            this.mspMain.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.erp)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip mspMain;
        private System.Windows.Forms.TextBox tbxDirectory;
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem closeToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem viewHistoryToolStripMenuItem;
        private System.Windows.Forms.Button btnBrowse;
        private System.Windows.Forms.Button btnTerminate;
        private System.Windows.Forms.FolderBrowserDialog fbdMain;
        private System.Windows.Forms.ErrorProvider erp;
    }
}

