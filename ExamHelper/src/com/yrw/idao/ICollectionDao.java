package com.yrw.idao;

import java.util.List;

import com.yrw.domains.Collection;
import com.yrw.domains.Scollection;

import net.sf.cglib.transform.impl.AddDelegateTransformer;

/**
 * 
 * 项目名称：ExamHelper 类名称：ICollectionDao 类描述： 针对收藏的有关操作的接口类，继承了IBasicDao 创建人：叶睿雯
 * 创建时间：2014-03-15 修改人： 修改时间： 修改备注：
 * 
 * @version
 * 
 */

public interface ICollectionDao extends IBasicDao {

	/**
	 * Method getCollectionByUser 得到某位用户收藏信息
	 * 
	 * @param userId
	 * @param pageNow
	 * @return List
	 */
	public List getCollectionByUser(int userId, int pageNow);

	/**
	 * 根据用户ID返回笔记列表
	 * @param userId
	 * @return
	 */
	public List<Collection> getCollectionByUser(int userId);

	/**
	 * Method getPageCountByUser 得到某位用户收藏信息页数
	 * 
	 * @param userId
	 * @param pageNow
	 * @return List
	 */
	public int getPageCountByUser(int userId);

	/**
	 * Method addCollection 增加收藏信息
	 * 
	 * @param JCollection
	 * @return void
	 */
	public void addCollection(Collection collection);

	/**
	 * Method delCollection 删除收藏信息
	 * 
	 * @param JCollection
	 * @return void
	 */
	public void delCollection(Collection collection);

	public List<Collection> getCollectionList();
	
	public int getSCollectionListPageCount();
	
	public List<Scollection> getScollectionListByPage(int pageNow);
}
