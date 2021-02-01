<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class lab3
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
        Me.rbnDaytime = New System.Windows.Forms.RadioButton()
        Me.rbnEvening = New System.Windows.Forms.RadioButton()
        Me.rbnOffPeak = New System.Windows.Forms.RadioButton()
        Me.gbxSelectRate = New System.Windows.Forms.GroupBox()
        Me.lblMinutes = New System.Windows.Forms.Label()
        Me.lblTotalCharge = New System.Windows.Forms.Label()
        Me.tbxMinutes = New System.Windows.Forms.TextBox()
        Me.tbxTotalCharge = New System.Windows.Forms.TextBox()
        Me.btnCalculate = New System.Windows.Forms.Button()
        Me.btnClear = New System.Windows.Forms.Button()
        Me.btnExit = New System.Windows.Forms.Button()
        Me.gbxSelectRate.SuspendLayout()
        Me.SuspendLayout()
        '
        'rbnDaytime
        '
        Me.rbnDaytime.AutoSize = True
        Me.rbnDaytime.Checked = True
        Me.rbnDaytime.Location = New System.Drawing.Point(12, 29)
        Me.rbnDaytime.Name = "rbnDaytime"
        Me.rbnDaytime.Size = New System.Drawing.Size(63, 17)
        Me.rbnDaytime.TabIndex = 0
        Me.rbnDaytime.TabStop = True
        Me.rbnDaytime.Text = "Daytime"
        Me.rbnDaytime.UseVisualStyleBackColor = True
        '
        'rbnEvening
        '
        Me.rbnEvening.AutoSize = True
        Me.rbnEvening.Location = New System.Drawing.Point(81, 29)
        Me.rbnEvening.Name = "rbnEvening"
        Me.rbnEvening.Size = New System.Drawing.Size(64, 17)
        Me.rbnEvening.TabIndex = 1
        Me.rbnEvening.TabStop = True
        Me.rbnEvening.Text = "Evening"
        Me.rbnEvening.UseVisualStyleBackColor = True
        '
        'rbnOffPeak
        '
        Me.rbnOffPeak.AutoSize = True
        Me.rbnOffPeak.Location = New System.Drawing.Point(162, 29)
        Me.rbnOffPeak.Name = "rbnOffPeak"
        Me.rbnOffPeak.Size = New System.Drawing.Size(67, 17)
        Me.rbnOffPeak.TabIndex = 2
        Me.rbnOffPeak.TabStop = True
        Me.rbnOffPeak.Text = "Off-Peak"
        Me.rbnOffPeak.UseVisualStyleBackColor = True
        '
        'gbxSelectRate
        '
        Me.gbxSelectRate.Controls.Add(Me.rbnOffPeak)
        Me.gbxSelectRate.Controls.Add(Me.rbnEvening)
        Me.gbxSelectRate.Controls.Add(Me.rbnDaytime)
        Me.gbxSelectRate.Location = New System.Drawing.Point(8, 12)
        Me.gbxSelectRate.Name = "gbxSelectRate"
        Me.gbxSelectRate.Size = New System.Drawing.Size(237, 64)
        Me.gbxSelectRate.TabIndex = 3
        Me.gbxSelectRate.TabStop = False
        Me.gbxSelectRate.Text = "Clear"
        '
        'lblMinutes
        '
        Me.lblMinutes.AutoSize = True
        Me.lblMinutes.Location = New System.Drawing.Point(12, 90)
        Me.lblMinutes.Name = "lblMinutes"
        Me.lblMinutes.Size = New System.Drawing.Size(127, 13)
        Me.lblMinutes.TabIndex = 0
        Me.lblMinutes.Text = "Enter Number of Minutes:"
        '
        'lblTotalCharge
        '
        Me.lblTotalCharge.AutoSize = True
        Me.lblTotalCharge.Location = New System.Drawing.Point(12, 116)
        Me.lblTotalCharge.Name = "lblTotalCharge"
        Me.lblTotalCharge.Size = New System.Drawing.Size(124, 13)
        Me.lblTotalCharge.TabIndex = 1
        Me.lblTotalCharge.Text = "Total Charge for the Call:"
        '
        'tbxMinutes
        '
        Me.tbxMinutes.Location = New System.Drawing.Point(145, 87)
        Me.tbxMinutes.Name = "tbxMinutes"
        Me.tbxMinutes.Size = New System.Drawing.Size(100, 20)
        Me.tbxMinutes.TabIndex = 2
        '
        'tbxTotalCharge
        '
        Me.tbxTotalCharge.Enabled = False
        Me.tbxTotalCharge.Location = New System.Drawing.Point(145, 113)
        Me.tbxTotalCharge.Name = "tbxTotalCharge"
        Me.tbxTotalCharge.Size = New System.Drawing.Size(100, 20)
        Me.tbxTotalCharge.TabIndex = 3
        '
        'btnCalculate
        '
        Me.btnCalculate.Location = New System.Drawing.Point(8, 139)
        Me.btnCalculate.Name = "btnCalculate"
        Me.btnCalculate.Size = New System.Drawing.Size(75, 23)
        Me.btnCalculate.TabIndex = 4
        Me.btnCalculate.Text = "Calculate"
        Me.btnCalculate.UseVisualStyleBackColor = True
        '
        'btnClear
        '
        Me.btnClear.Location = New System.Drawing.Point(89, 139)
        Me.btnClear.Name = "btnClear"
        Me.btnClear.Size = New System.Drawing.Size(75, 23)
        Me.btnClear.TabIndex = 5
        Me.btnClear.Text = "Clear"
        Me.btnClear.UseVisualStyleBackColor = True
        '
        'btnExit
        '
        Me.btnExit.Location = New System.Drawing.Point(170, 139)
        Me.btnExit.Name = "btnExit"
        Me.btnExit.Size = New System.Drawing.Size(75, 23)
        Me.btnExit.TabIndex = 6
        Me.btnExit.Text = "Exit"
        Me.btnExit.UseVisualStyleBackColor = True
        '
        'lab3
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(251, 167)
        Me.Controls.Add(Me.lblMinutes)
        Me.Controls.Add(Me.lblTotalCharge)
        Me.Controls.Add(Me.tbxMinutes)
        Me.Controls.Add(Me.tbxTotalCharge)
        Me.Controls.Add(Me.btnCalculate)
        Me.Controls.Add(Me.btnClear)
        Me.Controls.Add(Me.btnExit)
        Me.Controls.Add(Me.gbxSelectRate)
        Me.Name = "lab3"
        Me.Text = "Matthew Hunt"
        Me.gbxSelectRate.ResumeLayout(False)
        Me.gbxSelectRate.PerformLayout()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents rbnDaytime As RadioButton
    Friend WithEvents rbnEvening As RadioButton
    Friend WithEvents rbnOffPeak As RadioButton
    Friend WithEvents gbxSelectRate As GroupBox
    Friend WithEvents lblMinutes As Label
    Friend WithEvents lblTotalCharge As Label
    Friend WithEvents tbxMinutes As TextBox
    Friend WithEvents tbxTotalCharge As TextBox
    Friend WithEvents btnCalculate As Button
    Friend WithEvents btnClear As Button
    Friend WithEvents btnExit As Button
End Class
