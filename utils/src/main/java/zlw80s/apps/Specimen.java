package zlw80s.apps;

/**
 * 
 * 样本 
 *
 */
public class Specimen {
	
	private String typeName;//类型名称
	
	private Point coordinate;//坐标
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Point getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Point coordinate) {
		this.coordinate = coordinate;
	}
	
	public Specimen(String typeName,Point coordinate){
		this.typeName = typeName;
		this.coordinate = coordinate;		
	}

}
