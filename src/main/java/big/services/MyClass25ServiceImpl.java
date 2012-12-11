package big.services;

import big.repositories.MyClass25Repository;
import big.domain.MyClass25;
import big.repositories.criteria.MyClass25Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass25Service")
@Transactional(readOnly = true)
public class MyClass25ServiceImpl implements MyClass25Service
{

	
	@Autowired
	private MyClass25Repository myClass25Repository;
    

	
	public List<MyClass25> findAll () 
	{
		return this.myClass25Repository.findAll();	
	}

	
	public List<MyClass25> findByCriteria (MyClass25Criteria criteria) 
	{
		return this.myClass25Repository.findByCriteria (criteria);	
	}

	
	public MyClass25 findById (Long id) 
	{
		return this.myClass25Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass25 save (MyClass25 myclass25) 
	{
		return this.myClass25Repository.save (myclass25);	
	}


}
