using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentLibrary
{
    public class GraduateStudent : Student, IMajor, IRequiredHours
    {

        private string _previousDegree;

        // constructor
        public GraduateStudent(string name, string id, string major, int requiredHours, string previousDegree) : base(name, id)
        {
            Name = name;
            ID = id;
            Major = major;
            RequiredHours = requiredHours;
            _previousDegree = previousDegree;
        }

        // Property
        // previous degree property
        public string PreviousDegree
        {
            get { return _previousDegree; }
            set { _previousDegree = value; }
        }

        public override double RequiredHours { get; }
        public string Major { get; set; }

        int IRequiredHours.RequiredHours {get;set;}

        // methods
        public override string ToString()
        {
            return base.ToString() + " " + PreviousDegree + " " + RequiredHours;
        }
    }
}
