package big.services;

import big.repositories.criteria.MyClass76Criteria;
import big.repositories.MyClass76Repository;
import java.util.List;
import big.domain.MyClass76;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass76Service")
@Transactional(readOnly = true)
public class MyClass76ServiceImpl implements MyClass76Service
{

	
	@Autowired
	private MyClass76Repository myClass76Repository;
    

	
	public List<MyClass76> findAll () 
	{
		return this.myClass76Repository.findAll();	
	}

	
	public List<MyClass76> findByCriteria (MyClass76Criteria criteria) 
	{
		return this.myClass76Repository.findByCriteria (criteria);	
	}

	
	public MyClass76 findById (Long id) 
	{
		return this.myClass76Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass76 save (MyClass76 myclass76) 
	{
		return this.myClass76Repository.save (myclass76);	
	}


}
