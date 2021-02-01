using System;
using System.Collections.Generic;
using System.IO;
using System.Windows.Forms;


/* 
 * Name: Matthew Hunt
 * Project: Assignment 8
 * Date: 10/18/2017
 * Purpose: Allows a user to register and enter the system.
 */

namespace Login_Registration
{

    public partial class Form1 : Form
    {

        // Declare a structure, Account, that has name and password field
        public struct Account
        {
            public string name;
            public string password;
        }

        // Declare a List of type Account that will be used to store registered accounts
        List<Account> accounts = new List<Account>();

        private const string FILENAME = "accounts.txt";

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, System.EventArgs e)
        {
            StreamReader inputFile;
            inputFile = File.OpenText(FILENAME);

            // reads the text file. As the text file is read, Account objects are created and 
            // added to the List

            string line;
            while ((line = inputFile.ReadLine()) != null)
            {
                var fields = line.Split(',');
                Account account = new Account();
                account.name = fields[0];
                account.password = fields[1];
                accounts.Add(account);
            }

            // close the connection
            inputFile.Close();

        }

        private void btnRegister_Click(object sender, System.EventArgs e)
        {
            // The Registration procedure adds a new account to the list

            // The text boxes are validated to ensure that 
            // they contain text.
            bool containsText = !(txtRegisterName.Text == String.Empty || txtRegisterPassword.Text == String.Empty || txtConfirmPassword.Text == String.Empty);

            // The password must include at least 8 characters, an upper case letter, a lower case 
            // letter, a digit, and a punctuation symbol.
            bool passwordHas8Chars = txtRegisterPassword.Text.Length >= 8;
            bool atLeast1Upper = NumberUpperCase(txtRegisterPassword.Text) > 0;
            bool atLeast1Lower = NumberLowerCase(txtRegisterPassword.Text) > 0;
            bool atLeast1Digit = NumberDigits(txtRegisterPassword.Text) > 0;
            bool atLeast1Punctuation = NumberPunctuation(txtRegisterPassword.Text) > 0;

            // The password must be confirmed with the second text box
            bool passwordsAreTheSame = txtRegisterPassword.Text == txtConfirmPassword.Text;

            // Neither the name nor password can contain a comma symbol 
            bool nameContainsComma = txtRegisterName.Text.Contains(",");
            bool passwordContainsComma = txtRegisterPassword.Text.Contains(",");

            // Duplicate user names cannot be added to the list.
            bool nameAlreadyExists = false;

            foreach (Account ac in accounts)
            {
                if (ac.name == txtLoginName.Text)
                {
                    nameAlreadyExists = true;
                }
            }


            // check to make sure fields are valid
            string errMsg = "";

            if (!containsText)
            {
                errMsg += " Register fields may not be empty.";
            }

            if (!(passwordHas8Chars && atLeast1Upper && atLeast1Lower && atLeast1Digit && atLeast1Punctuation))
            {
                errMsg += " Password must have at least 8 chars, 1 upper case letter, 1 lower case letter, 1 digit, and 1 punctuation.";
            }

            if (!passwordsAreTheSame)
            {
                errMsg += " Passwords do not match";
            }

            if (nameContainsComma || passwordContainsComma)
            {
                errMsg += " Name and password can not contain comma.";
            }

            if (nameAlreadyExists)
            {
                errMsg += " Name already exists.";
            }

            if (errMsg != string.Empty)
            {
                MessageBox.Show(errMsg);
            }
            else
            {
                // Create an Account object using the entered text
                Account account = new Account();

                account.name = txtRegisterName.Text;
                account.password = txtRegisterPassword.Text;
                accounts.Add(account);

                lblStatus.Text = @"Account added successfully!";

                // write to file
                StreamWriter outputFile;
                outputFile = File.AppendText(FILENAME);
                outputFile.WriteLine(account.name + "," + account.password);
                outputFile.Close();
                
            }
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {

            string userName = "";

            // The text boxes are validated to ensure that they contain text.
            if (txtLoginName.Text == String.Empty || txtLoginPassword.Text == String.Empty)
            {
                MessageBox.Show(@"User and Login fields can not be empty.");
            }


            // The login procedure determines whether the user name and password match an account in the List. 
            foreach (Account acc in accounts)
            {
                if (acc.name == txtLoginName.Text && acc.password == txtLoginPassword.Text)
                {
                    userName = acc.name;
                }
            }

            // check if a user was found
            if (userName != string.Empty)
            {
                MessageBox.Show(@"Welcome to the system, " + userName);
            }
            else
            {
                MessageBox.Show(@"Username and/or password invalid.");
            }
        }

        /// 
        /// HELPER METHODS
        /// 

        // The NumberUpperCase method accepts a string argument
        // and returns the number of uppercase letters it contains.
        private int NumberUpperCase(string str)
        {
            int upperCase = 0;  // The number of uppercase letters

            // Count the uppercase characters in str.
            foreach (char ch in str)
            {
                if (char.IsUpper(ch))
                {
                    upperCase++;
                }
            }

            // Return the number of uppercase characters.
            return upperCase;
        }

        // The NumberLowerCase method accepts a string argument
        // and returns the number of lowercase letters it contains.
        private int NumberLowerCase(string str)
        {
            int lowerCase = 0;  // The number of lowercase letters

            // Count the lowercase characters in str.
            foreach (char ch in str)
            {
                if (char.IsLower(ch))
                {
                    lowerCase++;
                }
            }

            // Return the number of lowercase characters.
            return lowerCase;
        }

        // The NumberDigits method accepts a string argument
        // and returns the number of numeric digits it contains.
        private int NumberDigits(string str)
        {
            int digits = 0;  // The number of digits

            // Count the digits in str.
            foreach (char ch in str)
            {
                if (char.IsDigit(ch))
                {
                    digits++;
                }
            }

            // Return the number of digits.
            return digits;
        }


        // The NumberPunctuation method accepts a string argument
        // and returns the number of punctuation letters it contains.
        private int NumberPunctuation(string str)
        {
            int punctuation = 0;  // The number of punctuation letters

            // Count the punctuation characters in str.
            foreach (char ch in str)
            {
                if (char.IsPunctuation(ch))
                {
                    punctuation++;
                }
            }

            // Return the number of punctuation characters.
            return punctuation;
        }

    }
}
