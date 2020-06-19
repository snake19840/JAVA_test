package test1;
import java.util.ArrayList;

class CarForDeepCopy implements Cloneable
{
	private int i;
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}

	public CarForDeepCopy(int i)
	{
		this.i = i;
	}

	public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class DeepCopy {

	public static void main(String[] args) {
		CarForDeepCopy c1 = new CarForDeepCopy(1);

		CarForDeepCopy c2 = null;
		try {
			c2 = (CarForDeepCopy)c1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	       ArrayList<CarForDeepCopy> a1 = new ArrayList<CarForDeepCopy>();
	       ArrayList<CarForDeepCopy> a2 = new ArrayList<CarForDeepCopy>();
	       a1.add(c1);
	       a2.add(c2);

	       a1.get(0).setI(2);
	       System.out.println(a2.get(0).getI());

	}

}
