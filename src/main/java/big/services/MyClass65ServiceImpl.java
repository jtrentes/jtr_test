package big.services;

import java.util.List;
import big.repositories.criteria.MyClass65Criteria;
import big.domain.MyClass65;
import big.repositories.MyClass65Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass65Service")
@Transactional(readOnly = true)
public class MyClass65ServiceImpl implements MyClass65Service
{

	
	@Autowired
	private MyClass65Repository myClass65Repository;
    

	
	public List<MyClass65> findAll () 
	{
		return this.myClass65Repository.findAll();	
	}

	
	public List<MyClass65> findByCriteria (MyClass65Criteria criteria) 
	{
		return this.myClass65Repository.findByCriteria (criteria);	
	}

	
	public MyClass65 findById (Long id) 
	{
		return this.myClass65Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass65 save (MyClass65 myclass65) 
	{
		return this.myClass65Repository.save (myclass65);	
	}


}
