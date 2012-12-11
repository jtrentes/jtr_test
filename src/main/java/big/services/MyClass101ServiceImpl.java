package big.services;

import big.repositories.MyClass101Repository;
import big.domain.MyClass101;
import big.repositories.criteria.MyClass101Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass101Service")
@Transactional(readOnly = true)
public class MyClass101ServiceImpl implements MyClass101Service
{

	
	@Autowired
	private MyClass101Repository myClass101Repository;
    

	
	public List<MyClass101> findAll () 
	{
		return this.myClass101Repository.findAll();	
	}

	
	public List<MyClass101> findByCriteria (MyClass101Criteria criteria) 
	{
		return this.myClass101Repository.findByCriteria (criteria);	
	}

	
	public MyClass101 findById (Long id) 
	{
		return this.myClass101Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass101 save (MyClass101 myclass101) 
	{
		return this.myClass101Repository.save (myclass101);	
	}


}
