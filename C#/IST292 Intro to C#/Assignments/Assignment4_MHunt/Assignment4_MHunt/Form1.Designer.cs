namespace Assignment4_MHunt
{
    partial class frmRockPaperScissors
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
            this.gbxPlayerChoice = new System.Windows.Forms.GroupBox();
            this.rbnScissors = new System.Windows.Forms.RadioButton();
            this.rbnRock = new System.Windows.Forms.RadioButton();
            this.rbnPaper = new System.Windows.Forms.RadioButton();
            this.gbxTotalSummary = new System.Windows.Forms.GroupBox();
            this.tbxTies = new System.Windows.Forms.TextBox();
            this.lblTies = new System.Windows.Forms.Label();
            this.tbxPlayerWins = new System.Windows.Forms.TextBox();
            this.lblComputerWins = new System.Windows.Forms.Label();
            this.tbxComputerWins = new System.Windows.Forms.TextBox();
            this.lblPlayerWins = new System.Windows.Forms.Label();
            this.gbxPercentSummary = new System.Windows.Forms.GroupBox();
            this.tbxTiePercent = new System.Windows.Forms.TextBox();
            this.lblTiePercent = new System.Windows.Forms.Label();
            this.tbxPlayerWinPercentage = new System.Windows.Forms.TextBox();
            this.lblComputerWinPercent = new System.Windows.Forms.Label();
            this.tbxComputerWinPercentage = new System.Windows.Forms.TextBox();
            this.lblPlayerWinPercent = new System.Windows.Forms.Label();
            this.lblComputerChoice = new System.Windows.Forms.Label();
            this.btnPlay = new System.Windows.Forms.Button();
            this.cbxDisplayPercents = new System.Windows.Forms.CheckBox();
            this.cbxDisplayTotals = new System.Windows.Forms.CheckBox();
            this.cbxCheatMode = new System.Windows.Forms.CheckBox();
            this.btnExit = new System.Windows.Forms.Button();
            this.btnReset = new System.Windows.Forms.Button();
            this.tbxComputerChoice = new System.Windows.Forms.TextBox();
            this.tbxRoundSummary = new System.Windows.Forms.TextBox();
            this.gbxPlayerChoice.SuspendLayout();
            this.gbxTotalSummary.SuspendLayout();
            this.gbxPercentSummary.SuspendLayout();
            this.SuspendLayout();
            // 
            // gbxPlayerChoice
            // 
            this.gbxPlayerChoice.Controls.Add(this.rbnScissors);
            this.gbxPlayerChoice.Controls.Add(this.rbnRock);
            this.gbxPlayerChoice.Controls.Add(this.rbnPaper);
            this.gbxPlayerChoice.Location = new System.Drawing.Point(37, 12);
            this.gbxPlayerChoice.Name = "gbxPlayerChoice";
            this.gbxPlayerChoice.Size = new System.Drawing.Size(99, 93);
            this.gbxPlayerChoice.TabIndex = 0;
            this.gbxPlayerChoice.TabStop = false;
            this.gbxPlayerChoice.Text = "Player Choice";
            // 
            // rbnScissors
            // 
            this.rbnScissors.AutoSize = true;
            this.rbnScissors.Location = new System.Drawing.Point(6, 65);
            this.rbnScissors.Name = "rbnScissors";
            this.rbnScissors.Size = new System.Drawing.Size(64, 17);
            this.rbnScissors.TabIndex = 3;
            this.rbnScissors.TabStop = true;
            this.rbnScissors.Text = "Scissors";
            this.rbnScissors.UseVisualStyleBackColor = true;
            // 
            // rbnRock
            // 
            this.rbnRock.AutoSize = true;
            this.rbnRock.Location = new System.Drawing.Point(6, 19);
            this.rbnRock.Name = "rbnRock";
            this.rbnRock.Size = new System.Drawing.Size(51, 17);
            this.rbnRock.TabIndex = 1;
            this.rbnRock.TabStop = true;
            this.rbnRock.Text = "Rock";
            this.rbnRock.UseVisualStyleBackColor = true;
            // 
            // rbnPaper
            // 
            this.rbnPaper.AutoSize = true;
            this.rbnPaper.Location = new System.Drawing.Point(6, 42);
            this.rbnPaper.Name = "rbnPaper";
            this.rbnPaper.Size = new System.Drawing.Size(53, 17);
            this.rbnPaper.TabIndex = 2;
            this.rbnPaper.TabStop = true;
            this.rbnPaper.Text = "Paper";
            this.rbnPaper.UseVisualStyleBackColor = true;
            // 
            // gbxTotalSummary
            // 
            this.gbxTotalSummary.Controls.Add(this.tbxTies);
            this.gbxTotalSummary.Controls.Add(this.lblTies);
            this.gbxTotalSummary.Controls.Add(this.tbxPlayerWins);
            this.gbxTotalSummary.Controls.Add(this.lblComputerWins);
            this.gbxTotalSummary.Controls.Add(this.tbxComputerWins);
            this.gbxTotalSummary.Controls.Add(this.lblPlayerWins);
            this.gbxTotalSummary.Location = new System.Drawing.Point(12, 212);
            this.gbxTotalSummary.Name = "gbxTotalSummary";
            this.gbxTotalSummary.Size = new System.Drawing.Size(279, 86);
            this.gbxTotalSummary.TabIndex = 1;
            this.gbxTotalSummary.TabStop = false;
            this.gbxTotalSummary.Text = "Total Summary";
            // 
            // tbxTies
            // 
            this.tbxTies.Enabled = false;
            this.tbxTies.Location = new System.Drawing.Point(195, 43);
            this.tbxTies.Name = "tbxTies";
            this.tbxTies.Size = new System.Drawing.Size(77, 20);
            this.tbxTies.TabIndex = 14;
            this.tbxTies.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // lblTies
            // 
            this.lblTies.AutoSize = true;
            this.lblTies.Location = new System.Drawing.Point(192, 27);
            this.lblTies.Name = "lblTies";
            this.lblTies.Size = new System.Drawing.Size(27, 13);
            this.lblTies.TabIndex = 14;
            this.lblTies.Text = "Ties";
            // 
            // tbxPlayerWins
            // 
            this.tbxPlayerWins.Enabled = false;
            this.tbxPlayerWins.Location = new System.Drawing.Point(6, 43);
            this.tbxPlayerWins.Name = "tbxPlayerWins";
            this.tbxPlayerWins.Size = new System.Drawing.Size(77, 20);
            this.tbxPlayerWins.TabIndex = 13;
            this.tbxPlayerWins.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // lblComputerWins
            // 
            this.lblComputerWins.AutoSize = true;
            this.lblComputerWins.Location = new System.Drawing.Point(100, 27);
            this.lblComputerWins.Name = "lblComputerWins";
            this.lblComputerWins.Size = new System.Drawing.Size(79, 13);
            this.lblComputerWins.TabIndex = 13;
            this.lblComputerWins.Text = "Computer Wins";
            // 
            // tbxComputerWins
            // 
            this.tbxComputerWins.Enabled = false;
            this.tbxComputerWins.Location = new System.Drawing.Point(102, 43);
            this.tbxComputerWins.Name = "tbxComputerWins";
            this.tbxComputerWins.Size = new System.Drawing.Size(77, 20);
            this.tbxComputerWins.TabIndex = 12;
            this.tbxComputerWins.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // lblPlayerWins
            // 
            this.lblPlayerWins.AutoSize = true;
            this.lblPlayerWins.Location = new System.Drawing.Point(6, 27);
            this.lblPlayerWins.Name = "lblPlayerWins";
            this.lblPlayerWins.Size = new System.Drawing.Size(63, 13);
            this.lblPlayerWins.TabIndex = 12;
            this.lblPlayerWins.Text = "Player Wins";
            // 
            // gbxPercentSummary
            // 
            this.gbxPercentSummary.Controls.Add(this.tbxTiePercent);
            this.gbxPercentSummary.Controls.Add(this.lblTiePercent);
            this.gbxPercentSummary.Controls.Add(this.tbxPlayerWinPercentage);
            this.gbxPercentSummary.Controls.Add(this.lblComputerWinPercent);
            this.gbxPercentSummary.Controls.Add(this.tbxComputerWinPercentage);
            this.gbxPercentSummary.Controls.Add(this.lblPlayerWinPercent);
            this.gbxPercentSummary.Location = new System.Drawing.Point(11, 304);
            this.gbxPercentSummary.Name = "gbxPercentSummary";
            this.gbxPercentSummary.Size = new System.Drawing.Size(279, 87);
            this.gbxPercentSummary.TabIndex = 2;
            this.gbxPercentSummary.TabStop = false;
            this.gbxPercentSummary.Text = "Percent Summary";
            // 
            // tbxTiePercent
            // 
            this.tbxTiePercent.Enabled = false;
            this.tbxTiePercent.Location = new System.Drawing.Point(195, 48);
            this.tbxTiePercent.Name = "tbxTiePercent";
            this.tbxTiePercent.Size = new System.Drawing.Size(77, 20);
            this.tbxTiePercent.TabIndex = 19;
            this.tbxTiePercent.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // lblTiePercent
            // 
            this.lblTiePercent.AutoSize = true;
            this.lblTiePercent.Location = new System.Drawing.Point(192, 32);
            this.lblTiePercent.Name = "lblTiePercent";
            this.lblTiePercent.Size = new System.Drawing.Size(33, 13);
            this.lblTiePercent.TabIndex = 20;
            this.lblTiePercent.Text = "Tie %";
            // 
            // tbxPlayerWinPercentage
            // 
            this.tbxPlayerWinPercentage.Enabled = false;
            this.tbxPlayerWinPercentage.Location = new System.Drawing.Point(6, 48);
            this.tbxPlayerWinPercentage.Name = "tbxPlayerWinPercentage";
            this.tbxPlayerWinPercentage.Size = new System.Drawing.Size(77, 20);
            this.tbxPlayerWinPercentage.TabIndex = 17;
            this.tbxPlayerWinPercentage.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // lblComputerWinPercent
            // 
            this.lblComputerWinPercent.AutoSize = true;
            this.lblComputerWinPercent.Location = new System.Drawing.Point(100, 32);
            this.lblComputerWinPercent.Name = "lblComputerWinPercent";
            this.lblComputerWinPercent.Size = new System.Drawing.Size(85, 13);
            this.lblComputerWinPercent.TabIndex = 18;
            this.lblComputerWinPercent.Text = "Computer Win %";
            // 
            // tbxComputerWinPercentage
            // 
            this.tbxComputerWinPercentage.Enabled = false;
            this.tbxComputerWinPercentage.Location = new System.Drawing.Point(102, 48);
            this.tbxComputerWinPercentage.Name = "tbxComputerWinPercentage";
            this.tbxComputerWinPercentage.Size = new System.Drawing.Size(77, 20);
            this.tbxComputerWinPercentage.TabIndex = 15;
            this.tbxComputerWinPercentage.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // lblPlayerWinPercent
            // 
            this.lblPlayerWinPercent.AutoSize = true;
            this.lblPlayerWinPercent.Location = new System.Drawing.Point(6, 32);
            this.lblPlayerWinPercent.Name = "lblPlayerWinPercent";
            this.lblPlayerWinPercent.Size = new System.Drawing.Size(69, 13);
            this.lblPlayerWinPercent.TabIndex = 16;
            this.lblPlayerWinPercent.Text = "Player Win %";
            // 
            // lblComputerChoice
            // 
            this.lblComputerChoice.AutoSize = true;
            this.lblComputerChoice.Location = new System.Drawing.Point(170, 12);
            this.lblComputerChoice.Name = "lblComputerChoice";
            this.lblComputerChoice.Size = new System.Drawing.Size(88, 13);
            this.lblComputerChoice.TabIndex = 3;
            this.lblComputerChoice.Text = "Computer Choice";
            // 
            // btnPlay
            // 
            this.btnPlay.Location = new System.Drawing.Point(173, 71);
            this.btnPlay.Name = "btnPlay";
            this.btnPlay.Size = new System.Drawing.Size(75, 23);
            this.btnPlay.TabIndex = 5;
            this.btnPlay.Text = "Play";
            this.btnPlay.UseVisualStyleBackColor = true;
            this.btnPlay.Click += new System.EventHandler(this.btnPlay_Click);
            // 
            // cbxDisplayPercents
            // 
            this.cbxDisplayPercents.AutoSize = true;
            this.cbxDisplayPercents.Location = new System.Drawing.Point(13, 128);
            this.cbxDisplayPercents.Name = "cbxDisplayPercents";
            this.cbxDisplayPercents.Size = new System.Drawing.Size(105, 17);
            this.cbxDisplayPercents.TabIndex = 6;
            this.cbxDisplayPercents.Text = "Display Percents";
            this.cbxDisplayPercents.UseVisualStyleBackColor = true;
            this.cbxDisplayPercents.CheckedChanged += new System.EventHandler(this.cbxDisplayPercents_CheckedChanged);
            // 
            // cbxDisplayTotals
            // 
            this.cbxDisplayTotals.AutoSize = true;
            this.cbxDisplayTotals.Location = new System.Drawing.Point(116, 128);
            this.cbxDisplayTotals.Name = "cbxDisplayTotals";
            this.cbxDisplayTotals.Size = new System.Drawing.Size(92, 17);
            this.cbxDisplayTotals.TabIndex = 7;
            this.cbxDisplayTotals.Text = "Display Totals";
            this.cbxDisplayTotals.UseVisualStyleBackColor = true;
            this.cbxDisplayTotals.CheckedChanged += new System.EventHandler(this.cbxDisplayTotals_CheckedChanged);
            // 
            // cbxCheatMode
            // 
            this.cbxCheatMode.AutoSize = true;
            this.cbxCheatMode.Location = new System.Drawing.Point(208, 128);
            this.cbxCheatMode.Name = "cbxCheatMode";
            this.cbxCheatMode.Size = new System.Drawing.Size(84, 17);
            this.cbxCheatMode.TabIndex = 8;
            this.cbxCheatMode.Text = "Cheat Mode";
            this.cbxCheatMode.UseVisualStyleBackColor = true;
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(156, 157);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(75, 23);
            this.btnExit.TabIndex = 10;
            this.btnExit.Text = "Exit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // btnReset
            // 
            this.btnReset.Location = new System.Drawing.Point(60, 157);
            this.btnReset.Name = "btnReset";
            this.btnReset.Size = new System.Drawing.Size(75, 23);
            this.btnReset.TabIndex = 9;
            this.btnReset.Text = "Reset";
            this.btnReset.UseVisualStyleBackColor = true;
            this.btnReset.Click += new System.EventHandler(this.btnReset_Click);
            // 
            // tbxComputerChoice
            // 
            this.tbxComputerChoice.Enabled = false;
            this.tbxComputerChoice.Location = new System.Drawing.Point(163, 28);
            this.tbxComputerChoice.Name = "tbxComputerChoice";
            this.tbxComputerChoice.Size = new System.Drawing.Size(100, 20);
            this.tbxComputerChoice.TabIndex = 4;
            this.tbxComputerChoice.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // tbxRoundSummary
            // 
            this.tbxRoundSummary.Enabled = false;
            this.tbxRoundSummary.Location = new System.Drawing.Point(11, 186);
            this.tbxRoundSummary.Name = "tbxRoundSummary";
            this.tbxRoundSummary.Size = new System.Drawing.Size(280, 20);
            this.tbxRoundSummary.TabIndex = 11;
            this.tbxRoundSummary.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // frmRockPaperScissors
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(301, 406);
            this.Controls.Add(this.tbxRoundSummary);
            this.Controls.Add(this.tbxComputerChoice);
            this.Controls.Add(this.btnReset);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.cbxCheatMode);
            this.Controls.Add(this.cbxDisplayTotals);
            this.Controls.Add(this.cbxDisplayPercents);
            this.Controls.Add(this.btnPlay);
            this.Controls.Add(this.lblComputerChoice);
            this.Controls.Add(this.gbxPercentSummary);
            this.Controls.Add(this.gbxTotalSummary);
            this.Controls.Add(this.gbxPlayerChoice);
            this.Name = "frmRockPaperScissors";
            this.Text = "Rock-Paper-Scissors";
            this.Load += new System.EventHandler(this.frmRockPaperScissors_Load);
            this.gbxPlayerChoice.ResumeLayout(false);
            this.gbxPlayerChoice.PerformLayout();
            this.gbxTotalSummary.ResumeLayout(false);
            this.gbxTotalSummary.PerformLayout();
            this.gbxPercentSummary.ResumeLayout(false);
            this.gbxPercentSummary.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox gbxPlayerChoice;
        private System.Windows.Forms.GroupBox gbxTotalSummary;
        private System.Windows.Forms.RadioButton rbnScissors;
        private System.Windows.Forms.RadioButton rbnRock;
        private System.Windows.Forms.RadioButton rbnPaper;
        private System.Windows.Forms.GroupBox gbxPercentSummary;
        private System.Windows.Forms.Label lblComputerChoice;
        private System.Windows.Forms.Button btnPlay;
        private System.Windows.Forms.CheckBox cbxDisplayPercents;
        private System.Windows.Forms.CheckBox cbxDisplayTotals;
        private System.Windows.Forms.CheckBox cbxCheatMode;
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.Button btnReset;
        private System.Windows.Forms.TextBox tbxComputerChoice;
        private System.Windows.Forms.TextBox tbxRoundSummary;
        private System.Windows.Forms.Label lblTies;
        private System.Windows.Forms.Label lblComputerWins;
        private System.Windows.Forms.Label lblPlayerWins;
        private System.Windows.Forms.TextBox tbxTies;
        private System.Windows.Forms.TextBox tbxPlayerWins;
        private System.Windows.Forms.TextBox tbxComputerWins;
        private System.Windows.Forms.TextBox tbxTiePercent;
        private System.Windows.Forms.Label lblTiePercent;
        private System.Windows.Forms.TextBox tbxPlayerWinPercentage;
        private System.Windows.Forms.Label lblComputerWinPercent;
        private System.Windows.Forms.TextBox tbxComputerWinPercentage;
        private System.Windows.Forms.Label lblPlayerWinPercent;
    }
}

