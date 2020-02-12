package inl13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Metoder {

	Listor l = new Listor();
	private String Filnamn;
	
	public String getFilnamn() {
		return Filnamn;
	}

	public void setFilnamn(String filnamn) {
		Filnamn = filnamn;
	}

//	public void FilPrint() throws IOException {
//		String Filnamn = "matte.txt";
		
//		BufferedWriter out = new BufferedWriter(new FileWriter(Filnamn));
//		out.write("Hejhopp \n=========================\n");
//
//		for (int i = 0; i < l.namn.size(); i++) {
//			out.write(l.namn.get(i).toString() + "    ");
//			out.write(l.poang.get(i).toString());
//			if (l.poang.get(i) >= l.vg) {
//				out.write("   " + l.betyg.get(2).toString());
//			} else if (l.poang.get(i) >= l.g && l.poang.get(i) < l.vg) {
//				out.write("   " + l.betyg.get(1).toString());
//			} else {
//				out.write("   " + l.betyg.get(0).toString());
//			}
//
//			out.newLine();
//		}
//		out.close();
//	}
	
	public void FilExisterar() {
		File existera = new File("");
		boolean exists = existera.exists(); 
	}
}
