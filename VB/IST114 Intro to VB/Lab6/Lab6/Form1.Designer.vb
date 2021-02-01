<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class frmLab6
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
        Me.lblResult = New System.Windows.Forms.Label()
        Me.btnHighest = New System.Windows.Forms.Button()
        Me.btnLowest = New System.Windows.Forms.Button()
        Me.btnExit = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'lblResult
        '
        Me.lblResult.BackColor = System.Drawing.SystemColors.AppWorkspace
        Me.lblResult.Location = New System.Drawing.Point(39, 9)
        Me.lblResult.Name = "lblResult"
        Me.lblResult.Size = New System.Drawing.Size(177, 57)
        Me.lblResult.TabIndex = 0
        Me.lblResult.TextAlign = System.Drawing.ContentAlignment.MiddleCenter
        '
        'btnHighest
        '
        Me.btnHighest.Location = New System.Drawing.Point(12, 81)
        Me.btnHighest.Name = "btnHighest"
        Me.btnHighest.Size = New System.Drawing.Size(75, 23)
        Me.btnHighest.TabIndex = 1
        Me.btnHighest.Text = "Highest"
        Me.btnHighest.UseVisualStyleBackColor = True
        '
        'btnLowest
        '
        Me.btnLowest.Location = New System.Drawing.Point(93, 81)
        Me.btnLowest.Name = "btnLowest"
        Me.btnLowest.Size = New System.Drawing.Size(75, 23)
        Me.btnLowest.TabIndex = 2
        Me.btnLowest.Text = "Lowest"
        Me.btnLowest.UseVisualStyleBackColor = True
        '
        'btnExit
        '
        Me.btnExit.Location = New System.Drawing.Point(174, 81)
        Me.btnExit.Name = "btnExit"
        Me.btnExit.Size = New System.Drawing.Size(75, 23)
        Me.btnExit.TabIndex = 3
        Me.btnExit.Text = "Exit"
        Me.btnExit.UseVisualStyleBackColor = True
        '
        'frmLab6
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(257, 115)
        Me.Controls.Add(Me.btnExit)
        Me.Controls.Add(Me.btnLowest)
        Me.Controls.Add(Me.btnHighest)
        Me.Controls.Add(Me.lblResult)
        Me.Name = "frmLab6"
        Me.Text = "Matthew Hunt"
        Me.ResumeLayout(False)

    End Sub

    Friend WithEvents lblResult As Label
    Friend WithEvents btnHighest As Button
    Friend WithEvents btnLowest As Button
    Friend WithEvents btnExit As Button
End Class
