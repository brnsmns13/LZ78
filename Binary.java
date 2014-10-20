public class Binary {
	public static String ToBinary(String str)
	{
		final char[] masks = {0x8000,0x4000,0x2000,0x1000,0x800,0x400,0x200,0x100,0x80,0x40,0x20,0x10,0x8,0x4,0x2,0x1};
		String ret = "";

		for(int i = 0;i < str.length();i++)
		{
			char c = str.charAt(i);

			for(int j = 0;j < 16;j++)
				if((c & masks[j]) == 0)
					ret += "0";
				else
					ret += "1";
		}

		return ret;
	}

	public static String FromBinary(String str)
	{
		final char[] bits = {0x8000,0x4000,0x2000,0x1000,0x800,0x400,0x200,0x100,0x80,0x40,0x20,0x10,0x8,0x4,0x2,0x1};
		String ret = "";

		for(int i = 0;i < str.length();i += 16)
		{
			char c = 0x0000;

			for(int j = 0;j < 16;j++)
				if(str.charAt(i + j) == '1')
					c |= bits[j];

			ret += c;
		}

		return ret;
	}

}
