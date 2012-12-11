package big.services;

import big.repositories.MyClass128Repository;
import big.repositories.criteria.MyClass128Criteria;
import big.domain.MyClass128;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass128Service")
@Transactional(readOnly = true)
public class MyClass128ServiceImpl implements MyClass128Service
{

	
	@Autowired
	private MyClass128Repository myClass128Repository;
    

	
	public List<MyClass128> findAll () 
	{
		return this.myClass128Repository.findAll();	
	}

	
	public List<MyClass128> findByCriteria (MyClass128Criteria criteria) 
	{
		return this.myClass128Repository.findByCriteria (criteria);	
	}

	
	public MyClass128 findById (Long id) 
	{
		return this.myClass128Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass128 save (MyClass128 myclass128) 
	{
		return this.myClass128Repository.save (myclass128);	
	}


}
