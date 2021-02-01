Public Class lab3

    ' Matthew Hunt
    ' 9/16/2016
    ' Intro to VB 
    ' Mon, Wed 6:00-7:15pm

    ' Calculate button clicked
    Private Sub btnCalculate_Click(sender As Object, e As EventArgs) Handles btnCalculate.Click

        ' declare constants for the long distance rates
        Const DblDayRate As Double = 0.05
        Const DblEveningRate As Double = 0.1
        Const DblOffPeakRate As Double = 0.03

        ' declare variable to hold the minutes of the call, 
        ' the Rate Of the Call, And the total charge of the call
        Dim DblMinutes As Double
        Dim DblRate As Double
        Dim DblCharge As Double

        ' try to calculate the total charge
        Try

            ' check which radio button is checked and then
            ' fill the rate with the corresponding constant
            If rbnDaytime.Checked Then
                DblRate = DblDayRate
            ElseIf rbnEvening.Checked Then
                DblRate = DblEveningRate
            ElseIf rbnOffPeak.Checked Then
                DblRate = DblOffPeakRate
            Else
                ' no radio button has been selected so 
                ' throw exception
                Throw New Exception("No radio button selected.")
            End If

            ' try to parse the minutes textbox into a double
            ' and store it in the charge variable
            Double.TryParse(tbxMinutes.Text, DblCharge)

            ' retrieve the minutes from the textbox
            ' and parse to double
            DblMinutes = Double.Parse(tbxMinutes.Text)

            ' calculate the charge
            DblCharge = DblMinutes * DblRate

            ' set the text of the total charge textbox
            ' to that of the calculate charge
            tbxTotalCharge.Text = "$" & DblCharge

            ' catch number format exception
        Catch nex As FormatException

            ' tell the user they didn't enter a number into the textbox
            MessageBox.Show("You must enter a number into the minutes textbox.")

            ' catch all other exceptions
        Catch ex As Exception

            ' display the exception message to the user
            MessageBox.Show(ex.Message)

        End Try

    End Sub

    ' Clear button clicked
    Private Sub btnClear_Click(sender As Object, e As EventArgs) Handles btnClear.Click

        ' clear the radio buttons
        rbnDaytime.Checked = True

        ' clear the textboxes
        tbxMinutes.Clear()
        tbxTotalCharge.Clear()

        ' set focus
        tbxMinutes.Focus()

    End Sub

    ' Exit button clicked
    Private Sub btnExit_Click(sender As Object, e As EventArgs) Handles btnExit.Click

        ' close the application
        Me.Close()

    End Sub

End Class
