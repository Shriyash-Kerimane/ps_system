package com.demo.spring;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int large = -1;
		int second = -2;

		for (int i = 0; i < n; i++) {
			if (second < arr[i]) {
				if (large < arr[i]) {
					second = large;
					large = arr[i];
				} else if (arr[i] != large) {
					second = arr[i];
				}
			}
		}
		System.out.println(second);
	}

}
