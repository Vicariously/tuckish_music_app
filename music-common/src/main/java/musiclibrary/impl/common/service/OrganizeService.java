package musiclibrary.impl.common.service;

import musiclibrary.impl.common.organizor.OrganizeContext;
import musiclibrary.impl.common.organizor.Stash;
import musiclibrary.impl.common.organizor.strategy.OrganizeAlbum;
import musiclibrary.impl.common.organizor.strategy.OrganizeArtist;
import musiclibrary.impl.common.organizor.strategy.OrganizeMp3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
@Service
public class OrganizeService {

	@Autowired
	private OrganizeContext organizeContext;
	
	public Stash organize(String fileName, String fileType){
		
		if(fileType.equals("artist")){
			organizeContext.setOrganizer(new OrganizeArtist());
		}else if(fileType.equals("album")){
			organizeContext.setOrganizer(new OrganizeAlbum());
		}else if(fileType.equals("song")){
			organizeContext.setOrganizer(new OrganizeMp3());
		}
		organizeContext.organize(fileName, fileType);
		
		
		return new Stash();
	}
}
