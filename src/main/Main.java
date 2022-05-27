package main;

import processing.Degree;
import processing.FileProcess;
import processing.residents;

public class Main {
	public static void main (String[] args) {
		FileProcess system = new FileProcess();
		residents r1 = new residents("Alanine", "2 East South Street, IL", 22, Degree.BACHELOR, true);
		residents r2 = new residents("Trytophan", "3 East South Street, NH", 10, Degree.NONE, false);
		residents r3 = new residents("Histidine", "4 East South Street, NY", 50, Degree.MD, true);
		system.apply(r1);
		system.apply(r3);
		system.apply(r2);
		
		System.out.println(system.getSelectedList());
		
	}
}
