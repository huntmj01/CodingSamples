using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Assignment_9
{
    class Inventory
    {
        // member variable
        List<RetailItem> _items;

        // string property
        public string LastStatus { get; set; }

        // The constructor initializes the list object
        public Inventory()
        {
            _items = new List<RetailItem>();
        }

        // Add a method that returns a List of RetailItem.
        public List<RetailItem> Items()
        {
            // creates and returns a deep copy of the list
            List<RetailItem> items = new List<RetailItem>();

            foreach (RetailItem item in _items)
            {
                items.Add(item);
            }

            return items;
        }

        // calculates sum of each retail items price x units
        public double TotalCostOfGood()
        {
            double sum = 0;

            foreach (RetailItem item in _items)
            {
                sum += item.Units * item.Price;
            }

            return sum;
        }

        // adds item to list
        public void AddItem(RetailItem item)
        {

            bool exists = false;

            foreach (RetailItem it in _items)
            {
                // check if the id number of the parameter is already in the list
                if (it.IdNumber == item.IdNumber)
                {
                    exists = true;
                }
            }

            if (exists)
            {
                LastStatus = "ID number already exists";
            }
            else
            {
                // add item to list
                _items.Add(item);
                LastStatus = "Item added to inventory";
            }

        }

        // removes an item from the list
        public void DeleteItem(int id)
        {

            foreach (RetailItem it in _items)
            {
                if (it.IdNumber == id)
                {
                    // If the id number is in the list,check if the units is 0
                    if (it.Units == 0)
                    {
                        _items.Remove(it);
                        LastStatus = "Item Deleted";
                    }
                    else
                    {
                        LastStatus = "Item cannot be deleted";
                    }
                }
            }

        }
        
        // updates item in list
        public void UpdateItem(RetailItem item)
        {
            bool found = false;

            foreach (RetailItem it in _items)
            {
                if (it.IdNumber == item.IdNumber)
                {
                    var indexOf = _items.IndexOf(it);
                    _items.RemoveAt(indexOf);
                    _items.Add(item);
                    found = true;
                    LastStatus = "Item Updated";
                }
            }

            if (!found)
            {
                LastStatus = "No matching item with id as a parameter " + item.IdNumber;
            }
        }

        // gets item in list with specified id
        public RetailItem GetItem(int id)
        {
            RetailItem item = null;

            foreach (RetailItem it in _items)
            {
                if (it.IdNumber == id)
                {
                    item = new RetailItem(it.IdNumber, it.Units, it.Price, it.Description);
                }
            }

            return item;
        }

    }
}
