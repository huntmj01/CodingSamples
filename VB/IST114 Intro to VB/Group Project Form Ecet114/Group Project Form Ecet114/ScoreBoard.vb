Public Class frmScoreBoard

    ' Matthew Hunt, Hayden Nieuwlandt, Seth Everett
    ' 12/4/2016
    ' Intro to VB - Final Project
    ' Mon, Wed 6:00-7:15pm

    ' on form load
    Private Sub frmScoreBoard_Load(sender As Object, e As EventArgs) Handles MyBase.Load

        ' start the timer
        tmrDateTime.Start()

    End Sub

    ' on timer tick (1 second)
    Private Sub tmrDateTime_Tick(sender As Object, e As EventArgs) Handles tmrDateTime.Tick

        ' update the date time lable to the current date time
        lblDateTime.Text = Now

    End Sub

End Class
