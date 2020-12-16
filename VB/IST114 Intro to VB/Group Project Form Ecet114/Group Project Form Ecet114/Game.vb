Public Class frmGame

    ' Matthew Hunt, Hayden Nieuwlandt, Seth Everett
    ' 12/4/2016
    ' Intro to VB - Final Project
    ' Mon, Wed 6:00-7:15pm

    ' holds the game clock
    Dim oneSec As Boolean = True
    Dim twoSec As Boolean = False
    Dim threeSec As Boolean = False
    Dim fourSec As Boolean = False

    ' holds the selection of the user
    Dim userRock As Boolean = False
    Dim userPaper As Boolean = False
    Dim userScissor As Boolean = False

    ' holds the selection of the computer
    Dim computerRock As Boolean = False
    Dim computerPaper As Boolean = False
    Dim computerScissor As Boolean = False

    ' holds the scores
    Dim userScore As Integer
    Dim computerScore As Integer

    ' holds the score board and login form
    Dim ScoreBoard As New frmScoreBoard
    Dim Login As New frmLogin

    ' on form load
    Private Sub frmGame_Load(sender As Object, e As EventArgs) Handles MyBase.Load

        ' start the timer
        tmrGameClock.Start()
        ' show the socre board form
        ScoreBoard.Show()

    End Sub

    ' on timer tick (1 second)
    Private Sub tmrGameClock_Tick(sender As Object, e As EventArgs) Handles tmrGameClock.Tick

        ' using boolean fields, countdown from 3
        ' and at 0 determine the winner
        If oneSec = True Then
            lblGameClock.Text = "3"
            oneSec = False
            twoSec = True
        ElseIf twoSec = True Then
            lblGameClock.Text = "2"
            twoSec = False
            threeSec = True
        ElseIf threeSec = True Then
            lblGameClock.Text = "1"
            threeSec = False
            fourSec = True
        ElseIf fourSec = True Then
            lblGameClock.Text = "0"
            fourSec = False
            oneSec = True
            decideWinner()
        End If

    End Sub


    ' user changes the rock radio button
    Private Sub rbnRock_CheckedChanged(sender As Object, e As EventArgs) Handles rbnRock.CheckedChanged

        ' call helper method
        changeRadio()

    End Sub

    ' user changes the paper radio button
    Private Sub rbnPaper_CheckedChanged(sender As Object, e As EventArgs) Handles rbnPaper.CheckedChanged

        ' call helper method
        changeRadio()

    End Sub

    ' user changes the scissors radio button
    Private Sub rbnScissors_CheckedChanged(sender As Object, e As EventArgs) Handles rbnScissors.CheckedChanged

        ' call helper method
        changeRadio()

    End Sub

    ' user clicks the close button
    Private Sub btnClose_Click(sender As Object, e As EventArgs) Handles btnClose.Click

        ' go back to the login form
        Login.Show()
        ' close the score board
        ScoreBoard.Close()
        ' close this form
        Close()

    End Sub

    ' helper method to help decide the winner
    Private Sub decideWinner()

        ' holds a random and the random choice of the computer
        Dim rand As New Random
        Dim IntComputerChoice As Integer

        ' holds who wins the round
        Dim userWin As Boolean
        Dim computerWin As Boolean
        Dim draw As Boolean

        ' add a space and DateTime to the score board
        ScoreBoard.lbxConsole.Items.Add(" ")
        ScoreBoard.lbxConsole.Items.Add(Now)

        ' check to see which selection the user chose and
        ' set the appropriate boolean
        If rbnRock.Checked Then
            userRock = True
        ElseIf rbnPaper.Checked Then
            userPaper = True
        ElseIf rbnScissors.Checked Then
            userScissor = True
        End If

        ' calculate a random choice for the computer between 1 and 3
        IntComputerChoice = rand.Next(3) + 1

        ' determine which choice the computer selected and set the
        ' approiate boolean and change the computer's selection picture box
        Select Case IntComputerChoice
            Case 1
                computerRock = True
                pbxComputerSelection.Image = My.Resources.rock
            Case 2
                computerPaper = True
                pbxComputerSelection.Image = My.Resources.paper
            Case 3
                computerScissor = True
                pbxComputerSelection.Image = My.Resources.scissors
        End Select

        ' check if user selected rock
        If userRock Then

            ' compare to the computers selection, determine who won
            ' the round, and add the selections to the score board
            ScoreBoard.lbxConsole.Items.Add("User: Rock")
            If computerRock Then
                ScoreBoard.lbxConsole.Items.Add("Computer: Rock")
                draw = True
            ElseIf computerPaper Then
                ScoreBoard.lbxConsole.Items.Add("Computer: Paper")
                computerWin = True
            ElseIf computerScissor Then
                ScoreBoard.lbxConsole.Items.Add("Computer: Scissors")
                userWin = True
            End If

            ' check if user selected paper
        ElseIf userPaper Then

            ' compare to the computers selection, determine who won
            ' the round, and add the selections to the score board
            ScoreBoard.lbxConsole.Items.Add("User: Paper")
            If computerRock Then
                ScoreBoard.lbxConsole.Items.Add("Computer: Rock")
                userWin = True
            ElseIf computerPaper Then
                ScoreBoard.lbxConsole.Items.Add("Computer: Paper")
                draw = True
            ElseIf computerScissor Then
                ScoreBoard.lbxConsole.Items.Add("Computer: Scissors")
                computerWin = True
            End If

            ' check if user selected scissor
        ElseIf userScissor Then

            ' compare to the computers selection, determine who won
            ' the round, and add the selections to the score board
            ScoreBoard.lbxConsole.Items.Add("User: Scissors")
            If computerRock Then
                ScoreBoard.lbxConsole.Items.Add("Computer: Rock")
                computerWin = True
            ElseIf computerPaper Then
                ScoreBoard.lbxConsole.Items.Add("Computer: Paper")
                userWin = True
            ElseIf computerScissor Then
                ScoreBoard.lbxConsole.Items.Add("Computer: Scissors")
                draw = True
            End If

        End If


        ' check to see who won, send winner to the score board,
        ' update the score counder, and display winner on the
        ' game form too
        If userWin Then
            ScoreBoard.lbxConsole.Items.Add("User Wins")
            userScore = userScore + 1
            lblRoundWinner.Text = "Player"
        ElseIf computerWin Then
            ScoreBoard.lbxConsole.Items.Add("Computer Wins")
            computerScore = computerScore + 1
            lblRoundWinner.Text = "Computer"
        ElseIf draw Then
            ScoreBoard.lbxConsole.Items.Add("Draw")
            lblRoundWinner.Text = "Draw"
        End If

        ' update the computer and users scores
        lblPlayerWins.Text = userScore
        lblComputerWins.Text = computerScore

        ' set the user and computers selection booleans to false
        userRock = False
        userPaper = False
        userScissor = False

        computerRock = False
        computerPaper = False
        computerScissor = False

    End Sub

    ' helper method to help change the user's selection picture box
    Private Sub changeRadio()

        ' check if user changed to paper
        If (rbnPaper.Checked = True) Then

            pbxUserSelection.Image = My.Resources.paper

            ' else if user changed to rock
        ElseIf (rbnRock.Checked = True) Then

            pbxUserSelection.Image = My.Resources.rock

            ' else if user changed to scissors
        ElseIf (rbnScissors.Checked = True) Then

            ' change user selection picture box to scissors
            pbxUserSelection.Image = My.Resources.scissors

        End If

    End Sub

End Class
