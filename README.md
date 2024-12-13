WordTracker Application

The WordTracker application processes text files, tracks unique words, and provides information about their occurrences across files and line numbers. It supports serialized storage, allowing persistent tracking across multiple runs.

Features

Tracks occurrences of words across multiple files.

Records line numbers and filenames where each word appears.

Allows export of results to an output file.

Provides three display options:

-pf: Lists words and filenames.

-pl: Lists words, filenames, and line numbers.

-po: Lists words, filenames, line numbers, and frequency.

How to Run the Program

Prerequisites

Java 8 or higher installed.

The WordTracker application JAR file (e.g., WordTracker.jar).

Input text files located in the src/res/ directory.

Running the Program

To run the program, use the following format:

java -jar WordTracker.jar <input.txt> -pf/-pl/-po [-f <output.txt>]

Arguments

<input.txt> (Required):

Path to the input text file to process. Must end with .txt.

-pf, -pl, -po (Required):

Specify the display option for the output:

-pf: Displays words and filenames.

-pl: Displays words, filenames, and line numbers.

-po: Displays words, filenames, line numbers, and frequency of appearances.

[-f <output.txt>] (Optional):

Specifies an output file to save the results. Must end with .txt.

Examples

Example 1: Basic Usage

java -jar WordTracker.jar sample.txt -pf

Output:

Reading and processing the file...
Key : ===hello=== found in file(s): sample.txt,
Key : ===world=== found in file(s): sample.txt,

Example 2: Export Results to a File

java -jar WordTracker.jar sample.txt -pl -f output.txt

Output:

Reading and processing the file...
Exporting file to: src/res/output.txt

The results will also be saved in src/res/output.txt.

Help

To view the usage guide:

java -jar WordTracker.jar -h

Output:

Format guide: java -jar WordTracker.jar <input.txt> -pf/-pl/-po [-f <output.txt>]

Notes

Ensure the input files are placed in the src/res/ directory.

If the repository.ser file exists, previously processed data will be loaded, and the program will merge new data with the existing tree.

Results can be exported to a text file using the -f option.

If an input or output file is invalid, the program will display an appropriate error message.

Troubleshooting

Common Errors

"Invalid number of inputs!":

Ensure you provided the correct number of arguments.

"Please enter a valid .txt file.":

Check that the input and output file names end with .txt.

"Couldn't find the file to export to.":

Ensure the output file is writable and located in the src/res/ directory.

For further assistance, refer to the source code or contact the program maintainers.

