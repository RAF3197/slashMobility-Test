package com.example;

import com.example.plateGenerator.LicensePlateGenerator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
	public static void main(String[] args)
	{
		LicensePlateGenerator generator = new LicensePlateGenerator();

		try {
			System.out.println("Generating some plates:");

			System.out.println("Index 0: " + generator.getPlateNumber(0));
			System.out.println("Index 1: " + generator.getPlateNumber(1));
			System.out.println("Index 35: " + generator.getPlateNumber(35));
			System.out.println("Index 36: " + generator.getPlateNumber(36));
			System.out.println("Index 123456: " + generator.getPlateNumber(123456));
			System.out.println("Last Index: " + generator.getPlateNumber(2176782335L));

			System.out.println("\nInvalid index -1:");
			generator.getPlateNumber(-1);

		} catch (IllegalArgumentException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}