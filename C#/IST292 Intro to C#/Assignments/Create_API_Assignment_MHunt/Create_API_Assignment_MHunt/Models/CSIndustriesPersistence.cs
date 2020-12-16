using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.SQLite;

/* 
 * Name:    Matthew Hunt
 * Project: Create API Assignment
 * Date:    12/3/17
 * Purpose: Allows a user to manipulate a database of inventory items using an API.
 */
namespace Create_API_Assignment_MHunt.Models
{
    public class CSIndustriesPersistence
    {

        /// 
        /// constants to hold database info
        /// 
        private const String DB_NAME = "CSIndustries.db";
        private const String TABLE_INVENTORY = "Inventory";
        private const String COLUMN_ID = "Id";
        private const String COLUMN_PRODUCT_NAME = "productName";
        private const String COLUMN_QUANTITY = "quantity";
        private const String COLUMN_PRICE = "price";
        private const String COLUMN_DESCRIPTION = "description";
        private const String PARAMETER_PRODUCT_NAME = "@" + COLUMN_PRODUCT_NAME;
        private const String PARAMETER_QUANTITY = "@" + COLUMN_QUANTITY;
        private const String PARAMETER_PRICE = "@" + COLUMN_PRICE;
        private const String PARAMETER_DESCRIPTION = "@" + COLUMN_DESCRIPTION;
        private const String PARAMETER_ID = "@" + COLUMN_ID;
        private const String connectionString = "Data Source = |DataDirectory|\\" + DB_NAME + "; Version = 3";

        /// 
        /// fields to hold datadase connection
        /// 
        private SQLiteConnection conn;
        private SQLiteCommand comm;
        private SQLiteDataReader reader;
        private String sqlString;

        /// <summary>
        /// constructor
        /// </summary>
        public CSIndustriesPersistence()
        {
            // try to open connection to database
            try
            {
                conn = new SQLiteConnection();
                conn.ConnectionString = connectionString;
                conn.Open();
            }
            catch (Exception ex)
            {
                // log error
               Console.WriteLine("Error connecting to database.\n" + ex + "\nClosing...");
            }
        }

        /// <summary>
        /// retrieves all inventory from the database
        /// </summary>
        /// <returns></returns>
        public ArrayList GetInventory()
        {
            // create list to hold results
            ArrayList inventory = new ArrayList();

            // clear the reader
            reader = null;

            // create sql statement to get all from the inventory table
            sqlString = "SELECT * FROM " + TABLE_INVENTORY;

            // execute the query
            comm = new SQLiteCommand(sqlString, conn);
            reader = comm.ExecuteReader();

            // loop through the resutls
            while (reader.Read())
            {
                // add the current item to the list
                InventoryModel i = new InventoryModel();

                i.Id = reader.GetInt32(0);
                i.productName = reader.GetString(1);
                i.quantity = reader.GetInt32(2);
                i.price = reader.GetDouble(3);
                i.description = reader.GetString(4);

                inventory.Add(i);
            }

            // return the list
            return inventory;
        }

        /// <summary>
        /// retrieves a single inventory item
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public InventoryModel GetInventoryItem(int id)
        {
            // create an inventory item
            InventoryModel i = null;

            // create the query string to get the inventory with specified idea
            sqlString = "SELECT * FROM " + TABLE_INVENTORY + " WHERE " + COLUMN_ID + " = " + PARAMETER_ID;

            // exectue the query
            comm = new SQLiteCommand(sqlString, conn);
            comm.Parameters.AddWithValue(PARAMETER_ID, id);
            reader = comm.ExecuteReader();

            // loop through the results
            while (reader.Read())
            {
                i = new InventoryModel();

                i.Id = reader.GetInt32(0);
                i.productName = reader.GetString(1);
                i.quantity = reader.GetInt32(2);
                i.price = reader.GetDouble(3);
                i.description = reader.GetString(4);
            }

            // return the item
            return i;
        }

        /// <summary>
        /// adds an item to the inventory table
        /// </summary>
        /// <param name="inventory"></param>
        /// <returns></returns>
        public long AddInventoryItem(InventoryModel inventory)
        {
            // holds the id of the new inventory item
            long id = -1;

            // create the query to insert the inventory item
            sqlString = "INSERT INTO " + TABLE_INVENTORY + "(" + COLUMN_PRODUCT_NAME + ", " + COLUMN_QUANTITY + ", " +
                        COLUMN_PRICE + ", " + COLUMN_DESCRIPTION +" ) VALUES (" +
                        PARAMETER_PRODUCT_NAME + "," + PARAMETER_QUANTITY + "," + PARAMETER_PRICE + "," + PARAMETER_DESCRIPTION +")";

            // create the command to execute
            comm = new SQLiteCommand(sqlString, conn);
            comm.Parameters.AddWithValue(PARAMETER_PRODUCT_NAME, inventory.productName);
            comm.Parameters.AddWithValue(PARAMETER_QUANTITY, inventory.quantity);
            comm.Parameters.AddWithValue(PARAMETER_PRICE, inventory.price);
            comm.Parameters.AddWithValue(PARAMETER_DESCRIPTION, inventory.description);
            
            // try to execute the query
            try
            {
                comm.ExecuteNonQuery();
                sqlString = "SELECT last_insert_rowid()";
                comm = new SQLiteCommand(sqlString, conn);
                id = (long) comm.ExecuteScalar();
            }
            catch (Exception ex)
            {

            }

            // return the new inventory items id
            return id;
        }

        /// <summary>
        /// removes an item from the inventory table
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public bool DeleteInventoryItem(long id)
        {

            // holds whether item was deleted
            bool isDeleted = false;

            // create the query to delte the inventory with the specified id
            sqlString = "DELETE FROM " + TABLE_INVENTORY + " WHERE " + COLUMN_ID + " = " + PARAMETER_ID;

            // execute the query
            comm = new SQLiteCommand(sqlString, conn);
            comm.Parameters.AddWithValue(PARAMETER_ID, id);

            if (comm.ExecuteNonQuery() > 0)
            {
                isDeleted = true;
            }

            // return whether the item was deleted
            return isDeleted;

        }

        public bool UpdateInventoryItem(long id, InventoryModel inventory)
        {

            // holds whether item was updated
            bool isUpdated = false;

            // create the query to update the specified item
            sqlString = "UPDATE " + TABLE_INVENTORY +
                        " SET " + COLUMN_PRODUCT_NAME + "=" + PARAMETER_PRODUCT_NAME + ", " +
                        COLUMN_QUANTITY + "=" + PARAMETER_QUANTITY + ", " +
                        COLUMN_PRICE + "=" + PARAMETER_PRICE + ", " + COLUMN_DESCRIPTION + "=" + PARAMETER_DESCRIPTION +
                        " WHERE " + COLUMN_ID + "=" + PARAMETER_ID;

            // create the command to execute
            comm = new SQLiteCommand(sqlString, conn);
            comm.Parameters.AddWithValue(PARAMETER_ID, inventory.Id);
            comm.Parameters.AddWithValue(PARAMETER_PRODUCT_NAME, inventory.productName);
            comm.Parameters.AddWithValue(PARAMETER_QUANTITY, inventory.quantity);
            comm.Parameters.AddWithValue(PARAMETER_PRICE, inventory.price);
            comm.Parameters.AddWithValue(PARAMETER_DESCRIPTION, inventory.description);

            // execute the query
            if (comm.ExecuteNonQuery() > 0)
            {
                isUpdated = true;
            }

            // return whether the item was updated
            return isUpdated;

        }
    }
}