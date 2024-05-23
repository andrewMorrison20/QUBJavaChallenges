package cheersForBeersChallenge;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriterThread implements Runnable{
	
	private List<Beer> listToWrite = new ArrayList<Beer>();
	private double searchTarget;
	
	public WriterThread(List<Beer> listToWrite,double searchTarget) {
		this.listToWrite = listToWrite;
		this.searchTarget= searchTarget;
	}
	
	@Override
	public void run() {
		System.out.println("Thread Opening.....");
		List<Beer> list = new ArrayList<Beer>();
		list = Menu.searchAndSortByAttribute(listToWrite, "percentage", listToWrite.size());
		 Menu.subList(list, 15,6 );
		try {	
			File newfile = new File("ResultsFile.csv");
			FileWriter fw= new FileWriter(newfile);
			BufferedWriter bw = new BufferedWriter(fw);
			String line = String.format("%-35s %s", "Beer Name", "Percentage Alcohol ");
			bw.write(line);
			bw.newLine();
			int size = list.size();
			for(int i = 0 ; i < size; i++ ) {
				line = String.format("%-35s,%.2f ",list.get(i).getName(), list.get(i).getPercentage());
				bw.write(line);
				bw.newLine();
			}
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Thread Closing....");
		
		
	}
	
	

}
