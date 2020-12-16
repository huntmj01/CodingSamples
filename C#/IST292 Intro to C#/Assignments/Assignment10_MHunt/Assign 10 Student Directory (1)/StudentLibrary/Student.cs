using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentLibrary
{
    public abstract class Student
    {
        // fields
        private string _name;
        private string _id;

        // constructor
        public Student(string name, string id)
        {
            _name = name;
            _id = id;
        }

        // name property
        public string Name
        {
            get { return _name; }
            set { _name = value; }
        }

        // ID property
        public string ID
        {
            get { return _id;  }
            set { _id = value; }
        }

        // RequiredHours property (abstract)
        public abstract double RequiredHours { get; }

        public override string ToString()
        {
            return Name + " " + ID + " ";
        }
    }

}
