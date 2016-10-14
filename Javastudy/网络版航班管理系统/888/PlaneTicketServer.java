import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class PlaneTicketServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(3000);
		Socket socket=server.accept();
		BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
		while(true){
		StringBuilder sb=new StringBuilder();
		String msg=null;
		while((msg=br.readLine()).length()>0){
			sb.append(msg);
			sb.append("\r\n");
			if(msg==null){
				break;
			}
		}
		String requestInfo=sb.toString().trim();
		System.out.println(requestInfo);
		String firstLine=requestInfo.substring(0,requestInfo.indexOf("\r\n"));
		String urlStr=firstLine.substring(firstLine.indexOf("?")+1, firstLine.indexOf("HTTP"));
		System.out.println(urlStr);
		String [] parameterMapValue=urlStr.split("=");
		
		StringBuffer response=new StringBuffer(); 
		
		switch(parameterMapValue[0]){
			case "flight":
				TreeSet<Ticket> ts1=new TreeSet<Ticket>();
				addIntoSet(ts1);
				for(Ticket ticket:ts1){
					if((parameterMapValue[1].trim()).equals(ticket.getFlight())){
						response.append(ticket);
						break;
					}
				}
				if(response.toString()==null||response.toString().equals("")){
					response.append("未找到该班次的机票");
				}
				
				break;
			case "price":
				TreeSet<Ticket> ts2=new TreeSet<Ticket>(new Comparator<Ticket>(){
					public int compare(Ticket a1,Ticket a2){
						if(a1.getPrice()==a2.getPrice()){
							return a1.getFlight().compareTo(a2.getFlight());
						}
						return a1.getPrice()-a2.getPrice();
					}
				});
				addIntoSet(ts2);
				Set<Ticket> priceTailts=ts2.tailSet(new Ticket("",Integer.parseInt(parameterMapValue[1].trim()),""));
				for(Ticket ticket:priceTailts){
					response.append(ticket+"\r\n");
				}
				if(response.toString()==null||response.toString().equals("")){
					response.append("未找到该班次的机票");
				}
				break;
			case "time":
				TreeSet<Ticket> ts3=new TreeSet<Ticket>(new Comparator<Ticket>(){
					public int compare(Ticket a1,Ticket a2){
						if(a1.getTime()==a2.getTime()){
							return a1.getFlight().compareTo(a2.getFlight());
						}
						return a1.getTime().compareTo(a2.getTime());
					}
				});
				addIntoSet(ts3);
				Set<Ticket> timeTailts=ts3.tailSet(new Ticket("",0,parameterMapValue[1]));
				for(Ticket ticket:timeTailts){
					response.append(ticket+"\r\n");
				}
				if(response.toString()==null||response.toString().equals("")){
					response.append("未找到该班次的机票");
				}
				break;
			default:
				break;
		}
		pw.println(response.toString());
		pw.println("!@#$%^&*()");
	}
		
	}
	private static void addIntoSet(TreeSet<Ticket> ts){
		ObjectInputStream ois;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("/Users/abc123/desktop/abc.txt"));
			TreeSet<Ticket> fileTs=(TreeSet<Ticket>)ois.readObject();
			for(Ticket ticket:fileTs){
				ts.add(ticket);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
