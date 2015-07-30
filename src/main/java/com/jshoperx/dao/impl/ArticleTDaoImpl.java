package com.jshoperx.dao.impl;

import com.jshoperx.dao.ArticleTDao;
import com.jshoperx.entity.ArticleT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * ArticleT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshoperx.entity.ArticleT
 * @author MyEclipse Persistence Tools
 */
@Repository("articleTDao")
public class ArticleTDaoImpl extends BaseTDaoImpl<ArticleT> implements ArticleTDao {

	private static final Logger log = LoggerFactory.getLogger(ArticleTDaoImpl.class);

	
}