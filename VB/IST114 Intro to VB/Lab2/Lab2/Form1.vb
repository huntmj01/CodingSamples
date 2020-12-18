Public Class lab2

    ' Matthew Hunt
    ' 9/12/2016
    ' Intro to VB 
    ' Mon, Wed 6:00-7:15pm

    Dim DblNumber1, DblNumber2 As Double                                                        ' textbox inputs
    Dim DblSum, DblDifference, DblProduct, DblQuotient, DblPower, DblRound, DblMod As Double    ' calculated results

    ' On form load
    Private Sub lab2_Load(sender As Object, e As EventArgs) Handles MyBase.Load

        ' focus on the first textbox
        tbxNumber1.Focus()

        ' set the date time
        lblDateTime.Text = DateTime.Now

    End Sub

    ' Add button clicked
    Private Sub btnAdd_Click(sender As Object, e As EventArgs) Handles btnAdd.Click

        ' try to retrieve the numbers in the two textboxes
        Try
            DblNumber1 = Convert.ToDouble(tbxNumber1.Text)
            DblNumber2 = Convert.ToDouble(tbxNumber2.Text)
        Catch ex As Exception
            ' notify the user they are a dumb dumb
            MessageBox.Show("Invalid number entered.")
        End Try

        ' calculate the sum
        DblSum = DblNumber1 + DblNumber2

        ' set the selected output lable as +
        lblSelectedOperation.Text = "+"

        ' set the output lable to display the sum
        lblOutput.Text = DblSum

    End Sub

    ' Subtract button clicked
    Private Sub btnSubtract_Click(sender As Object, e As EventArgs) Handles btnSubtract.Click

        ' try to retrieve the numbers in the two textboxes
        Try
            DblNumber1 = Convert.ToDouble(tbxNumber1.Text)
            DblNumber2 = Convert.ToDouble(tbxNumber2.Text)
        Catch ex As Exception
            ' notify the user they are a dumb dumb
            MessageBox.Show("Invalid number entered.")
        End Try

        ' calculate the difference
        DblDifference = DblNumber1 - DblNumber2

        ' set the selected output lable as -
        lblSelectedOperation.Text = "-"

        ' set the output lable to display the difference
        lblOutput.Text = DblDifference

    End Sub

    ' Multiply button clicked
    Private Sub btnMultiply_Click(sender As Object, e As EventArgs) Handles btnMultiply.Click

        ' try to retrieve the numbers in the two textboxes
        Try
            DblNumber1 = Convert.ToDouble(tbxNumber1.Text)
            DblNumber2 = Convert.ToDouble(tbxNumber2.Text)
        Catch ex As Exception
            ' notify the user they are a dumb dumb
            MessageBox.Show("Invalid number entered.")
        End Try

        ' calculate the product
        DblProduct = DblNumber1 * DblNumber2

        ' set the selected output lable as *
        lblSelectedOperation.Text = "*"

        ' set the output lable to display the product
        lblOutput.Text = DblProduct

    End Sub

    ' Division button clicked
    Private Sub btnDivision_Click(sender As Object, e As EventArgs) Handles btnDivision.Click

        ' try to retrieve the numbers in the two textboxes
        Try
            DblNumber1 = Convert.ToDouble(tbxNumber1.Text)
            DblNumber2 = Convert.ToDouble(tbxNumber2.Text)
        Catch ex As Exception
            ' notify the user they are a dumb dumb
            MessageBox.Show("Invalid number entered.")
        End Try

        ' calculate the quotient
        DblQuotient = DblNumber1 / DblNumber2

        ' set the selected output lable as /
        lblSelectedOperation.Text = "/"

        ' set the output lable to display the quotient
        lblOutput.Text = DblQuotient

    End Sub

    ' Power button clicked
    Private Sub btnPower_Click(sender As Object, e As EventArgs) Handles btnPower.Click

        ' try to retrieve the numbers in the two textboxes
        Try
            DblNumber1 = Convert.ToDouble(tbxNumber1.Text)
            DblNumber2 = Convert.ToDouble(tbxNumber2.Text)
        Catch ex As Exception
            ' notify the user they are a dumb dumb
            MessageBox.Show("Invalid number entered.")
        End Try

        ' calculate the result of number1^number2
        DblPower = DblNumber1 ^ DblNumber2

        ' set the selected output lable as /
        lblSelectedOperation.Text = "^"

        ' set the output lable to the result of number1^number2
        lblOutput.Text = DblPower

    End Sub

    ' Round button clicked
    Private Sub btnRound_Click(sender As Object, e As EventArgs) Handles btnRound.Click

        ' calculate the rounded value of the output
        DblRound = CInt(lblOutput.Text)

        ' set the selected output lable as Round
        lblSelectedOperation.Text = "Round"

        ' set the output lable to the rounded result
        lblOutput.Text = DblRound

    End Sub

    ' Mod button clicked
    Private Sub btnMod_Click(sender As Object, e As EventArgs) Handles btnMod.Click

        ' try to retrieve the numbers in the two textboxes
        Try
            DblNumber1 = Convert.ToDouble(tbxNumber1.Text)
            DblNumber2 = Convert.ToDouble(tbxNumber2.Text)
        Catch ex As Exception
            ' notify the user they are a dumb dumb
            MessageBox.Show("Invalid number entered.")
        End Try

        ' calculate the mod 
        DblMod = DblNumber1 Mod DblNumber2

        ' set the selected output lable as Mod
        lblSelectedOperation.Text = "Mod"

        ' set the output lable to the mod
        lblOutput.Text = DblMod

    End Sub

    ' Clear button clicked
    Private Sub btnClear_Click(sender As Object, e As EventArgs) Handles btnClear.Click

        ' clear the textboxes
        tbxNumber1.Clear()
        tbxNumber2.Clear()

        ' reset the lables
        lblSelectedOperation.Text = "Selected Operation"
        lblOutput.Text = "Output"

        ' focus on the first textbox
        tbxNumber1.Focus()

    End Sub

    ' Exit button clicked
    Private Sub btnExit_Click(sender As Object, e As EventArgs) Handles btnExit.Click
        ' exit the program
        Me.Close()
    End Sub

End Class
