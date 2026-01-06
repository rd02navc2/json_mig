package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class ReadProperties {
	Properties properties = new Properties();

	public ReadProperties() {

	}

	public void readin() {
		String propFileName = "settings.properties";
		try {

			// properties.load(new FileInputStream("c:/settings.properties"));

			// InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propFileName);
			// if (inputStream == null) {
			// throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			// }

			URL url = ClassLoader.getSystemResource("settings.properties");
			properties.load(new FileInputStream(new File(url.getFile())));

		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	public String getSchemaOutputLocation() {
		return properties.getProperty("schema.output.location");
	}

	public String getMessageListLocation() {
		return properties.getProperty("message.list.location");
	}

	public String getTDL_DENsXslLocation() {
		return properties.getProperty("TDL_DENs.xsl.location");
	}

	public String getMIGLocation() {
		return properties.getProperty("MIG.location");
	}

	public String getDataItemSetTemplateLocation() {
		return properties.getProperty("data.item.set.template.location");
	}

	public String getMappingTreeXslLocation() {
		return properties.getProperty("mapping.tree.xsl.location");
	}

	public String getDataItemDescriptionTemplateLocation() {
		return properties.getProperty("data.item.description.template.location");
	}

	public String getDataHarmoResultTemplateLocation() {
		return properties.getProperty("data.harmo.result.template.location");
	}
	
	
	public String getWordAllLocation() {
		return properties.getProperty("java.io.tmpdir.location");
	}

	public String getWCODataLocation() {
		return properties.getProperty("wco.data.location");
	}

	public String getProcessFileLocation() {
		return properties.getProperty("process.file.location");
	}
/*
	public static void main(String[] args) {
		ReadProperties o = new ReadProperties();
		o.readin();
		System.out.println("ok");
	}
*/
}
