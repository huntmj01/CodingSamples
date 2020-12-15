package lab9;

import java.io.File;
import javax.swing.filechooser.*;

/**
 * 
 * The TileFilter class extends FileFilter
 * and overrides its accept and getDescription
 * methods in order to only accept dat files
 * 
 * @author 2015H_000
 *
 */

public class DatFilter extends FileFilter {

	/**
	 * 
	 * accept() returns whether the file
	 * is a dat file and can be opened
	 * 
	 * @param f, the file to be checked
	 * 
	 * @return true if the File is of type dat
	 * 
	 */
	@Override
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}
		String extension = getFileExtension(f);
		if (extension != null) {
			if (extension.equals("dat")) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	/**
	 * 
	 * getDescription() returns the description
	 * of the file filter
	 * 
	 * @return ".dat"
	 * 
	 */
	@Override
	public String getDescription() {
		return ".dat or .DATASS";
	}

	/**
	 * 
	 * getFileExtension() parses a file
	 * to retrieve its extension
	 * 
	 * @param file, the file to be parsed
	 * 
	 * @return extension, the extension of the file
	 * 
	 */
	private String getFileExtension(File file) {
		String name = file.getName();
		try {
			return name.substring(name.lastIndexOf(".") + 1);
		} catch (Exception e) {
			return "";
		}
	}
}