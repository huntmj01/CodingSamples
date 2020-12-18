<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class lab2
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
        Me.gbxEnterValue = New System.Windows.Forms.GroupBox()
        Me.tbxNumber1 = New System.Windows.Forms.TextBox()
        Me.tbxNumber2 = New System.Windows.Forms.TextBox()
        Me.lblNumber2 = New System.Windows.Forms.Label()
        Me.lblNumber1 = New System.Windows.Forms.Label()
        Me.gbxOperationKeys = New System.Windows.Forms.GroupBox()
        Me.btnMod = New System.Windows.Forms.Button()
        Me.btnRound = New System.Windows.Forms.Button()
        Me.btnPower = New System.Windows.Forms.Button()
        Me.btnDivision = New System.Windows.Forms.Button()
        Me.btnMultiply = New System.Windows.Forms.Button()
        Me.btnSubtract = New System.Windows.Forms.Button()
        Me.btnAdd = New System.Windows.Forms.Button()
        Me.BackgroundWorker1 = New System.ComponentModel.BackgroundWorker()
        Me.btnExit = New System.Windows.Forms.Button()
        Me.btnClear = New System.Windows.Forms.Button()
        Me.lblSelectedOperation = New System.Windows.Forms.Label()
        Me.lblOperation = New System.Windows.Forms.Label()
        Me.lblOutput = New System.Windows.Forms.Label()
        Me.lblResult = New System.Windows.Forms.Label()
        Me.lblDateTime = New System.Windows.Forms.Label()
        Me.gbxEnterValue.SuspendLayout()
        Me.gbxOperationKeys.SuspendLayout()
        Me.SuspendLayout()
        '
        'gbxEnterValue
        '
        Me.gbxEnterValue.Controls.Add(Me.tbxNumber1)
        Me.gbxEnterValue.Controls.Add(Me.tbxNumber2)
        Me.gbxEnterValue.Controls.Add(Me.lblNumber2)
        Me.gbxEnterValue.Controls.Add(Me.lblNumber1)
        Me.gbxEnterValue.Location = New System.Drawing.Point(12, 39)
        Me.gbxEnterValue.Name = "gbxEnterValue"
        Me.gbxEnterValue.Size = New System.Drawing.Size(200, 100)
        Me.gbxEnterValue.TabIndex = 0
        Me.gbxEnterValue.TabStop = False
        Me.gbxEnterValue.Text = "Enter Value"
        '
        'tbxNumber1
        '
        Me.tbxNumber1.Location = New System.Drawing.Point(94, 25)
        Me.tbxNumber1.Name = "tbxNumber1"
        Me.tbxNumber1.Size = New System.Drawing.Size(100, 20)
        Me.tbxNumber1.TabIndex = 0
        '
        'tbxNumber2
        '
        Me.tbxNumber2.Location = New System.Drawing.Point(94, 59)
        Me.tbxNumber2.Name = "tbxNumber2"
        Me.tbxNumber2.Size = New System.Drawing.Size(100, 20)
        Me.tbxNumber2.TabIndex = 1
        '
        'lblNumber2
        '
        Me.lblNumber2.AutoSize = True
        Me.lblNumber2.Location = New System.Drawing.Point(6, 62)
        Me.lblNumber2.Name = "lblNumber2"
        Me.lblNumber2.Size = New System.Drawing.Size(56, 13)
        Me.lblNumber2.TabIndex = 4
        Me.lblNumber2.Text = "Number 2:"
        '
        'lblNumber1
        '
        Me.lblNumber1.AutoSize = True
        Me.lblNumber1.Location = New System.Drawing.Point(6, 28)
        Me.lblNumber1.Name = "lblNumber1"
        Me.lblNumber1.Size = New System.Drawing.Size(56, 13)
        Me.lblNumber1.TabIndex = 3
        Me.lblNumber1.Text = "Number 1:"
        '
        'gbxOperationKeys
        '
        Me.gbxOperationKeys.Controls.Add(Me.btnMod)
        Me.gbxOperationKeys.Controls.Add(Me.btnRound)
        Me.gbxOperationKeys.Controls.Add(Me.btnPower)
        Me.gbxOperationKeys.Controls.Add(Me.btnDivision)
        Me.gbxOperationKeys.Controls.Add(Me.btnMultiply)
        Me.gbxOperationKeys.Controls.Add(Me.btnSubtract)
        Me.gbxOperationKeys.Controls.Add(Me.btnAdd)
        Me.gbxOperationKeys.Location = New System.Drawing.Point(223, 159)
        Me.gbxOperationKeys.Name = "gbxOperationKeys"
        Me.gbxOperationKeys.Size = New System.Drawing.Size(160, 100)
        Me.gbxOperationKeys.TabIndex = 0
        Me.gbxOperationKeys.TabStop = False
        Me.gbxOperationKeys.Text = "Operation Keys"
        '
        'btnMod
        '
        Me.btnMod.Location = New System.Drawing.Point(100, 48)
        Me.btnMod.Name = "btnMod"
        Me.btnMod.Size = New System.Drawing.Size(48, 23)
        Me.btnMod.TabIndex = 8
        Me.btnMod.Text = "MOD"
        Me.btnMod.UseVisualStyleBackColor = True
        '
        'btnRound
        '
        Me.btnRound.Location = New System.Drawing.Point(43, 48)
        Me.btnRound.Name = "btnRound"
        Me.btnRound.Size = New System.Drawing.Size(51, 23)
        Me.btnRound.TabIndex = 7
        Me.btnRound.Text = "round"
        Me.btnRound.UseVisualStyleBackColor = True
        '
        'btnPower
        '
        Me.btnPower.Location = New System.Drawing.Point(6, 48)
        Me.btnPower.Name = "btnPower"
        Me.btnPower.Size = New System.Drawing.Size(31, 23)
        Me.btnPower.TabIndex = 6
        Me.btnPower.Text = "^"
        Me.btnPower.UseVisualStyleBackColor = True
        '
        'btnDivision
        '
        Me.btnDivision.Location = New System.Drawing.Point(117, 19)
        Me.btnDivision.Name = "btnDivision"
        Me.btnDivision.Size = New System.Drawing.Size(31, 23)
        Me.btnDivision.TabIndex = 5
        Me.btnDivision.Text = "/"
        Me.btnDivision.UseVisualStyleBackColor = True
        '
        'btnMultiply
        '
        Me.btnMultiply.Location = New System.Drawing.Point(80, 19)
        Me.btnMultiply.Name = "btnMultiply"
        Me.btnMultiply.Size = New System.Drawing.Size(31, 23)
        Me.btnMultiply.TabIndex = 4
        Me.btnMultiply.Text = "*"
        Me.btnMultiply.UseVisualStyleBackColor = True
        '
        'btnSubtract
        '
        Me.btnSubtract.Location = New System.Drawing.Point(43, 19)
        Me.btnSubtract.Name = "btnSubtract"
        Me.btnSubtract.Size = New System.Drawing.Size(31, 23)
        Me.btnSubtract.TabIndex = 3
        Me.btnSubtract.Text = "-"
        Me.btnSubtract.UseVisualStyleBackColor = True
        '
        'btnAdd
        '
        Me.btnAdd.Location = New System.Drawing.Point(6, 19)
        Me.btnAdd.Name = "btnAdd"
        Me.btnAdd.Size = New System.Drawing.Size(31, 23)
        Me.btnAdd.TabIndex = 2
        Me.btnAdd.Text = "+"
        Me.btnAdd.UseVisualStyleBackColor = True
        '
        'btnExit
        '
        Me.btnExit.Location = New System.Drawing.Point(304, 284)
        Me.btnExit.Name = "btnExit"
        Me.btnExit.Size = New System.Drawing.Size(75, 23)
        Me.btnExit.TabIndex = 10
        Me.btnExit.Text = "Exit"
        Me.btnExit.UseVisualStyleBackColor = True
        '
        'btnClear
        '
        Me.btnClear.Location = New System.Drawing.Point(223, 284)
        Me.btnClear.Name = "btnClear"
        Me.btnClear.Size = New System.Drawing.Size(75, 23)
        Me.btnClear.TabIndex = 9
        Me.btnClear.Text = "Clear"
        Me.btnClear.UseVisualStyleBackColor = True
        '
        'lblSelectedOperation
        '
        Me.lblSelectedOperation.AutoSize = True
        Me.lblSelectedOperation.Location = New System.Drawing.Point(53, 207)
        Me.lblSelectedOperation.Name = "lblSelectedOperation"
        Me.lblSelectedOperation.Size = New System.Drawing.Size(98, 13)
        Me.lblSelectedOperation.TabIndex = 5
        Me.lblSelectedOperation.Text = "Selected Operation"
        '
        'lblOperation
        '
        Me.lblOperation.AutoSize = True
        Me.lblOperation.Location = New System.Drawing.Point(69, 159)
        Me.lblOperation.Name = "lblOperation"
        Me.lblOperation.Size = New System.Drawing.Size(53, 13)
        Me.lblOperation.TabIndex = 6
        Me.lblOperation.Text = "Operation"
        '
        'lblOutput
        '
        Me.lblOutput.AutoSize = True
        Me.lblOutput.Location = New System.Drawing.Point(65, 297)
        Me.lblOutput.Name = "lblOutput"
        Me.lblOutput.Size = New System.Drawing.Size(39, 13)
        Me.lblOutput.TabIndex = 7
        Me.lblOutput.Text = "Output"
        '
        'lblResult
        '
        Me.lblResult.AutoSize = True
        Me.lblResult.Location = New System.Drawing.Point(8, 297)
        Me.lblResult.Name = "lblResult"
        Me.lblResult.Size = New System.Drawing.Size(40, 13)
        Me.lblResult.TabIndex = 8
        Me.lblResult.Text = "Result:"
        '
        'lblDateTime
        '
        Me.lblDateTime.AutoSize = True
        Me.lblDateTime.BackColor = System.Drawing.SystemColors.ButtonShadow
        Me.lblDateTime.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblDateTime.Location = New System.Drawing.Point(241, 9)
        Me.lblDateTime.Name = "lblDateTime"
        Me.lblDateTime.Size = New System.Drawing.Size(76, 13)
        Me.lblDateTime.TabIndex = 9
        Me.lblDateTime.Text = "DATE/TIME"
        '
        'lab2
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(390, 318)
        Me.Controls.Add(Me.lblDateTime)
        Me.Controls.Add(Me.lblResult)
        Me.Controls.Add(Me.lblOutput)
        Me.Controls.Add(Me.lblOperation)
        Me.Controls.Add(Me.lblSelectedOperation)
        Me.Controls.Add(Me.btnExit)
        Me.Controls.Add(Me.btnClear)
        Me.Controls.Add(Me.gbxOperationKeys)
        Me.Controls.Add(Me.gbxEnterValue)
        Me.Name = "lab2"
        Me.Text = "Matthew Hunt"
        Me.gbxEnterValue.ResumeLayout(False)
        Me.gbxEnterValue.PerformLayout()
        Me.gbxOperationKeys.ResumeLayout(False)
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents gbxEnterValue As GroupBox
    Friend WithEvents gbxOperationKeys As GroupBox
    Friend WithEvents BackgroundWorker1 As System.ComponentModel.BackgroundWorker
    Friend WithEvents tbxNumber1 As TextBox
    Friend WithEvents tbxNumber2 As TextBox
    Friend WithEvents lblNumber2 As Label
    Friend WithEvents lblNumber1 As Label
    Friend WithEvents btnMod As Button
    Friend WithEvents btnRound As Button
    Friend WithEvents btnPower As Button
    Friend WithEvents btnDivision As Button
    Friend WithEvents btnMultiply As Button
    Friend WithEvents btnSubtract As Button
    Friend WithEvents btnAdd As Button
    Friend WithEvents btnExit As Button
    Friend WithEvents btnClear As Button
    Friend WithEvents lblSelectedOperation As Label
    Friend WithEvents lblOperation As Label
    Friend WithEvents lblOutput As Label
    Friend WithEvents lblResult As Label
    Friend WithEvents lblDateTime As Label
End Class
