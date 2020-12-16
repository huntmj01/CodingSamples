using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentLibrary
{
    public class UndergraduateStudent : Student, IMajor, IRequiredHours
    {

        private string _academicStatus;

        // constructor
        public UndergraduateStudent(string name, string id, string major, int requiredHours, string status) : base(name, id)
        {
            Name = name;
            ID = id;
            Major = major;
            RequiredHours = requiredHours;
            _academicStatus = status;
        }

        // Property
        // acadmic status property
        public string AcademicStatus
        {
            get { return _academicStatus; }
            set { _academicStatus = value; }
        }

        public override double RequiredHours { get; }
        public string Major { get; set; }

        int IRequiredHours.RequiredHours
        {
            get;
            set;
        }

        // methods
        public override string ToString()
        {
            return base.ToString() + " " + AcademicStatus + " " + RequiredHours;
        }
    }
}
