
public class Slot {
	Car car;
	int number;
	
	@Override
	public String toString() {
		return "Slot [car=" + car + ", number=" + number + "]";
	}
	public Slot( int number) {
		this.number = number;
		this.car=null;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
