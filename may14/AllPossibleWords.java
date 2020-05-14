https://www.geeksforgeeks.org/find-all-possible-interpretations/


static int allWord(String str,String ans)
	{
		if(str.length()==0)
		{
			System.out.println(ans);
			return 1;
		}
		
		int count=0;
		
		if(str.length()>1)
		{
			int  two=Integer.parseInt(str.substring(0,2));
			if(two>9&&two<=26)
			{
//				System.out/.println(two);
				char curr=(char)(two+96);
				
				count+=allWord(str.substring(2), ans+curr);
			}
		}
		int one =Integer.parseInt(str.charAt(0)+"");
		if(one!=0)
		{
			
			
			char curr=(char)(one+96);
			
			count+=allWord(str.substring(1), ans+curr);	
		}
		

		return count;
		
		
	}

}
