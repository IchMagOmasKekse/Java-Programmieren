package me.xxfreakdevxx.de.game;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
@SuppressWarnings("deprecation")
public class Console {
	
	
	public static String getTimeInString() {
		SimpleDateFormat sdf = new SimpleDateFormat();
		Calendar date = sdf.getCalendar();
		Date d = date.getTime();
		return d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
	}
	public static String getDateInString() {
		SimpleDateFormat sdf = new SimpleDateFormat();
		Calendar date = sdf.getCalendar();
		Date d = date.getTime();
		int day = d.getDate();
		int mon = d.getMonth();
		int year = d.getYear();
		return day+":"+mon+":"+year;
	}
	public static void send(String prefix, String... strings) {
		for(String s : strings) {
			System.out.println("["+getTimeInString()+"]["+prefix+"] >"+s);
		}
	}
	public static void sendIfDebug(String prefix, String... strings) {
		if(Game.DEBUG) {			
			for(String s : strings) {
				System.out.println("["+getTimeInString()+"]["+prefix+"][Debugging] >"+s);
			}
		}
	}
	
	public static void tick() {
//		CommandAnalysis.analyse();
	}
	@SuppressWarnings("unused")
	private static class CommandAnalysis {
		
		public static void analyse() {
			
//	        try {
//	            BufferedReader buffy = new BufferedReader(new InputStreamReader(System.in));
//	            String in = buffy.readLine();
//	            buffy.close();
//	            if(isCommand(in)) send("Command", in);
//	        }
//	        catch (IOException e) {}
			
//			send("INFO", "Analysing");
//			// Erzeugung eines neuen Objektes
//			Scanner sc = new Scanner(System.in);
//			if(sc.hasNextLine()) {
//				// Einlesen der Eingabe in den String "eingabe"
//				String input = sc.nextLine();
//
//				// Ausgabe der Eingabe
//				send("Info", "Command: "+input);
////				if(isCommand(input)) {
////				}else send("Info", "Nachricht >"+input);
//			}
//			// Schließen des Scanners (nicht nötig, aber empfohlen)
//			sc.close();
			return;
		}
		public static boolean isCommand(String message) {
			while(message.startsWith(" ")) {
				message = message.substring(1, message.length());
			}
			if(message.startsWith("/")) {
				return true;
			} else return false;
		}
		
	}
	
//	public class Konsole extends JFrame implements ActionListener {
//	    
//	    private Process proc = null;
//	    
//	    public Konsole() {
//	        
//	    }
//	    
//	    public void exec(final String toExecute) {
//	        
//	        new Thread(new Runnable() {
//	            public void run() {
//	                try {
//	                    proc = Runtime.getRuntime().exec(toExecute);
//	                    InputStream in = proc.getInputStream();
//	                    bw = new BufferedWriter(new OutputStreamWriter(proc.getOutputStream()));
//	                    int bytes = 0;
//	                    setVisible(true);
//	                    while ((bytes = in.read()) != -1) {
//	                        ausgabe.append(String.valueOf((char)bytes));
//	                    }
//	                }
//	                catch (IOException e) {
//	                    e.printStackTrace();
//	                }
//	            }
//	        }).start();
//	    }
//	    
//	    public void actionPerformed(ActionEvent evt) {
//	        
//	        try {
//	            bw.write(eingabe.getText());
//	            bw.flush();
//	            eingabe.setText("");
//	        }
//	        catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	    
//	    public static void main(String[] args) {
//	        
//	        Konsole kon = new Konsole();
//	        kon.exec("java Blup");
//	    }
//	}
	
}
