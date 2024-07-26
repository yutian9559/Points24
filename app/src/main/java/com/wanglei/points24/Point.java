package com.wanglei.points24;

import java.util.ArrayList;
import java.util.List;

public class Point {
	public static final int OPERATOR_INVALID = 0;
	public static final int OPERATOR_ADD = 1;
	public static final int OPERATOR_SUBTRACT = 2;
	public static final int OPERATOR_MULTIPLY = 3;
	public static final int OPERATOR_DIVIDE = 4;
	private static final int[] OPERATOR_LIST = { OPERATOR_ADD, OPERATOR_SUBTRACT, OPERATOR_MULTIPLY, OPERATOR_DIVIDE };
	private final Point mA;
	private final Point mB;
	private final float mValue;
	private final int mOperator;

	public Point(float value) {
		mA = null;
		mB = null;
		mValue = value;
		mOperator = OPERATOR_INVALID;
	}

	public Point(Point a, Point b, int operator) {
		mA = a;
		mB = b;
		mOperator = operator;
		float valueA = a.getValue();
		float valueB = b.getValue();
		switch (operator) {
		case OPERATOR_ADD:
			mValue = valueA + valueB;
			break;
		case OPERATOR_SUBTRACT:
			mValue = valueA - valueB;
			break;
		case OPERATOR_MULTIPLY:
			mValue = valueA * valueB;
			break;
		case OPERATOR_DIVIDE:
			mValue = valueA / valueB;
			break;
		default:
			mValue = valueA;
			break;
		}
	}

	public float getValue() {
		return mValue;
	}

	@Override
	public String toString() {
		final String result;
		switch (mOperator) {
		case OPERATOR_ADD:
			result = "(" + mA + "+" + mB + ")";
			break;
		case OPERATOR_SUBTRACT:
			result = "(" + mA + "-" + mB + ")";
			break;
		case OPERATOR_MULTIPLY:
			result = "(" + mA + "*" + mB + ")";
			break;
		case OPERATOR_DIVIDE:
			result = "(" + mA + "/" + mB + ")";
			break;
		default:
			result = Float.toString(mValue);
			break;
		}
		return result;
	}

	public static List<Point> getPoints24(float a, float b, float c, float d) {
		List<Point> input = new ArrayList<>();
		List<Point> output = new ArrayList<>();
		input.add(new Point(a));
		input.add(new Point(b));
		input.add(new Point(c));
		input.add(new Point(d));
		List<Point> temp = getPoints(input);
		for (Point point : temp) {
			float value = point.getValue();
//			System.out.println("point = " + point + ", value = " + value);
			if (value > 23.99f && value < 24.01f) {
				output.add(point);
			}
		}
		return output;
	}

	private static List<Point> getPoints(List<Point> input) {
		List<Point> output = new ArrayList<>();
		int size = input.size();
		if (size > 1) {
			for (int i = 0; i < size; i++) {
				Point a = input.get(i);
				List<Point> subInput = remove(input, i);
				for (int j = 0; j < subInput.size(); j++) {
					Point b = subInput.get(j);
					List<Point> subInput2 = remove(subInput, j);
					for (int operator : OPERATOR_LIST) {
						List<Point> subInput3 = new ArrayList<>(subInput2);
						subInput3.add(new Point(a, b, operator));
						output.addAll(getPoints(subInput3));
					}
				}
			}
		} else if (size == 1) {
			output = input;
		}
		return output;
	}

	private static List<Point> remove(List<Point> input, int index) {
		List<Point> sub = new ArrayList<>(input);
		sub.remove(index);
		return sub;
	}
}