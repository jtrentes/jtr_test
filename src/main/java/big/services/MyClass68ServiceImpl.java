package big.services;

import big.domain.MyClass68;
import big.repositories.criteria.MyClass68Criteria;
import java.util.List;
import big.repositories.MyClass68Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass68Service")
@Transactional(readOnly = true)
public class MyClass68ServiceImpl implements MyClass68Service
{

	
	@Autowired
	private MyClass68Repository myClass68Repository;
    

	
	public List<MyClass68> findAll () 
	{
		return this.myClass68Repository.findAll();	
	}

	
	public List<MyClass68> findByCriteria (MyClass68Criteria criteria) 
	{
		return this.myClass68Repository.findByCriteria (criteria);	
	}

	
	public MyClass68 findById (Long id) 
	{
		return this.myClass68Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass68 save (MyClass68 myclass68) 
	{
		return this.myClass68Repository.save (myclass68);	
	}


}
