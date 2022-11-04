
import java.util.*;
class Main {
	// A binary search based function
	// that returns index of a peak element
	static int findPeakUtil(
		int arr[], int low, int high, int n)
	{
		int mid = low + (high - low) / 2;
		System.out.println(low+" "+mid+" "+high);
		
		// Compare middle element with its neighbours (if neighbours exist)
		// mid == 0 && arr[mid + 1] <= arr[mid] i.e arr[1] <arr[0] corner case start
		// mid == n - 1 && arr[mid - 1] <= arr[mid] corner case last
		// arr[mid - 1] <= arr[mid] &&  arr[mid + 1] <= arr[mid]) when mid is peak
		
		if ((mid == 0 || arr[mid - 1] <= arr[mid])
			&& (mid == n - 1 || arr[mid + 1] <= arr[mid]))
			return mid;

		// If middle element is not peak
		// and its left neighbor is
		// greater than it, then left half
		// must have a peak element
		else if (mid > 0 && arr[mid + 1] > arr[mid])
			return findPeakUtil(arr, (mid + 1), high, n);

		// If middle element is not peak
		// and its right neighbor
		// is greater than it, then right
		// half must have a peak
		// element
		else
			return findPeakUtil(arr, low, (mid - 1) , n);
	}

	static int findPeak(int arr[], int n)
	{
		return findPeakUtil(arr, 0, n - 1, n);
	}

	public static void main(String[] args)
	{
		int arr[] = { 1, 3, 20, 21, 1, 0 };
		int n = arr.length;
		System.out.println("Index of  peak element is " + findPeak(arr, n));
	}
}
