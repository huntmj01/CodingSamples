using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentLibrary
{
    public class AuditStudent : Student
    {
        private int _hoursTaken;

        public AuditStudent(string name, string id, int hoursTaken) : base(name, id)
        {
            Name = name;
            ID = id;
            _hoursTaken = hoursTaken;
        }

        public override double RequiredHours { get; }

        public override string ToString()
        {
            return base.ToString() + " " + _hoursTaken;
        }
    }
}
