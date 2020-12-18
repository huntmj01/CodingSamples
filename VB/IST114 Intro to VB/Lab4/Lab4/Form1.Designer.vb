<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class lab4
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
        Me.tbxTestAverage = New System.Windows.Forms.TextBox()
        Me.lblTestAverage = New System.Windows.Forms.Label()
        Me.btnGetScore = New System.Windows.Forms.Button()
        Me.btnExit = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'tbxTestAverage
        '
        Me.tbxTestAverage.Enabled = False
        Me.tbxTestAverage.Location = New System.Drawing.Point(107, 12)
        Me.tbxTestAverage.Name = "tbxTestAverage"
        Me.tbxTestAverage.Size = New System.Drawing.Size(100, 20)
        Me.tbxTestAverage.TabIndex = 0
        '
        'lblTestAverage
        '
        Me.lblTestAverage.AutoSize = True
        Me.lblTestAverage.Location = New System.Drawing.Point(12, 15)
        Me.lblTestAverage.Name = "lblTestAverage"
        Me.lblTestAverage.Size = New System.Drawing.Size(71, 13)
        Me.lblTestAverage.TabIndex = 1
        Me.lblTestAverage.Text = "Test Average"
        '
        'btnGetScore
        '
        Me.btnGetScore.Location = New System.Drawing.Point(12, 54)
        Me.btnGetScore.Name = "btnGetScore"
        Me.btnGetScore.Size = New System.Drawing.Size(75, 23)
        Me.btnGetScore.TabIndex = 2
        Me.btnGetScore.Text = "Get Score"
        Me.btnGetScore.UseVisualStyleBackColor = True
        '
        'btnExit
        '
        Me.btnExit.Location = New System.Drawing.Point(132, 54)
        Me.btnExit.Name = "btnExit"
        Me.btnExit.Size = New System.Drawing.Size(75, 23)
        Me.btnExit.TabIndex = 3
        Me.btnExit.Text = "Exit"
        Me.btnExit.UseVisualStyleBackColor = True
        '
        'lab4
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(219, 104)
        Me.Controls.Add(Me.btnExit)
        Me.Controls.Add(Me.btnGetScore)
        Me.Controls.Add(Me.lblTestAverage)
        Me.Controls.Add(Me.tbxTestAverage)
        Me.Name = "lab4"
        Me.Text = "Matthew Hunt"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents tbxTestAverage As TextBox
    Friend WithEvents lblTestAverage As Label
    Friend WithEvents btnGetScore As Button
    Friend WithEvents btnExit As Button
End Class
