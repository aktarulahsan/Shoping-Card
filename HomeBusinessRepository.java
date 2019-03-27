package com.mysoft.auth.homebusiness;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import com.mysoft.core.base.BaseRepository;
import com.mysoft.core.util.Response;


@Repository
@Transactional
public class HomeBusinessRepository extends BaseRepository{
	
	public Response save(String regObj) {
		HomeBusinessEntity homeBusinessEntity = objectMapperReadValue(regObj, HomeBusinessEntity.class);
		return baseOnlySave(homeBusinessEntity);
	}
	

	public Response list(String reqObj) {
		HomeBusinessEntity fatureEntity = objectMapperReadValue(reqObj, HomeBusinessEntity.class);
		return baseList(criteriaQuery(fatureEntity));
	}
	
	public List<HomeBusinessEntity> findByUserId(Long userId) {
		
		List<HomeBusinessEntity>  homeBusinessEntityList = null;
		
		HomeBusinessEntity homeBusinessEntity = new HomeBusinessEntity();
		
		//problem here ////
		homeBusinessEntity.setUserNo(userId);
		Response response = baseList(criteriaQuery(homeBusinessEntity));
		
		if(response.isSuccess() && response.getItems() !=null) {
			homeBusinessEntityList = getListFromObject(response.getItems(), HomeBusinessEntity.class);
		}
		
		return homeBusinessEntityList;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(HomeBusinessEntity filter) {
		init();

		List<Predicate> p = new ArrayList<Predicate>();
		p = criteriaCodtion(filter, null, null);

		if (!CollectionUtils.isEmpty(p)) {
			Predicate[] pArray = p.toArray(new Predicate[] {});
			Predicate predicate = builder.and(pArray);
			criteria.where(predicate);
		}
		return criteria;
	}

	@SuppressWarnings({ "unchecked" })
	private List<Predicate> criteriaCodtion(HomeBusinessEntity filter, CriteriaBuilder builder,
			Root<HomeBusinessEntity> root) {

		if (builder == null) {
			builder = super.builder;
		}
		if (root == null) {
			root = super.root;
		}

		List<Predicate> p = new ArrayList<Predicate>();
//problem here /////////
		if (filter != null) {
			if (filter.getHideFlag()!=null && filter.getHideFlag()) {
				Predicate condition = builder.equal(root.get("hideFlag"), filter.getHideFlag());
				p.add(condition);
			}
			if (filter.getId() != null && filter.getId() > 0) {
				Predicate condition = builder.equal(root.get("id"), filter.getId());
				p.add(condition);
			}
			if (filter.getUserNo() != null && filter.getUserNo() > 0) {
				Predicate condition = builder.equal(root.get("userNo"), filter.getUserNo());
				p.add(condition);
			}

		}

		return p;
	}

	private void init() {
		initEntityManagerBuilderCriteriaQueryRoot(HomeBusinessEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
	}

	public Response update(String reqObj) {
		HomeBusinessEntity homeBusinessEntity = objectMapperReadValue(reqObj, HomeBusinessEntity.class);
		return baseSaveOrUpdate(homeBusinessEntity);
	}

	public HomeBusinessEntity findById(Long id) {
		HomeBusinessEntity homeBusinessEntity = new HomeBusinessEntity();
		homeBusinessEntity.setId(id);
		Response response = baseFindById(criteriaQuery(homeBusinessEntity));

		if (response.isSuccess()) {
			return getValueFromObject(response.getObj(), HomeBusinessEntity.class);
		}
		return null;
	}

	public Response delete(Long id) {
		HomeBusinessEntity homeBusinessEntity = findById(id);
		return baseDelete(homeBusinessEntity);
	}
}
