package processing;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class FileProcess {
	residents resident;
	Queue <residents> applicants;
	Map <String, String> selectedApplicants;
	
	public FileProcess() {
		applicants = new LinkedList<>();
		selectedApplicants = new TreeMap<>();
	}
	
	private String listtoString () {
		String output = "";
		for (Map.Entry<String, String> kv : selectedApplicants.entrySet()) {
			String toAdd = kv.getKey() + ": " + kv.getValue() + "\n";
			output += toAdd;
		}
		return output;
	}
	
	public void apply(residents r) {
		if (!applicants.contains(r)) {
			applicants.add(r);
		}
	}
	
	public Queue<residents> getApplicantList(){
		return this.applicants;
	}
	
	
	private boolean screening (residents r) {
		int score = 0;
		if (r.getAge()>75) {
			score += 2;
		}else {
			score +=3;
		}
		
		if (r.getEducationLevel() == Degree.BACHELOR || r.getEducationLevel() == Degree.NONE) {
			score +=1;
		}else if (r.getEducationLevel() == Degree.MASTER) {
			score += 2;
		}else if (r.getEducationLevel() == Degree.MD || r.getEducationLevel() == Degree.PHD) {
			score += 2.5;
		}
		
		if (!r.getCrimeHistory()) {
			score += 1;
		}
		
		if (score > 4) {
			return true;
		} else 
			return false;
	}

	
	private void filtering(Queue<residents> list){
		if (list.size() != 0) {
			residents r = applicants.poll();
			if (screening(r)) {
				selectedApplicants.put(r.getName(), r.homeAddress());
			}
			filtering(applicants);
		}
	}
	
	public String getSelectedList() {
		filtering(applicants);
		return listtoString();
	}
	
	
	
}
