package jdavis.columnPrinter;

public class ColumnPrinter 
{
    public static void main( String[] args )
    {
		try
		{
			TextProcessor processor = new TextProcessor(args);
			processor.formatTextAsColumn();
			System.out.print(processor.getColumn());
		}
		catch (Exception e) {
			System.err.print(e.getMessage());
		}
    }
}
