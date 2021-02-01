Public Class frmLab5

    ' Matthew Hunt
    ' 10/17/2016
    ' Intro to VB 
    ' Mon, Wed 6:00-7:15pm

    ' user clicks calculate button
    Private Sub btnCalculate_Click(sender As Object, e As EventArgs) Handles btnCalculate.Click

        ' try to calculate the sales price
        Try

            ' check to see if the retail price input is not numeric
            If Not IsNumeric(tbxRetailPrice.Text) Then
                ' check to see if the discount percentage input is not numeric
                If Not IsNumeric(tbxDiscountPercentage.Text) Then
                    ' throw exception
                    Throw New InvalidCastException
                End If
            End If

            ' declare varriables
            Dim DblRetailPrice As Double = tbxRetailPrice.Text                      ' to hold retail price
            Dim DblDiscountPercentage As Double = tbxDiscountPercentage.Text / 100  ' to hold

            ' calculate the sales price by subtracting the retail price from the retail
            ' price times the discount percentage and place it in the sales price textbox
            tbxSalesPrice.Text = CStr(DblRetailPrice - DblRetailPrice * DblDiscountPercentage)

        Catch NotANumber As InvalidCastException
            ' Show error message on failure to enter numeric numbers
            MessageBox.Show("You must enter a valid number for the retail price and discount percentage.", "Error!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation)
        End Try

    End Sub

    ' user clicks exit button
    Private Sub btnExit_Click(sender As Object, e As EventArgs) Handles btnExit.Click
        ' exit the program
        Close()
    End Sub
End Class
