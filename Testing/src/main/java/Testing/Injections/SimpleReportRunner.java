package Testing.Injections;

public class SimpleReportRunner {
	
	public static void main(String[] args){
		
		if(args.length<1){
			System.err.println("You must provide command line argument specyfying the file to analyze");
			System.exit(-1);
		}
		
		SalesReport report = new SalesReport(System.out, args[0]);
		report.report();
		
	}
}
