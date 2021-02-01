using System;
using System.Windows.Forms;
using System.IO;

/* 
 * Name: Matthew Hunt
 * Project: Assignment 5
 * Date: 09/16/17
 * Purpose: Allows the user to play a game of guessing.
 */
namespace Program5_11
{
    public partial class Form1 : Form
    {
        // global variables
        private int numberToGuess;
        private int attemptNumber;
        private int numberOfGamesPlayed;
        private double averageNumberOfAttemptsTaken;
        private int sumOfAllAttempts;

        /// <summary>
        /// constructor 
        /// </summary>
        public Form1()
        {
            InitializeComponent();
        }

        /// <summary>
        /// on form load
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void Form1_Load(object sender, EventArgs e)
        {
            StreamReader inputFile = null;

            try
            {
                
                inputFile = File.OpenText("attempts.txt");

                int howManyValuesThereAre = 0;
                int totalAttempts = 0;

                // read the file
                while (!inputFile.EndOfStream)
                {
                    howManyValuesThereAre++;
                    totalAttempts += int.Parse(inputFile.ReadLine());
                }

                averageNumberOfAttemptsTaken = (totalAttempts + 0.0) / howManyValuesThereAre;

            }
            catch (DivideByZeroException dbze)
            {
                lblStatus.Text = @"Can't divide by zero.";
            }
            catch (FileNotFoundException fnfe)
            {
                numberOfGamesPlayed = 0;
                averageNumberOfAttemptsTaken = 0;
                lblStatus.Text = @"attempts.txt not found.";
            }
            catch (Exception ex)
            {
                lblStatus.Text = ex.ToString();
            }
            finally
            {
                inputFile.Close();
            }
        

        // display the number of games played and average attempts for games played
            lblGamesPlayed.Text = "" + numberOfGamesPlayed;
            lblGuesses.Text = "" + averageNumberOfAttemptsTaken;

            // generate a random number that the user will be attempting to guess
            Random rand = new Random();
            numberToGuess = rand.Next(100);

        }

        /// <summary>
        /// user clicks the guess button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnGuess_Click(object sender, EventArgs e)
        {
            int guess = -1;

            if (int.TryParse(txtNumber.Text, out guess) && (guess > 0 && guess < 101))
            {
                // display number of attempts and last guess in output
                attemptNumber++;
                lblOutput.Text = @"Attempt: " + attemptNumber + "\nLast Guess: " + guess;
                
                // tell user if user is to high or to low
                if (guess < numberToGuess)
                {
                    lblOutput.Text += "\nYour guess is to low.";
                }
                else if (guess > numberToGuess)
                {
                    lblOutput.Text += "\nYour guess is to high.";
                }

                // clear out the text box and set focus to the text box
                txtNumber.Text = string.Empty;
                txtNumber.Focus();

                // if user guesses correctly
                if (guess == numberToGuess)
                {
                    // display new amount of games played, recalculate average
                    // number of attempts, enable the save button
                    numberOfGamesPlayed++;
                    lblGamesPlayed.Text = "" + numberOfGamesPlayed; 
                    sumOfAllAttempts += attemptNumber;
                    averageNumberOfAttemptsTaken = sumOfAllAttempts / (numberOfGamesPlayed + 0.0);
                    lblGuesses.Text = averageNumberOfAttemptsTaken + "";
                    btnSave.Enabled = true;
                }
            }
            else
            {
                errorProvider1.SetError(txtNumber, "Must be a number between 1 and 100.");
            }

        }

        /// <summary>
        /// user clicks the new game button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnNewGame_Click(object sender, EventArgs e)
        {
            // generate a new random number
            Random rand = new Random();
            numberToGuess = rand.Next(100);
            
            // clear the output label
            lblOutput.Text = string.Empty;

            // unenable the save button
            btnSave.Enabled = false;
        }

        /// <summary>
        /// user clicks save button
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnSave_Click(object sender, EventArgs e)
        {
            StreamWriter outputFile = null;

            try
            {
                // write number of attempts to the file
                outputFile = File.AppendText("attempts.txt");
                outputFile.WriteLine(attemptNumber);
            }
            catch (Exception ex)
            {
                lblStatus.Text = ex.ToString();
            }
            finally
            {
                // close the sream writer
                outputFile.Close();
            }
        }
    }
}
