package com.gmail.klewzow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SearchAndCopyFile implements FileFilter {

	private File fileIn;
	private File fileOut;

	public SearchAndCopyFile(File fileIn, File fileOut) {
		super();
		if (fileOut.isDirectory() == false) {
			fileOut.mkdirs();
		}
		if (fileIn.isDirectory() == false) {
			fileIn.mkdirs();
		}

		this.fileIn = fileIn;
		this.fileOut = fileOut;
	}

	public SearchAndCopyFile() {
		super();
	}

	@Override
	public void copyFile(String exp) {
		if (this.fileIn.isDirectory()) {

			for (String str : this.fileIn.list()) {

				int r = str.lastIndexOf(".");
				if (exp.equals(str.substring(r + 1))) {
					try {
						fileCopy(new File(this.fileIn.toString() + "/" + str), new File(this.fileOut.toString()));
					} catch (IOException e) {

						e.printStackTrace();
					}
				}

			}
		}

	}

	private void fileCopy(File in, File out) throws IOException {

		byte[] buff = new byte[(1024 * 1024) * 5];
		System.out.println(in.getName() + " Copy ");
		int readByte = 0;
		try (FileInputStream fileInputStream = new FileInputStream(in);
				FileOutputStream fileOutputStream = new FileOutputStream(out +"/"+ in.getName())) {

			for (; (readByte = fileInputStream.read()) > 0;) {
				fileOutputStream.write(buff, 0, readByte);
				System.out.println("Coppied");
			}

		} catch (IOException e) {
			throw e;
		}

	}



	public File getFileIn() {
		return fileIn;
	}

	public void setFileIn(File fileIn) {
		this.fileIn = fileIn;
	}

	public File getFileOut() {
		return fileOut;
	}

	public void setFileOut(File fileOut) {
		this.fileOut = fileOut;
	}

	@Override
	public String toString() {
		return "SearchAndCopyFile [fileIn=" + fileIn + ", fileOut=" + fileOut + "]";
	}

}
