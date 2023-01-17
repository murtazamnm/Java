package serialized;

import java.io.Serializable;
import java.util.Arrays;

// Serializable: marker interface
public class SomeData implements Serializable {
	private static final long serialVersionUID = 2022_11_03L;

	private int num;
	private String txt;
	private double[] moreNums;

	public SomeData(int num, String txt, double[] moreNums) {
		this.num = num;
		this.txt = txt;
		this.moreNums = moreNums;
	}

	@Override
	public String toString() {
		return "SomeData [num=" + num + ", txt=" + txt + ", moreNums=" + Arrays.toString(moreNums) + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public double[] getMoreNums() {
		return moreNums;
	}

	public void setMoreNums(double[] moreNums) {
		this.moreNums = moreNums;
	}
}
