public class TestTime {
	// global variables !!!
	public static int passed = 0;
	public static int total = 0;
	
	public static void main(String[] args) {
        test(3, 45, "3h45m");
        test(0, 55, "0h55m");
        test(0, 155, "2h35m");
        test(3, 155, "5h35m");
        test(6, 0, "6h0m");
        
        test(3, 45, 2, 30, "6h15m");
        test(3, 45, 0, 30, "4h15m");
        test(3, 45, 2, 0, "5h45m");
        test(3, 45, 2, 130, "7h55m");
        test(3, 45, 0, 130, "5h55m");
        
        test("6h15m", 3, 45, 2, 30);
        test("4h15m", 3, 45, 0, 30);
        test("5h45m",3, 45, 2, 0);
        test("7h55m", 3, 45, 2, 130);
        test("5h55m",3, 45, 0, 130);
        
        

                
   //   _____   ____    _   _  ____ _______   ______ _____ _____ _______ 
    //  |  __ \ / __ \  | \ | |/ __ \__   __| |  ____|  __ \_   _|__   __|
    //  | |  | | |  | | |  \| | |  | | | |    | |__  | |  | || |    | |   
    //  | |  | | |  | | | . ` | |  | | | |    |  __| | |  | || |    | |   
    //  | |__| | |__| | | |\  | |__| | | |    | |____| |__| || |_   | |   
    //  |_____/ \____/  |_| \_|\____/  |_|    |______|_____/_____|  |_|     
    //
        
        if (passed < total) 
        	System.err.println("\nPass/Total: " + passed + "/" + total);
        else {
        	System.out.println("\nPass/Total: " + passed + "/" + total + " !");
        }
	}
	
	private static void test(int hours, int min, String sresult) { 
		TimeSpan t1 = new TimeSpan(hours, min);
			total++;
		if (t1.toString().equals(sresult) && (t1.getTotalHours()==(t1.hours+t1.minutes/60.0))){
			passed++;
			System.out.println(t1 +" "+ t1.getTotalHours()+" expected "+ sresult+" expected "+ (t1.hours+t1.minutes/60.0)+" Passed");	
		}
		else {
			System.out.println(t1 +" "+ t1.getTotalHours()+" expected "+ sresult+" expected "+ (t1.hours+t1.minutes/60.0)+" Failed");
		}
		   }
	
	private static void test(int hours, int min, int hours2, int min2, String sresult) { 
		TimeSpan t1 = new TimeSpan(hours, min);
		TimeSpan t2 = new TimeSpan(hours2, min2);
		total++;
		//t1.add(t2);
		t1.add(hours2, min2);		
		if (t1.toString().equals(sresult) && (t1.getTotalHours()==(t1.hours+t1.minutes/60.0))){
			passed++;
			System.out.println(t1 +" "+ t1.getTotalHours()+" expected "+ sresult+" expected "+ (t1.hours+t1.minutes/60.0)+" Passed");	
		}
		else {
			System.out.println(t1 +" "+ t1.getTotalHours()+" expected "+ sresult+" expected "+ (t1.hours+t1.minutes/60.0)+" Failed");
		}
	}

		private static void test(String sresult, int hours, int min, int hours2, int min2 ) { 
			TimeSpan t1 = new TimeSpan(hours, min);
			TimeSpan t2 = new TimeSpan(hours2, min2);
			total++;
			t1.add(t2);
				
			if (t1.toString().equals(sresult) && (t1.getTotalHours()==(t1.hours+t1.minutes/60.0))){
				passed++;
				System.out.println(t1 +" "+ t1.getTotalHours()+" expected "+ sresult+" expected "+ (t1.hours+t1.minutes/60.0)+" Passed");	
			}
			else {
				System.out.println(t1 +" "+ t1.getTotalHours()+" expected "+ sresult+" expected "+ (t1.hours+t1.minutes/60.0)+" Failed");
			}	
    }
}