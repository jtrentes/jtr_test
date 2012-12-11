package big.services;

import big.domain.MyClass109;
import big.repositories.criteria.MyClass109Criteria;
import java.util.List;
import big.repositories.MyClass109Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass109Service")
@Transactional(readOnly = true)
public class MyClass109ServiceImpl implements MyClass109Service
{

	
	@Autowired
	private MyClass109Repository myClass109Repository;
    

	
	public List<MyClass109> findAll () 
	{
		return this.myClass109Repository.findAll();	
	}

	
	public List<MyClass109> findByCriteria (MyClass109Criteria criteria) 
	{
		return this.myClass109Repository.findByCriteria (criteria);	
	}

	
	public MyClass109 findById (Long id) 
	{
		return this.myClass109Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass109 save (MyClass109 myclass109) 
	{
		return this.myClass109Repository.save (myclass109);	
	}


}
