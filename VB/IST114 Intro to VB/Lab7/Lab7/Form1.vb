Imports System.IO

' Matthew Hunt
' 11/14/2016
' Intro to VB 
' Mon, Wed 6:00-7:15pm

Public Class frmStreamReaderWriter

    ' user clicks the write button
    Private Sub btnWrite_Click(sender As Object, e As EventArgs) Handles btnWrite.Click

        ' holds file to output user text to
        Dim outputFile As StreamWriter

        ' holds the text the user wants to output to the file
        Dim StrInput As String = InputBox("Enter Text:")

        ' try to create the file and write the user text
        ' to that file
        Try

            ' create the file
            outputFile = File.CreateText("text.txt")

            ' write user text to the file
            outputFile.WriteLine(StrInput)

            ' close the stream writer
            outputFile.Close()

        Catch ex As Exception

            ' display error to user
            MessageBox.Show(ex.ToString)

        End Try

    End Sub

    ' user clicks the read button
    Private Sub btnRead_Click(sender As Object, e As EventArgs) Handles btnRead.Click

        ' holds file with the text to output to textbox
        Dim inputFile As StreamReader

        ' try to open the file and print the text to the textbox
        Try

            ' open the file
            inputFile = File.OpenText("text.txt")

            ' output the text in the text file to the textbox
            tbxOutput.Text = inputFile.ReadLine

            ' close the stream reader
            inputFile.Close()

        Catch ex As Exception

            ' display error to user
            MessageBox.Show(ex.ToString)

        End Try

    End Sub

    ' user clicks the close button
    Private Sub btnClose_Click(sender As Object, e As EventArgs) Handles btnClose.Click

        ' exit the application
        Close()

    End Sub

End Class
