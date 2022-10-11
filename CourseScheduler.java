//Ben Ford
//CPSC 340 
//4/19/2022
//see graphs class for info on sizeOfNeigh(int n)


import java.io.*;  
import java.io.FileNotFoundException; 
import java.util.Scanner;


public class CourseScheduler {
    
    public static void main(String args[]) {

	try{
		FileInputStream f = null;
		Scanner in = null;
		f = new FileInputStream(args[0]);
		in = new Scanner(f);
		int i = in.nextInt();
		i = i;
		in.close();


	
		Graph<String> courses = new Graph<String>(i);  
		f = null;
		f = new FileInputStream(args[0]);
 
		Scanner intwo = new Scanner(f);
		intwo.nextLine();

		int c = 0;

		while(intwo.hasNextLine() == true){
			String yo = intwo.nextLine();
			String [] yoyo = yo.split(" ");

			courses.setValue(c,yoyo[0]);


			c = c + 1;			
		}
		int g;

		Scanner inthree = null;
		intwo.close();
		f = null;
		f = new FileInputStream(args[0]);
		inthree = new Scanner(f);
		inthree.nextLine();
		c = 0;

		while(inthree.hasNextLine() == true){
			String word = inthree.nextLine();
			String[] line = word.split(" ");
			int yo = line.length;
			int y;
			for (y = 2; y < line.length;y++){
				courses.insertEdge(line[0], line[y]);
			}


		}
	
		int num = courses.getSize();
      	String[] ordering = new String[num];
	      String[] start = new String[num];
	      start[0] = "marker";
		int a = 0;
		int b = 0;
		int numOfEl = num - 1;
		int num2 = ordering.length - 1;

	        while(start[0] != null) {
	        	int bucket;
	            	if (ordering[numOfEl] != null) {
	                	break;
            		}
	    		bucket = 0;
            		start = new String[num];



		        for(a = 0;a < num; a++) {
	 	                boolean marker = false;
		                while (b < num) {

		                	if (courses.isEdge(a, b) == true) {
				
		                        marker = true;
					
			                }
			
				        b = b + 1;
    			        }
			
			b = 0;
	                if (marker == false) {

		                while(b < num) {
		                        if (ordering[b] != null) {
		                        	if (ordering[b].toString() == courses.getValue(a).toString()) {
		     				
				        		break;
			
			                        }
		                        } else {
		                                start[bucket] = courses.getValue(a).toString();
      	 
			                        ordering[b] = courses.getValue(a).toString();
		              			bucket = bucket + 1;
				
			                        break;	
		                        }
					b = b + 1;
		
		               }
			
			}
		
		  

            

		}
	
		int num3 = start.length;
           
            	for(a = 0;a < num3; a++) {
                	if (start[a] == null) {
				break;
                	}
                	for(b = 0; b < num; b++) {
                    		if (courses.isEdge(b, courses.lookup(start[a])) == true) {
                        		courses.removeEdge(b, courses.lookup(start[a]));
                    		}

		
	
	                }

       	        }
        }
	

	String[] wrong = new String[num];
       	boolean check = false;
	int x = 0;
	int y = 0;
	String wron = "";
	int m = 0;
	while(x < num){
		while(y < num){
			if(courses.sizeOfNeigh(x) > 0){
				wron = courses.getValue(x).toString();
				check = true;

				
			}	
			y = y + 1;


				
				
				
		}
	
		x = x + 1;
	}




        
        if(check == true){

		x = 0;
		y = 0;
		int checkie = wrong.length;
		while (x < checkie){
			System.out.println("impossible sort: " + wron);
						

			x = x + 1;
		}
	}else{

		for(x = 0; x < ordering.length; x++){
			System.out.println(ordering[x]);
		}
	}

	}
 
	catch(FileNotFoundException e){
		System.out.println("Invalid");
	}
    }
}

