using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/* 
 * Name:    Matthew Hunt
 * Project: Create API Assignment
 * Date:    12/3/17
 * Purpose: Allows a user to manipulate a database of inventory items using an API.
 */
namespace Create_API_Assignment_MHunt.Models
{
    public class InventoryModel
    {
        public int Id { get; set; }
        public string productName { get; set; }
        public int quantity { get; set; }
        public double price { get; set; }
        public string description { get; set; }
    }
}