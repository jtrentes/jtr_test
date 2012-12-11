package big.services;

import big.repositories.criteria.MyClass137Criteria;
import big.domain.MyClass137;
import java.util.List;
import big.repositories.MyClass137Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass137Service")
@Transactional(readOnly = true)
public class MyClass137ServiceImpl implements MyClass137Service
{

	
	@Autowired
	private MyClass137Repository myClass137Repository;
    

	
	public List<MyClass137> findAll () 
	{
		return this.myClass137Repository.findAll();	
	}

	
	public List<MyClass137> findByCriteria (MyClass137Criteria criteria) 
	{
		return this.myClass137Repository.findByCriteria (criteria);	
	}

	
	public MyClass137 findById (Long id) 
	{
		return this.myClass137Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass137 save (MyClass137 myclass137) 
	{
		return this.myClass137Repository.save (myclass137);	
	}


}
