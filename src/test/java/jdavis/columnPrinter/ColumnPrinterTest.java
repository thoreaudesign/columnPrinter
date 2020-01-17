package jdavis.columnPrinter;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

import org.junit.After;
import org.junit.Test;

public class ColumnPrinterTest 
{
	private final ByteArrayInputStream CONTENT_ARGS_VALID_IN = new ByteArrayInputStream(convertToBytes(TextProcessorTest.expectedInput)[0]);
	private final ByteArrayInputStream CONTENT_ARGS_EMPTY_IN = new ByteArrayInputStream(new byte[0]);
		
	@After
	public void restoreStreams()
	{
		System.setIn(System.in);
		System.setOut(System.out);
		System.setErr(System.err);
	}
	@Test
	public void main_verifyArgs()
	{
		ByteArrayOutputStream content_out = new ByteArrayOutputStream();
		
		System.setIn(this.CONTENT_ARGS_VALID_IN);
		System.setOut(new PrintStream(content_out));
		
		ColumnPrinter.main(TextProcessorTest.expectedInput);
		
		assertEquals(TextProcessorTest.expectedOutput, content_out.toString());
	}
	
    @Test 
    public void main_argsEmpty()
    {
    	ByteArrayOutputStream content_out = new ByteArrayOutputStream();
    	
    	System.setIn(this.CONTENT_ARGS_EMPTY_IN);
    	System.setErr(new PrintStream(content_out));
    	
        ColumnPrinter.main(TextProcessorTest.emptyInput);
        
        assertEquals(TextProcessor.MISSING_ARGUMENT, content_out.toString());
    }

    private byte[][] convertToBytes(String[] strings) {
        byte[][] data = new byte[strings.length][];
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            data[i] = string.getBytes(Charset.defaultCharset());
        }
        return data;
    }    
}
