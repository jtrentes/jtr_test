package big.services;

import big.repositories.criteria.MyClass152Criteria;
import java.util.List;
import big.repositories.MyClass152Repository;
import big.domain.MyClass152;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass152Service")
@Transactional(readOnly = true)
public class MyClass152ServiceImpl implements MyClass152Service
{

	
	@Autowired
	private MyClass152Repository myClass152Repository;
    

	
	public List<MyClass152> findAll () 
	{
		return this.myClass152Repository.findAll();	
	}

	
	public List<MyClass152> findByCriteria (MyClass152Criteria criteria) 
	{
		return this.myClass152Repository.findByCriteria (criteria);	
	}

	
	public MyClass152 findById (Long id) 
	{
		return this.myClass152Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass152 save (MyClass152 myclass152) 
	{
		return this.myClass152Repository.save (myclass152);	
	}


}
