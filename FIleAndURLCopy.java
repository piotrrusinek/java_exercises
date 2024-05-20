import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.URL;


public class FIleAndURLCopy {
	
	public static void copy(String originalPath, String copyPath) throws copyException {
		if(originalPath.length()==0) throw new copyException("No path provided for source.");
		
		
		InputStream in;
		OutputStream out;
		
		if(originalPath.matches("https?://.*")) {
			URL url;
			try {
				url = new URL(originalPath);
			}
			catch(Exception e) {
				throw new copyException("Wrong URL adress", e);
			}
			try {
				in = new BufferedInputStream(url.openStream());
			}
			catch(IOException ioe) {
				throw new copyException("Adress can not be reached.", ioe);
			}
			
			
			if(copyPath.length()==0 || copyPath.equals(".") || copyPath.equals("..")) {
				System.out.println("index of /: " + originalPath.indexOf('/'));
				String name = originalPath.substring(originalPath.indexOf('/')+2);
				System.out.println("first cut: " + name);
				if(name.indexOf('/')!=-1)name = name.substring(0, name.indexOf('/'));
				System.out.println("second cut: " + name);
				name = name.replace('.', '_');
				System.out.println("new filename: " + name);
				if(copyPath.length()==0) copyPath += ("copies/" + name + ".html");
				else copyPath += (name+".html");
			}
			
			
			
			
			
		}
		else {
			if(copyPath.length()==0) throw new copyException("No path provided for destination");
			
			File original = new File(originalPath);
			if(!original.exists()) throw new copyException("File: " + originalPath + " does not exist.");
			if(!original.canRead()) throw new copyException("Can not read file: " + originalPath);
			if(!original.isFile()) {
				if(!original.isDirectory()) throw new copyException("Source path leads to directory instead of file.");
				else throw new copyException("Source is not a normal file.");
			}
			
			try {
				 in = new BufferedInputStream(new FileInputStream(original));
			}
			catch(SecurityException se) {
				throw new copyException("Source file access denied.", se);
			}
			catch(FileNotFoundException fe) {
				throw new copyException("For some strange reason source can not be opened.", fe);
			}
		}
		
		
		
		File copy = new File(copyPath);
		//if(!copy.isDirectory()) throw new copyException("Destination leads to a directory lasking filename.");
		
		//Files.getPosixFilePermissions(Path.of(originalPath));
		
		
		
		
		
		try {
			 out = new BufferedOutputStream(new FileOutputStream(copy));
		}
		catch(SecurityException se) {
			throw new copyException("Destination file access denied.", se);
		}
		catch(FileNotFoundException fe) {
			throw new copyException("For some strange reason destination can not be opened.", fe);
		}
		
		
		byte[] buffer = new byte[1024];
		int lengthRead;
		
		try {
			while((lengthRead = in.read(buffer)) > 0) {
				out.write(buffer, 0, lengthRead);
				out.flush();
			}
			in.close();
			out.close();
		}
		catch(IOException ie) {
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		String source = "https://blog.hubspot.com/marketing/best-personal-websites?hubs_content=blog.hubspot.com%2Fwebsite%2Fhtml-websites&hubs_content-cta=personal%20site";
		String source2 = "http://www.agh.edu.pl";
		String source3 = "resources/file1";
		String source4 = "resources/file2";
		
		try {
			FIleAndURLCopy.copy(source, "copies/blog_copy.html");
		}
		catch(copyException ce) {
			System.out.println("source" + ": " + ce.getMessage());
		}
		try {
			FIleAndURLCopy.copy(source, "");
		}
		catch(copyException ce) {
			System.out.println("source" + ": " + ce.getMessage());
		}
		try {
			FIleAndURLCopy.copy(source2, "copies/agh_copy.html");
		}
		catch(copyException ce) {
			System.out.println("source2" + ": " + ce.getMessage());
		}
		try {
			FIleAndURLCopy.copy(source2, "");
		}
		catch(copyException ce) {
			System.out.println("source2" + ": " + ce.getMessage());
		}
		try {
			FIleAndURLCopy.copy(source3, "copies/file1_copy");
		}
		catch(copyException ce) {
			System.out.println("source2" + ": " + ce.getMessage());
		}
		try {
			FIleAndURLCopy.copy(source4, "copies/file2_copy");
		}
		catch(copyException ce) {
			System.out.println("source2" + ": " + ce.getMessage());
		}
		
	}

}
