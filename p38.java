import java.util.*;

public class p38 {
	public static void main(String[] args) {
		
		long max_resault = 0;
		boolean pan[] = new boolean[9];
		for (int i = 0; i < args.length; i++) {
			pan[i] = false;
		}
		for(long i = 2; i < 10000; i++) {
			if( i == 9)
				System.out.println();
			long res = i;
			long result = i;
			int j = 2;
			while(result < 900000000)
			{
				res = i*j;
				j++;
				result = num_concat(result,res);
			}
			Check_Single_section(result,pan);
			if(all_array_unanimous(pan,9))
			{
				if(max_resault < result)
					max_resault = result;
			}
		}
		System.out.println(max_resault);
	}
	
	
	public static boolean Check_Single_section(long temp_multiplier,boolean pandigital[])
	{
		while((double)temp_multiplier / 10 >= 1)
		{
			long num = (int)temp_multiplier % 10;
			temp_multiplier /= 10;
			if(num-1 < 0) {
				return false;
			}
			if(!pandigital[(int) (num-1)])
				pandigital[(int) (num-1)] = true;
			else
				return false;
		}
		if(temp_multiplier-1 >= 0)
		{
			if(!pandigital[(int) (temp_multiplier-1)])
				pandigital[(int) (temp_multiplier-1)] = true;
			else
				return false;
		}
		return true;
	}

	public static boolean all_array_unanimous(boolean array[],int BOUND)
	{
		boolean return_value = true;
		for (int c = 0; c < BOUND ; c++) {
			if(array[c] == true)
				continue;
			return_value = false;
		}

		for (int i = 0; i < array.length; i++) {
			array[i] = false;
		}

		return return_value;

	}
	
	static long num_concat(long left_side,long right_side)
	{
		long concat = 0;
		int size_of_right = size_of_num(right_side);
		long shift = (long)Math.pow(10, size_of_right);
		left_side *= shift;
		concat += left_side+right_side;
		return concat;
	}
	static int size_of_num(long num)
	{
		long t_num = num;
		int counter = 0;
		while(t_num >= 1)
		{
			t_num/=10;
			counter++;
		}
		return counter;
	}
}