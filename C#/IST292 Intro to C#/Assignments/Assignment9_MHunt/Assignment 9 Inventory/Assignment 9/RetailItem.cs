using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Assignment_9
{
    class RetailItem
    {

        // private member variables
        private int _id;
        private int _units;
        private double _price;
        private string _description;

        // read-only properties
        public readonly string Description;
        public readonly int IdNumber;

        // properties
        public int Units { get; set; }
        public double Price { get; set; }

        // constructor
        // The constructor assigns member variables the ap
        // propriate parameter value
        public RetailItem(int id, int units, double price, string description)
        {
            _id = id;
            _units = units;
            _price = price;
            _description = description;
        }
    }
}
