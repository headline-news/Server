package cn.xinxing.service.news;

import java.util.List;

import cn.xinxing.model.News;

/**
 * 
 */
public interface NewService {
	public List<News> getAllNews();
	public void addData(String _id, String _ip);
	public void deleteData(String _id, String _ip);
}
