package jdavis.columnPrinter;

import java.util.StringTokenizer;

import org.apache.commons.lang3.*;

public class TextProcessor 
{
	private static final int MAX_LINE_LENGTH = 13;
	
	public static final String MISSING_ARGUMENT = "Missing string as argument.";
	
	String column;
	String[] args;
	
	StringBuilder output;
	StringBuilder currentLine;
	
	public TextProcessor(String[] args) 
	{
		this.args = args;
		this.output = new StringBuilder();
		this.currentLine = new StringBuilder();
	}

	public String getColumn()
	{
		return this.column;
	}
	
	public void formatTextAsColumn()
	{
		this.verifyParamsExist();
		this.parseText();
	}
	
	public void verifyParamsExist() 
	{
		if (ArrayUtils.isEmpty(this.args)) 
		{
			throw new IllegalArgumentException(MISSING_ARGUMENT);
		}
	}
	
	public void parseText()
	{
		StringBuilder parsedLines = this.parseLines();
		this.setColumn(parsedLines);
	}
	
	private void setColumn(StringBuilder parsedLines)
	{
		this.column = parsedLines.toString();
	}
	
	private StringBuilder parseLines()
	{
		StringTokenizer tokenizer = new StringTokenizer(this.args[0], " ");
		
		while(tokenizer.hasMoreTokens())
		{	
			String word = tokenizer.nextToken();
			
			int potentialLineLength = word.length() + this.currentLine.length();
			
			if(potentialLineLength < TextProcessor.MAX_LINE_LENGTH)
			{
				this.appendWord(word);
			}
			else
			{	
				this.maxLengthExceeded(word);
			}
		}
		
		this.addLineToOutput();
		return output;
	}

	private void maxLengthExceeded(String word)
	{
		this.appendNewline();
		this.addLineToOutput();
		this.resetLine();
		this.appendWord(word);
	}
	
	private void appendWord(String word)
	{
		this.currentLine.append(word + " ");
	}
	
	private void appendNewline()
	{
		this.currentLine.append("\n");
	}
	
	private void addLineToOutput()
	{
		this.output.append(this.currentLine);
	}
	
	private void resetLine()
	{
		this.currentLine = new StringBuilder();
	}
}
