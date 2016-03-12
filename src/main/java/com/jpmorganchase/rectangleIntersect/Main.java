package com.jpmorganchase.rectangleIntersect;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = in.readLine()) != null) {
			// System.out.println(s);
			String[] temp = s.split(" ");
			if (temp.length < 8)
				continue;
			try {
				int w, h;
				Point p1_rec1 = new Point(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]));
				w = Integer.valueOf(temp[2]);
				h = Integer.valueOf(temp[3]);
				Point p2_rec1 = new Point(p1_rec1.x + w, p1_rec1.y);
				Point p3_rec1 = new Point(p1_rec1.x, p1_rec1.y + h);
				Point p4_rec1 = new Point(p1_rec1.x + w, p1_rec1.y + h);
				Point p1_rec2 = new Point(Integer.valueOf(temp[4]), Integer.valueOf(temp[5]));
				w = Integer.valueOf(temp[6]);
				h = Integer.valueOf(temp[7]);
				Point p2_rec2 = new Point(p1_rec2.x + w, p1_rec2.y);
				Point p3_rec2 = new Point(p1_rec2.x, p1_rec2.y + h);
				Point p4_rec2 = new Point(p1_rec2.x + w, p1_rec2.y + h);

				List<Point> rec1 = new ArrayList<Point>();
				rec1.add(p1_rec1);
				rec1.add(p2_rec1);
				rec1.add(p3_rec1);
				rec1.add(p4_rec1);
				List<Point> rec2 = new ArrayList<Point>();
				rec2.add(p1_rec2);
				rec2.add(p2_rec2);
				rec2.add(p3_rec2);
				rec2.add(p4_rec2);

				boolean isInRect = false;
				for (Point p : rec1) {
					if (isInPolygon(p, rec2)) {
						isInRect = true;
					}
				}

				System.out.println(isInRect);

			} catch (NumberFormatException ne) {
				continue;
			}
		}
	}

	public static boolean isInPolygon(Point x, List<Point> l) {
		if (l.get(0).x <= x.x && l.get(0).y <= x.y) {
			if (l.get(1).x >= x.x && l.get(1).y <= x.y) {
				if (l.get(2).x <= x.x && l.get(2).y >= x.y) {
					if (l.get(3).x >= x.x && l.get(3).y >= x.y) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// public static boolean isInPolygon(Point x, List<Point> l) {
	// boolean result = false;
	// for (int i = 0, j = l.size() - 1; i < l.size(); j = i++)
	// if (((l.get(i).x > x.x) != (l.get(j).x > x.x))
	// && (x.y < ((l.get(j).y - l.get(i).y) * (x.x - l.get(i).x) / (l.get(j).x -
	// l.get(i).x)
	// + l.get(i).y)))
	// result = !result;
	// return result;
	// }
}
