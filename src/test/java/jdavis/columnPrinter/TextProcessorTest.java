package jdavis.columnPrinter;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;

public class TextProcessorTest
{
	public static final String[] emptyInput = {};
	public static final String[] expectedInput = {"Four score and seven years ago our fathers brought forth upon this continent a new nation, concieved in liberty and dedicated to the proposition that all men are created equal."};
	public static final String expectedOutput = 
			"Four score \n" + 
			"and seven \n" + 
			"years ago \n" + 
			"our fathers \n" + 
			"brought \n" + 
			"forth upon \n" + 
			"this \n" + 
			"continent a \n" + 
			"new nation, \n" + 
			"concieved in \n" + 
			"liberty and \n" + 
			"dedicated to \n" + 
			"the \n" + 
			"proposition \n" + 
			"that all men \n" + 
			"are created \n" + 
			"equal. ";
	
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test 
    public void verifyParametersExist_argsEmpty()
    {      
    	thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(TextProcessor.MISSING_ARGUMENT);
        
        TextProcessor processor = new TextProcessor(TextProcessorTest.emptyInput);
        processor.verifyParamsExist();
    }
    
    @Test
    public void parseTestIntoColumn()
    {
    	TextProcessor processor = new TextProcessor(TextProcessorTest.expectedInput);
    	processor.formatTextAsColumn();
    	assertEquals(processor.getColumn(), TextProcessorTest.expectedOutput);
    }
}
