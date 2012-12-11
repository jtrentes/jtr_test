package big.services;

import big.repositories.criteria.MyClass116Criteria;
import big.domain.MyClass116;
import big.repositories.MyClass116Repository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass116Service")
@Transactional(readOnly = true)
public class MyClass116ServiceImpl implements MyClass116Service
{

	
	@Autowired
	private MyClass116Repository myClass116Repository;
    

	
	public List<MyClass116> findAll () 
	{
		return this.myClass116Repository.findAll();	
	}

	
	public List<MyClass116> findByCriteria (MyClass116Criteria criteria) 
	{
		return this.myClass116Repository.findByCriteria (criteria);	
	}

	
	public MyClass116 findById (Long id) 
	{
		return this.myClass116Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass116 save (MyClass116 myclass116) 
	{
		return this.myClass116Repository.save (myclass116);	
	}


}
