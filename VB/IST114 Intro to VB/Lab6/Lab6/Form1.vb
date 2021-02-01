Public Class frmLab6

    ' Matthew Hunt
    ' 10/19/2016
    ' Intro to VB 
    ' Mon, Wed 6:00-7:15pm

    ' create global integer array
    Dim intUnits() As Integer = {1, 2, 3, 4, 5}

    ' user clickes highest button
    Private Sub btnHighest_Click(sender As Object, e As EventArgs) Handles btnHighest.Click
        ' display the highest number in the array to the lable
        lblResult.Text = "The lowest number is " + CStr(intUnits.Max)
    End Sub

    ' user clicks lowest button
    Private Sub btnLowest_Click(sender As Object, e As EventArgs) Handles btnLowest.Click
        ' display the lowest number in the array to the lable
        lblResult.Text = "The lowest number is " + CStr(intUnits.Min)
    End Sub

    ' user clicks the exit button
    Private Sub btnExit_Click(sender As Object, e As EventArgs) Handles btnExit.Click
        ' exit the application
        Close()
    End Sub

End Class
