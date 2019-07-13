using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using uniondemo.com.allinpay.syb;

namespace uniondemo
{
    public partial class Notify : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Dictionary<String, String> reqParams = new Dictionary<String, String>();
            /**
             * 此处注意,因为通联收银宝以后可能增加字段,所以,这里一定要动态遍历获取所有的请求参数
             * 
             * */
            for (int i = 0; i < Request.Form.Count; i++)
            {
                reqParams.Add(Request.Form.Keys[i], Request.Form[i].ToString());
            }   
            if (!reqParams.ContainsKey("sign"))//如果不包含sign,则不进行处理
            {
                Response.Write("error");
                return;
            }
            if (AppUtil.validSign(reqParams,AppConstants.APPKEY))//验签成功
            {
                //验签成功后,进行业务处理,处理完毕返回成功
                Response.Write("success");
            }
            else
            {
                Response.Write("error");
            }
        }
    }
}