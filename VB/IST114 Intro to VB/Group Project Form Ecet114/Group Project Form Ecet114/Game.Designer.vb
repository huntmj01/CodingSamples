<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class frmGame
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(frmGame))
        Me.pbxUserSelection = New System.Windows.Forms.PictureBox()
        Me.pbxComputerSelection = New System.Windows.Forms.PictureBox()
        Me.rbnRock = New System.Windows.Forms.RadioButton()
        Me.rbnPaper = New System.Windows.Forms.RadioButton()
        Me.rbnScissors = New System.Windows.Forms.RadioButton()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.btnClose = New System.Windows.Forms.Button()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.lblRoundWinner = New System.Windows.Forms.Label()
        Me.lblPlayerWins = New System.Windows.Forms.Label()
        Me.lblComputerWins = New System.Windows.Forms.Label()
        Me.tmrGameClock = New System.Windows.Forms.Timer(Me.components)
        Me.gbxSelection = New System.Windows.Forms.GroupBox()
        Me.lblGameClock = New System.Windows.Forms.Label()
        CType(Me.pbxUserSelection, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.pbxComputerSelection, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.gbxSelection.SuspendLayout()
        Me.SuspendLayout()
        '
        'pbxUserSelection
        '
        Me.pbxUserSelection.Image = CType(resources.GetObject("pbxUserSelection.Image"), System.Drawing.Image)
        Me.pbxUserSelection.InitialImage = CType(resources.GetObject("pbxUserSelection.InitialImage"), System.Drawing.Image)
        Me.pbxUserSelection.Location = New System.Drawing.Point(15, 64)
        Me.pbxUserSelection.Name = "pbxUserSelection"
        Me.pbxUserSelection.Size = New System.Drawing.Size(108, 105)
        Me.pbxUserSelection.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.pbxUserSelection.TabIndex = 0
        Me.pbxUserSelection.TabStop = False
        '
        'pbxComputerSelection
        '
        Me.pbxComputerSelection.Image = Global.Group_Project_Form_Ecet114.My.Resources.Resources.paper
        Me.pbxComputerSelection.Location = New System.Drawing.Point(145, 64)
        Me.pbxComputerSelection.Name = "pbxComputerSelection"
        Me.pbxComputerSelection.Size = New System.Drawing.Size(115, 105)
        Me.pbxComputerSelection.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.pbxComputerSelection.TabIndex = 1
        Me.pbxComputerSelection.TabStop = False
        '
        'rbnRock
        '
        Me.rbnRock.AutoSize = True
        Me.rbnRock.Checked = True
        Me.rbnRock.Location = New System.Drawing.Point(6, 17)
        Me.rbnRock.Name = "rbnRock"
        Me.rbnRock.Size = New System.Drawing.Size(51, 17)
        Me.rbnRock.TabIndex = 2
        Me.rbnRock.TabStop = True
        Me.rbnRock.Text = "Rock"
        Me.rbnRock.UseVisualStyleBackColor = True
        '
        'rbnPaper
        '
        Me.rbnPaper.AutoSize = True
        Me.rbnPaper.Location = New System.Drawing.Point(93, 17)
        Me.rbnPaper.Name = "rbnPaper"
        Me.rbnPaper.Size = New System.Drawing.Size(53, 17)
        Me.rbnPaper.TabIndex = 3
        Me.rbnPaper.TabStop = True
        Me.rbnPaper.Text = "Paper"
        Me.rbnPaper.UseVisualStyleBackColor = True
        '
        'rbnScissors
        '
        Me.rbnScissors.AutoSize = True
        Me.rbnScissors.Location = New System.Drawing.Point(187, 19)
        Me.rbnScissors.Name = "rbnScissors"
        Me.rbnScissors.Size = New System.Drawing.Size(64, 17)
        Me.rbnScissors.TabIndex = 4
        Me.rbnScissors.TabStop = True
        Me.rbnScissors.Text = "Scissors"
        Me.rbnScissors.UseVisualStyleBackColor = True
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(12, 9)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(61, 13)
        Me.Label1.TabIndex = 5
        Me.Label1.Text = "Roshambo!"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(12, 48)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(42, 13)
        Me.Label2.TabIndex = 6
        Me.Label2.Text = "Player: "
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(142, 48)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(58, 13)
        Me.Label3.TabIndex = 7
        Me.Label3.Text = "Computer: "
        '
        'btnClose
        '
        Me.btnClose.Location = New System.Drawing.Point(185, 266)
        Me.btnClose.Name = "btnClose"
        Me.btnClose.Size = New System.Drawing.Size(75, 23)
        Me.btnClose.TabIndex = 8
        Me.btnClose.Text = "Close"
        Me.btnClose.UseVisualStyleBackColor = True
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(12, 234)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(79, 13)
        Me.Label4.TabIndex = 9
        Me.Label4.Text = "Round Winner:"
        '
        'lblRoundWinner
        '
        Me.lblRoundWinner.AutoSize = True
        Me.lblRoundWinner.Location = New System.Drawing.Point(97, 234)
        Me.lblRoundWinner.Name = "lblRoundWinner"
        Me.lblRoundWinner.Size = New System.Drawing.Size(64, 13)
        Me.lblRoundWinner.TabIndex = 10
        Me.lblRoundWinner.Text = "First Round!"
        '
        'lblPlayerWins
        '
        Me.lblPlayerWins.AutoSize = True
        Me.lblPlayerWins.Location = New System.Drawing.Point(60, 48)
        Me.lblPlayerWins.Name = "lblPlayerWins"
        Me.lblPlayerWins.Size = New System.Drawing.Size(13, 13)
        Me.lblPlayerWins.TabIndex = 11
        Me.lblPlayerWins.Text = "0"
        '
        'lblComputerWins
        '
        Me.lblComputerWins.AutoSize = True
        Me.lblComputerWins.Location = New System.Drawing.Point(206, 48)
        Me.lblComputerWins.Name = "lblComputerWins"
        Me.lblComputerWins.Size = New System.Drawing.Size(13, 13)
        Me.lblComputerWins.TabIndex = 12
        Me.lblComputerWins.Text = "0"
        '
        'tmrGameClock
        '
        Me.tmrGameClock.Interval = 1000
        '
        'gbxSelection
        '
        Me.gbxSelection.Controls.Add(Me.rbnRock)
        Me.gbxSelection.Controls.Add(Me.rbnPaper)
        Me.gbxSelection.Controls.Add(Me.rbnScissors)
        Me.gbxSelection.Location = New System.Drawing.Point(19, 184)
        Me.gbxSelection.Name = "gbxSelection"
        Me.gbxSelection.Size = New System.Drawing.Size(251, 47)
        Me.gbxSelection.TabIndex = 13
        Me.gbxSelection.TabStop = False
        Me.gbxSelection.Text = "Selection"
        '
        'lblGameClock
        '
        Me.lblGameClock.AutoSize = True
        Me.lblGameClock.Location = New System.Drawing.Point(231, 9)
        Me.lblGameClock.Name = "lblGameClock"
        Me.lblGameClock.Size = New System.Drawing.Size(34, 13)
        Me.lblGameClock.TabIndex = 14
        Me.lblGameClock.Text = "Clock"
        '
        'frmGame
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(282, 301)
        Me.Controls.Add(Me.lblGameClock)
        Me.Controls.Add(Me.gbxSelection)
        Me.Controls.Add(Me.lblComputerWins)
        Me.Controls.Add(Me.lblPlayerWins)
        Me.Controls.Add(Me.lblRoundWinner)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.btnClose)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.pbxComputerSelection)
        Me.Controls.Add(Me.pbxUserSelection)
        Me.Name = "frmGame"
        Me.Text = "Roshambo"
        CType(Me.pbxUserSelection, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.pbxComputerSelection, System.ComponentModel.ISupportInitialize).EndInit()
        Me.gbxSelection.ResumeLayout(False)
        Me.gbxSelection.PerformLayout()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents pbxUserSelection As PictureBox
    Friend WithEvents pbxComputerSelection As PictureBox
    Friend WithEvents rbnRock As RadioButton
    Friend WithEvents rbnPaper As RadioButton
    Friend WithEvents rbnScissors As RadioButton
    Friend WithEvents Label1 As Label
    Friend WithEvents Label2 As Label
    Friend WithEvents Label3 As Label
    Friend WithEvents btnClose As Button
    Friend WithEvents Label4 As Label
    Friend WithEvents lblRoundWinner As Label
    Friend WithEvents lblPlayerWins As Label
    Friend WithEvents lblComputerWins As Label
    Friend WithEvents tmrGameClock As Timer
    Friend WithEvents gbxSelection As GroupBox
    Friend WithEvents lblGameClock As Label
End Class
