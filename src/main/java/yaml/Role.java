package yaml;

import java.util.List;

public class Role {

	private String name;
	private String home;
	private List<String> addresses;

	public void setName(String name) {
		this.name = name;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	public String getName() {
		return name;
	}

	public String getHome() {
		return home;
	}

	public List<String> getAddresses() {
		return addresses;

	}
}
