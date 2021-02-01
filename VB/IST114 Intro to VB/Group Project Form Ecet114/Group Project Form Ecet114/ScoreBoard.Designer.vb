<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class frmScoreBoard
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
        Me.components = New System.ComponentModel.Container()
        Me.lblDateTime = New System.Windows.Forms.Label()
        Me.lbxConsole = New System.Windows.Forms.ListBox()
        Me.tmrDateTime = New System.Windows.Forms.Timer(Me.components)
        Me.SuspendLayout()
        '
        'lblDateTime
        '
        Me.lblDateTime.AutoSize = True
        Me.lblDateTime.Location = New System.Drawing.Point(383, 9)
        Me.lblDateTime.Margin = New System.Windows.Forms.Padding(2, 0, 2, 0)
        Me.lblDateTime.Name = "lblDateTime"
        Me.lblDateTime.Size = New System.Drawing.Size(67, 13)
        Me.lblDateTime.TabIndex = 0
        Me.lblDateTime.Text = "DATE\TIME"
        '
        'lbxConsole
        '
        Me.lbxConsole.FormattingEnabled = True
        Me.lbxConsole.Location = New System.Drawing.Point(8, 30)
        Me.lbxConsole.Margin = New System.Windows.Forms.Padding(2)
        Me.lbxConsole.Name = "lbxConsole"
        Me.lbxConsole.Size = New System.Drawing.Size(545, 459)
        Me.lbxConsole.TabIndex = 1
        '
        'tmrDateTime
        '
        Me.tmrDateTime.Interval = 1000
        '
        'frmScoreBoard
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(563, 501)
        Me.Controls.Add(Me.lbxConsole)
        Me.Controls.Add(Me.lblDateTime)
        Me.Margin = New System.Windows.Forms.Padding(2)
        Me.Name = "frmScoreBoard"
        Me.Text = "ScoreBoard"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents lblDateTime As Label
    Friend WithEvents lbxConsole As ListBox
    Friend WithEvents tmrDateTime As Timer
End Class
