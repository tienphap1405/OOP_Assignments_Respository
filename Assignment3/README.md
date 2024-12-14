# WordTracker Program

The **WordTracker** program processes text files, tracks words, and provides information about their total number of appearances with line numbers. across files. It supports serialized and deserialized, allowing persistent tracking across multiple runs.

- Provides three display options:
  - **-pf**: Lists words and filenames.
  - **-pl**: Lists words, filenames, and line numbers.
  - **-po**: Lists words, filenames, line numbers, and frequency.

---

## How to Run the Program

To run the program, use the following format, and it MUST be run from the project directory:

```
java -jar ./dist/WordTracker.jar <input.txt> -pf/-pl/-po [-f <output.txt>]
```

#### Arguments

1. **`<input.txt>`** (Required):

   - Path to the input text file to process. Must end with `.txt`.

2. **`-pf`, `-pl`, `-po`** (Required):

   - Specify the display option for the output:
     - **`-pf`**: Displays words and filenames.
     - **`-pl`**: Displays words, filenames, and line numbers.
     - **`-po`**: Displays words, filenames, line numbers, and frequency of appearances.

3. **`[-f <output.txt>]`** (Optional):
   - Specifies an output file to save the results. Must end with `.txt`.

---

## Notes

1. Ensure the input files are placed in the `src/res/` directory.
2. If an input or output file is invalid, the program will display an appropriate error message.
