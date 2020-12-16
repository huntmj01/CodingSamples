using System;
using System.Windows.Forms;

/* 
 * Name: Matthew Hunt
 * Project: Assignment 4
 * Date: 09/07/17
 * Purpose: Allows the user to play a game of Roshambo.
 */
namespace Assignment4_MHunt
{
    public partial class frmRockPaperScissors : Form
    {
        // global variables
        private int playerWins = 0; // holds the amount of wins awarded to the player

        private int computerWins = 0; // holds the amount of wins awarded to the computer
        private int ties = 0; // holds the amount of ties
        private int roundCount = 0; // holds the amount of rounds

        private const int ROCK = 0; // holds value for rock
        private const int PAPER = 1; // holds value for paper
        private const int SCISSORS = 2; // holds value for scissors

        private const double CHEAT_PERCENTAGE = 1.0 / 3.0; // 33.3333% 

        /// <summary>
        /// constructor
        /// </summary>
        public frmRockPaperScissors()
        {
            InitializeComponent();
        }

        /// <summary>
        /// on form load
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void frmRockPaperScissors_Load(object sender, EventArgs e)
        {
            // select the default radio button and hide the bottom group boxes 
            rbnRock.Checked = true;
            gbxPercentSummary.Visible = false;
            gbxTotalSummary.Visible = false;
        }

        /// <summary>
        /// user clicks the play button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnPlay_Click(object sender, EventArgs e)
        {
            Play();
        }

        /// <summary>
        /// user unchecks/checks the display percents checkbox
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void cbxDisplayPercents_CheckedChanged(object sender, EventArgs e)
        {
            // set the percent summary group box visibility to display percents checked property
            gbxPercentSummary.Visible = cbxDisplayPercents.Checked;
        }

        /// <summary>
        /// user unchecks/checks the display totals checkbox
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void cbxDisplayTotals_CheckedChanged(object sender, EventArgs e)
        {
            // set the total summary group box visibility to display totals checked property
            gbxTotalSummary.Visible = cbxDisplayTotals.Checked;
        }

        /// <summary>
        /// user clicks the reset button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnReset_Click(object sender, EventArgs e)
        {
            // clear the form
            tbxComputerChoice.Text = string.Empty;
            tbxRoundSummary.Text = string.Empty;
            tbxPlayerWins.Text = string.Empty;
            tbxComputerWins.Text = string.Empty;
            tbxTies.Text = string.Empty;
            tbxPlayerWinPercentage.Text = string.Empty;
            tbxComputerWinPercentage.Text = string.Empty;
            tbxTiePercent.Text = string.Empty;

            // reset focus to the radio button
            rbnRock.Checked = true;
            rbnRock.Focus();

            // reset global variables
            playerWins = 0;
            computerWins = 0;
            ties = 0;
            roundCount = 0;

            // uncheck cheat mode
            cbxCheatMode.Checked = false;
        }

        /// <summary>
        /// user clicks the exit button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnExit_Click(object sender, EventArgs e)
        {
            // exit the application
            Close();
        }

        /// <summary>
        /// play a round of roshambo
        /// </summary>
        private void Play()
        {
            // local variables
            int playerChoice = 0;
            int computerChoice = 0;
            Random rand = new Random();

            // update the round counter
            roundCount++;

            // convert player choice to an int
            if (rbnRock.Checked)
            {
                playerChoice = ROCK;
            }
            else if (rbnPaper.Checked)
            {
                playerChoice = PAPER;
            }
            else if (rbnScissors.Checked)
            {
                playerChoice = SCISSORS;
            }

            // use random variable to determine computer choice
            computerChoice = rand.Next(3);

            // use a switch structure to display the computer's choice
            switch (computerChoice)
            {
                case ROCK:
                    tbxComputerChoice.Text = @"Rock";
                    break;
                case PAPER:
                    tbxComputerChoice.Text = @"Paper";
                    break;
                case SCISSORS:
                    tbxComputerChoice.Text = @"Scissors";
                    break;
            }

            // check if cheat mode is enabled
            if (cbxCheatMode.Checked)
            {
                // generate random between 0.0 and 1.0 and see if it is under the cheat percentage
                // this if will only be true 1/3 of the time
                if (rand.NextDouble() < CHEAT_PERCENTAGE)
                {
                    switch (computerChoice)
                    {
                        // set the players choice to the winning choice
                        case ROCK:
                            playerChoice = PAPER;
                            rbnPaper.Checked = true;
                            break;
                        case PAPER:
                            playerChoice = SCISSORS;
                            rbnScissors.Checked = true;
                            break;
                        case SCISSORS:
                            playerChoice = ROCK;
                            rbnRock.Checked = true;
                            break;
                    }
                }
            }

            // determine round winner
            if (playerChoice == ROCK && computerChoice == PAPER)
            {
                computerWins++;
                tbxRoundSummary.Text = @"Paper beats rock... you lose!";
            }
            else if (playerChoice == ROCK && computerChoice == SCISSORS)
            {
                playerWins++;
                tbxRoundSummary.Text = @"Rock beats scissors... you win!";
            }
            else if (playerChoice == PAPER && computerChoice == ROCK)
            {
                playerWins++;
                tbxRoundSummary.Text = @"Paper beats rock... you win!";
            }
            else if (playerChoice == PAPER && computerChoice == SCISSORS)
            {
                computerWins++;
                tbxRoundSummary.Text = @"Scissors beats paper... you lose!";
            }
            else if (playerChoice == SCISSORS && computerChoice == ROCK)
            {
                computerWins++;
                tbxRoundSummary.Text = @"Rock beats scissors... you lose!";
            }
            else if (playerChoice == SCISSORS && computerChoice == PAPER)
            {
                playerWins++;
                tbxRoundSummary.Text = @"Scissors beats paper... you win!";
            }
            else
            {
                ties++;
                tbxRoundSummary.Text = @"No winner.";
            }

            // display totals
            tbxPlayerWins.Text = playerWins.ToString();
            tbxComputerWins.Text = computerWins.ToString();
            tbxTies.Text = ties.ToString();

            // display percentages
            tbxComputerWinPercentage.Text = (computerWins / (roundCount + 1.0) * 100).ToString("N2") + @"%";
            tbxPlayerWinPercentage.Text = (playerWins / (roundCount + 1.0) * 100).ToString("N2") + @"%";
            tbxTiePercent.Text = (ties / (roundCount + 1.0) * 100).ToString("N2") + @"%";
        }
    }
}
