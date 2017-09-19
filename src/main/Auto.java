package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public abstract class Auto {
	private String name;
	private String pathFile;
	private String urlMazda;
	private String icon;

	

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrlMazda() {
		return urlMazda;
	}

	public void setUrlMazda(String urlMazda) {
		this.urlMazda = urlMazda;
	}

	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String readFileDesc() throws IOException {
	    File file = new File( pathFile );

	    @SuppressWarnings("resource")
		BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream( file )));
	    String line = null;
	    while ((line = br.readLine()) != null) {
	    	return line;
	    }
	    br.close();
		return line;
		}
	

	public void goToLink() {
		try {
			String url = urlMazda;
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		} catch (java.io.IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
