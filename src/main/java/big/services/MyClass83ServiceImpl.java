package big.services;

import big.domain.MyClass83;
import big.repositories.criteria.MyClass83Criteria;
import java.util.List;
import big.repositories.MyClass83Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass83Service")
@Transactional(readOnly = true)
public class MyClass83ServiceImpl implements MyClass83Service
{

	
	@Autowired
	private MyClass83Repository myClass83Repository;
    

	
	public List<MyClass83> findAll () 
	{
		return this.myClass83Repository.findAll();	
	}

	
	public List<MyClass83> findByCriteria (MyClass83Criteria criteria) 
	{
		return this.myClass83Repository.findByCriteria (criteria);	
	}

	
	public MyClass83 findById (Long id) 
	{
		return this.myClass83Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass83 save (MyClass83 myclass83) 
	{
		return this.myClass83Repository.save (myclass83);	
	}


}
