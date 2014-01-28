package musiclibrary.impl.common.model;

import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@MappedSuperclass
public class TitledModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
