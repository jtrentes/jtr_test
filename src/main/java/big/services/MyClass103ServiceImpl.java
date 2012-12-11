package big.services;

import big.repositories.MyClass103Repository;
import java.util.List;
import big.repositories.criteria.MyClass103Criteria;
import big.domain.MyClass103;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass103Service")
@Transactional(readOnly = true)
public class MyClass103ServiceImpl implements MyClass103Service
{

	
	@Autowired
	private MyClass103Repository myClass103Repository;
    

	
	public List<MyClass103> findAll () 
	{
		return this.myClass103Repository.findAll();	
	}

	
	public List<MyClass103> findByCriteria (MyClass103Criteria criteria) 
	{
		return this.myClass103Repository.findByCriteria (criteria);	
	}

	
	public MyClass103 findById (Long id) 
	{
		return this.myClass103Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass103 save (MyClass103 myclass103) 
	{
		return this.myClass103Repository.save (myclass103);	
	}


}
