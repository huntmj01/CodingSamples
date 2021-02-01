using System;
using System.Collections;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Create_API_Assignment_MHunt.Models;

/* 
 * Name:    Matthew Hunt
 * Project: Create API Assignment
 * Date:    12/3/17
 * Purpose: Allows a user to manipulate a database of inventory items using an API.
 */
namespace Create_API_Assignment_MHunt.Controllers
{
    public class InventoryController : ApiController
    {
         
        ///
        /// filed to hold persitence class
        /// 
        CSIndustriesPersistence persistence = new CSIndustriesPersistence();

        // GET: api/Inventory
        public ArrayList Get()
        {
            return persistence.GetInventory();
        }

        // GET: api/Inventory/5
        public InventoryModel Get(int id)
        {
            InventoryModel i = new InventoryModel();
            i = persistence.GetInventoryItem(id);
            return i;
        }

        // POST: api/Inventory
        public HttpResponseMessage Post([FromBody]InventoryModel value)
        {
            HttpResponseMessage response = Request.CreateResponse(HttpStatusCode.Created);

            long id = persistence.AddInventoryItem(value);

            response.Headers.Location = new Uri(Request.RequestUri.ToString() + "/" + id);

            return response;
        }

        // PUT: api/Inventory/5
        public HttpResponseMessage Put(int id, [FromBody]InventoryModel value)
        {
            HttpResponseMessage response;

            bool isUpdated = persistence.UpdateInventoryItem(id, value);

            if (isUpdated)
            {
                response = Request.CreateResponse(HttpStatusCode.NoContent);
            }
            else
            {
                response = Request.CreateResponse(HttpStatusCode.NotFound);
            }

            return response;
        }

        // DELETE: api/Inventory/5
        public HttpResponseMessage Delete(int id)
        {
            HttpResponseMessage response;

            bool isDeleted = persistence.DeleteInventoryItem(id);

            if (isDeleted)
            {
                response = Request.CreateResponse(HttpStatusCode.NoContent);
            }
            else
            {
                response = Request.CreateResponse(HttpStatusCode.NotFound);
            }

            return response;
        }
    }
}
