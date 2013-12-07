package musiclibrary.impl.common.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	protected long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
