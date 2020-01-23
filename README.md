# columnPrinter
This applicaiton represents a solution to a coding challenge. It takes a string as an argument and reprints the string as a column with a width of 13 characters without breaking words.
## Dependencies
* git
* maven
* java 1.8 or higher
## Build
    git clone https://github.com/thoreaudesign/columnPrinter.git  
    cd columnPrinter/
    mvn install  
    java -jar target/columnPrinter-1.0.0.jar "some text to print as column"
# Challege Description
> **Text Wrap Problem**
>  
> Write a program that takes an input string and prints it as multiple lines of text such that no line of text is greater than 13 characters and words are kept whole.  
>
> For example, the first line of the Gettysburg address:  
> *Four score and seven years ago our fathers brought forth upon this continent a new nation,
> conceived in liberty and dedicated to the proposition that all men are created equal*  
>
> Becomes
>  
    Four score  
    and seven  
    years ago  
    our fathers  
    brought  
    forth upon  
    this  
    continent a  
    new nation,  
    conceived in  
    liberty and  
    dedicated to  
    the  
    proposition  
    that all men  
    are created  
    equal  
