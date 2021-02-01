using StudentLibrary;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Student_Directory
{
    public partial class MainForm : Form
    {
        private const String TXT_SPECIAL = "txtSpecial";
        private List<Student> students;

        private enum RadioButtonNames
        {
            Undergraduate,
            Graduate,
            Audit
        }

        public MainForm()
        {
            InitializeComponent();
        }

        private void radioButtons_CheckedChanged(object sender, EventArgs e)
        {
            RadioButton rb = (RadioButton)sender;
            int buttonid = int.Parse(rb.Tag.ToString());
            String txt = "";
            txtSpecial.Visible = true;
            txtMajor.Visible = true;
            lblMajor.Visible = true;

            switch (buttonid)
            {
                case (int)RadioButtonNames.Undergraduate :
                    txt = "Academic Status:";
                    break;
                case (int)RadioButtonNames.Graduate :
                    txt = "Previous Degree:";
                    break;
                case (int)RadioButtonNames.Audit:
                    txt = "";
                    txtSpecial.Visible = false;
                    txtMajor.Visible = false;
                    lblMajor.Visible = false;
                    break;
            }

            lblSpecial.Text = txt;
        }


        private void mnuItemViewAll_Click(object sender, EventArgs e)
        {
            lstStudents.Items.Clear();
            //display all students
            foreach (Student stu in students)
            {
                lstStudents.Items.Add(stu.ToString());
            }
        }

        private void mnuItemViewUndergrad_Click(object sender, EventArgs e)
        {
            lstStudents.Items.Clear();
            //display undergraduate students
            foreach (Student stu in students)
            {
                if (stu is UndergraduateStudent)
                {
                    lstStudents.Items.Add(stu.ToString());
                }
            }
        }

        private void mnuItemViewGrad_Click(object sender, EventArgs e)
        {
            lstStudents.Items.Clear();
            //display graduate students
            foreach (Student stu in students)
            {
                if (stu is GraduateStudent)
                {
                    lstStudents.Items.Add(stu.ToString());
                }
            }
        }


        private void mnuItemViewAudit_Click(object sender, EventArgs e)
        {
            lstStudents.Items.Clear();
            //display audit students
            foreach (Student stu in students)
            {
                if (stu is AuditStudent)
                {
                    lstStudents.Items.Add(stu.ToString());
                }
            }
        }

        private void MainForm_Load(object sender, EventArgs e)
        {
            students = new List<Student>();

            //Add students to list

            GraduateStudent gradStudent1 = new GraduateStudent("Joe Jones","123", "BA", 36, "Computer Science");
            GraduateStudent gradStudent2 = new GraduateStudent("Miranda Merkler", "456", "BS", 30, "Computer Science");

            UndergraduateStudent undergradStudent1 = new UndergraduateStudent("Kathy Klum", "234", "BA", 120, "Probation");
            UndergraduateStudent undergradStudent2 = new UndergraduateStudent("Larry Lewis", "345", "BA", 30, "Satisfactory");

            AuditStudent auditStudent1 = new AuditStudent("Norman Nelson", "567", 0);
            AuditStudent auditStudent2 = new AuditStudent("Otto Olson", "678", 6);

            students.Add(gradStudent1);
            students.Add(gradStudent2);
            students.Add(undergradStudent1);
            students.Add(undergradStudent2);
            students.Add(auditStudent1);
            students.Add(auditStudent2);

        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnAdd_Click(object sender, EventArgs e)
        {
            lblStatus.Text = "";

            string aName = txtName.Text;
            string aId = txtID.Text;
            string major = txtMajor.Text;

            Student newStudent;

            int hours;

            if (!int.TryParse(txtCreditHours.Text, out hours) || hours < 0)
            {
                lblStatus.Text = "Credit hours not valid";
                txtCreditHours.Focus();
                return;
            }

            if (radUndergraduate.Checked)
            {
                string status = txtSpecial.Text;
                //instantiate newStudent
                newStudent = new UndergraduateStudent(aName, aId, major, hours, status);

            }
            else if (radGraduate.Checked)
            {
                string degree = txtSpecial.Text;
                newStudent = new GraduateStudent(aName, aId, major, hours, degree);
            }
            else
            {
                //instantiate newStudent
                newStudent = new AuditStudent(aName, aId, hours);
            }

            students.Add(newStudent);

            lblStatus.Text = "Student has been added";

            ClearInputs();

        }

        private void mnuItemExit_Click(object sender, EventArgs e)
        {
            Close();
        }


        private void ClearInputs()
        {
            foreach (Control c in Controls)
            {
                if (c is TextBox)
                {
                    TextBox tb = (TextBox)c;
                    tb.Clear();
                    tb.Focus();
                }

                if (c is RadioButton)
                {
                    RadioButton rb = (RadioButton)c;
                    rb.Checked = false;
                }
            }
        }

    }
}
