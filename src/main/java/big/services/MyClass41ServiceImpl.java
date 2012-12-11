package big.services;

import big.repositories.criteria.MyClass41Criteria;
import java.util.List;
import big.repositories.MyClass41Repository;
import big.domain.MyClass41;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass41Service")
@Transactional(readOnly = true)
public class MyClass41ServiceImpl implements MyClass41Service
{

	
	@Autowired
	private MyClass41Repository myClass41Repository;
    

	
	public List<MyClass41> findAll () 
	{
		return this.myClass41Repository.findAll();	
	}

	
	public List<MyClass41> findByCriteria (MyClass41Criteria criteria) 
	{
		return this.myClass41Repository.findByCriteria (criteria);	
	}

	
	public MyClass41 findById (Long id) 
	{
		return this.myClass41Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass41 save (MyClass41 myclass41) 
	{
		return this.myClass41Repository.save (myclass41);	
	}


}
