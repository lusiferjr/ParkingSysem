import java.util.ArrayList;
import java.util.Scanner;

public class RequiredFunctions {
	ArrayList<Slot> parkingslots = new ArrayList<Slot>();
	int index = 0;
	private void findAllCarNumberWithColor(String color) {
		int flag = 0;
		for (Slot slot : parkingslots) {
			if (slot.getCar() != null && slot.getCar().getColor().equals(color)) {
				if (flag == 1)
					System.out.print(",");
				flag = 1;
				System.out.print(slot.getCar().getNumber());
			}
		}
		if (flag == 0)
			System.out.print("Not found");

	}

	void findAllCarSlotNumberWithColor(String color) {
		int flag = 0;
		for (Slot slot : parkingslots) {
			if (slot.getCar() != null && slot.getCar().getColor().equals(color)) {
				if (flag == 1)
					System.out.print(",");
				flag = 1;
				System.out.print(slot.getNumber());
			}
		}
		if (flag == 0)
			System.out.print("Not found");
	}

	void findSlotNumberFromCarNumber(String number) {

		for (Slot slot : parkingslots) {
			if (slot.getCar() != null && slot.getCar().getNumber().equals(number)) {
				System.out.println(slot.getNumber());
				return;
			}
		}
		System.out.print("Not found");
	}

	void testSlot() {
		for (Slot i : parkingslots) {
			System.out.println(i);
		}
	}

	String[] commandParser(String command) {
		return command.split("\\s+");
	}

	void generateSlot(int number) {
		for (int i = 1; i < number + 1; i++) {
			this.parkingslots.add(new Slot(i));
		}
	}

	Slot findEmptySlot() {
		for (Slot i : parkingslots) {
			if (i.getCar() == null) {
				return i;
			}
		}
		return null;

	}

	void status() {

		String carnumber[] = new String[parkingslots.size()];
		String carcolor[] = new String[parkingslots.size()];
		int slotnumber[] = new int[parkingslots.size()];
		
		for (Slot slot : parkingslots) {
			if (slot.getCar() != null) {
				slotnumber[index] = slot.getNumber();
				carnumber[index] = slot.getCar().getNumber();
				carcolor[index] = slot.getCar().getColor();
				index++;
			}
		}
		System.out.println("Slot No.");
		for (int i=0;i<index;i++) {
			System.out.println(slotnumber[i]);
		}
		System.out.println("Registration No");
		for (int i=0;i<index;i++) {
			System.out.println(carnumber[i]);
		}
		System.out.println("Colour");
		for (int i=0;i<index;i++) {
			System.out.println(carcolor[i]);
		}

	}

	void menu() {

		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();
		String commandPart[] = commandParser(command);
		Slot currentSlot;
		switch (commandPart[0]) {
		case "create_parking_lot":
			try {
				generateSlot(Integer.parseInt(commandPart[1]));
				System.out.println("Created a parking lot with " + commandPart[1] + " slots");
			} catch (Exception e) {
				System.out.println("enter a valid number");
			}
			break;
		case "park":
			currentSlot = findEmptySlot();
			if (parkingslots.size() != 0) {
				if (currentSlot == null) {
					System.out.println("Sorry, parking lot is full");
					break;
				} else {
					currentSlot.setCar(new Car(commandPart[1], commandPart[2]));
					System.out.println("Allocated slot number:" + currentSlot.getNumber());
				}
			} else {
				System.out.println("create slot first");
			}
			break;
		case "leave":
			try {
				currentSlot = parkingslots.get(Integer.parseInt(commandPart[1]) - 1);
				currentSlot.setCar(null);
				System.out.println("Slot number " + currentSlot.getNumber() + " is free");

			} catch (Exception e) {
				System.out.println("enter a slot number");
			}
			break;
		case "slot_numbers_for_cars_with_colour":
			findAllCarSlotNumberWithColor(commandPart[1]);
			System.out.println();
			break;
		case "registration_numbers_for_cars_with_colour":
			findAllCarNumberWithColor(commandPart[1]);
			System.out.println();
			break;
		case "slot_number_for_registration_number":
			findSlotNumberFromCarNumber(commandPart[1]);
			System.out.println();
			break;
		case "status":
			status();
			break;
		case "exit":
			System.exit(0);
			break;
		default:
			break;
		}
	}

}
/*
 * create_parking_lot 6 park KA-01-HH-1234 White
 * 
 * park KA-01-HH-9999 White
 * 
 * park KA-01-BB-0001 Black
 * 
 * park KA-01-HH-7777 Red
 * 
 * park KA-01-HH-2701 Blue
 * 
 * park KA-01-HH-3141 Black
 * 
 * 
 * leave 4
 * 
 * park KA-01-P-333 White
 */
