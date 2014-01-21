package musiclibrary.impl.common.service;

import musiclibrary.impl.common.organizor.OrganizeContext;
import musiclibrary.impl.common.organizor.Stash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
@Service
public class OrganizeService {

	@Autowired
	private OrganizeContext organizeContext;
	
	public Stash organize(){
		return new Stash();
	}
}
