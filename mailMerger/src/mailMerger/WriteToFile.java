package mailMerger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile implements Runnable {
	private Student s;

	public WriteToFile(Student s) {
		this.setStudent(s);
	}

	public void setStudent(Student s) {
		if (s == null) {
			throw new IllegalArgumentException("Student cannot be null - no data to write");

		} else {
			this.s = s;
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
try {
	writeToNewFile();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

	public void writeToNewFile() throws IOException {
		// TODO Auto-generated method stub
	
		String fileName= s.getName()+".txt";
		File newFile = new File(fileName);
		FileWriter fw = new FileWriter(newFile);
		BufferedWriter bw = new BufferedWriter(fw);
		String linetoWrite = String.format("Dear %s,",s.getName());
		bw.write(linetoWrite);
        bw.newLine();
        bw.newLine();
        linetoWrite= String.format("You didn't last too long at the lecture today! (%d mins.) You need to stay for the full duration.",s.calcTimeOnLine());
        bw.write(linetoWrite);
        bw.newLine();
        linetoWrite= (s.toString());
        bw.write(linetoWrite);
      
        bw.flush();
        bw.close();
        

	}

	public Student getStudent() {
		return s;
	}

}
