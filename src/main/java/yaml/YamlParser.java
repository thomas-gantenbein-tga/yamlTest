package yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class YamlParser {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File(YamlParser.class.getClassLoader().getResource("roles.yaml").getFile());

		try (InputStream in = new FileInputStream(file)) {
			Yaml yaml = new Yaml();
			/*Constructor constructor = new Constructor(Configuration.class);
			TypeDescription configDesc = new TypeDescription(Configuration.class);
			configDesc.putListPropertyType("roles", Role.class);
			constructor.addTypeDescription(configDesc);*/
			Configuration config = yaml.loadAs(in, Configuration.class);
			for (String address : config.getRoles().get(0).getAddresses()) {
				System.out.println(address);
			}
			for (String address : config.getRoles().get(1).getAddresses()) {
				System.out.println(address);
			}
		}
	}
}
