using System;
using System.Data;
using System.Data.SQLite;
using System.IO;

/* 
 * Name:    Matthew Hunt
 * Project: Final Project
 * Date:    12/6/2017
 * Purpose: Allows a user to delete a folder and view/edit delete history.
 */
namespace IST_292_Final_Project
{
    class TerminatorDBUtils
    {

        ///
        /// private const fields
        /// 
        private const string CONNECTION_STRING = "Data Source = FolderTerminator.db";
        private const string HISTORY_TABLE = "TerminationHistory";
        private const string ID_COLUMN = "Id";
        private const string PATH_COLUMN = "Path";
        private const string DATE_DELETED_COLUMN = "DateDeleted";
        private const string SUCCESS_COLUMN = "Success";
        private const string ID_PARAMETER = "@id";
        private const string PATH_PARAMETER = "@path";
        private const string DATE_DELETED_PARAMETER = "@datedeleted";
        private const string SUCCESS_PARAMETER = "@success";
        private const string LOG_FILENAME = "log.error";

        ///
        /// private fields to hold database connection info
        /// 
        private SQLiteConnection conn;
        private SQLiteCommand comm;
        private SQLiteDataAdapter da;
        private DataSet ds;
        private string SQL;

        ///
        /// public field to hold database status
        /// 
        private string mLastStatus { get; set;  }

        /// <summary>
        /// CRUD - CREATE
        /// Creates a record in the history table
        /// </summary>
        /// <param name="pPath"></param>
        /// <param name="pDate"></param>
        /// <param name="pSuccess"></param>
        /// <returns></returns>
        public bool AddHistory(string pPath, DateTime pDate, bool pSuccess)
        {
            // holds whether insert was successful
            bool result = true;

            // write the sql statement
            SQL = "INSERT INTO " + HISTORY_TABLE + "(" + PATH_COLUMN + ", " + DATE_DELETED_COLUMN + ", " + SUCCESS_COLUMN + ")"
                  + "VALUES(" + PATH_PARAMETER + "," + DATE_DELETED_PARAMETER + "," + SUCCESS_PARAMETER + ");";

            // try to insert into db
            try
            {
                // make the connection
                using (conn = new SQLiteConnection(CONNECTION_STRING))
                {
                    conn.Open();

                    using (comm = new SQLiteCommand(SQL, conn))
                    {
                        // insert parameters
                        comm.Parameters.AddWithValue(PATH_PARAMETER, pPath);
                        comm.Parameters.AddWithValue(DATE_DELETED_PARAMETER, pDate);
                        comm.Parameters.AddWithValue(SUCCESS_PARAMETER, pSuccess);

                        // execute the query
                        comm.ExecuteNonQuery();
                        mLastStatus = "Record added to database";
                    }
                }
            }
            catch (Exception ex)
            {
                // log any errors
                result = false;
                LogError(ex.Message);
                mLastStatus = "Error adding to database, check " + LOG_FILENAME + " for details.";
            }

            return result;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="pId"></param>
        /// <returns></returns>
        public DataTable GetById(long pId)
        {
            SQL = "SELECT * FROM " + HISTORY_TABLE + " WHERE " + ID_COLUMN + " = " + ID_PARAMETER;

            try
            {
                using (conn = new SQLiteConnection(CONNECTION_STRING))
                {
                    conn.Open();

                    using (da = new SQLiteDataAdapter(SQL, conn))
                    {
                        da.SelectCommand.Parameters.AddWithValue(ID_PARAMETER, pId);

                        using (ds = new DataSet())
                        {
                            ds.Clear();
                            da.Fill(ds);
                            return ds.Tables[0];
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                // log any errors
                LogError(ex.Message);
                mLastStatus = "Error reading database, check " + LOG_FILENAME + " for details.";
                return null;
            }
        }

        /// <summary>
        /// CRUD - UPDATE
        /// Updates a history item in the database
        /// </summary>
        /// <param name="pId"></param>
        /// <param name="pPath"></param>
        /// <param name="pDate"></param>
        /// <param name="pSuccess"></param>
        /// <returns></returns>
        public bool EditHistory(long pId, string pPath, DateTime pDate, bool pSuccess)
        {
            bool result = true;

            SQL = "UPDATE " + HISTORY_TABLE + " SET " +
                  PATH_COLUMN + " = " + PATH_PARAMETER + ", " + DATE_DELETED_COLUMN +
                  " = " + DATE_DELETED_PARAMETER + ", " + SUCCESS_COLUMN + " = " + SUCCESS_PARAMETER +
                  " WHERE " + ID_COLUMN + " = " + ID_PARAMETER;

            try
            {
                using (conn = new SQLiteConnection(CONNECTION_STRING))
                {
                    conn.Open();

                    using (comm = new SQLiteCommand(SQL, conn))
                    {
                        comm.Parameters.AddWithValue(ID_PARAMETER, pId);
                        comm.Parameters.AddWithValue(PATH_PARAMETER, pPath);
                        comm.Parameters.AddWithValue(DATE_DELETED_PARAMETER, pDate);
                        comm.Parameters.AddWithValue(SUCCESS_PARAMETER, pSuccess);

                        comm.ExecuteNonQuery();
                        mLastStatus = "Record updated";
                    }
                }
            }
            catch (Exception ex)
            {
                // log any errors
                result = false;
                LogError(ex.Message);
                mLastStatus = "Error updating database, check " + LOG_FILENAME + " for details.";
            }

            return result;
        }

        /// <summary>
        /// CRUD - READ
        /// </summary>
        /// <returns></returns>
        public DataTable GetAllHistory()
        {
            SQL = "SELECT * FROM " + HISTORY_TABLE + " ORDER BY " + ID_COLUMN;

            try
            {
                using (conn = new SQLiteConnection(CONNECTION_STRING))
                {
                    conn.Open();

                    using (da = new SQLiteDataAdapter(SQL, conn))
                    {
                        using (ds = new DataSet())
                        {
                            ds.Clear();
                            da.Fill(ds);
                            return ds.Tables[0];
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                LogError(ex.Message);
                mLastStatus = "Error selecting all database, check " + LOG_FILENAME + " for details.";
                return null;
            }
            
        }

        /// <summary>
        /// CRUD - DELETE
        /// </summary>
        /// <param name="pId"></param>
        /// <returns></returns>
        public bool DeleteHistory(long pId)
        {
            bool result = true;

            SQL = "DELETE FROM " + HISTORY_TABLE + " WHERE " + ID_COLUMN + " = " + ID_PARAMETER; ;

            try
            {
                using (conn = new SQLiteConnection(CONNECTION_STRING))
                {
                    conn.Open();

                    using (comm = new SQLiteCommand(SQL, conn))
                    {
                        comm.Parameters.AddWithValue(ID_PARAMETER, pId);
                        comm.ExecuteNonQuery();
                        mLastStatus = "Record deleted";
                    }
                }
            }
            catch (Exception ex)
            {
                LogError(ex.Message);
                mLastStatus = "Error deleteing from database, check " + LOG_FILENAME + " for details.";
                result = false;
            }

            return result;
        }

        /// <summary>
        /// writes the specified string to the log file
        /// </summary>
        /// <param name="error">error: the error to log</param>
        private void LogError(String error)
        {
            // write to file
            StreamWriter outputFile;
            outputFile = File.AppendText(LOG_FILENAME);
            outputFile.WriteLine("[ERROR " + DateTime.Now + "]: " + error);

            // close the file
            outputFile.Close();
        }

    }
}
