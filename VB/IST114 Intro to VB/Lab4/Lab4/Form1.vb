Public Class lab4

    ' Matthew Hunt
    ' 9/16/2016
    ' Intro to VB 
    ' Mon, Wed 6:00-7:15pm

    ' Get Score button clicked
    Private Sub btnGetScore_Click(sender As Object, e As EventArgs) Handles btnGetScore.Click

        ' declare variables 
        Dim DblTotal As Double = 0         ' to hold the total of the scores the user enters
        Dim DblAverage As Double = 0        ' to hold average of the test scores
        Dim IntNumOfScores As Integer = 0   ' to hold number of scores user wants to average
        Dim IntCount As Integer = 0         ' to hold the count of iterations in the loop

        ' try to calculate the average
        Try

            ' try to parse the number of scores from an input box to the user
            If Integer.TryParse(InputBox("How many test scores do you want to average?"), IntNumOfScores) Then
                ' do nothing
            Else
                ' throw an exception to let the user know they must enter an integer
                Throw New Exception("You must enter an integer for the number of test scores.")
            End If

            ' set count to the number of scores
            IntCount = IntNumOfScores

            ' loop until count is zero
            Do Until IntCount = 0

                ' declare variables
                Dim temp As Double  ' to hold the users input
                Dim testScoreToEnter As Integer  ' to hold the test score the user needs to enter

                ' clculate the which test score the user needs to enter
                ' by subtracting the count-1 from the number of scores
                testScoreToEnter = IntNumOfScores - (IntCount - 1)

                ' try to parse the input from an input box to the user
                If Double.TryParse(InputBox("Enter test score " & testScoreToEnter), temp) Then
                    ' do nothing
                Else
                    ' throw an exception to let the user know they must enter an integer
                    Throw New Exception("You must enter an integer for test score " & testScoreToEnter)
                End If

                ' subtract 1 from the count
                IntCount -= 1

                ' add the user input to the total
                DblTotal += temp

            Loop

            ' calculate the average by dividing the number of scores from the total
            DblAverage = DblTotal / IntNumOfScores

            ' display the average to 2 decimal places in the average textbox
            tbxTestAverage.Text = DblAverage.ToString("n2")

            ' catch any exception
        Catch ex As Exception

            ' display the exception to the user
            MessageBox.Show(ex.Message)

        End Try

    End Sub

    ' Exit button clicked
    Private Sub btnExit_Click(sender As Object, e As EventArgs) Handles btnExit.Click

        ' application exit
        Me.Close()

    End Sub

End Class
