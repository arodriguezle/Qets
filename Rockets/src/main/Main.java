package main;

import java.util.Scanner;

import domain.*;

public class Main {
	private static int DETERMINED_SPEED_ALGORIHTM = 1, BACKTRACKING_ALGORITHM = 2;
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		
		System.out.println(
				"Select Algorithm:  \n1 => determinedSpeedAlgorithm   \n2 => backtrackingAlgorithm (Not finished yet, it is for the next delivery)");
		int selection = Integer.valueOf(scan.next());
		
	}
}
