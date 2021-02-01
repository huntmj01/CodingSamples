Imports System.Data.SqlClient

' Matthew Hunt, Hayden Nieuwlandt, Seth Everett
' 12/4/2016
' Intro to VB - Final Project
' Mon, Wed 6:00-7:15pm

Public Class frmLogin

    ' holds string information for sql command
    Dim StrPath As String = Application.StartupPath().Replace("\bin\Debug", "")
    Dim StrConnection As String = "Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=" & StrPath & "\Roshambo.mdf" & ";Integrated Security=True;Connect Timeout=30"
    Dim StrSqlQuery As String

    ' holds the database information
    Dim Connection As New SqlConnection
    Dim Command As New SqlCommand
    Dim Reader As SqlDataReader

    ' user clicks the not a user label 
    Private Sub lblNotAUser_Click(sender As Object, e As EventArgs) Handles lblNotAUser.Click

        ' retrieve the new user name and password
        Dim StrUsername As String = InputBox("Enter new username:")
        Dim StrPassword As String = InputBox("Enter new password:")

        ' open a connection to Roshambo.mdf
        Connection.ConnectionString = StrConnection
        Connection.Open()

        ' create a query to insert the new username and password into the database
        StrSqlQuery = "INSERT INTO Users(username, password)  VALUES('" & StrUsername & "','" & StrPassword & "')"

        ' execute the query
        Command = New SqlCommand(StrSqlQuery, Connection)
        Command.ExecuteNonQuery()

        ' close the connection
        Connection.Close()

    End Sub

    ' user clicks the login button
    Private Sub btnLogin_Click(sender As Object, e As EventArgs) Handles btnLogin.Click

        ' open a connection to Roshambo.mdf
        Connection.ConnectionString = StrConnection
        Connection.Open()

        ' create a query to retrieve the user with the given username and password
        StrSqlQuery = "SELECT * FROM Users WHERE username = '" & txtUsername.Text & "' AND password = '" & txtPassword.Text & "'"

        ' execute the query
        Command = New SqlCommand(StrSqlQuery, Connection)
        Reader = Command.ExecuteReader()

        ' check to see if a user was returned
        If Reader.Read() Then

            ' open the game window
            Dim Game As New frmGame
            Game.Show()
            ' close the connection to the database
            Connection.Close()
            ' hide this form
            Hide()

            ' else a user was not returned
        Else

            ' show user not found message
            MessageBox.Show("Invalid username or password")
            ' close the connection to the database
            Connection.Close()

        End If

    End Sub

    ' user clicks the exit button
    Private Sub btnExit_Click(sender As Object, e As EventArgs) Handles btnExit.Click

        ' exit the program
        Application.Exit()

    End Sub
End Class
