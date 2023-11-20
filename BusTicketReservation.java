package hhh;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
class Bus {
		private int busNo;
		private String ac;
		private int capacity;
		private String driverName;
		private String route;
		private int duration;
		public int getBusNo() {
			return busNo;
		}
		public void setBusNo(int busNo) {
			this.busNo = busNo;
		}
		public String isAc() {
			return ac;
		}
		public void setAc(String ac) {
			this.ac = ac;
		}
		public int getCapacity() {
			return capacity;
		}
		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}
		public String getDriverName() {
			return driverName;
		}
		public void setDriverName(String driverName) {
			this.driverName = driverName;
		}
		public String getRoute() {
			return route;
		}
		public void setRoute(String route) {
			this.route = route;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
			Bus(int busNo, String ac, int capacity ,String driverName, String route, int durartion){
				this.busNo=busNo;
				this.ac=ac;
				this.capacity=capacity;
				this.driverName=driverName;
				this.route=route;
				this.duration=duration;
			}
			public void displayInfo() {
				System.out.println(" Bus No: "+busNo+" AC: "+ac+" Capacity: "+capacity+" Driver Name: "+driverName+" Route: "+route+" Duration: "+duration);
			}
		}
class BusBooking {
	String passengerName;
	int busNo;
	Date date;
	String gender;
	int age;
	BusBooking(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Name of the Passenger:");
		passengerName = sc.next();
		System.out.println("Enter the Bus No:");
		busNo = sc.nextInt();
		System.out.println("Enter the date dd-mm-yyyy:");
		String dateinput = sc.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		try {
			date = dateFormat.parse(dateinput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Enter You're Gender:");
		gender = sc.next();
		System.out.println(("Enter You're Age:"));
		age = sc.nextInt();
	}
	public boolean isAvailable(ArrayList<BusBooking> bookings, ArrayList<Bus> buses) {
		int capacity=0;
		for(Bus bus:buses) {
			if(bus.getBusNo()==busNo)
				capacity = bus.getCapacity();
		}
		int booked = 0;
		for(BusBooking b:bookings) {
			if(b.busNo == busNo && b.date.equals(date)) {
				booked++;
			}
		}
		return booked <capacity?true:false;
	}

}

public class BusTicketReservation {
	public static void main(String[] args) {
		System.out.println("-----WELCOME TO THE BUS TICKET RESERVATION SYSTEM-----");
		System.out.println("-----Read the Given Information Throughly-----");
		System.out.println();
		ArrayList<Bus>buses = new ArrayList<>();
		ArrayList<BusBooking>bookings = new ArrayList<>();
		buses.add(new Bus(1,"Yes",30,"John","Coimbator to Chennai",10));
		buses.add(new Bus(2,"No",50,"Emil","Coimbator to Erode",5));
		buses.add(new Bus(3,"Yes",70,"Joshua","Coimbator to Trichy",6));
		int userOp = 1;
		Scanner sc = new Scanner(System.in);
		for(Bus b:buses) {
			b.displayInfo();
		}
		while(userOp==1) {
			System.out.println("Press 1 to Book You're Tickets and 2 to Exit from the App:");
			userOp = sc.nextInt();
			if(userOp ==1) {
				BusBooking booking = new BusBooking();
				if(booking.isAvailable(bookings, buses)) {
					bookings.add(booking);
					System.out.println("Your Booking is Conformed");
				}
				else {
					System.out.println("Sorry, Bus is Full. Try in another Bus or Date.");
				}
			}
		}
	}
}
