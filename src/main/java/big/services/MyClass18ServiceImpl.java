package big.services;

import java.util.List;
import big.repositories.criteria.MyClass18Criteria;
import big.repositories.MyClass18Repository;
import big.domain.MyClass18;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass18Service")
@Transactional(readOnly = true)
public class MyClass18ServiceImpl implements MyClass18Service
{

	
	@Autowired
	private MyClass18Repository myClass18Repository;
    

	
	public List<MyClass18> findAll () 
	{
		return this.myClass18Repository.findAll();	
	}

	
	public List<MyClass18> findByCriteria (MyClass18Criteria criteria) 
	{
		return this.myClass18Repository.findByCriteria (criteria);	
	}

	
	public MyClass18 findById (Long id) 
	{
		return this.myClass18Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass18 save (MyClass18 myclass18) 
	{
		return this.myClass18Repository.save (myclass18);	
	}


}
