import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;



public class FileCopy {

	public static void copyAdvanced(String originalPath, String copyPath) throws Throwable {
		
		File original = new File(originalPath);
		File copy = new File(copyPath);
		InputStream in = new BufferedInputStream(new FileInputStream(original));
		OutputStream out = new BufferedOutputStream(new FileOutputStream(copy));
		byte[] buffer = new byte[1024];
		int lengthRead;
		while((lengthRead = in.read(buffer)) > 0) {
			out.write(buffer, 0, lengthRead);
			out.flush();
		}
		
	}
	
	public static void copyBasic(String originalPath, String copyPath) throws Exception {
		FileReader originalFile = new FileReader(originalPath);
		FileWriter copiedFile = new FileWriter(copyPath);
		
		int ch;

		while((ch = originalFile.read()) != -1) {
			copiedFile.write(ch);
			
		}
		originalFile.close();
		copiedFile.close();
	}
	
	public static void copy(String originalPath, String copyPath) throws copyException {
		if(originalPath.length()==0) throw new copyException("No path provided for source.");
		if(copyPath.length()==0) throw new copyException("No path provided for destination");
		
		File original = new File(originalPath);
		if(!original.exists()) throw new copyException("File: " + originalPath + " does not exist.");
		if(!original.canRead()) throw new copyException("Can not read file: " + originalPath);
		if(!original.isFile()) {
			if(!original.isDirectory()) throw new copyException("Source path leads to directory instead of file.");
			else throw new copyException("Source is not a normal file.");
		}
		
		File copy = new File(copyPath);
		//if(!copy.isDirectory()) throw new copyException("Destination leads to a directory lasking filename.");
		
		//Files.getPosixFilePermissions(Path.of(originalPath));
		
		InputStream in;
		OutputStream out;
		
		try {
			 in = new BufferedInputStream(new FileInputStream(original));
		}
		catch(SecurityException se) {
			throw new copyException("Source file access denied.", se);
		}
		catch(FileNotFoundException fe) {
			throw new copyException("For some strange reason source can not be opened.", fe);
		}
		
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
		/*
		try {
			FileCopy.copyBasic("resources/file6", "copies/file6_copy");
		}
		catch(Throwable e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
			System.out.println(e.getLocalizedMessage());
			System.out.println(e);
		}
		try {
			FileCopy.copyAdvanced("resources/file6", "copies/file6_copy");
		}
		catch(Throwable e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
			System.out.println(e);
			
		}
		*/
		try {
			FileCopy.copy("resources/file6", "copies/file6_copy");
		}
		catch(copyException ce) {
			System.out.println(ce.getMessage());
		}
		try {
			FileCopy.copy("resources/file2", "copies/file1_copy");
		}
		catch(copyException ce) {
			System.out.println(ce.getMessage());
		}
		try {
			FileCopy.copy("resources/file2", "copies/file2_copy");
		}
		catch(copyException ce) {
			System.out.println(ce.getMessage());
		}

	}

}


class copyException extends Exception{
	public copyException(String errorMessage, Throwable err){
		super(errorMessage, err);
	}
	public copyException(String errorMessage){
		super(errorMessage);
	}
}

