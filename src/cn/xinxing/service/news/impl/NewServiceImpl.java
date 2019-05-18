package cn.xinxing.service.news.impl;
import java.util.List;

import cn.xinxing.business.NewBusiness;
import cn.xinxing.model.News;
import cn.xinxing.service.news.NewService;


public class NewServiceImpl implements NewService{
	@Override

	public int getYesCount(String _id) {
		return NewBusiness.getYesCount(_id);
	}
	public Boolean getYesStatus(String _id, String _ip) {
		return NewBusiness.getYesStatus(_id, _ip);
	}
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return NewBusiness.getAllNews();
	}
	
	public void addData(String _id, String _ip) {
		NewBusiness.addData(_id, _ip);
	}
	
	public void deleteData(String _id, String _ip) {
		NewBusiness.deleteData(_id, _ip);
	}
}
