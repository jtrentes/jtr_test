package big.services;

import big.repositories.criteria.MyClass138Criteria;
import java.util.List;
import big.repositories.MyClass138Repository;
import big.domain.MyClass138;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass138Service")
@Transactional(readOnly = true)
public class MyClass138ServiceImpl implements MyClass138Service
{

	
	@Autowired
	private MyClass138Repository myClass138Repository;
    

	
	public List<MyClass138> findAll () 
	{
		return this.myClass138Repository.findAll();	
	}

	
	public List<MyClass138> findByCriteria (MyClass138Criteria criteria) 
	{
		return this.myClass138Repository.findByCriteria (criteria);	
	}

	
	public MyClass138 findById (Long id) 
	{
		return this.myClass138Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass138 save (MyClass138 myclass138) 
	{
		return this.myClass138Repository.save (myclass138);	
	}


}
