package musiclibrary.impl.common.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NamedModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
