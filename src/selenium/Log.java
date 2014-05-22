package selenium;
public class Log {
	public static void log( Object message, Throwable throwable ) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append( message );

		// Clickable link at end of line
		for ( StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace() ) {
			if ( stackTraceElement.getFileName() != null && stackTraceElement.getClassName().equals( Log.class.getName() ) == false ) {
				stringBuffer.append( " (" );
				stringBuffer.append( stackTraceElement.getFileName() );
				stringBuffer.append( ":" );
				stringBuffer.append( stackTraceElement.getLineNumber() );
				stringBuffer.append( ")" );
				break;
			}
		}

		// Stack dump if exception is given.
		stringBuffer.append( '\n' );
		if ( throwable != null ) {
			stringBuffer.append( throwable.toString() );
			stringBuffer.append( '\n' );
			for ( StackTraceElement stackTraceElement : throwable.getStackTrace() ) {
				stringBuffer.append( stackTraceElement.toString() );
				stringBuffer.append( '\n' );
			}
			if ( throwable.getCause() != null ) {
				stringBuffer.append( "Caused by:\n" );
				stringBuffer.append( throwable.getCause().toString() );
				stringBuffer.append( '\n' );
				for ( StackTraceElement stackTraceElement : throwable.getCause().getStackTrace() ) {
					stringBuffer.append( stackTraceElement.toString() );
					stringBuffer.append( '\n' );
				}
			}
		}

		System.out.println( message );
	}
}

