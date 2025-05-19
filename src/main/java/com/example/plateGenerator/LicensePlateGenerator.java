package com.example.plateGenerator;


public class LicensePlateGenerator
{
	private static final char[] chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static final int plateLength = 6;
	private static final long maxIndex = (long) Math.pow(chars.length, plateLength) - 1;

	public String getPlateNumber(long index)
	{
		if (index < 0 || index > maxIndex) throw new IllegalArgumentException("Plate index must be between 0 and " + maxIndex);

		char[] plate = new char[plateLength];

		for (int i = plateLength - 1; i >= 0; i--)
		{
			int element = (int) (index % chars.length);

			plate[i] = chars[element];

			index /= chars.length;
		}

		return new String(plate);

	}
}
