import java.io.*;

public class CopyFile {
	public static void main(String[] args) {

		// create byte streams and link to textfile
		try {
			copy(new FileInputStream("L://java/text.txt"),
					new FileOutputStream("L://java/copiedtext.txt"));
		} catch (IOException e) {
			System.out.println("I/O Error!");
		}

	}

	
	private static void copy(FileInputStream input, FileOutputStream output)
			throws IOException {

		int i;
		
		try {
			// read from inputstream and write the data to the outputstream
			while ((i = input.read()) != -1)
				output.write(i);
			System.out.println("File succesfully copied in new text file!");
		} finally

		// close streams
		{
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
		}

	}
}