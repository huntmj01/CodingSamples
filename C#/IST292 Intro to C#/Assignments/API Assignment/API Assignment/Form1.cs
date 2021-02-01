using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Newtonsoft.Json;

namespace API_Assignment
{
    public partial class Form1 : Form
    {
        const String URL = "https://api.schooldigger.com/v1/schools/";
        private const String APP_ID = "9ab984d3";
        private const String API_KEY = "ec68b9c9e9277be56bf198fada342bdf";
        private const String HUNTINGTON_NORTH_SCHOOL_ID = "180471000786";

        public Form1()
        {
            InitializeComponent();
        }

        private void btnGetPosts_Click(object sender, EventArgs e)
        {
            WebClient client = new WebClient();

            String url = URL + tbxSchoolId.Text + "?appID=" + APP_ID + "&appKey=" + API_KEY;
            String response = client.DownloadString(url);
            tbxOutput.Text = response;

            Post thePost = deserializeJSON(response);

            tbxName.Text = thePost.SchoolName;
            tbxPhone.Text = thePost.Phone;
            tbxUrl.Text = thePost.Url;
        }

        private Post deserializeJSON(string JSON)
        {
            Post post = null;

            post = JsonConvert.DeserializeObject<Post>(JSON);

            return post;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            tbxSchoolId.Text = HUNTINGTON_NORTH_SCHOOL_ID;
        }
    }
}
