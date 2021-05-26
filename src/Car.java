
public class Car {
String number;
String color;

@Override
public String toString() {
	return "Car [number=" + number + ", color=" + color + "]";
}
public Car(String number, String color) {
	super();
	this.number = number;
	this.color = color;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}

}
