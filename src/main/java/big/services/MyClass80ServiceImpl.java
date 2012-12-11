package big.services;

import java.util.List;
import big.repositories.MyClass80Repository;
import big.domain.MyClass80;
import big.repositories.criteria.MyClass80Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass80Service")
@Transactional(readOnly = true)
public class MyClass80ServiceImpl implements MyClass80Service
{

	
	@Autowired
	private MyClass80Repository myClass80Repository;
    

	
	public List<MyClass80> findAll () 
	{
		return this.myClass80Repository.findAll();	
	}

	
	public List<MyClass80> findByCriteria (MyClass80Criteria criteria) 
	{
		return this.myClass80Repository.findByCriteria (criteria);	
	}

	
	public MyClass80 findById (Long id) 
	{
		return this.myClass80Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass80 save (MyClass80 myclass80) 
	{
		return this.myClass80Repository.save (myclass80);	
	}


}
