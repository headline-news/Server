package cn.xinxing.action.news;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xinxing.business.NewBusiness;
import cn.xinxing.json.core.ListObject;
import cn.xinxing.json.responseUtils.ResponseUtils;
import cn.xinxing.json.status.StatusHouse;
import cn.xinxing.json.utils.JackJsonUtils;
import cn.xinxing.model.News;

/**
 * Servlet implementation class NewInq
 */
@WebServlet("/NewInq")
public class NewInq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewInq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//System.out.println("GET request.getRemoteAddr():    "    +    request.getRemoteAddr());   
		List<News> list = NewBusiness.getAllNews();
		ListObject listObject=new ListObject();
		listObject.setItems(list);
		listObject.setStatusObject(StatusHouse.COMMON_STATUS_OK);
		String responseText = JackJsonUtils.toJson(listObject);
		ResponseUtils.renderJson(response, responseText);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		String ipAddr = request.getRemoteAddr();
		String id = request.getParameter("id");
		String ip = request.getParameter("ip");
		
		if(type == "delete") {
			NewBusiness.deleteData(id, ip);
		} else if(type == "add") {
			NewBusiness.addData(id, ipAddr);
		}

		System.out.println("POST request.getRemoteAddr():    "    +    ipAddr);   
		// doGet(request, response);
	}

}
