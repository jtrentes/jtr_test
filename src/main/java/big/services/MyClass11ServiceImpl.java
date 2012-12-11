package big.services;

import big.domain.MyClass11;
import big.repositories.criteria.MyClass11Criteria;
import java.util.List;
import big.repositories.MyClass11Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass11Service")
@Transactional(readOnly = true)
public class MyClass11ServiceImpl implements MyClass11Service
{

	
	@Autowired
	private MyClass11Repository myClass11Repository;
    

	
	public List<MyClass11> findAll () 
	{
		return this.myClass11Repository.findAll();	
	}

	
	public List<MyClass11> findByCriteria (MyClass11Criteria criteria) 
	{
		return this.myClass11Repository.findByCriteria (criteria);	
	}

	
	public MyClass11 findById (Long id) 
	{
		return this.myClass11Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass11 save (MyClass11 myclass11) 
	{
		return this.myClass11Repository.save (myclass11);	
	}


}
