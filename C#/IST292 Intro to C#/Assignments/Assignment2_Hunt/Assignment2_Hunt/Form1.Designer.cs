namespace Assignment2_Hunt
{
    partial class frmAssignment2
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
            this.pbxImg1 = new System.Windows.Forms.PictureBox();
            this.backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            this.pbxImg5 = new System.Windows.Forms.PictureBox();
            this.pbxImg4 = new System.Windows.Forms.PictureBox();
            this.pbxImg3 = new System.Windows.Forms.PictureBox();
            this.pbxImg2 = new System.Windows.Forms.PictureBox();
            this.btnHide = new System.Windows.Forms.Button();
            this.btnClear = new System.Windows.Forms.Button();
            this.btnShow = new System.Windows.Forms.Button();
            this.lblPet = new System.Windows.Forms.Label();
            this.btnExit = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.pbxImg1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxImg5)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxImg4)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxImg3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxImg2)).BeginInit();
            this.SuspendLayout();
            // 
            // pbxImg1
            // 
            this.pbxImg1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.pbxImg1.Image = global::Assignment2_Hunt.Properties.Resources.img1;
            this.pbxImg1.Location = new System.Drawing.Point(12, 24);
            this.pbxImg1.Name = "pbxImg1";
            this.pbxImg1.Size = new System.Drawing.Size(127, 82);
            this.pbxImg1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbxImg1.TabIndex = 0;
            this.pbxImg1.TabStop = false;
            this.pbxImg1.Click += new System.EventHandler(this.pbxImg1_Click);
            // 
            // pbxImg5
            // 
            this.pbxImg5.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.pbxImg5.Image = global::Assignment2_Hunt.Properties.Resources.img5;
            this.pbxImg5.Location = new System.Drawing.Point(544, 24);
            this.pbxImg5.Name = "pbxImg5";
            this.pbxImg5.Size = new System.Drawing.Size(127, 82);
            this.pbxImg5.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbxImg5.TabIndex = 1;
            this.pbxImg5.TabStop = false;
            this.pbxImg5.Click += new System.EventHandler(this.pbxImg5_Click);
            // 
            // pbxImg4
            // 
            this.pbxImg4.Image = global::Assignment2_Hunt.Properties.Resources.img4;
            this.pbxImg4.Location = new System.Drawing.Point(411, 24);
            this.pbxImg4.Name = "pbxImg4";
            this.pbxImg4.Size = new System.Drawing.Size(127, 82);
            this.pbxImg4.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbxImg4.TabIndex = 2;
            this.pbxImg4.TabStop = false;
            this.pbxImg4.Click += new System.EventHandler(this.pbxImg4_Click);
            // 
            // pbxImg3
            // 
            this.pbxImg3.Image = global::Assignment2_Hunt.Properties.Resources.img3;
            this.pbxImg3.Location = new System.Drawing.Point(278, 24);
            this.pbxImg3.Name = "pbxImg3";
            this.pbxImg3.Size = new System.Drawing.Size(127, 82);
            this.pbxImg3.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbxImg3.TabIndex = 3;
            this.pbxImg3.TabStop = false;
            this.pbxImg3.Click += new System.EventHandler(this.pbxImg3_Click);
            // 
            // pbxImg2
            // 
            this.pbxImg2.Image = global::Assignment2_Hunt.Properties.Resources.img2;
            this.pbxImg2.Location = new System.Drawing.Point(145, 24);
            this.pbxImg2.Name = "pbxImg2";
            this.pbxImg2.Size = new System.Drawing.Size(127, 82);
            this.pbxImg2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbxImg2.TabIndex = 4;
            this.pbxImg2.TabStop = false;
            this.pbxImg2.Click += new System.EventHandler(this.pbxImg2_Click);
            // 
            // btnHide
            // 
            this.btnHide.Location = new System.Drawing.Point(142, 183);
            this.btnHide.Name = "btnHide";
            this.btnHide.Size = new System.Drawing.Size(192, 23);
            this.btnHide.TabIndex = 5;
            this.btnHide.Text = "Hide";
            this.btnHide.UseVisualStyleBackColor = true;
            this.btnHide.Click += new System.EventHandler(this.btnHide_Click);
            // 
            // btnClear
            // 
            this.btnClear.Location = new System.Drawing.Point(142, 212);
            this.btnClear.Name = "btnClear";
            this.btnClear.Size = new System.Drawing.Size(192, 23);
            this.btnClear.TabIndex = 6;
            this.btnClear.Text = "Clear";
            this.btnClear.UseVisualStyleBackColor = true;
            this.btnClear.Click += new System.EventHandler(this.btnClear_Click);
            // 
            // btnShow
            // 
            this.btnShow.Location = new System.Drawing.Point(346, 183);
            this.btnShow.Name = "btnShow";
            this.btnShow.Size = new System.Drawing.Size(192, 23);
            this.btnShow.TabIndex = 7;
            this.btnShow.Text = "Show";
            this.btnShow.UseVisualStyleBackColor = true;
            this.btnShow.Click += new System.EventHandler(this.btnShow_Click);
            // 
            // lblPet
            // 
            this.lblPet.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.lblPet.Location = new System.Drawing.Point(142, 136);
            this.lblPet.Name = "lblPet";
            this.lblPet.Size = new System.Drawing.Size(396, 23);
            this.lblPet.TabIndex = 8;
            this.lblPet.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(346, 212);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(192, 23);
            this.btnExit.TabIndex = 9;
            this.btnExit.Text = "Exit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // frmAssignment2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(689, 258);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.lblPet);
            this.Controls.Add(this.btnShow);
            this.Controls.Add(this.btnClear);
            this.Controls.Add(this.btnHide);
            this.Controls.Add(this.pbxImg2);
            this.Controls.Add(this.pbxImg3);
            this.Controls.Add(this.pbxImg4);
            this.Controls.Add(this.pbxImg5);
            this.Controls.Add(this.pbxImg1);
            this.Name = "frmAssignment2";
            this.Text = "Pet Identifier";
            ((System.ComponentModel.ISupportInitialize)(this.pbxImg1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxImg5)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxImg4)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxImg3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbxImg2)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox pbxImg1;
        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private System.Windows.Forms.PictureBox pbxImg5;
        private System.Windows.Forms.PictureBox pbxImg4;
        private System.Windows.Forms.PictureBox pbxImg3;
        private System.Windows.Forms.PictureBox pbxImg2;
        private System.Windows.Forms.Button btnHide;
        private System.Windows.Forms.Button btnClear;
        private System.Windows.Forms.Button btnShow;
        private System.Windows.Forms.Label lblPet;
        private System.Windows.Forms.Button btnExit;
    }
}

