package big.services;

import java.util.List;
import big.repositories.MyClass151Repository;
import big.repositories.criteria.MyClass151Criteria;
import big.domain.MyClass151;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass151Service")
@Transactional(readOnly = true)
public class MyClass151ServiceImpl implements MyClass151Service
{

	
	@Autowired
	private MyClass151Repository myClass151Repository;
    

	
	public List<MyClass151> findAll () 
	{
		return this.myClass151Repository.findAll();	
	}

	
	public List<MyClass151> findByCriteria (MyClass151Criteria criteria) 
	{
		return this.myClass151Repository.findByCriteria (criteria);	
	}

	
	public MyClass151 findById (Long id) 
	{
		return this.myClass151Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass151 save (MyClass151 myclass151) 
	{
		return this.myClass151Repository.save (myclass151);	
	}


}
