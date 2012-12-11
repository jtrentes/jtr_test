package big.services;

import java.util.List;
import big.repositories.MyClassRepository;
import big.domain.MyClass;
import big.repositories.criteria.MyClassCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclassService")
@Transactional(readOnly = true)
public class MyClassServiceImpl implements MyClassService
{

	
	@Autowired
	private MyClassRepository myClassRepository;
    

	
	public List<MyClass> findAll () 
	{
		return this.myClassRepository.findAll();	
	}

	
	public List<MyClass> findByCriteria (MyClassCriteria criteria) 
	{
		return this.myClassRepository.findByCriteria (criteria);	
	}

	
	public MyClass findById (Long id) 
	{
		return this.myClassRepository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass save (MyClass myclass) 
	{
		return this.myClassRepository.save (myclass);	
	}


}
