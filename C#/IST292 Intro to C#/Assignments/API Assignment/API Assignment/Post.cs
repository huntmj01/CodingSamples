using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace API_Assignment
{
    class Post
    {

        public String SchoolName { get; set; }
        public String Phone { get; set; }
        public String Url { get; set; }

        public override string ToString()
        {
            return "Name: " + SchoolName + ", Phone: " + Phone + ", URL:" + Url;
        }


    }
}
