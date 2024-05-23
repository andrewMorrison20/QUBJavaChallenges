package oneHundredMeterChallenge;

import java.util.Map;

public class RaceTimer implements Runnable {
private Double time;
private String name;

public RaceTimer(Double time,String name) {
	this.setName(name);
	this.setTime(time);
}





	private void setName(String name) throws IllegalArgumentException{
	// TODO Auto-generated method stub
	if(name!=null) {
		this.name=name;
	}else {throw new IllegalArgumentException("Name cannot be null");}
}





	public void setTime(Double time) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	if(time<=0) {
		throw new IllegalArgumentException("time must be greater than zero ");
	}else {
		this.time=time;
	}
}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		startRace();
	}
private void startRace() {
		// TODO Auto-generated method stub
	try {
			Thread.sleep((long)((double)time*1000));
			System.out.println(name + "Finsh time : " + time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
public Double getTime() {
	return time;
}
}
