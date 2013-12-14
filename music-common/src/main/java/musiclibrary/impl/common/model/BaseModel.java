package musiclibrary.impl.common.model;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@MappedSuperclass
public class BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;
	protected long id;

	@Id
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
