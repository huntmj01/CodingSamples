<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class frmLab5
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.btnCalculate = New System.Windows.Forms.Button()
        Me.btnExit = New System.Windows.Forms.Button()
        Me.tbxSalesPrice = New System.Windows.Forms.TextBox()
        Me.tbxDiscountPercentage = New System.Windows.Forms.TextBox()
        Me.tbxRetailPrice = New System.Windows.Forms.TextBox()
        Me.lblRetailPrice = New System.Windows.Forms.Label()
        Me.lblSalePrice = New System.Windows.Forms.Label()
        Me.lblDiscountPercentage = New System.Windows.Forms.Label()
        Me.SuspendLayout()
        '
        'btnCalculate
        '
        Me.btnCalculate.Location = New System.Drawing.Point(15, 99)
        Me.btnCalculate.Name = "btnCalculate"
        Me.btnCalculate.Size = New System.Drawing.Size(115, 23)
        Me.btnCalculate.TabIndex = 0
        Me.btnCalculate.Text = "Calculate Sale Price"
        Me.btnCalculate.UseVisualStyleBackColor = True
        '
        'btnExit
        '
        Me.btnExit.Location = New System.Drawing.Point(161, 99)
        Me.btnExit.Name = "btnExit"
        Me.btnExit.Size = New System.Drawing.Size(75, 23)
        Me.btnExit.TabIndex = 1
        Me.btnExit.Text = "Exit"
        Me.btnExit.UseVisualStyleBackColor = True
        '
        'tbxSalesPrice
        '
        Me.tbxSalesPrice.Enabled = False
        Me.tbxSalesPrice.Location = New System.Drawing.Point(136, 59)
        Me.tbxSalesPrice.Name = "tbxSalesPrice"
        Me.tbxSalesPrice.Size = New System.Drawing.Size(100, 20)
        Me.tbxSalesPrice.TabIndex = 3
        '
        'tbxDiscountPercentage
        '
        Me.tbxDiscountPercentage.Location = New System.Drawing.Point(136, 33)
        Me.tbxDiscountPercentage.Name = "tbxDiscountPercentage"
        Me.tbxDiscountPercentage.Size = New System.Drawing.Size(100, 20)
        Me.tbxDiscountPercentage.TabIndex = 4
        '
        'tbxRetailPrice
        '
        Me.tbxRetailPrice.Location = New System.Drawing.Point(136, 7)
        Me.tbxRetailPrice.Name = "tbxRetailPrice"
        Me.tbxRetailPrice.Size = New System.Drawing.Size(100, 20)
        Me.tbxRetailPrice.TabIndex = 5
        '
        'lblRetailPrice
        '
        Me.lblRetailPrice.AutoSize = True
        Me.lblRetailPrice.Location = New System.Drawing.Point(12, 10)
        Me.lblRetailPrice.Name = "lblRetailPrice"
        Me.lblRetailPrice.Size = New System.Drawing.Size(64, 13)
        Me.lblRetailPrice.TabIndex = 6
        Me.lblRetailPrice.Text = "Retail Price:"
        '
        'lblSalePrice
        '
        Me.lblSalePrice.AutoSize = True
        Me.lblSalePrice.Location = New System.Drawing.Point(12, 62)
        Me.lblSalePrice.Name = "lblSalePrice"
        Me.lblSalePrice.Size = New System.Drawing.Size(58, 13)
        Me.lblSalePrice.TabIndex = 7
        Me.lblSalePrice.Text = "Sale Price:"
        '
        'lblDiscountPercentage
        '
        Me.lblDiscountPercentage.AutoSize = True
        Me.lblDiscountPercentage.Location = New System.Drawing.Point(12, 36)
        Me.lblDiscountPercentage.Name = "lblDiscountPercentage"
        Me.lblDiscountPercentage.Size = New System.Drawing.Size(110, 13)
        Me.lblDiscountPercentage.TabIndex = 8
        Me.lblDiscountPercentage.Text = "Discount Percentage:"
        '
        'frmLab5
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(251, 139)
        Me.Controls.Add(Me.lblDiscountPercentage)
        Me.Controls.Add(Me.lblSalePrice)
        Me.Controls.Add(Me.lblRetailPrice)
        Me.Controls.Add(Me.tbxRetailPrice)
        Me.Controls.Add(Me.tbxDiscountPercentage)
        Me.Controls.Add(Me.tbxSalesPrice)
        Me.Controls.Add(Me.btnExit)
        Me.Controls.Add(Me.btnCalculate)
        Me.Name = "frmLab5"
        Me.Text = "Matthew Hunt"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents btnCalculate As Button
    Friend WithEvents btnExit As Button
    Friend WithEvents tbxSalesPrice As TextBox
    Friend WithEvents tbxDiscountPercentage As TextBox
    Friend WithEvents tbxRetailPrice As TextBox
    Friend WithEvents lblRetailPrice As Label
    Friend WithEvents lblSalePrice As Label
    Friend WithEvents lblDiscountPercentage As Label
End Class
