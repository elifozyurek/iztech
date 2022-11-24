
public class Photo {
	private String position;
	private String resolution;
	
	public Photo() {
		this(" no resolution","no position");
	}


	public Photo(String resolution, String position) {
		this.resolution = resolution;
		this.position = position;
	}


	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
	
}
