**Requirements:**
The program is not generic and can only be executed based on shapes.


	**Steps to use the Sorting Program:**
		- Using Netbeans will auto compiled all the .java files and create the .jar file in the dist folders.
		  Navigate to the root directory and open the terminal
		  Input the following command line: java -jar .\dist\Sort.jar -sb -tv -f"shapes1.txt"

	**Arguments to input:**
	        -f”..”: Input the file name that will be executed with sorting algorithms.
	        -s.. (b: Bubble Sort, s: Selection Sort, i: Insertion Sort, m: Merge Sort, q: Quick Sort, z: Cycle Sort) with no spaces, can be upper or lower cases.
	        -t.. (h: Sorting by height, v: Sorting by Volumes, a: Sorting by Based Area) with no spaces, can be upper or lower cases.
	        Ex: java -jar .\dist\Sort.jar -sm -th -f"shapes1.txt"
			        java -jar .\dist\Sort.jar -ss -f"shapes2.txt" -ta 
	            java -jar .\dist\Sort.jar -f"shapes3.txt" -sq -tv 
