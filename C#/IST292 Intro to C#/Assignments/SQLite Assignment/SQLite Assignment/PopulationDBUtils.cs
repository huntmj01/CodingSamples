using System;
using System.Data;
using System.Data.SQLite;

namespace SQLite_Assignment
{
    class PopulationDBUtils
    {
        private const string CONNECTION_STRING = "Data Source = ../../population.db;";
        private const string CITIES_TABLE = "Cities";
        private const string CITY_COLUMN = "City";
        private const string POPULATION_COLUMN = "Population";
        private const string CITY_PARAMETER = "@city";
        private const string POPULATION_PARAMETER = "@population";

        private SQLiteConnection conn;
        private SQLiteCommand comm;
        private SQLiteDataAdapter da;
        private DataSet ds;
        private string SQL;

        private string mLastStatus;

        public string LastStatus
        {
            get { return mLastStatus; }
        }

        public bool AddCity(string pCity, string pPopulation)
        {
            bool result = true;

            SQL = "INSERT INTO " + CITIES_TABLE + "(" + CITY_COLUMN + ", " + POPULATION_COLUMN + ")"
                  + "VALUES(" + CITY_PARAMETER + "," + POPULATION_PARAMETER + ");";

            try
            {
                using (conn = new SQLiteConnection(CONNECTION_STRING))
                {
                    conn.Open();

                    using (comm = new SQLiteCommand(SQL, conn))
                    {
                        comm.Parameters.AddWithValue(CITY_PARAMETER, pCity);
                        comm.Parameters.AddWithValue(POPULATION_PARAMETER, pPopulation);

                        comm.ExecuteNonQuery();
                        mLastStatus = "Record added to database";
                    }
                }
            }
            catch (Exception ex)
            {
                result = false;
                mLastStatus = "Error adding to database";
            }

            return result;
        }//end AddEmployee

        public bool EditCity(string pCity, string pPopulation)
        {
            bool result = true;

            SQL = "UPDATE " + CITIES_TABLE + " SET " +
                  POPULATION_COLUMN + " = " + POPULATION_PARAMETER +
                  " WHERE " + CITY_COLUMN + " = " + CITY_PARAMETER;

            try
            {
                using (conn = new SQLiteConnection(CONNECTION_STRING))
                {
                    conn.Open();

                    using (comm = new SQLiteCommand(SQL, conn))
                    {
                        comm.Parameters.AddWithValue(CITY_PARAMETER, pCity);
                        comm.Parameters.AddWithValue(POPULATION_PARAMETER, pPopulation);

                        comm.ExecuteNonQuery();
                        mLastStatus = "Record updated";
                    }
                }
            }
            catch (Exception ex)
            {
                result = false;
                mLastStatus = "Error updating record";
            }

            return result;
        }//end EditEmployee

        public bool DeleteCity(string pCity)
        {
            bool result = true;

            SQL = "DELETE FROM " + CITIES_TABLE + " WHERE " + CITY_COLUMN + " = " + CITY_PARAMETER; ;

            try
            {
                using (conn = new SQLiteConnection(CONNECTION_STRING))
                {
                    conn.Open();

                    using (comm = new SQLiteCommand(SQL, conn))
                    {
                        comm.Parameters.AddWithValue(CITY_PARAMETER, pCity);
                        comm.ExecuteNonQuery();
                        mLastStatus = "Record deleted";
                    }
                }
            }
            catch (Exception ex)
            {
                result = false;
                mLastStatus = "Error deleting";
            }

            return result;
        }

        public DataTable FindByCity(string pCity)
        {
            SQL = "SELECT * FROM " + CITIES_TABLE + " WHERE " + CITY_COLUMN + " = " + CITY_PARAMETER;

            try
            {
                using (conn = new SQLiteConnection(CONNECTION_STRING))
                {
                    conn.Open();

                    using (da = new SQLiteDataAdapter(SQL, conn))
                    {
                        da.SelectCommand.Parameters.AddWithValue(CITY_PARAMETER, pCity);

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
                return null;
            }
        }

        public DataTable GetAllCities()
        {
            SQL = "SELECT * FROM " + CITIES_TABLE + " ORDER BY " + CITY_COLUMN;

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
                return null;
            }
        }

        public Int64 GetTotalPopulation()
        {
            SQL = "SELECT SUM(" + POPULATION_COLUMN + ") FROM " + CITIES_TABLE;

            using (conn = new SQLiteConnection(CONNECTION_STRING))
            {
                conn.Open();

                using (comm = new SQLiteCommand(SQL, conn))
                {
                    var result = comm.ExecuteScalar();
                    return (Int64)result;
                }
            }
        }

        public double GetAveragePopulation()
        {
            SQL = "SELECT AVG(" + POPULATION_COLUMN + ") FROM " + CITIES_TABLE;

            using (conn = new SQLiteConnection(CONNECTION_STRING))
            {
                conn.Open();

                using (comm = new SQLiteCommand(SQL, conn))
                {
                    var result = comm.ExecuteScalar();
                    return (double)result;
                }
            }
        }

        //    public bool TestDatabaseConnection() {
        //        bool result = true;

        //        try {
        //            using (conn = new SQLiteConnection(CONNECTION_STRING)) {
        //                conn.Open();
        //            }
        //        } catch (Exception ex) {
        //            result = false;
        //            mLastStatus = "Error opening database";
        //        }

        //        return result;
        //    }
    }
}
