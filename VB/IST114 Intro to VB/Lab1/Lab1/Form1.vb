Public Class Form1

    ' Matthew Hunt
    ' 8/29/2016
    ' Intro to VB 
    ' Mon, Wed 6:00-7:15pm

    ' form loads
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        ' display the date/time to lblDate
        lblDate.Text = "Date: " + Date.Now
    End Sub

    ' user clicks the about button
    Private Sub btnAbout_Click(sender As Object, e As EventArgs) Handles btnAbout.Click
        ' set the text of the name, year, and fact lables 
        lblName.Text = "Name: Matthew Hunt"
        lblYear.Text = "Year: I am a sophomore at IPFW."
        lblFact.Text = "Fact: I am majoring in Computer Science and minoring" + vbNewLine + "in Information Systems."
    End Sub

    ' user clicks the close button
    Private Sub btnClose_Click(sender As Object, e As EventArgs) Handles btnClose.Click
        ' close the application
        Me.Close()
    End Sub
End Class
