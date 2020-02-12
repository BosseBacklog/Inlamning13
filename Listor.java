package inl13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Listor {

//	Programmet ska kunna hämta datum ifrån datorn och lägga till det i slutet av filnamnet
//	Man ska kunna välja om man vill lägga till datum eller inte
//	Gör en jagged array för namn och sen ett betyg kopplat till den. Ev lättare att inte göra den Jagged när man ska skriva ut sen??
//  Fixa formatering
//	Kika på om man kan göra en hashmap. Typ Hasse som key och sen egenskaperna 32 poäng och VG
//	"Tryck ned valfri tangent för att fortsätta
//	Fixa felmeddelande för varje steg i processen

	List<String> namn = new ArrayList<>();
	List<Integer> poang = new ArrayList<>();
	List<String> betyg = new ArrayList<>();
	int maxpoäng = 0;
	int antalPersonerSomSkaLaggasIn = 0;
	int raknarePersonSkriv = 1;
	Scanner sc = new Scanner(System.in);

	String NamngeFil;
	String s;
	String Filnamn = "matte.txt";
	int g;
	int vg;
	Calendar cal = Calendar.getInstance();

	public void Start() throws IOException {

		while (true) {
//			sc.nextLine();
			betyg.add("IG");
			betyg.add("G");
			betyg.add("VG");

			System.out.println("Ange skrivningens maxpoäng");

			if (sc.hasNextInt() == false) {
				System.err.println("Invalid input");
				sc.nextLine();
				continue;
			} else {
				maxpoäng = sc.nextInt();
				break;
			}
		}
		while (true) {
			System.out.println("Ange betygsgräns för G: ");
			sc.nextLine();
			if (sc.hasNextInt() == false) {
				System.err.println("Invalid input  ");
				continue;

			} else {
				g = sc.nextInt();
				break;
			}

		}
		while (true) {
			System.out.println("Ange betygsgräns för VG: ");
			sc.nextLine();
			if (sc.hasNextInt() == false) {
				System.err.println("Invalid input");
				continue;
			} else {
				vg = sc.nextInt();
				break;
			}

		}

		while (true) {
			System.out.println("Hur många värden ska skrivas in?");
			sc.nextLine();
			if (sc.hasNextInt() == false) {
				System.err.println("Invalid input  ");
				continue;
			} else {
				antalPersonerSomSkaLaggasIn = sc.nextInt();
				break;
			}

		}
		System.out.println("Ange skrivningens namn (namnet måste vara unikt) : ");
		Datum();
		FilExisterar();
		while (antalPersonerSomSkaLaggasIn != 0) {
			System.out.println("Ange namn på person nummer " + raknarePersonSkriv);

			if (sc.hasNext() == true) {
				namn.add(sc.next());
				antalPersonerSomSkaLaggasIn--;

				while (true) {
					System.out.println("Skriv in poäng på person nummer " + raknarePersonSkriv);
					sc.nextLine();
					if (sc.hasNextInt() == false) {
						System.err.println("Invalid input");
						continue;
					} else {
						poang.add(sc.nextInt());
						raknarePersonSkriv++;
						break;
					}

				}
			}
		}

		System.out.println("Maxpoäng = " + maxpoäng);
		for (int i = 0; i < namn.size(); i++) {
			System.out.println(namn.get(i));
		}
		for (int i = 0; i < betyg.size(); i++) {
			System.out.println(betyg.get(i));
		}
		
		FilPrint();

	}

	public void FilPrint() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(Filnamn));
		out.write("Hejhopp \n=========================\n");

		for (int i = 0; i < namn.size(); i++) {
			out.write(namn.get(i).toString() + "    ");
			out.write(poang.get(i).toString());
			if (poang.get(i) >= vg) {
				out.write("   " + betyg.get(2).toString());
			} else if (poang.get(i) >= g && poang.get(i) < vg) {
				out.write("   " + betyg.get(1).toString());
			} else {
				out.write("   " + betyg.get(0).toString());
			}

			out.newLine();
		}
		out.close();
	}
	
	public void Datum() {
		NamngeFil = sc.next();
		while (true) {

			System.out.println("Vill du lägga till dagens datum i filnamnet? \nSvara y för ja och n för nej");
			sc.nextLine();
			s = sc.nextLine();
			if (!s.toLowerCase().equals("y") && !s.toLowerCase().equals("n")) {
				System.err.println("Invalid input  ");
				continue;
			}

			if (s.toLowerCase().equals("y")) {
				Filnamn = NamngeFil + java.time.LocalDate.now() + ".txt";
				break;
			}
			if (s.toLowerCase().equals("n")) {
				Filnamn = NamngeFil + ".txt";
				break;
			}

		}
		FilExisterar();
	}
	
	public void FilExisterar() {
		File existera = new File(Filnamn);
		boolean exists = existera.exists(); 
		if (exists == true) {
			System.out.println("En fil med samma namn existerar redan. Vill du skriva över den? \\nSvara y för ja och n för nej");
			while(true) {
//				sc.nextLine();
				s = sc.nextLine();
				if (!s.toLowerCase().equals("y") && !s.toLowerCase().equals("n")) {
					System.err.println("Invalid input. Du måste svara y eller n  ");
					continue;
				}

				if (s.toLowerCase().equals("y")) {
					break;
				}
				if (s.toLowerCase().equals("n")) {
						System.out.println("Ange ett nytt namn på filen");
						Datum();
						break;
					
				}
				
			}
		}
	}

}
